import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_14867_water_230214 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int count;
		
		xy(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
		@Override
		public int compareTo(xy arg0) {
			return this.count-arg0.count;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		
		if(a==0 && b==0) {
			System.out.println(0);
			return;
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		pq.add(new xy(0,0,0));
		set.add(0+"_"+0);
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			
			int x = node.x;
			int y = node.y;
			int count = node.count;
			
//			System.out.println(x+" "+y+" "+count);
			
			if(x==a && y==b) {
				System.out.println(node.count);
				return;
			}
			
			int quantity = x+y;
			
			if(quantity>N) {
				int tx = N;
				int ty = quantity-N;
				if(!set.contains(tx+"_"+ty)) {
					set.add(tx+"_"+ty);
					pq.add(new xy(tx,ty,count+1));
				}
			}
			if(quantity>M) {
				int tx = quantity-M;
				int ty = M;
				if(!set.contains(tx+"_"+ty)) {
					set.add(tx+"_"+ty);
					pq.add(new xy(tx,ty,count+1));
				}
			}
			if(!set.contains("0_"+y)) {
				set.add("0_"+y);
				pq.add(new xy(0,y,count+1));
			}
			if(!set.contains(x+"_0")) {
				set.add(x+"_0");
				pq.add(new xy(x,0,count+1));
			}
			if(!set.contains(N+"_"+y)) {
				set.add(N+"_"+y);
				pq.add(new xy(N,y,count+1));
			}
			if(!set.contains(x+"_"+M)) {
				set.add(x+"_"+M);
				pq.add(new xy(x,M,count+1));
			}
			if(quantity<=N) {
				int tx = quantity;
				int ty = 0;
				if(!set.contains(tx+"_"+ty)) {
					set.add(tx+"_"+ty);
					pq.add(new xy(tx,ty,count+1));
				}
			}
			if(quantity<=M) {
				int tx = 0;
				int ty = quantity;
				if(!set.contains(tx+"_"+ty)) {
					set.add(tx+"_"+ty);
					pq.add(new xy(tx,ty,count+1));
				}
			}
			
			
		}
		
		System.out.println(-1);
	}

}
