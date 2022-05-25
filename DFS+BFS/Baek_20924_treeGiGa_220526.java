import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_20924_treeGiGa_220526 {
	static class xy{
		int y;
		int val;
		xy(int y, int val){
			this.y = y;
			this.val = val;
		}
	}
	static int N,M, root = 0;
	static long Gi = 0, Ga = 0;
	static ArrayList<xy>[] ar;
	static boolean[] marked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		marked = new boolean[N+1];
		
		ar = new ArrayList[N+1];
		for(int i =0 ; i<=N; i++) {
			ar[i] = new ArrayList<xy>();
		}
		
		for(int i =1 ; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			ar[x].add(new xy(y,val));
			ar[y].add(new xy(x,val));
		}
		marked[M] = true;
		dfs1(M,0);
		if(root!=0)	{
			marked[root] = true;
			dfs2(root,0);
		}
		System.out.println(Gi+" "+Ga);
		
		
	}
	
	static void dfs1(int x, long val) {
		int count = 0;
		for(xy t : ar[x]) {
			if(!marked[t.y]) {
				count++;
			}
		}
		if(count>1) {
			root = x;
			Gi = Math.max(val, Gi);
			return;
		}
		for(xy t : ar[x]) {
			if(marked[t.y]) continue;
			marked[t.y]= true; 
			Gi += t.val;
			dfs1(t.y, val+t.val);
		}
	}
	
	static void dfs2(int x, long val) {
		int count = 0;
		for(xy t : ar[x]) {
			if(!marked[t.y]) {
				count++;
				break;
			}
		}
		if(count==0) {
			Ga = Math.max(val, Ga);
			return;
		}
		for(xy t : ar[x]) {
			if(marked[t.y])continue;
			marked[t.y]= true; 
			dfs2(t.y, val+t.val);
		}
	}
}
