import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_11438_LCA2_210711 {
	static ArrayList<Integer>[] ar = new ArrayList[100001];
	static boolean[] marked = new boolean[100001];
	static int[][] dp_depth = new int[20][100001];
	static int[] array_depth = new int[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i<=100000; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a].add(b);
			ar[b].add(a);
		}
		
		dfs(1,0);
		
		for(int i = 0; i<19; i++) {
			for(int j = 0; j<=N; j++) {
				dp_depth[i+1][j] = dp_depth[i][dp_depth[i][j]]; // j의 2의i+1승번째 부모는 dp_depth[i][j]의 2의i번째 부모와 같다
			}
		}
//		System.out.println();
//		for(int i = 0; i<19; i++) {
//			for(int j = 0; j<=N; j++) {
//				System.out.print(dp_depth[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("ㅋㅋ");
//		for(int i = 1; i<=15; i++) {
//			System.out.println(i+" "+array_depth[i]);
//		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(array_depth[a]<array_depth[b]) {
				int c = a;
				a = b;
				b = c;
			}
			int gap = array_depth[a]-array_depth[b];
			int j = 0;
			while(true) {
//				System.out.println(a+" "+dp_depth[j][a]+" "+gap);
				if(gap==0) break;
				if(gap%2!=0) a = dp_depth[j][a];
				gap = gap/2;
				j++;
			}
			if(a!=b) {
				for(int k = 18; k>=0; k--) {
					if(dp_depth[k][a]!=0 && dp_depth[k][a] != dp_depth[k][b]) { // 만약 같다고 두고 break을 건다면 2의 N승번째 부모가 
						//같을 수도 있기 때문에 다를때 까지 찾아주고 마지막 다른 곳에서 그 부모를 찾는다.
						a = dp_depth[k][a];
						b = dp_depth[k][b];
					}
				}
				a = dp_depth[0][a];
	//			System.out.println(dp_depth[0][a]);
	//			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
			sb.append(a+"\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int a, int b) {
		marked[a] = true;
		array_depth[a] = b;
		for(int hyo : ar[a]) {
			if(!marked[hyo]) {
				dp_depth[0][hyo] = a; // 한 칸 앞에 있는 부모만 먼저 구함
				dfs(hyo,b+1);
			}
		}
	}

}
