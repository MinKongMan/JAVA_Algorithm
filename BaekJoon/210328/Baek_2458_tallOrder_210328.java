import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_2458_tallOrder_210328 {
	static ArrayList<Integer>[] ar1,ar2;
	static int N,M, stack = 0, stack2 = 0,count = 0;
	static boolean[] marked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		ar1 = new ArrayList[N+1];
		ar2 = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar1[i] = new ArrayList<Integer>();
			ar2[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar1[a].add(b);
			ar2[b].add(a);
		}
		for(int i =1; i<=N; i++) {
			marked = new boolean[N+1];
			stack = 0;
			stack2 = 0;
			dfs1(i);
			dfs2(i);
			if(stack+stack2+1==N) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
	}
	static void dfs1(int a) {
		for(Integer hyo : ar1[a]) {
			if(marked[hyo]) continue;
			marked[hyo] = true;
			stack++;
			dfs1(hyo);
		}
	}
	static void dfs2(int a) {
		for(Integer hyo : ar2[a]) {
			if(marked[hyo]) continue;
			marked[hyo] = true;
			stack2++;
			dfs2(hyo);
		}
	}
}
