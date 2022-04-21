import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_17616_order_220421 {
	static ArrayList<Integer>[] ar_son, ar_parent;
	static int N,M,X;
	static boolean[] marked;
	static int count = 0, max = 0, min = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		marked = new boolean[N+1];
		ar_son = new ArrayList[N+1];
		ar_parent = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar_son[i] = new ArrayList<Integer>();
			ar_parent[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar_son[x].add(y);
			ar_parent[y].add(x);
		}
		
		son(X);
		marked[X] = true;
		parent(X);
		for(int i = 1; i<=N; i++) {
			if(!marked[i]) count++;
		}
		int val1 = min+1;
		int val2 = N-max;
//		System.out.println(max+" "+min);
		System.out.println(val1+" "+val2);
	}
	
	static void son(int x) {
		for(int a : ar_son[x]) {
			if(marked[a]) continue;
			marked[a] = true;
			max++;
			son(a);
		}
	}
	
	static void parent(int x) {
		for(int a : ar_parent[x]) {
			if(marked[a]) continue;
			marked[a] = true;
			min++;
			parent(a);
		}
	}

}
