import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2887_planet_220701 {
	static class find1 implements Comparable<find1>{
		int x,y,z,i;
		find1(int i, int x, int y, int z){
			this.i = i;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(find1 arg0) {
			// TODO Auto-generated method stub
			if(this.x==arg0.x) {
				if(this.y==arg0.y) {
					return this.z-arg0.z;
				}
				return this.y-arg0.y;
			}
			return this.x-arg0.x;
		}
		
	}
	static class find2 implements Comparable<find2>{
		int x,y,z,i;
		find2(int i, int x, int y, int z){
			this.i = i;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(find2 arg0) {
			// TODO Auto-generated method stub
			if(this.x==arg0.x) {
				if(this.z==arg0.z) {
					return this.x-arg0.x;
				}
				return this.z-arg0.z;
			}
			return this.x-arg0.x;
		}
		
	}
	static class find3 implements Comparable<find3>{
		int x,y,z,i;
		find3(int i, int x, int y, int z){
			this.i = i;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(find3 arg0) {
			// TODO Auto-generated method stub
			if(this.y==arg0.y) {
				if(this.x==arg0.x) {
					return this.z-arg0.z;
				}
				return this.x-arg0.x;
			}
			return this.y-arg0.y;
		}
		
	}
	static class find4 implements Comparable<find4>{
		int x,y,z,i;
		find4(int i, int x, int y, int z){
			this.x = x;
			this.i = i;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(find4 arg0) {
			// TODO Auto-generated method stub
			if(this.y==arg0.y) {
				if(this.z==arg0.z) {
					return this.x-arg0.x;
				}
				return this.z-arg0.z;
			}
			return this.y-arg0.y;
		}
		
	}
	static class find5 implements Comparable<find5>{
		int x,y,z,i;
		find5(int i, int x, int y, int z){
			this.x = x;
			this.i = i;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(find5 arg0) {
			// TODO Auto-generated method stub
			if(this.z==arg0.z) {
				if(this.x==arg0.x) {
					return this.y-arg0.y;
				}
				return this.x-arg0.x;
			}
			return this.z-arg0.z;
		}
		
	}
	static class find6 implements Comparable<find6>{
		int x,y,z,i;
		find6(int i, int x, int y, int z){
			this.x = x;
			this.i = i;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(find6 arg0) {
			// TODO Auto-generated method stub
			if(this.z==arg0.z) {
				if(this.y==arg0.y) {
					return this.x-arg0.x;
				}
				return this.y-arg0.y;
			}
			return this.z-arg0.z;
		}
		
	}
	
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
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<find1> pq1 = new PriorityQueue<find1>();
		PriorityQueue<find2> pq2 = new PriorityQueue<find2>();
		PriorityQueue<find3> pq3 = new PriorityQueue<find3>();
		PriorityQueue<find4> pq4 = new PriorityQueue<find4>();
		PriorityQueue<find5> pq5 = new PriorityQueue<find5>();
		PriorityQueue<find6> pq6 = new PriorityQueue<find6>();
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		int[][] array = new int[7][N+1];
		parent = new int[N+1];
		int[][] val = new int[N+1][4];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq1.add(new find1(i,x,y,z));
			pq2.add(new find2(i,x,y,z));
			pq3.add(new find3(i,x,y,z));
			pq4.add(new find4(i,x,y,z));
			pq5.add(new find5(i,x,y,z));
			pq6.add(new find6(i,x,y,z));
			parent[i] = i;
			val[i][1] = x;
			val[i][2] = y;
			val[i][3] = z;
		}
		
		int count = 1;
		
		while(!pq1.isEmpty()) {
			find1 node1 = pq1.poll();
			find2 node2 = pq2.poll();
			find3 node3 = pq3.poll();
			find4 node4 = pq4.poll();
			find5 node5 = pq5.poll();
			find6 node6 = pq6.poll();
			array[1][count] = node1.i;
			array[2][count] = node2.i;
			array[3][count] = node3.i;
			array[4][count] = node4.i;
			array[5][count] = node5.i;
			array[6][count] = node6.i;
			count++;
		}
		
		for(int i = 1; i<N; i++) {
			for(int j = 1; j<=6; j++) {
				int valx = Math.abs(val[array[j][i]][1]-val[array[j][i+1]][1]);
				int valy = Math.abs(val[array[j][i]][2]-val[array[j][i+1]][2]);
				int valz = Math.abs(val[array[j][i]][3]-val[array[j][i+1]][3]);
				int min = Math.min(valx, valy);
				int min2 = Math.min(min, valz);
				pq.add(new xy(array[j][i],array[j][i+1],min2));
			}
		}
		
		long value = 0;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			if(find(parent[node.x])!=find(parent[node.y])) {
				union(node.x,node.y);
				value += node.val;
			}
			
		}
		
		System.out.println(value);
	}
	
	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
	
		if(a<b) {
			parent[b] = a;
		}
		else parent[a] = b;
	}

}
