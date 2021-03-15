import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class link_1753 implements Comparable<link_1753>{
		int y;
		int val;
		link_1753(int y, int val){
			this.y = y;
			this.val =val;
		}
		@Override
		public int compareTo(link_1753 arg0) {
			return val-arg0.val;
		}
	}
public class Baek_1753_goodWay_210315 {
	
	static int N,M,K,a,temp;
	static int[][] array;
	static int[] answer;
	static boolean[] marked;
	static List<link_1753>[] link;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		answer = new int[N+1];
		marked = new boolean[N+1];
		K = Integer.parseInt(br.readLine());
		link = new ArrayList[N+1];
		for(int i = 0; i<=N; i++) {
			link[i] = new ArrayList<>();
			answer[i] = Integer.MAX_VALUE;
		}
		StringTokenizer st;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			link[a].add(new link_1753(b,c));
		}
		DFS(K);
		for(int i = 1; i<=N; i++) {
			if(i==K) System.out.println(0);
			else System.out.println(answer[i]==Integer.MAX_VALUE?"INF":answer[i]);
		}
	}
	static void DFS(int x) {
		PriorityQueue<link_1753> pq = new PriorityQueue<link_1753>();
		boolean[] marked = new boolean[N+1];
		pq.add(new link_1753(x,0));
		answer[x] = 0;
		while(!pq.isEmpty()) {
			link_1753 hyo = pq.poll();
			if(marked[hyo.y]==true) continue;
			marked[hyo.y] = true;
			for(link_1753 kang: link[hyo.y]) {
				if(answer[kang.y]>kang.val+answer[hyo.y]) {
					answer[kang.y]= kang.val+answer[hyo.y];
					pq.add(new link_1753(kang.y, answer[kang.y]));
				}
			}
		}
	}

}
