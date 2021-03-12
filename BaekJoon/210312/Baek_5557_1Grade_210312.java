import java.util.ArrayList;
import java.util.Scanner;

public class Baek_5557_1Grade_210312 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int[] array = new int[(int) (N+1)];
		long[][] dp = new long[(int) (N+1)][21];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
//		for(int i = 0; i<=N; i++) {
//			for(int j = 0; j<21; j++) {
//				dp[i][j] = 0;
//			}
//		}
		dp[1][array[1]] = 1;
		for(int i = 1; i<N; i++) {
			System.out.println();
			for(int j= 0; j<=20; j++) {
				if(j-array[i]>=0 && dp[i-1][j-array[i]]>0) {
					dp[i][j] += dp[i-1][j-array[i]];
				}
				if(j+array[i]<=20 && dp[i-1][j+array[i]]>0) {
					dp[i][j] += dp[i-1][j+array[i]];
				}
//				if(dp[i-1][j]>0) {
//					if(j-array[i]>=0 && j+array[i]<=20) {
//						dp[i][j] = dp[i-1][j-array[i]]+dp[i-1][j+array[i]];
//					}
//					else if(j-array[i]>=0) {
//						dp[i][j] = dp[i-1][j-array[i]]+1;
//					}
//					else if(j+array[i]<=20) {
//						dp[i][j] = dp[i-1][j+array[i]]+1;
//					}
//				}
//				System.out.print(dp[i][j]+" ");
//				if(dp[i-1][j]>0) {
//					if(j-array[i]>=0 && j-array[i]==j+array[i]) {
//						dp[i][j-array[i]]++;
////						System.out.println("i : "+i+" j : "+j+" array["+i+"] = "+array[i]+" j-array[i] = "+(j-array[i]+" dp["+i+"]["+(j-array[i])+"] = "+dp[i][j-array[i]]));
//					}
//					else if(j-array[i]>=0 && j-array[i]!=j+array[i]) {
//						if(dp[i][j-array[i]]==0) {
//							dp[i][j-array[i]] = 1;
//						}
//						else {
//							dp[i][j-array[i]]++;
//						}
//						
////						System.out.println("i : "+i+" j : "+j+" array["+i+"] = "+array[i]+" j-array[i] = "+(j-array[i]+" dp["+i+"]["+(j-array[i])+"] = "+dp[i][j-array[i]]));
//					}
////					System.out.println("i-1 = "+(i-1)+" j+array[i] = "+(j+array[i])+" j-array[i] = "+(j-array[i]));
//					if(j+array[i]<=20) {
//						if(dp[i][j+array[i]]==0) {
//							dp[i][j+array[i]] = 1;
//						}
//						else {
//							dp[i][j+array[i]]++;
//						}
//						
////						System.out.println("i : "+i+" j : "+j+" array["+i+"] = "+array[i]+" j+array[i] = "+(j+array[i]+" dp["+i+"]["+(j+array[i])+"] = "+dp[i][j+array[i]]));
//					}
//					
//				}
				System.out.print(dp[i][j]+" ");
			}
		}
		System.out.println(dp[(int) (N-1)][array[(int) N]]==0?"0":dp[(int) (N-1)][array[(int) N]]);
	}

}
