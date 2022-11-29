import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_24230_treeColor_221130 {

	static int N,M,count=0;
	static ArrayList<Integer>[] ar;
	static boolean[] marked;
	static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		array = new int[N+1];
		marked = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			ar[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ar[x].add(y);
			ar[y].add(x);
		}
		marked[1] = true;
		if(array[1]!=0) count++;
		dfs(1);
		System.out.println(count);
	}
	
	static void dfs(int x) {
		for(int a : ar[x]) {
			if(marked[a]) continue;
			marked[a] = true;
			if(array[x]!=array[a]) {
				count++;
			}
			dfs(a);
		}
	}

}
