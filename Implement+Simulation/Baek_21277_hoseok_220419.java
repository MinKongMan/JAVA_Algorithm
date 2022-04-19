import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_21277_hoseok_220419 {

	static int N1,M1,N,M;
	static int[][] array,answer;
	static int[][] temp_array1, temp_array2, temp_array3, temp_array4;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N1 = Integer.parseInt(st.nextToken());
		M1 = Integer.parseInt(st.nextToken());
		
		array = new int[153][153];
		answer = new int[153][153];
		
		for(int i = 51; i<=50+N1; i++) {
			String l = br.readLine();
			for(int j = 51; j<=50+M1; j++) {
				array[i][j] = l.charAt(j-51)-'0';
				answer[i][j] = array[i][j];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		temp_array1 = new int[105][105];
		temp_array3 = new int[105][105];
		temp_array2 = new int[105][105];
		temp_array4 = new int[105][105];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			for(int j = 1; j<=M; j++) {
				temp_array1[i][j] = l.charAt(j-1)-'0';
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				temp_array2[j][N-i+1] = temp_array1[i][j];
				temp_array3[N-i+1][M-j+1] = temp_array1[i][j];
				temp_array4[M-j+1][i] = temp_array1[i][j];
			}
		}
		
		for(int i = 1; i<=100; i++) {
			for(int j = 1; j<=100; j++) {
					int temp_x1 = Math.min(i, 51);
					int temp_y1 = Math.min(j, 51);
					int temp_x2 = Math.min(i, 51);
					int temp_y2 = Math.min(j, 51);
					
					int temp_x11 = Math.max(50+N1, i+M-1);
					int temp_y11 = Math.max(50+M1, j+N-1);
					int temp_x22 = Math.max(50+N1, i+N-1);
					int temp_y22 = Math.max(50+M1, j+M-1);
					
					int case_x1 = Math.abs(temp_x1-temp_x11)+1;
					int case_y1 = Math.abs(temp_y1-temp_y11)+1;
					int case_x2 = Math.abs(temp_x2-temp_x22)+1;
					int case_y2 = Math.abs(temp_y2-temp_y22)+1;
					
					if(check1(i,j)) {
						int val = case_x1*case_y1;
						min = min<val?min:val;
//						if(i==50 && j==50) {
//							System.out.println(case_x1+" "+case_y1+" / "+temp_x1+" "+temp_y1);
//						}
					}
					
					if(check2(i,j)) {
						int val = case_x2*case_y2;
						min = min<val?min:val;
					}
					
					if(check3(i,j)) {
						int val = case_x1*case_y1;
						min = min<val?min:val;
//						if(i==52 && j==52) {
//							System.out.println(case_x1+" "+case_y1+" / "+temp_x1+" "+temp_x11+" / "+temp_y1+" "+temp_y11);
//						}
					}
					
					if(check4(i,j)) {
						int val = case_x2*case_y2;
						min = min<val?min:val;
					}
			}
		}
		System.out.println(min);
		
	}
	
	static boolean check1(int x, int y) {
		for(int i = 1; i<=M; i++) {
			for(int j = 1; j<=N; j++) {
				if(array[x+i-1][y+j-1]+temp_array2[i][j]==2) return false;
				answer[x+i-1][y+j-1] = array[x+i-1][y+j-1]+temp_array2[i][j];
			}
		}
		return true;
	}
	
	static boolean check2(int x, int y) {
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[x+i-1][y+j-1]+temp_array3[i][j]==2) return false;
				answer[x+i-1][y+j-1] = array[x+i-1][y+j-1]+temp_array3[i][j];
			}
		}
		return true;
	}
	
	static boolean check3(int x, int y) {
		for(int i = 1; i<=M; i++) {
			for(int j = 1; j<=N; j++) {
				if(array[x+i-1][y+j-1]+temp_array4[i][j]==2) return false;
			}
		}
		return true;
	}
	
	static boolean check4(int x, int y) {
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(array[x+i-1][y+j-1]+temp_array1[i][j]==2) return false;
				answer[x+i-1][y+j-1] = array[x+i-1][y+j-1]+temp_array1[i][j];
			}
		}
		return true;
	}
}
