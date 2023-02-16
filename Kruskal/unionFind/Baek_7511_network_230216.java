import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_7511_network_230216 {
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			
			for(int i = 1; i<=N; i++) {
				parent[i] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i<=a; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x,y);
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			sb.append("Scenario "+tc+":\n");
			for(int i =1 ; i<=b; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(find(parent[x])!=find(parent[y])) sb.append(0+"\n");
				else sb.append(1+"\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int x = find(parent[a]);
		int y = find(parent[b]);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}

}
