import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_13265_color_220706 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int Test = 1; Test<=tc; Test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] array = new int[N+1];
			
			boolean[] marked = new boolean[N+1];
			
			ArrayList<Integer>[] ar = new ArrayList[N+1];
			for(int i = 0; i<=N; i++) {
				ar[i] = new ArrayList<Integer>();
			}
			
			for(int i = 1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ar[a].add(b);
				ar[b].add(a);
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			boolean tmark = false;
//			System.out.println("天天天天天天天天天天天天天天天天天天天天");
			forout:
			for(int i = 1; i<=N; i++) {
				if(marked[i]) continue;
				q.add(i);
				array[i] = 1;
				marked[i] = true;
				while(!q.isEmpty()) {
					int x = q.poll();
					for(int t : ar[x]) {
						if(array[x]==array[t]) {
							sb.append("impossible\n");
							tmark = true;
							q.clear();
							break forout;
						}
						if(!marked[t]) {
							if(array[x]==1) {
								array[t] = 2;
							}
							else if(array[x]==2) {
								array[t] = 1;
							}
							marked[t] = true;
							q.add(t);
						}
					}
				}
			}
			
			if(!tmark) sb.append("possible\n");
		}
		System.out.println(sb);
	}

}
