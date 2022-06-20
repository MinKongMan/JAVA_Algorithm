package test;

import java.util.*;
import java.io.*;
public class sds_2022_summer_4 {
    static class xy implements Comparable<xy>{
         int end;
         int num;
         int count;
         xy(int x, int y, int count){
            this.end = x;
            this.num = y;
            this.count = count;        
        }
 
         @Override
         public int compareTo(xy arg0){
            return this.count-arg0.count;
         }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test<=tc; test++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int[] array = new int[M+1];
            int[] val = new int[N+1];
            ArrayList<xy>[] ar =  new ArrayList[N+1];
            for(int i = 1; i<=N; i++){
                ar[i] = new ArrayList<xy>();
                val[i] = Integer.MAX_VALUE;
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=M; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                int[] temp_array = new int[array[i]+1];
                for(int j = 1; j<=array[i]; j++){
                    temp_array[j] = Integer.parseInt(st.nextToken());
                }
                
                for(int j = 1; j<array[i]; j++){
                	for(int k = j+1; k<=array[i]; k++) {
	                    int x = temp_array[j];
	                    int y = temp_array[k];
	                    ar[x].add(new xy(y,i,0));
	                    ar[y].add(new xy(x,i,0));
	                }
                }
            }
            
            PriorityQueue<xy> pq = new PriorityQueue<xy>();
            boolean[] marked = new boolean[N+1];
            val[start] = 0;
            for(xy node : ar[start]){
                val[node.end] = 0;
                pq.add(new xy(node.end,node.num,0));
            }
            while(!pq.isEmpty()){
                xy node = pq.poll();
                for(xy temp_node : ar[node.end]){
                    if(node.num==temp_node.num){
                        if(val[temp_node.end]>node.count){
//                        	System.out.println("같음 : "+node.end+" "+temp_node.end);
                            val[temp_node.end] = node.count;
                            pq.add(new xy(temp_node.end,temp_node.num,val[temp_node.end]));
                        }
                    }
                    else{
                        if(val[temp_node.end]>=node.count+1){
//                        	System.out.println("다름 : "+node.end+" "+temp_node.end);
                            val[temp_node.end] = node.count+1;
                            pq.add(new xy(temp_node.end,temp_node.num,val[temp_node.end]));
                        }
                    }
                }
            }
            if(val[end]==Integer.MAX_VALUE) sb.append("#"+test+" -1\n");
            else sb.append("#"+test+" "+val[end]+"\n");
        }
        System.out.println(sb);
    }
}
