import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1167_treeDi_210405 {
	static int N;
	static class node{
		int end;
		int val;
		node(int end, int val){
			this.end = end;
			this.val = val;
		}
	}
	static ArrayList<node>[] ar;
	static boolean[] marked;
	static int max = 0,temp = 0;
	static Queue<Integer> qx = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<node>();
		}
		marked = new boolean[N+1];
		for(int i =1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			if(i==1) qx.add(start);
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				if(end==-1) break;
				int val = Integer.parseInt(st.nextToken());
				ar[start].add(new node(end,val));
			}
		}
		int[] dp = new int[N+1];
		marked[qx.peek()] = true;
		while(!qx.isEmpty()) {
			int x = qx.poll();
			for(node hyo : ar[x]) {
				if(!marked[hyo.end]) {
					marked[hyo.end] = true;
					dp[hyo.end] += dp[x]+hyo.val;
					qx.add(hyo.end);
				}
			}
		}
		max = 0;
		int idx = 0;
		for(int i = 1; i<=N; i++) {
			if(max<dp[i]) {
				max = dp[i];
				idx = i;
			}
		}
		marked = new boolean[N+1];
		dp = new int[N+1];
		marked[idx] = true;
		qx.add(idx);
		while(!qx.isEmpty()) {
			int x = qx.poll();
			for(node hyo : ar[x]) {
				if(!marked[hyo.end]) {
					marked[hyo.end] = true;
					dp[hyo.end] += dp[x]+hyo.val;
					qx.add(hyo.end);
				}
			}
		}
		max = 0;
		for(int i = 1; i<=N; i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
