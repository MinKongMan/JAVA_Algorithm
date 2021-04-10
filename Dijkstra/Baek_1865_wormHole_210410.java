import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Baek_1865_wormHole_210410 {
	static int N,M,V;
	static class cl implements Comparable<cl>{
		int end;
		int val;
		cl(int end, int val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(cl o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=TC; tc++) {
			String[] k = br.readLine().split(" ");
			PriorityQueue<cl> pq = new PriorityQueue<cl>();
			N = Integer.parseInt(k[0]);
			M = Integer.parseInt(k[1]);
			V = Integer.parseInt(k[2]);
			boolean[][] marked = new boolean[N+1][N+1];
			int[][] array = new int[N+1][N+1];
			ArrayList<cl>[] ar = new ArrayList[N+1];
			ArrayList<cl>[] ar2 = new ArrayList[N+1];
			for(int i = 1; i<=N; i++) {
				ar[i] = new ArrayList<cl>();
				ar2[i] = new ArrayList<cl>();
				for(int j = 1; j<=N; j++) {
					array[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int i = 1; i<=M; i++) {
				k = br.readLine().split(" ");
				int a = Integer.parseInt(k[0]);
				int b = Integer.parseInt(k[1]);
				int c = Integer.parseInt(k[2]);
				ar[a].add(new cl(b,c));
				ar[b].add(new cl(a,c));
			}
			
			for(int i = 1; i<=V; i++) {
				k = br.readLine().split(" ");
				int a = Integer.parseInt(k[0]);
				int b = Integer.parseInt(k[1]);
				int c = Integer.parseInt(k[2]);
				ar2[a].add(new cl(b,-c));
			}
			
			for(int i = 1; i<=N; i++) {
				array[i][i] = 0;
				pq.add(new cl(i,0));
				while(!pq.isEmpty()) {
					cl hyo = pq.poll();
					int x = hyo.end;
					if(!marked[i][x]) {
						marked[i][x] = true;
						for(cl sin : ar2[x]) {
							if(array[i][sin.end]>array[i][x]+sin.val) {
								array[i][sin.end]= array[i][x]+sin.val;
								pq.add(new cl(sin.end,array[i][sin.end]));
							}
						}
						for(cl sin : ar[x]) {
							if(array[i][sin.end]>array[i][x]+sin.val) {
								array[i][sin.end]= array[i][x]+sin.val;
								pq.add(new cl(sin.end,array[i][sin.end]));
							}
						}
					}
				}
				
				
			}boolean flag = false;
			for(int j = 1; j<=N; j++) {
				if(array[j][j]<0) {
					flag = true;
					break;
				}
			}
			if(flag) sb.append("YES"+"\n");
			else sb.append("NO"+"\n");
			
		}
		System.out.println(sb);
	}

}
