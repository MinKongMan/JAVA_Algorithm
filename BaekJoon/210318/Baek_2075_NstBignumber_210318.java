import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2075_NstBignumber_210318 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N ; j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}
		int i = 0;
		int a = 0;
		while(i!=N) {
			a = q.poll();
			i++;
		}
		System.out.println(a);
	}

}
