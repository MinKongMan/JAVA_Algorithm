import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_12763_noLate_220610 {
	static class xy implements Comparable<xy>{
		int end;
		int time;
		int money;
		xy(int end, int time, int money){
			this.end = end;
			this.time = time;
			this.money = money;
		}
		
		@Override
		public int compareTo(xy arg0) {
			if(this.money==arg0.money) {
				return this.time-arg0.time;
			}
			return this.money-arg0.money;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int time = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] array_m = new int[N+1];
		
		ArrayList<xy>[]ar = new ArrayList[N+1];
		for(int i =1; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
			array_m[i] = Integer.MAX_VALUE;
		}
		
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[x].add(new xy(y,a,b));
			ar[y].add(new xy(x,a,b));
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		pq.add(new xy(1,0,0));
		array_m[1] = 0;
		while(!pq.isEmpty()) {
			xy node = pq.poll();
//			System.out.println(node.end+" / "+node.time+" / "+node.money);
			array_m[node.end] = Math.min(array_m[node.end], node.money); 
			for(xy temp_node : ar[node.end]) {
				if(node.time+temp_node.time>time ||
						node.money+temp_node.money>money) continue;
				pq.add(new xy(temp_node.end,node.time+temp_node.time,node.money+temp_node.money));
			}
		}
		if(array_m[N]>money) {
			System.out.println(-1);
			return;
		}
		System.out.println(array_m[N]);
	}

}
