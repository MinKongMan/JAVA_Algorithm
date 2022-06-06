import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_19542_danji_220606 {
	
	static ArrayList<Integer>[] ar;
	static int N,M,D,count = 0;
	static boolean[] marked;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		marked = new boolean[N+1];
		array = new int[N+1];
		for(int i = 1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar[x].add(y);
			ar[y].add(x);
		}
		marked[M] = true;
		dfs(M,0);
//		for(int i = 1; i<=N; i++) {
//			System.out.println(i+" "+array[i]);
//		}
		marked = new boolean[N+1];
		marked[M] = true;
		dfs2(M);
		System.out.println((count-1)*2);
	}
	
	static void dfs(int a, int b) {
		int k = 0;
		for(int x : ar[a]) {
			if(marked[x]) continue;
			marked[x] = true;
			dfs(x,b+1);
			k = Math.max(k, array[x]);
		}
//		System.out.println(a+"  / "+k);
		array[a] = k+1;
	}
	
	static void dfs2(int a) {
		if(array[a]<=D) return;
		count++;
//		System.out.println(a+" "+count);
		for(int x : ar[a]) {
			if(marked[x]) continue;
			marked[x] = true;
			dfs2(x);
		}
	}
}
