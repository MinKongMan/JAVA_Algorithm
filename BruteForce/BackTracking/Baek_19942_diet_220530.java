import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_19942_diet_220530 {
	static int N;
	static int a,b,c,d,ta=0,tb=0,tc=0,td=0;
	static int[][] array;
	static int min = Integer.MAX_VALUE;
	static boolean[] marked = new boolean[N+1];
	static LinkedList<String> link = new LinkedList<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		array = new int[N+1][6];
		st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		marked = new boolean[N+1];
		
		for(int i =1 ; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			array[i][1] = q;
			array[i][2] = w;
			array[i][3] = e;
			array[i][4] = r;
			array[i][5] = t;
		}
		dfs(1,0);
		if(link.size()==0) {
			System.out.println(-1);
			return;
		}
		Collections.sort(link);
		System.out.println(min);
		System.out.println(link.get(0));
	}

	static void dfs(int x, int y) {
//		System.out.println(ta+" "+tb+" "+tc+" "+td);
		if(ta>=a && tb>=b && tc>=c && td>=d) {
			if(min>y) {
				link.clear();
				String l = "";
				for(int i = 1; i<=N; i++) {
					if(marked[i]) l += i+" ";
				}
				link.add(l);
				min = y;
			}
			else if(min==y) {
				String l = "";
				for(int i = 1; i<=N; i++) {
					if(marked[i]) l += i;
				}
				link.add(l);
			}
			return;
		}
		
		for(int i = x; i<=N; i++) {
			if(marked[i]) continue;
			marked[i] = true;
			ta += array[i][1];
			tb += array[i][2];
			tc += array[i][3];
			td += array[i][4];
			
			dfs(i+1,y+array[i][5]);
			
			ta -= array[i][1];
			tb -= array[i][2];
			tc -= array[i][3];
			td -= array[i][4];
			marked[i] = false;
		}
	}
}
