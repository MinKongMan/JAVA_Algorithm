import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2398_3pCall_221215 {
	static class xy implements Comparable<xy>{
		int start;
		int end;
		int val;
		ArrayList<Integer> ar;
		xy(int start, int end, int val, ArrayList<Integer> ar){
			this.start = start;
			this.end = end;
			this.val = val;
			this.ar = ar;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
		
	}
	static StringBuilder sb = new StringBuilder();
	static int max = 0, ans = 0;
	static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PriorityQueue<xy> pq = new PriorityQueue<xy>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<xy>[] ar = new ArrayList[N+1];
        ArrayList<Integer>[][] array = new ArrayList[4][N+1];
        int[][] parent = new int[4][N+1];
        check = new boolean[N+1];
    	for(int j = 1; j<=N; j++) {
    		ar[j] = new ArrayList<xy>();
    		for(int i = 1; i<=3; i++) {
    			parent[i][j]= Integer.MAX_VALUE;
    			array[i][j] = new ArrayList<Integer>();
    		}
        }
        
        for(int i = 1; i<=M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int val = Integer.parseInt(st.nextToken());
        	ar[x].add(new xy(x,y,val,null));
        	ar[y].add(new xy(y,x,val,null));
        }
        
        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());
        int node3 = Integer.parseInt(st.nextToken());
        
        array[1][node1].add(node1);
        array[2][node2].add(node2);
        array[3][node3].add(node3);
        pq.add(new xy(1,node1,0,array[1][node1]));
        pq.add(new xy(2,node2,0,array[2][node2]));
        pq.add(new xy(3,node3,0,array[3][node3]));
        parent[1][node1] = 0;
        parent[2][node2] = 0;
        parent[3][node3] = 0;
        
        
        while(!pq.isEmpty()) {
        	xy node = pq.poll();
        	for(xy temp_node : ar[node.end]) {
        		if(parent[node.start][temp_node.end]>parent[node.start][node.end]+temp_node.val) {
        			parent[node.start][temp_node.end] = parent[node.start][node.end]+temp_node.val;
        			array[node.start][temp_node.end].clear();
        			array[node.start][temp_node.end].addAll(array[node.start][node.end]);
        			array[node.start][temp_node.end].add(temp_node.end);
        			pq.add(new xy(node.start,temp_node.end,parent[node.start][temp_node.end],array[node.start][temp_node.end]));
        		}
        	}
        }
        
        int max = Integer.MAX_VALUE;
        int count = 0;
        int idx = 0;
        
        for(int i = 1; i<=N; i++) {
        	if(parent[1][i]+parent[2][i]+parent[3][i]<max) {
        		max = parent[1][i]+parent[2][i]+parent[3][i];
        		count = array[1][i].size()+array[2][i].size()+array[3][i].size()-3;
        		idx = i;
        	}
//        	System.out.println(i+" "+parent[1][i]+" "+parent[2][i]+" "+parent[3][i]+" / "+array[1][i]+" "+array[2][i]+" "+array[3][i]);
        }
        
        System.out.println(max+" "+count);
        
        for(int i = 1; i<=3; i++) {
        	if(array[i][idx].size()==1) continue;
        	else {
        		for(int j = 1; j<array[i][idx].size(); j++) {
        			sb.append(array[i][idx].get(j-1)+" "+array[i][idx].get(j)+"\n");
        		}
        	}
        }
        System.out.println(sb);
	}
}
