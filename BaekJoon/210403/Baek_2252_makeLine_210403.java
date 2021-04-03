import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2252_makeLine_210403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		int N = Integer.parseInt(k[0]);
		int M = Integer.parseInt(k[1]);
		int[] count = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer>[] ar = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<=M; i++) {
			k = br.readLine().split(" ");
			int a = Integer.parseInt(k[0]);
			int b = Integer.parseInt(k[1]);
			ar[a].add(b);
			count[b]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			if(count[i]==0) {
				sb.append(i+" ");
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int hyo : ar[x]) {
				count[hyo]--;
				if(count[hyo]==0) {
					sb.append(hyo+" ");
					q.add(hyo);
				}
			}
		}
		System.out.println(sb);
		
	}

}
