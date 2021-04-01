import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2660_choicePresident_210401 {
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int N, min = Integer.MAX_VALUE, count = 0, max = 0;
	static boolean[] marked;
	static int[][] array;
	static int[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		ar = new ArrayList[N+1];
		check = new int[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		while(true) {
			String[] k = br.readLine().split(" ");
			int a = Integer.parseInt(k[0]);
			int b = Integer.parseInt(k[1]);
			if(a==-1 && b==-1) {
				break;
			}
			ar[a].add(b);
			ar[b].add(a);
		}
		for(int i = 1; i<=N; i++) {
			marked = new boolean[N+1];
			max = 0;
			q.add(i);
			marked[i] =true;
			BFS(i);
			check[i] = max;
			min = min<max?min:max;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			if(check[i]==min) {
				count++;
				sb.append(i+" ");
			}
		}
		System.out.println(min+" "+count);
		System.out.println(sb);
	}
	
	static void BFS(int a) {
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int hyo : ar[x]) {
				if(!marked[hyo]) {
					array[a][hyo] = array[a][x]+1;
					marked[hyo] = true;
					q.add(hyo);
					max = max>array[a][hyo]?max:array[a][hyo];
				}
			}
		}
	}

}
