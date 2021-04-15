import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_2014_decimal_210415 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] array = new long[N+1];
		st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			pq.add(array[i]);
		}
		int count = 0;
		long x = 0;
		while(!pq.isEmpty()) {
			x = pq.poll();
			count++;
			for(int i = 1; i<=N; i++) {
				pq.add(array[i]*x);
				if(x % array[i]==0) break;
			}
			if(count==M) {
				break;
			}
		}
		System.out.println(x);
	}
}
