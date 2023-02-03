import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_10429_QUENTO_230203 {
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int [] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static int N,M;
	static char[][] array = new char[3][3];
	static boolean[][] marked = new boolean[3][3];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<3; i++) {
			String l = br.readLine();
			for(int j = 0; j<3; j++) {
				array[i][j] = l.charAt(j);
			}
		}
		LinkedList<xy> asd = new LinkedList<xy>();
		asd.add(new xy(1,2));
		asd.add(new xy(12,25));
		asd.add(new xy(17,26));
		
		System.out.println(asd.removeLast().y);
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(array[i][j]!='+' && array[i][j]!='-') {
					LinkedList<xy> list = new LinkedList<xy>();
					list.add(new xy(i,j));
					marked[i][j] = true;
					dfs(i, j, array[i][j]-'0', 1, '1', list);
					marked[i][j] = false;
				}
			}
		}
		if(sb.length()>1) System.out.println(sb);
		else System.out.println(0);
	}
	
	static void dfs(int x, int y, int val, int count, char t, LinkedList<xy> list) {
		if(sb.length()>=1) return;
//		System.out.println("юс╫ц : "+val);
//		for(xy asd : list) {
//			System.out.print(asd.x+" "+asd.y+" / ");
//		}
//		System.out.println();
		if(count==M) {
//			System.out.println(val);
//			for(xy a : list) {
//				System.out.print(a.x+" "+a.y+" ");
//			}
//			System.out.println();
			if(val==N) {
				for(xy a : list) {
					sb.append(a.x+" "+a.y+"\n");
				}
			}
			return;
		}
		for(int i = 0; i<4; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			
			if(temp_x<0 || temp_y<0 || temp_x>2 || temp_y>2) continue;
			if(marked[temp_x][temp_y]) continue;
			
			marked[temp_x][temp_y] = true;
			
			if(array[temp_x][temp_y]=='+' || array[temp_x][temp_y]=='-') {
				
				list.add(new xy(temp_x, temp_y));
				dfs(temp_x, temp_y, val, count, array[temp_x][temp_y], list);
			
			}
			else {
				
				list.add(new xy(temp_x, temp_y));
				if(t=='+') {
					dfs(temp_x, temp_y, val+(array[temp_x][temp_y]-'0'), count+1, t, list);
				}
				else {
					dfs(temp_x, temp_y, val-(array[temp_x][temp_y]-'0'), count+1, t, list);
				}
				
			}
			marked[temp_x][temp_y] = false;
			list.removeLast();
		}
	}

}
