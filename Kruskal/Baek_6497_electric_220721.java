import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_6497_electric_220721 {
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
			return this.val- arg0.val;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0) break;
			ArrayList<xy>[] ar = new ArrayList[N+1];
			parent = new int[N+1];
			for(int i = 0; i<=N; i++) {
				ar[i] = new ArrayList<xy>();
				parent[i] = i;
			}
			
			int sum = 0;
			PriorityQueue<xy> pq = new PriorityQueue<xy>();			
			for(int i = 1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				sum +=  z;
				pq.add(new xy(x,y,z));
			}

			int val = 0;
			while(!pq.isEmpty()) {
				xy node = pq.poll();
				int x = node.x;
				int y = node.y;
				if(find(parent[x])!=find(parent[y])) {
					union(x,y);
					val+=node.val;
				}
			}
			sb.append(val+"\n");
		}
		System.out.println(sb);

	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
}
