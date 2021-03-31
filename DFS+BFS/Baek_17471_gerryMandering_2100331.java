import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17471_gerryMandering_2100331 {
	static int N,t_temp = 0, f_temp = 0,count_t, count_f,min = Integer.MAX_VALUE;
	static int[] array;
	static ArrayList<Integer>[] ar;
	static boolean[] marked,dividing;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		ar = new ArrayList[N+1];
		marked = new boolean[N+1];
		dividing = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			for(int j = 1; j<=a; j++) {
				int b = Integer.parseInt(st.nextToken());
				ar[i].add(b);
			}
		}
		divide(1);
		System.out.println(min==Integer.MAX_VALUE?"-1":min);
	}
	
	static void divide(int a) {
		if(a<=N) {
			marked = new boolean[N+1];
			count_t = 0;
			count_f = 0;
			t_temp = 0;
			f_temp = 0;
			find();
			if(count_t+count_f==N) {
//				System.out.println(t_temp+" "+f_temp);
				min = Math.min(Math.abs(t_temp-f_temp), min);
			}
			
		}
		else return;
		for(int i = a; i<=N; i++) {
			if(!dividing[i]) {
				dividing[i] = true;
				divide(a+1);
				dividing[i] = false;
			}
		}
	}
	
	static void find() {
		int a = 0;
		for(int i = 1; i<=N; i++) {
			if(dividing[i]) a = i; 
		}
		if(a==0) return;
		dfs1(a);
		a = 0;
		for(int i = 1; i<=N; i++) {
			if(!dividing[i]) a = i;
		}
		if(a==0) return;
		dfs2(a);
	}
	
	static void dfs1(int a) {
		count_t++;
		t_temp += array[a];
		marked[a] = true;
		for(int hyo : ar[a]) {
			if(dividing[hyo] && marked[hyo] == false) {
				marked[hyo] = true;
				dfs1(hyo);
			}
		}
	}
	static void dfs2(int a) {
		count_f++;
		f_temp += array[a];
		marked[a] = true;
		for(int hyo : ar[a]) {
			if(!dividing[hyo] && marked[hyo] == false) {
				marked[hyo] = true;
				dfs2(hyo);
			}
		}
	}
}
