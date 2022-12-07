import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9207_pegSolitare_221207 {
	static int min = 10000, move = 10000;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] array = new int[6][10];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			min = 10000;
			move = 10000;
			
			int pin = 0;
			
			for(int k = 1; k<=5; k++) {
				String l = br.readLine();
				for(int j = 1; j<10; j++) {
					if(l.charAt(j-1)=='#') array[k][j] = 1;
					else if(l.charAt(j-1)=='o') {
						array[k][j] = 5;
						pin++;
					}
					else array[k][j] = 0;
				}
			}
			
			dfs(array,pin,0);
			sb.append(min+" "+move+"\n");
			br.readLine();
		}
		System.out.println(sb);
	}
	
	static void dfs(int[][] array, int pin, int count) {
		if(pin<min) {
			min = pin;
			move = count;
		}
//		for(int i = 1; i<=5; i++) {
//			for(int j = 1; j<=9; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("天天天天天天天天天天天天天天天天");
		for(int i = 1; i<=5; i++) {
			for(int j = 1; j<=9; j++) {
				if(array[i][j]==5) {
					for(int k = 0; k<4; k++) {
						int temp_x = i+dx[k];
						int temp_y = j+dy[k];
						
						if(temp_x<1 || temp_y<1 || temp_x>5 || temp_y>9) continue;
						if(array[temp_x][temp_y]!=5) continue;
						
						int tx = temp_x+dx[k];
						int ty = temp_y+dy[k];
						
						if(tx<1 || ty<1 || tx>5 || ty>9) continue;
						if(array[tx][ty]!=0) continue;
						
						array[temp_x][temp_y] = 0;
						array[i][j] = 0;
						array[tx][ty] = 5;
						
						dfs(array,pin-1,count+1);
						array[i][j] = 5;
						array[tx][ty] = 0;
						array[temp_x][temp_y] = 5;
					}
				}
			}
		}
	}

}
