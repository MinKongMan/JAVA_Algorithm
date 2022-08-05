import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_2668_numChoice_220805 {

	static int[] array;
	static boolean[] marked, checked, temp_mark;
	static int N, count = 0;
	static ArrayList<Integer> ar = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		marked = new boolean[N+1];
		checked = new boolean[N+1];
		temp_mark = new boolean[N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
			if(array[i]==i) {
				count++;
				ar.add(i);
				marked[i] = true;
			}
		}
		
		for(int i = 1; i<=N; i++) {
			if(marked[i]) continue;
			dfs(i);
		}
		Collections.sort(ar);
		
		System.out.println(count);
		for(int i : ar) {
			System.out.print(i+" ");
		}
	}
	
	static void dfs(int x) {
		if(marked[x]) return;
		checked[x] = true;
		if(!checked[array[x]]) dfs(array[x]);
		else dfs2(array[x], 0);
		checked[x] = false;
		marked[x] = true;
	}
	
	static void dfs2(int x, int val) {
		if(checked[x] && !temp_mark[x]) {
			ar.add(x);
			temp_mark[x] = true;
			dfs2(array[x], val+1);
		}
		else if(checked[x] && temp_mark[x]) {
			count += val;
		}
	}

}
