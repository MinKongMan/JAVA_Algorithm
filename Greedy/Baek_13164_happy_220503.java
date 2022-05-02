import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13164_happy_220503 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 1; i<N; i++) {
			pq.add(array[i+1]-array[i]);
		}
		
		int ans = 0;
		
		for(int i = 1; i<=N-M; i++) {
			ans += pq.poll();
		}
		
		System.out.println(ans);

	}

}
