import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
class find_1516 implements Comparable<find_1516>{
	int x;
	int count;
	find_1516(int x, int count){
		this.x = x;
		this.count = count;
	}
	@Override
	public int compareTo(find_1516 arg0) {
		// TODO Auto-generated method stub
		return this.count-arg0.count;
	}
	
}
public class Baek_1516_gameDevelop_210330 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<find_1516> q = new PriorityQueue<find_1516>();
		int N = sc.nextInt();
		int[] array = new int[N+1];
		boolean[][] marked = new boolean[N+1][N+1];
		ArrayList<Integer>[] ar;
		ar = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i]= new ArrayList<Integer>();
		}
		int[] dp = new int[N+1];
		for(int i = 1; i<=N; i++) {
			int j = 1;
			while(true) {
				int a = sc.nextInt();
				if(a==-1) {
					q.add(new find_1516(i, ar[i].size()));
					break;
				}
				if(j==1) {
					array[i] = a;
				}
				else {
					ar[i].add(a);
					marked[i][a] = true;
				}
				j++;
			}
		}
		while(!q.isEmpty()) {
			find_1516 hyo = q.poll();
			int x = hyo.x;
			int count = hyo.count;
			int temp = 0;
			boolean flag = true;
			if(count == 0) {
				for(Integer hyojung : ar[x]) {
					temp = temp>dp[hyojung]?temp:dp[hyojung];
				}
				dp[x] = array[x]+temp;
			}
			else {
				for(Integer hyojung : ar[x]) {
					if(dp[hyojung]==0) {
						flag = false;
						break;
					}
					temp = temp>dp[hyojung]?temp:dp[hyojung];
				}
				if(flag) dp[x] = array[x]+temp;
				else q.add(new find_1516(x, count+1));
			}
		}
		for(int i = 1; i<=N; i++) {
			System.out.println(dp[i]);
		}
	}
}
