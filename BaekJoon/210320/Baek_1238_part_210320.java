import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class dik_1238 implements Comparable<dik_1238>{
	int end;
	int cost;
	dik_1238(int end, int cost){
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(dik_1238 arg0) {
		// TODO Auto-generated method stub
		return this.cost-arg0.cost;
	}
	
}
public class Baek_1238_part_210320 {
	static int N,M,K;
	static int[][] answer;
	static boolean[][] marked;
	static List<dik_1238>[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k  = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		K = Integer.parseInt(k[2]);
		answer = new int[N+1][N+1];
		StringTokenizer st;
		array = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				answer[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0; i<=N; i++) {
			array[i] = new ArrayList<dik_1238>();
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			array[a].add(new dik_1238(b, c));
		}
		
		for(int i = 1; i<=N; i++) {
			System.out.println("天天天天天天天天天"+i);
			DFS(i);
		}
		int max = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
//				System.out.print(answer[i][j]+" ");
			}
//			System.out.println();
		}
		for(int i = 1; i<=N; i++) {
			int temp = answer[i][K]+answer[K][i];
			max = max>temp?max:temp;
		}
		System.out.println(max);
	}
	static void DFS(int a) {
		PriorityQueue<dik_1238> pq = new PriorityQueue<dik_1238>();
		boolean[] marked = new boolean[N+1];
		answer[a][a] = 0;
		pq.add(new dik_1238(a, 0));
		while(!pq.isEmpty()) {
			dik_1238 x = pq.poll();
			if(marked[x.end]) continue; 
			marked[x.end] = true;
			for(dik_1238 j : array[x.end]) {
//				System.out.println(x.end+" "+j.end +" "+answer[a][x.end]+" "+j.cost+" / "+answer[a][j.end]);
				if(answer[a][j.end]>answer[a][x.end]+j.cost) {
					answer[a][j.end]= answer[a][x.end]+j.cost;
					pq.add(new dik_1238(j.end, answer[a][j.end]));
				}
			}
		}
	}

}
