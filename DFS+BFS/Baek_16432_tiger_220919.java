import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_16432_tiger_220919 {
	static int N;
	static int[] tree, array;
	static ArrayList<Integer>[] ar;
	static StringBuilder sb = new StringBuilder();
	static boolean mark = false;
	static boolean[][] marked;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		tree = new int[N+1];
		marked = new boolean[N+1][11];
		for(int i = 0; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j<=x; j++) {
				int y = Integer.parseInt(st.nextToken());
				ar[i].add(y);
			}
		}
		
		dfs(1);
		if(mark) System.out.println(sb);
		else System.out.println(-1);
	}
	
	static void dfs(int x) {
		if(mark) return;
		if(x==N+1) {
			if(mark) return;
			mark = true;
			for(int i = 1; i<=N; i++) {
				sb.append(tree[i]+"\n");
			}
			return;
		}
		for(int a : ar[x]) {
			if(a==tree[x-1]) continue;
			if(marked[x][a]) continue;
			marked[x][a] = true;
			tree[x] = a;
			dfs(x+1);
		}
	}

}
