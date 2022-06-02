import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_9007_canu_220602 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N,M;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[][] array = new int[5][M+1];
			for(int i = 1; i<=4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=M; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] a1 = new int[M*M];
			int[] b1 = new int[M*M];
			
			int count = 0;
			for(int i = 1; i<=M; i++) {
				for(int j = 1; j<=M; j++) {
					a1[count] = array[1][i]+array[2][j];
					b1[count] = array[3][i]+array[4][j];
					count++;
				}
			}
			
			Arrays.sort(a1);
			Arrays.sort(b1);
			
			int cha = Integer.MAX_VALUE;
			int real = 0;
			
			for(int i = 0; i<M*M; i++) {
				int l = 0;
				int r = M*M;
				int val = a1[i];
				
				while(l<r) {
					int mid = (l+r)/2;
					int temp_cha = Math.abs(N-(val+b1[mid]));
					if(temp_cha<cha) {
						cha = temp_cha;
						real = val+b1[mid];
					}
					else if(temp_cha==cha) {
						real = Math.min(val+b1[mid], real);
					}
					if(b1[mid]+val<N) l = mid+1;
					else if(b1[mid]+val>N) r = mid;
					else {
						l = mid;
						real = N;
						cha = 0;
						break;
					}
				}
				
//				int temp_cha1 = Math.abs(N-(val+b1[l]));
//				int temp_cha2 = Math.abs(N-(val+b1[l-1]));
//				if(temp_cha2<=temp_cha1) {
//					l = l-1;
//				}
//				
//				if(val+b1[l]==N) {
//					real = val+b1[l];
//					break;
//				}
//				else {
//					int temp = Math.abs(N-(b1[l]+val));
//					if(temp<cha) {
//						cha = temp;
//						real = b1[l]+val;
//					}
//					else if(temp==cha) {
//						real = Math.min(b1[l]+val, real);
//					}
//				}
//				System.out.println(t+" : "+(val+b1[l])+" / "+val);
			}
			sb.append(real+"\n");
			
		}
		System.out.println(sb);
		
		
	}

}
