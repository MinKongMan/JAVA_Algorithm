import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_20208_mintChoco_230117 {
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N,M,K,startX,startY;
	static int[][] array,dis;
	static LinkedList<xy> list = new LinkedList<>();
	static boolean[] marked;
	static int max = 0;
	static int[] per;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==1) {
					startX = i;
					startY = j;
				}
				else if(array[i][j]==2){
					list.add(new xy(i,j));
				}
			}
		}
		
		list.add(0, new xy(startX,startY));
		dis = new int[list.size()+1][list.size()+1];
		marked = new boolean[list.size()+1];
		
		for(int i = 0; i<list.size(); i++) {
			for(int j = i+1; j<list.size(); j++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				int n = list.get(j).x;
				int m = list.get(j).y;
				
				dis[i][j] = Math.abs(x-n)+Math.abs(y-m);
				dis[j][i] = dis[i][j];
			}
		}
		
		dfs(0,0,M);
		System.out.println(max);
	}
	
	static void dfs(int x, int prev, int health) {
//		System.out.println(dis[0][prev]+" "+health);
		if(dis[0][prev]<=health) {
//			System.out.println(dis[0][prev]+" "+health+" / "+x+" "+prev);
			max = Math.max(max, x);
		}
		
		for(int i = 1; i<list.size(); i++) {
			if(marked[i]) continue;
//			System.out.println(prev+" "+i+" / "+dis[i][prev]+" "+health);
			if(dis[i][prev]<=health) {
//				System.out.println(i);
				marked[i] = true;
				dfs(x+1, i, health-dis[i][prev]+K);
				marked[i] = false;
			}
		}
	}

}
