import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13975_file_220503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j<=M; j++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long ans = 0;
			
			while(!pq.isEmpty()) {
				if(pq.size()==1) {
					break;
				}
				long val = pq.poll()+pq.poll();
				pq.add(val);
				ans += val;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

}
