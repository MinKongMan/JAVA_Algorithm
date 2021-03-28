import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Baek_4195_friendNetwork_210328 {
	static int N,M,count = 1, temp = 0;
	static ArrayList<Integer>[] ar;
	static int[] marked,level;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			count = 1;
			ar = new ArrayList[400001];
			marked = new int[400001];
			level = new int[400001];
			for(int l = 1; l<=400000; l++) {
				marked[l] = l;
				level[l] = 1;
			}
			for(int k = 1; k<=400000; k++) {
			ar[k] = new ArrayList<Integer>();
			}
			HashMap<String,Integer> hash = new HashMap<String,Integer>();
			M = Integer.parseInt(br.readLine());
			for(int j = 1; j<=M; j++) {
				temp = 0;
				
				String[] k = br.readLine().split(" ");
				if(!hash.containsKey(k[0])) {
					hash.put(k[0], count);
					count++;
				}
				if(!hash.containsKey(k[1])) {
					hash.put(k[1], count);
					count++;
				}
				int x = hash.get(k[0]);
				int y = hash.get(k[1]);
				if(find(x)!=find(y)) {
					union(x,y);
				}
				sb.append(level[find(x)]+"\n");
			}
		}
		System.out.print(sb);
	}
	
	static int find(int a) {
		if(marked[a]==a) return a;
		return marked[a] = find(marked[a]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x!=y) {
			marked[y] = x;
			level[x] += level[y];
		}
	}

}
