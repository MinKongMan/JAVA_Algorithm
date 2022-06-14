import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_10217_KCM_220614 {
	static class xy implements Comparable<xy>{
		int end;
		int time;
		int money;
		
		xy(int end, int money, int time){
			this.end = end;
			this.money = money;
			this.time = time;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			if(this.time==arg0.time) {
				return this.money-arg0.money;
			}
			return this.time-arg0.time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] array = new int[N+1][money+1];
			
			ArrayList<xy>[] ar = new ArrayList[N+1];
			for(int i =1 ; i<=N; i++) {
				ar[i] = new ArrayList<xy>();
				Arrays.fill(array[i], Integer.MAX_VALUE);
			}
			
			for(int i = 1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				ar[x].add(new xy(y,a,b));
			}
			
			PriorityQueue<xy> pq = new PriorityQueue<xy>();
			array[1][0] = 0;
			pq.add(new xy(1,0,0));
			
			
			
			while(!pq.isEmpty()) {
				xy node = pq.poll();
//				if(node.end==N) break;
				for(xy temp_node : ar[node.end]) {
					if(node.money+temp_node.money<=money) {
						if(array[temp_node.end][node.money+temp_node.money]>temp_node.time+node.time) {
							array[temp_node.end][node.money+temp_node.money] = temp_node.time+node.time;
							
							for(int i=node.money+temp_node.money+1; i<=money; i++) {
								if(array[temp_node.end][i]>temp_node.time+node.time) {
									array[temp_node.end][i] = temp_node.time+node.time;
								}
							}
							
							pq.add(new xy(temp_node.end, node.money+temp_node.money, node.time+temp_node.time));
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i = 1; i<=money; i++) {
				min = min<array[N][i]?min:array[N][i];
			}
			if(min==Integer.MAX_VALUE) {
				sb.append("Poor KCM\n");
			}
			else {
				sb.append(min+"\n");
			}
			
		}
		System.out.println(sb);
	}

}
