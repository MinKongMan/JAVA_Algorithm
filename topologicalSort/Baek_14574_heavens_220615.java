import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_14574_heavens_220615 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		
		xy(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy arg0) {
			return -this.val+arg0.val;
		}
		
	}
	static int[] parent, show;
	static int[][] array;
	static int N;
	static ArrayList<Integer>[] ar;
	static boolean[] marked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		array = new int[N+1][3];
		ar = new ArrayList[N+1];
		marked = new boolean[N+1];
		show = new int[N+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar[i] = new ArrayList<Integer>();
			array[i][1] = x;
			array[i][2] = y;
			parent[i] = i;
		}
		
		for(int i =1 ; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				int temp = (int)Math.floor((array[i][2]+array[j][2])/Math.abs(array[i][1]-array[j][1]));
				pq.add(new xy(i,j,temp));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		long val = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			if(find(parent[x])!=find(parent[y])) {
				union(x,y);
				val += node.val;
				ar[x].add(y);
				ar[y].add(x);
				show[x]++;
				show[y]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i<=N; i++) {
			if(show[i]==1) q.add(i);
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			marked[x] = true;
			for(int a : ar[x]) {
				if(marked[a]) continue;
				sb.append(a+" "+x+"\n");
				show[a]--;
				if(show[a]==1) q.add(a);
			}
		}
		
		System.out.println(val);
		System.out.println(sb);
	}
	
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
