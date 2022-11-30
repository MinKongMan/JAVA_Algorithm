import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_16168_parade_221130 {

	static int N,M;
	static ArrayList<Integer>[] ar;
	static int[] array, parent;
	static Set<Integer> set = new HashSet<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int count = 0;
		ar = new ArrayList[N+1];
		array = new int[N+1];
		parent = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
			parent[i] = i;
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(find(parent[x])!=find(parent[y])) union(x,y);
			ar[x].add(y);
			ar[y].add(x);
		}
		
		int t = 0;
		for(int i = 1; i<=N; i++) {
			set.add(find(parent[i]));
		}
		
		for(int i = 1; i<=N; i++) {
			array[i] = ar[i].size();
			if(array[i]%2!=0) count++;
		}
		
		if((count==0 || count==2) && set.size()==1) System.out.println("YES");
		else System.out.println("NO");
	}

	public static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] =a ;
		else parent[a] = b;
	}
}
