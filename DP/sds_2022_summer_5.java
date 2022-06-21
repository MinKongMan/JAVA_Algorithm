package test;
import java.util.*;
import java.io.*;
public class sds_2022_summer_5 {
    static int N,M,K;
    static long[][][] dp;
    static int[][] array;
    static boolean[][] marked;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test<=tc; test++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            dp = new long[K+1][N+1][M+1];
            array = new int[N+1][M+1];
            int start_x = 0;
            int start_y = 0;
            
            for(int i = 1; i<=N; i++){
                String l = br.readLine();
                for(int j = 1; j<=M; j++){
                    if(l.charAt(j-1)=='X') array[i][j] = 1;
                    else if(l.charAt(j-1)=='S') {
                        start_x = i;
                        start_y = j;
                        array[i][j] = 5;
                    }
                    for(int k = 0; k<=K; k++){
                        dp[k][i][j] = -1;
                    }
                }
            }
            // System.out.println(start_x+" "+start_y);
            dfs(start_x,start_y,0);
            sb.append("#"+test+" "+(dp[0][start_x][start_y]%1000000007)+"\n");
//            for(int k = 0; k<=K; k++) {
//            	System.out.println(k);
//            	for(int i = 1; i<=N; i++){
//                 for(int j = 1; j<=M; j++){
//                     System.out.print(dp[k][i][j]+" ");
//                 }
//                 System.out.println();
//             }
//            }
        }
        System.out.println(sb);
            
    }
    
    static void dfs(int a, int b, int c){
        if(dp[c][a][b]!=-1) return;
        dp[c][a][b] = 0;
        if(c==K) return;
        
        for(int i = 0 ; i<4; i++){
            int temp_x = a+dx[i];
            int temp_y = b+dy[i];
            if(temp_x< 1 || temp_y<1 || temp_x>N || temp_y>M){
//            	System.out.println(c+" "+temp_x+" "+temp_y);
                dp[c][a][b]++;
                continue;
            }
            if(array[temp_x][temp_y]==1) continue;
//            System.out.println(temp_x+" "+temp_y+" "+(c+1));
//            if(dp[c+1][temp_x][temp_y]>=0) continue;
            dfs(temp_x,temp_y,c+1);
            dp[c][a][b] += dp[c+1][temp_x][temp_y];
            dp[c][a][b] %= 1000000007;
        }
    }

}
