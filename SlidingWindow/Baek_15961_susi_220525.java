import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_15961_susi_220525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<Integer>();
		int[] array = new int[N+1+k];
		int[] check = new int[d+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			array[i] = x;
		}
		for(int i = N+1; i<=N+k; i++) {
			array[i] = array[i-N];
		}
		Queue<Integer> q = new LinkedList<Integer>();
		
		int right = 1;
		int max = 0;
		
		while(true) {
			if(right>N+k) break;
//			System.out.println(right+" "+set.size());
			if(q.size()<k) {
				q.add(array[right]);
				set.add(array[right]);
				check[array[right]]++;
				right++;
			}
			else {
				int x = q.poll();
				check[x]--;
				if(check[x]==0) set.remove(x);
				
			}
			if(set.contains(c)) {
				max = Math.max(max, set.size());
			}
			else {
				max = Math.max(max, set.size()+1);
			}
		}
		System.out.println(max);
	}

}
