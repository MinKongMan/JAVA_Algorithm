import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7512_sosuSum_220712 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		boolean[] marked = new boolean[10000001];
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i<=10000000; i++) {
			if(!marked[i]) {
				for(int j = i*2; j<=10000000; j+=i) {
					marked[j] = true;
				}
			}
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(0);
		for(int i = 2; i<=10000000; i++) {
			if(!marked[i]) {
				ar.add(i);
			}
		}
		
		for(int TC = 1; TC<=tc; TC++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] list = new ArrayList[N+1];
			int[] array = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i<=N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<Integer>();
				int val = 0;
				Queue<Integer> q = new LinkedList<Integer>();
				for(int j = 1; j<ar.size(); j++) {
					int temp_val = ar.get(j);
					if(q.size()<array[i]) {
						q.add(temp_val);
						val += temp_val;
//						System.out.println(val);
					}
					else if(q.size()==array[i]) {
						val -= q.poll();
						q.add(temp_val);
						val += temp_val;
					}
					if(val>10000000) break;
					if(q.size()==array[i]) {
						if(!marked[val]) {
							list[i].add(val);
						}
					}
				}
			}
			
			int max = 0;
			int idx = 0;
			while(true) {
				for(int i = 1; i<=N; i++) {
					if(max<list[i].get(0)) {
						max = list[i].get(0);
						idx = i;
					}
				}
				forout:
				for(int i = 1; i<=N; i++) {
					int size = list[i].size();
					if(idx==i) continue;
					for(int j = 0; j<size; j++) {
						if(max==list[i].get(0)) break;
						else if(list[i].get(0)<max) list[i].remove(0);
						else {
							break;
						}
					}
				}
				boolean check = true;
				for(int i = 1; i<=N; i++) {
					if(list[i].get(0)!=max) {
						check = false;
					}
				}
				if(check) {
					sb.append("Scenario "+TC+":\n"+max+"\n\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}

}
