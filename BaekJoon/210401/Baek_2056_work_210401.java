import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2056_work_210401 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N+1];
		int[] dp = new int[N+1];
		int[] temp = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer>[] ar = new ArrayList[N+1];
		for(int i = 0; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<=N; i++) {
			String[] k = br.readLine().split(" ");
			array[i] = Integer.parseInt(k[0]);
			int j = 1;
			int count = Integer.parseInt(k[1]);
			while(j<=count) {
				int hyo = Integer.parseInt(k[j+1]);
				ar[hyo].add(i);
				temp[i]++;
				j++;
			}
		}
		for(int i = 1; i<=N; i++) {
			if(temp[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int hyo : ar[x]) {
				temp[hyo]--;
				if(temp[hyo]==0) {
					q.add(hyo);
				}
				dp[hyo] = Math.max(dp[hyo],dp[x]+array[x]);
			}
		}
		int max = 0;
		for(int i = 1; i<=N; i++) {
			max = max>dp[i]+array[i]?max:dp[i]+array[i];
		}
		System.out.println(max);
	}

}
