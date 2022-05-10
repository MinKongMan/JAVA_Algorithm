import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek_15559_gift_220510 {
	static class find implements Comparable<find>{
		int x;
		int y;
		int val;
		
		find(int x, int y, int val)
		{
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			return +arg0.val-this.val;
		}
		
	}
	static int[] parent;
	static int N,M;
	static boolean[][] marked;
	static char[][] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N*M];
		array = new char[N][M];
		marked = new boolean[N][M];
		for(int i = 0; i<=N-1; i++) {
			String l = br.readLine();
			for(int j = 0; j<M; j++) {
				array[i][j] = l.charAt(j);
				parent[i*M+j] = i*M+j;
			}
		}
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<M; j++) {
//				System.out.print(parent[i*M+j]+" ");
//			}
//			System.out.println();
//		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(marked[i][j]) continue;
				marked[i][j] = true;
				dfs(i,j);
			}
		}
		int count = 0;
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<M; j++) {
//				System.out.print(parent[i*M+j]+" ");
//			}
//			System.out.println();
//		}
		for(int i = 0; i<N*M; i++) {
			if(i==find(parent[i])) count++;
		}
		System.out.println(count);
	}
	
	public static void dfs(int x, int y) {
		
		if(array[x][y]=='W') {
			int a = x;
			int b = y-1;
			if(a>N || a<0 || b>M || b<0) return;
			if(find(parent[x*M+y])!=find(parent[a*M+b])) {
				union(x*M+y,a*M+b);
				marked[a][b] = true;
				dfs(a,b);
			}
			else return;
		}
		else if(array[x][y]=='E') {
			int a = x;
			int b = y+1;
			if(a>N || a<0 || b>M || b<0) return;
			if(find(parent[x*M+y])!=find(parent[a*M+b])) {
				union(x*M+y,a*M+b);
				marked[a][b] = true;
				dfs(a,b);
			}
			else return;
		}
		else if(array[x][y]=='N') {
			int a = x-1;
			int b = y;
			if(a>N || a<0 || b>M || b<0) return;
			if(find(parent[x*M+y])!=find(parent[a*M+b])) {
				union(x*M+y,a*M+b);
				marked[a][b] = true;
				dfs(a,b);
			}
			else return;
		}
		else {
			int a = x+1;
			int b = y;
			if(a>N || a<0 || b>M || b<0) return;
			if(find(parent[x*M+y])!=find(parent[a*M+b])) {
				union(x*M+y,a*M+b);
				marked[a][b] = true;
				dfs(a,b);
			}
			else return;
		}
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]); 
	}
	
	public static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
