import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Baek_12930_two_220630 {
	static class find implements Comparable<find>{
		int x;
		int y;
		int z;
		long val;
		find(int x, int y, int z, long val){
			this.x = x;
			this.y = y;
			this.z = z;
			this.val = val;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			if(this.val<arg0.val) return -1; 
			return 1;
		}
		
	}
	
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N+1];
		
		ArrayList<find>[] ar = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			ar[i] = new ArrayList<find>();
		}
		
		PriorityQueue<find> pq = new PriorityQueue<find>();
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar[x].add(new find(x,y,a,0));
			ar[y].add(new find(y,x,a,0));
			pq.add(new find(x,y,a,array[x]+array[y]));
		}
		
		while(!pq.isEmpty()) {
			find node = pq.poll();
			for(find temp_node : ar[node.x]) {
				if(array[temp_node.x]+array[temp_node.y]>=array[temp_node.z]) continue;
				array[temp_node.z] = array[temp_node.x]+array[temp_node.y];
				pq.add(new find(temp_node.z,temp_node.z,temp_node.z,array[temp_node.z]));
			}
		}
		
		System.out.println(array[1]);
	}

}
