import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_3584_LCA_221202 {
	static int N,M,K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int test = 1; test<=K; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			int[] ar = new int[N+1];
			boolean[] marked = new boolean[N+1];
			
			for(int i = 1; i<=N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				ar[y] = x;
			}
			
			for(int i = 1; i<=N; i++) {
				if(ar[i]==0) ar[i] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(X);
			if(X==Y) {
				sb.append(X+"\n");
				continue;
			}
			marked[X] = true;
			while(!q.isEmpty()) {
				int x = q.poll();
				if(marked[ar[x]]) continue;
				marked[ar[x]] = true;
				q.add(ar[x]);
			}
			
			q.add(Y);
			while(!q.isEmpty()) {
				int x = q.poll();
				if(marked[ar[x]]) {
					sb.append(ar[x]+"\n");
					break;
				}
				q.add(ar[x]);
			}
		}
		System.out.println(sb);
	}
	
}
