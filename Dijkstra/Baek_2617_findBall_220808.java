import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_2617_findBall_220808 {
	static ArrayList<Integer>[] parent, son;
	static int N,M;
	static int[] p_array, s_array;
	static boolean[] p_marked, s_marked;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new ArrayList[N+1];
		son = new ArrayList[N+1];
		p_array = new int[N+1];
		s_array = new int[N+1];
		p_marked = new boolean[N+1];
		s_marked = new boolean[N+1];
		
		for(int i = 1; i<=N; i++) {
			parent[i] = new ArrayList<Integer>();
			son[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(!son[x].contains(y)) son[x].add(y);
			if(!parent[y].contains(x)) parent[y].add(x);
		}
		
		for(int i = 1; i<=N; i++) {
			p_marked = new boolean[N+1];
			s_marked = new boolean[N+1];
			if(!p_marked[i]) {
				count = 0;
				p_marked[i] = true;
				dfs1(i);
				p_array[i] = count;
			}

			if(!s_marked[i]) {
				count = 0;
				s_marked[i] = true;
				dfs2(i);
				s_array[i] = count;
			}
		}
		int count = 0;
		for(int i = 1; i<=N; i++) {
//			System.out.println(p_array[i]-1+" "+(s_array[i]-1));
			if((p_array[i]-1)>=(N+1)/2 || s_array[i]-1>=(N+1)/2) count++;	
			
		}
		System.out.println(count);
	}
	
	static void dfs1(int x) {
		count++;
		for(int a : parent[x]) {
			if(p_marked[a]) {
				continue;
			}
			p_marked[a] = true;
			dfs1(a);
		}
		
	}
	static void dfs2(int x) {
		count++;
		for(int a : son[x]) {
			if(s_marked[a]) {
				continue;
			}
			s_marked[a] = true;
			dfs2(a);
		}
	}
	
}
