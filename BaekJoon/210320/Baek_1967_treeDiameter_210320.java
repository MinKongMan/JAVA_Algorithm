import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class dfs_1967{
	int end;
	int cost;
	dfs_1967(int end ,int cost){
		this.end = end;
		this.cost = cost;
	}
}
public class Baek_1967_treeDiameter_210320 {
	
	static int N,max,temp;
	static List<dfs_1967>[] array;
	static boolean[] marked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = new ArrayList<dfs_1967>();
		}
		StringTokenizer st;
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			array[a].add(new dfs_1967(b,c));
			array[b].add(new dfs_1967(a, c));
		}
		max = 0;
		for(int i = 1; i<=N; i++) {
			marked = new boolean[N+1];
			temp = 0;
			dfs(i);
		}
		System.out.println(max);
	}
	static void dfs(int a) {
		if(marked[a]) return;
		marked[a] = true;
		for(dfs_1967 hyo : array[a]) {
			if(marked[hyo.end]) continue;
			temp += hyo.cost;
			max = max>temp?max:temp;
//			System.out.println(a+" "+hyo.end+" "+temp);
			dfs(hyo.end);
			temp -= hyo.cost;
		}
	}
}
