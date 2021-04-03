import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class divide implements Comparable<divide>{
	int start;
	int end;
	int val;
	divide(int start, int end, int val){
		this.start = start;
		this.end = end;
		this.val = val;
	}
	@Override
	public int compareTo(divide o) {
		// TODO Auto-generated method stub
		return this.val-o.val;
	}
}
public class Baek_1647_cityDivide_210403 {
	static int N,M;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
		PriorityQueue<divide> pq = new PriorityQueue<divide>();
		for(int i = 1; i<=M; i++) {
			k = br.readLine().split(" ");
			int a = Integer.parseInt(k[0]);
			int b = Integer.parseInt(k[1]);
			int c = Integer.parseInt(k[2]);
			pq.add(new divide(a,b,c));
		}
		int max = 0;
		int val = 0;
		while(!pq.isEmpty()) {
			divide hyo = pq.poll();
			int x = hyo.start;
			int y = hyo.end;
			int z = hyo.val;
			if(find(x)!=find(y)) {
				union(x,y);
				max = max>z?max:z;
				val += z;
			}
		}
		System.out.println(val-max);
	}
	
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) {
			parent[y] = x;
		}
	}

}
