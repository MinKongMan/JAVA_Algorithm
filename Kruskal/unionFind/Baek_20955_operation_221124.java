import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_20955_operation_221124 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		Set<Integer> set = new HashSet<Integer>();
		for(int i =1 ; i<=N; i++) {
			parent[i] = i;
		}
		int counting = 0;
		for(int i =1 ; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(find(parent[x])==find(parent[y])) counting++;
			else union(x,y);
		}
		
		int count = 0;
		
		for(int i = 1; i<=N; i++) {
			if(!set.contains(find(parent[i]))) {
				count++;
				set.add(find(parent[i]));
			}
		}
		System.out.println(counting+count-1);
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int a = find(parent[x]);
		int b = find(parent[y]);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

}
