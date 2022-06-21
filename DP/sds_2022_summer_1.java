package test;
import java.util.*;
import java.io.*;
public class sds_2022_summer_1 {
    static class xy implements Comparable<xy>{
        int x;
        int y;
        int val;
        int day;
        xy(int x, int y, int val, int day){
            this.x = x;
            this.y = y;
            this.val = val;
            this.day = day;
        }
        @Override
        public int compareTo(xy arg0){
            if(this.val==arg0.val){
                return this.day-arg0.day;
            }
            return -this.val+arg0.val;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test<=tc; test++){
            // if(test!=15) {
            //     sb.append("#"+test+" "+5+"\n");
            //     continue;
            // }
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[][] array = new int[N+1][M+1];
            int[][] temp_array = new int[N+1][M+1];
            // int[][] marked = new int[N+1][M+1];
            PriorityQueue<xy> pq = new PriorityQueue<xy>();
            for(int i = 1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j<=M; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                    // marked[i][j] = 1;
                    pq.add(new xy(i,j,array[i][j],1));
                }
            }
            
            Queue<xy> q = new LinkedList<xy>();
            
            int[] day = new int[D+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=D; i++){
                day[i] = Integer.parseInt(st.nextToken());
            }
            
            long val = 0;
            while(!pq.isEmpty()){
                q.add(pq.poll());
            }
            for(int i = 1; i<=D; i++){
                long temp_val = 0;
                for(int j = 1; j<=day[i]; j++){
                    xy node = q.poll();
                    temp_val += node.val+(i-node.day);
                    q.add(new xy(node.x,node.y,1,i+1));
                    
                }
                temp_val *= i;
                val += temp_val;
            }
            
            sb.append("#"+test+" "+val+"\n");
        }
        System.out.print(sb);
    }

}
