import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_10159_Scale_210411 {
	static int N,M,count = 0;
	static boolean[] marked;
	static ArrayList<Integer>[] ar,ar2;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		ar = new ArrayList[N+1];
		ar2 = new ArrayList[N+1];
		marked = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
			ar2[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a].add(b);
			ar2[b].add(a);
			
		}
		for(int i = 1; i<=N; i++) {
			marked = new boolean[N+1];
			marked[i] = true;
			count = 1;
			find(i);
			find2(i);
			sb.append((N-count)+"\n");
		}
		System.out.print(sb);
	}
	
	static void find(int a) {
		for(int i : ar[a]) {
			if(!marked[i]) {
				marked[i] = true;
				count++;
				find(i);
			}
		}
	}
	
	static void find2(int a) {
		for(int i : ar2[a]) {
			if(!marked[i]) {
				marked[i] = true;
				count++;
				find2(i);
			}
		}
	}

}
