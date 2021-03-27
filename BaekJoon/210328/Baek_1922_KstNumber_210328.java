import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class MST implements Comparable<MST>{
	int start;
	int end;
	int value;
	MST(int start, int end, int value){
		this.start = start;
		this.end = end;
		this.value = value;
	}
	@Override
	public int compareTo(MST arg0) {
		// TODO Auto-generated method stub
		return this.value-arg0.value;
	}
	
}

public class Baek_1922_KstNumber_210328 {
	static ArrayList<MST>[] ar;
	static int[] parent;
	static int N,M,min = 0;
	static PriorityQueue<MST> q = new PriorityQueue<MST>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i =1; i<=N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i<=M; i++) {
			String[] k = br.readLine().split(" ");
			q.add(new MST(Integer.parseInt(k[0]),Integer.parseInt(k[1]),Integer.parseInt(k[2])));
		}
		while(!q.isEmpty()) {
			MST hyo = q.poll();
			int x = hyo.start;
			int y = hyo.end;
			int z = hyo.value;
			if(union(x,y)) {
				min += z;
				mix(x,y);
			}
		}
		System.out.println(min);
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		else {
			parent[a] = find(parent[a]);
			return parent[a];
		}
	}
	
	static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x==y) return false;
		else return true;
	}
	
	static void mix(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) {
			parent[x] = y;
		}
	}

}
