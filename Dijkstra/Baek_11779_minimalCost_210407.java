import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_11779_minimalCost_210407 {
	static class cost implements Comparable<cost>{
		int end;
		int val;
		cost( int end, int val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(cost arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
	}
	static int[] parent;
	static int[][] arr;
	static int answer;
	static Stack<Integer> stack = new Stack<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		PriorityQueue<cost> pq = new PriorityQueue<cost>();
		ArrayList<cost>[] ar = new ArrayList[N+1];
		int[] array = new int[N+1];
		boolean[] marked = new boolean[N+1];
		arr = new int[N+1][N+1];
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.MAX_VALUE;
			parent[i] = i;
			ar[i] = new ArrayList<cost>();
		}

		StringTokenizer st;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
			ar[a].add(new cost(b,c));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		array[a] = 0;
		pq.add(new cost(a,0));
		int b = Integer.parseInt(st.nextToken());
		while(!pq.isEmpty()) {
			cost hyo = pq.poll();
			int x = hyo.end;
//			System.out.println(x);
			if(!marked[x]) {
				marked[x] = true;
				for(cost sin : ar[x]) {
					int hyosin = sin.end;
//					System.out.println(x+" "+hyosin);
					if(array[sin.end]>array[x]+sin.val) {
						array[sin.end] = array[x]+sin.val;
						pq.add(new cost(sin.end,array[sin.end]));
						union(hyosin,x);
//						System.out.println("µé¾î¿È"+hyosin+" "+x);
//						for(int i = 1; i<=N; i++) {
//							System.out.print(parent[i]+" ");
//						}
//						System.out.println();
					}
				}
			}
		}
//		for(int i = 1; i<=N; i++) {
//			System.out.print(parent[i]+" ");
//		}
		stack.clear();
		find(b);
		System.out.println(array[b]);
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	static int find(int a) {
		if(a==parent[a]) {
			stack.add(a);
			return a;
		}
		else {
			stack.add(a);
			return find(parent[a]);
		}
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		parent[a] = b;
	}

}
