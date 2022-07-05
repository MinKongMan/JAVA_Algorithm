import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13418_school_220705 {
	static class xy1 implements Comparable<xy1>{
		int x;
		int y;
		int val;
		xy1(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy1 arg0) {
			// TODO Auto-generated method stub
			if(this.val==-1) return -1;
			else return 1;
		}
		
	}
	
	static class xy2 implements Comparable<xy2>{
		int x;
		int y;
		int val;
		xy2(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy2 arg0) {
			// TODO Auto-generated method stub
			if(this.val == -1) return -1;
			else return 1;
		}
	}
	static int N;
	static int[] parent1, parent2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<xy1> pq1 = new PriorityQueue<xy1>();
		PriorityQueue<xy2> pq2 = new PriorityQueue<xy2>();
		
		parent1 = new int[N+1];
		parent2 = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			parent1[i] = i;
			parent2[i] = i;
		}
		
		int count1 = 0;
		int count2 = 0;
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		
		if(sc==0) {
			count1 += 1;
			count2 += 1;
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(z==0) {
				pq1.add(new xy1(x,y,1));
				pq2.add(new xy2(x,y,-1));
			}
			else {
				pq1.add(new xy1(x,y,-1));
				pq2.add(new xy2(x,y,1));
			}
		}
		
		
		
		while(!pq1.isEmpty()) {
			xy1 node = pq1.poll();
			int x = node.x;
			int y = node.y;
			if(find1(parent1[x])!=find1(parent1[y])) {
//				System.out.println(x+" "+y+" "+node.val+" / "+find1(parent1[x])+" "+find1(parent1[y]));
				union1(x,y);
//				System.out.println(find1(parent1[x])+" "+find1(parent1[y]));
				if(node.val==1) count1 += (node.val);
			}
			
		}
		
		while(!pq2.isEmpty()) {
			xy2 node = pq2.poll();
			int x = node.x;
			int y = node.y;
			if(find2(parent2[x])!=find2(parent2[y])) {
				union2(x,y);
			if(node.val==-1)	
				count2 += (-node.val);
			}
		}
//		System.out.println(count1+" "+count2);
		System.out.println(count2*count2-(count1*count1));
	}
	
	static int find1(int x) {
		if(x==parent1[x]) return x;
		else return parent1[x] = find1(parent1[x]);
	}
	
	static int find2(int x) {
		if(x==parent2[x]) return x;
		else return parent2[x] = find2(parent2[x]);
	}
	
	static void union1(int a, int b) {
		int x = find1(parent1[a]);
		int y = find1(parent1[b]);
		
		if(x<y) parent1[y] = x;
		else parent1[x] = y;
	}
	
	static void union2(int a, int b) {
		int x = find2(parent2[a]);
		int y = find2(parent2[b]);
		
		if(x<y) parent2[y] = x;
		else parent2[x] = y;
	}

}
