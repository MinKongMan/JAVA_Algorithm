import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_15971_twoRobot_220816 {
	static class xy{
		int y;
		int val;
		xy(int y, int val){
			this.y = y;
			this.val = val;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(M==K) {
			System.out.println(0);
			return;
		}
		ArrayList<xy>[] ar = new ArrayList[N+1];
		ArrayList<xy>[] array = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
			array[i] = new ArrayList<xy>();
		}
		
		for(int i = 1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			ar[x].add(new xy(y,z));
			ar[y].add(new xy(x,z));
		}
		int dis = 0;
		
		Queue<xy> q = new LinkedList<xy>();
		boolean[] marked = new boolean[N+1];
		marked[M] = true;
		q.add(new xy(M,0));
		while(!q.isEmpty()) {
			xy node = q.poll();
			if(node.y==K) dis = node.val;
			for(xy temp_node : ar[node.y]) {
				if(!marked[temp_node.y]) {
					marked[temp_node.y]= true;
					q.add(new xy(temp_node.y, node.val+temp_node.val));
					array[temp_node.y].add(new xy(node.y, temp_node.val));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		marked = new boolean[N+1];
		q.add(new xy(K,0));
		marked[K] = true;
		while(!q.isEmpty()) {
			xy node = q.poll();
			for(xy x : array[node.y]) {
				if(marked[x.y]) continue;
				min = Math.min(min, dis-x.val);
				marked[x.y]= true; 
				q.add(new xy(x.y, x.val));
			}
		}
		System.out.println(min);
		
	}

}
