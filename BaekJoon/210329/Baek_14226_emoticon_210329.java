import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_14226_emoticon_210329 {
	static class bfs{
		int x;
		int time;
		int copy;
		bfs(int x, int time, int copy){
			this.x = x;
			this.time = time;
			this.copy = copy;
		}
	}
	public static void main(String[] args) {
		Queue<bfs> q = new LinkedList<bfs>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[1001];
		boolean[][] marked = new boolean[2001][2001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		dp[2] = 2;
		
			q.add(new bfs(1,0,0));
			while(!q.isEmpty()) {
				bfs hyo = q.poll();
				int x = hyo.x;
				int time = hyo.time;
				int copy = hyo.copy;
				if(marked[copy][x]) continue;
				marked[copy][x] = true;
				
				if(x==N) {
					System.out.println(time);
					q.clear();
					continue;
				}
				if(x==0) continue;
				q.add(new bfs(x-1,time+1,copy));
				
				if(x>N || x+copy>N) continue;
				q.add(new bfs(x+copy,time+1,copy));
				
				q.add(new bfs(x,time+1,x));
				
	//			}
			
		}
	}

}
