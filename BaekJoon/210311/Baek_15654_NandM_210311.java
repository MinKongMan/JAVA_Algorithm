import java.util.Arrays;
import java.util.Scanner;

public class Baek_15654_NandM_210311 {
	static int[] array,array2;
	static int N,M;
	static StringBuilder sb;
	static boolean[] marked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		marked = new boolean[N+1];
		array = new int[N+1];
		
		array2 = new int[M+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		DFS(0,1);
		System.out.println(sb);
	}
	
	static void DFS(int a, int b) {
		if(b==M+1) {
			for(int i= 1; i<=M; i++) {
				sb.append(array2[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(marked[i]==false) {
				marked[i] = true;
				array2[b] = array[i];
				DFS(a,b+1);
				marked[i] = false;
			}
		}
	}

}
