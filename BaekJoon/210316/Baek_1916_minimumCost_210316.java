import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class link_1916 implements Comparable<link_1916>{
	int y;
	int cost;
	link_1916(int y, int cost){
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(link_1916 arg0) {
		// TODO Auto-generated method stub
		return this.cost-arg0.cost;
	}
}
public class Baek_1916_minimumCost_210316 {
	static int N,M,start,end;
	static List<link_1916>[] link;
	static int[] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i<=N; i++) {
			link[i] = new ArrayList<>();
		}
		array = new int[N+1];
		Arrays.fill(array, Integer.MAX_VALUE);
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			link[a].add(new link_1916(b,c));
		}
		String[] k;
		k = br.readLine().split(" ");
		start = Integer.parseInt(k[0]);
		end = Integer.parseInt(k[1]);
		find(start);
		System.out.println(array[end]);
	}
	
	static void find(int a) {
		PriorityQueue<link_1916> pq = new PriorityQueue<link_1916>();
		pq.add(new link_1916(a,0));
		array[a] = 0;
		boolean[] marked = new boolean[N+1];
		while(!pq.isEmpty()) {
			link_1916 hyo = pq.poll();
			if(!marked[hyo.y]) {
				marked[hyo.y]= true;
				for(link_1916 min : link[hyo.y]) {
					if(array[min.y]>array[hyo.y]+min.cost) {
						array[min.y]= array[hyo.y]+min.cost;
						pq.add(new link_1916(min.y,array[min.y]));
					}
				}
			}
		}
	}
}
