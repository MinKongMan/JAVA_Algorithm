import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_23296_elevator_220804 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[N+1];
		int[] sort_array = new int[N+1];
		int[] t_array = new int[N+1];
		boolean[] marked = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer>[] ar = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=N; i++) {
			int x = Integer.parseInt(st.nextToken());
			t_array[i] = x;
			array[x]++;
			ar[i].add(x);
		}
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> qx = new LinkedList<Integer>();
		qx.add(1);
		int count = 1;
		while(!qx.isEmpty()) {
			int x = qx.poll();
//			System.out.println(x);
			if(marked[x]) continue;
			marked[x] = true;
			sort_array[count] = x;
			count++;
			qx.add(t_array[x]);
		}
		
		
		for(int i = 1; i<=N; i++) {
			if(array[i]==0 && !(marked[i])) {
				marked[i] = true;
				qx.add(i);
			}
		}
		
		while(!qx.isEmpty()) {
			int x = qx.poll();
			sort_array[count] = x;
			marked[x] = true;
			count++;
			for(int a : ar[x]) {
				array[a]--;
				if(array[a]==0) {
					if(marked[a]) continue;
					marked[a] = true;
					qx.add(a);
				}
			}
		}
		
		if(count!=N+1) {
			for(int i = 1; i<=N; i++) {
				if(marked[i]) continue;
				sort_array[count] = i;
				count++;
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			System.out.println(sort_array[i]);
//		}
		
		marked = new boolean[N+1];
		count = 0;
		for(int i = 1; i<=N; i++) {
			if(marked[sort_array[i]]) continue;
			int t = sort_array[i];
			qx.add(t);
			if(i!=1) {
				count++;
				sb.append(sort_array[i]+" ");
			}
			while(!qx.isEmpty()) {
				int x = qx.poll();
				if(marked[x]) continue;
				marked[x] = true;
				sb.append(t_array[x]+" ");
				qx.add(t_array[x]);
				count++;
			}
		}
		System.out.println(count);
		System.out.println(sb);
		
	}

}
