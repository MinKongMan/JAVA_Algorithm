import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_16562_friendMoney_210404 {
	static int N,M,K;
	static int[] parent;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		K = Integer.parseInt(k[2]);
		parent = new int[N+1];
		array = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
			array[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=M; i++) {
			k = br.readLine().split(" ");
			int a = Integer.parseInt(k[0]);
			int b = Integer.parseInt(k[1]);
			if(find(a)!=find(b)) {
				if(array[find(a)]<=array[find(b)]) {
					union(a,b);
				}
				else {
					union(b,a);
				}
			}
		}
		int max = 0;
		for(int i = 1; i<=N; i++) {
			if(parent[i]==i) {
				max += array[i];
			}
		}
		if(max>K) {
			System.out.println("Oh no");
		}
		else {
			System.out.println(max);
		}
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		parent[y] = x;
		
	}

}
