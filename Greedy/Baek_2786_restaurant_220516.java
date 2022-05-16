import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2786_restaurant_220516 {
	static class find implements Comparable<find>{
		int x;
		int y;
		int i;
		find(int x, int y, int i){
			this.x = x;
			this.y = y;
			this.i = i;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			if(this.y == arg0.y) {
				return this.x-arg0.x;
			}
			return (this.y)-(arg0.y);
		}
	}
	
	static class find2 implements Comparable<find2>{
		int x;
		int y;
		int i;
		find2(int x, int y, int i){
			this.x = x;
			this.y = y;
			this.i = i;
		}
		@Override
		public int compareTo(find2 arg0) {
			// TODO Auto-generated method stub
			return this.x-arg0.x;
		}
	}
	
	static class find3 implements Comparable<find3>{
		int x;
		int y;
		int i;
		find3(int x, int y, int i){
			this.x = x;
			this.y = y;
			this.i = i;
		}
		@Override
		public int compareTo(find3 arg0) {
			// TODO Auto-generated method stub
			return (this.x-this.y)-(arg0.x-arg0.y);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<find3> temp_pq1 = new PriorityQueue<find3>();
		PriorityQueue<find2> temp_pq2 = new PriorityQueue<find2>();
		PriorityQueue<find> pq = new PriorityQueue<find>();
		
//		BufferedReader br2 = new BufferedReader(
//				new FileReader("C:\\Users\\daemy\\OneDrive\\πŸ≈¡ »≠∏È\\asd\\contest2_testdata\\popust\\popust.out.3")
//		);
//		
//		String str = "";
		
		
		int N = Integer.parseInt(st.nextToken());
		int[][] array1 = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new find(x,y,i));
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 1;
		while(!pq.isEmpty()) {
			find node = pq.poll();
			array1[count][0] = node.i;
			array1[count][1] = node.x;
			array1[count][2] = node.y;
			
			temp_pq2.add(new find2(node.x, node.y, count));
			
			count++;
		}
		
		long cha = 0;
		long val = 0;
		long bigB = 0;
		
		for(int i = 1; i<=N; i++) {
			temp_pq1.add(new find3(array1[i][1],array1[i][2],array1[i][0]));
			
			while(true) {
				if(temp_pq2.isEmpty()) break;
				if(temp_pq2.peek().i<=i) temp_pq2.poll();
				else break;
			}
			
			val += array1[i][2];
			int temp_x1 = temp_pq1.peek().x;
			int temp_y1 = temp_pq1.peek().y;
			bigB = Math.max(bigB, array1[i][2]);
			int temp_x2 = 0;
			
			long temp_val1 = val+temp_x1-temp_y1;
			long temp_val2 = val;
			
			if(!temp_pq2.isEmpty()) {
				temp_x2 = temp_pq2.peek().x;
				temp_val2 = temp_val2-bigB+temp_x2;
			}
			else temp_val2 = Long.MAX_VALUE;
			
			
			long temp = Math.min(temp_val1, temp_val2);
//			System.out.println(temp+" / "+val+" "+temp_val1+" "+temp_val2+" / "+temp_x1+" "+temp_y1+" "+temp_x2+" "+bigB+" ");
			sb.append(temp+"\n");
		}
		
		
		System.out.println(sb);
	}

}
