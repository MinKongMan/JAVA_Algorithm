import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Baek_9505_enterprise_221216 {
	static StringBuilder sb = new StringBuilder();
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int val;
		
		xy(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int test = Integer.parseInt(st.nextToken());
        
        for(int TC = 1; TC<=test; TC++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        
        	HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        	
        	for(int i = 1; i<=x; i++) {
        		String[] l = br.readLine().split(" ");
        		char a = l[0].charAt(0);
        		int num = Integer.parseInt(l[1]);
        		
        		hash.put(a, num);
        	}
        	
        	int[][] array = new int[y+1][z+1];
        	
        	int startX = 0;
        	int startY = 0;
        	for(int i = 1; i<=y; i++) {
        		String l = br.readLine();
        		for(int j=1 ; j<=z; j++) {
        			if(l.charAt(j-1)=='E') {
        				startX = i; startY = j;
        				array[i][j] = 0;
        			}
        			else {
        				array[i][j] = hash.get(l.charAt(j-1));
        			}
        		}
        	}
        	
        	dijk(y,z,array,startX,startY);
        }
        System.out.println(sb);
	}
    
    static void dijk(int N, int M, int[][] array, int x, int y) {
    	PriorityQueue<xy> pq = new PriorityQueue<xy>();
    	pq.add(new xy(x,y,0));
    	
    	int[][] parent = new int[N+1][M+1];
    	
    	for(int i = 1; i<=N; i++) {
    		for(int j = 1; j<=M; j++) {
    			parent[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	parent[x][y] = 0;
    	int[] dx = {-1,0,1,0};
    	int[] dy = {0,1,0,-1};
    	
    	while(!pq.isEmpty()) {
    		xy node = pq.poll();
    		int a = node.x;
    		int b = node.y;
    		
    		for(int i = 0; i<4; i++) {
    			int temp_x = a+dx[i];
    			int temp_y = b+dy[i];
    			
    			if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) continue;
    			
    			if(parent[temp_x][temp_y]>parent[a][b]+array[temp_x][temp_y]) {
    				parent[temp_x][temp_y] = parent[a][b]+array[temp_x][temp_y];
    				pq.add(new xy(temp_x,temp_y,parent[temp_x][temp_y]));
    			}
    		}
    	}
    	sb.append(findVal(N,M,parent)+"\n");
    }
    
    static int findVal(int N, int M, int[][] array) {
    	int min = Integer.MAX_VALUE;
    	
    	for(int i = 1; i<=N; i++) {
    		min = Math.min(array[i][1], min);
    		min = Math.min(array[i][M], min);
    	}
    	
    	for(int i = 1; i<=M; i++) {
    		min = Math.min(array[1][i], min);
    		min = Math.min(array[N][i], min);
    	}
    	return min;
    }

}
