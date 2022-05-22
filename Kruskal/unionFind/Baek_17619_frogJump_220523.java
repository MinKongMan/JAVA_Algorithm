import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Baek_17619_frogJump_220523 {
	static class xy implements Comparable<xy>{
		int start_x;
		int end_x;
		int num;
		int y;
		xy(int num, int start_x, int end_x, int y){
			this.num = num;
			this.start_x = start_x;
			this.end_x = end_x;
			this.y = y;
		}
		@Override
		public int compareTo(xy arg0) {
			if(this.start_x==arg0.start_x) return this.end_x-arg0.end_x;
			return this.start_x - arg0.start_x;
		}
	}
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		parent = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			parent[i] = i;
			pq.add(new xy(i,x,y,z));
		}
		
		int count = 1;
		
		int[][] array = new int[N+1][4];
		int[] num = new int[N+1];
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			array[count][0] = node.start_x;
			array[count][1] = node.end_x;
			array[count][2] = node.y;
			array[count][3] = node.num;
			num[node.num] = count;
			count++;
		}
		
		int start_x = 0;
		int end_x = 0;
		int number = array[1][3];
		
		for(int i = 1; i<=N; i++) {
			int sx = array[i][0];
			int ex = array[i][1];
//			System.out.println(sx+" "+ex);
			if(sx<=end_x) {
				if(end_x<ex) end_x = ex;
				if(find(parent[number])!=find(parent[array[i][3]])) {
					union(number,array[i][3]);
				}
			}
			else {
				end_x = ex;
				number = array[i][3];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =1 ; i<=Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int rx1 = Math.min(num[x], num[y]);
			int rx2 = Math.max(num[x], num[y]);
			
			int sx1 = array[rx1][0];
			int ex1 = array[rx1][1];
			int y1 = array[rx1][2];
			
			int sx2 = array[rx2][0];
			int ex2 = array[rx2][1];
			int y2 = array[rx2][2];
			
			
				if(find(parent[array[num[x]][3]])!=find(parent[array[num[y]][3]])) sb.append(0+"\n");
				else {
					if(y1==y2) {
						if(sx2<=ex1) sb.append(0+"\n");
						else sb.append(1+"\n");
					}
					else sb.append(1+"\n");
				}
		}
		
//		for(int i =1 ; i<=N; i++) {
//			System.out.println( num[i]+" "+array[i][3]+" / "+find(parent[array[num[i]][3]]));
//		}
//		System.out.println("天天天天天天天天天天天天天天天天天");
		System.out.println(sb);
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
		
	}
	
	public static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
