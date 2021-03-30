import java.util.ArrayList;
import java.util.Scanner;

public class Baek_1976_goTrip_210330 {
	static int N,M;
	static int[] hyo;
	static boolean[] marked;
	static int[] parent;
	static boolean flag;
	static ArrayList<Integer>[] ar;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		hyo = new int[M+1];
		parent = new int[N+1];
		marked = new boolean[N+1];
		ar = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				int k = sc.nextInt();
				if(k==1) {
					int a = find(i);
					int b = find(j);
					if(a!=b) {
						union(i,j);
					}
				}
			}
		}
		for(int i = 1; i<=M; i++) {
			hyo[i] = sc.nextInt();
		}
		int jung = 1;
		int kang = 0;
		while(jung<M) {
			if(parent[hyo[jung]]!=parent[hyo[jung+1]]) {
				kang = 1;
				break;
			}
			jung++;
		}
		System.out.println(kang==0?"YES":"NO");
	}
	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) {
			parent[y] = x;
		}
	}
}
