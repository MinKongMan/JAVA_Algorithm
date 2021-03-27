import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class baek_1197 implements Comparable<baek_1197>{
	int start;
	int end;
	int value;
	baek_1197(int start, int end, int value){
		this.start = start;
		this.end = end;
		this.value = value;
	}
	@Override
	public int compareTo(baek_1197 o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}
	
}
public class Baek_1197_MST_210328 {
	static PriorityQueue<baek_1197> q = new PriorityQueue<baek_1197>();
	static int N,M;
	static long val = 0;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k  = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i<=M; i++) {
			k = br.readLine().split(" ");
			q.add(new baek_1197(Integer.parseInt(k[0]),Integer.parseInt(k[1]),Integer.parseInt(k[2])));
		}

		while(!q.isEmpty()) {
			baek_1197 hyo = q.poll();
			int x = hyo.start;
			int y = hyo.end;
			int z = hyo.value;
			if(find(x)!=find(y)) {
				val += z;
				union(x,y);
			}
		}
		System.out.println(val);
	}
	static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	static void union(int a,int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) parent[x] = y;
	}
	
}
