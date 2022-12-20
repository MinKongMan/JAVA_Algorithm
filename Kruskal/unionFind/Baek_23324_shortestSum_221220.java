import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_23324_shortestSum_221220 {
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
		public int compareTo(xy arg0) {
			return this.val-arg0.val;
		}
	}
	static int N,M;
	static ArrayList<Integer>[] ar;
	static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ar = new ArrayList[N+1];
        parent = new int[N+1];
        
        for(int i =1 ; i<=N; i++) {
        	ar[i] = new ArrayList<Integer>();
        	parent[i] = i;
        }
        
        PriorityQueue<xy> pq = new PriorityQueue<xy>();
        
        for(int i = 1; i<=M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	if(i==K) {
        		pq.add(new xy(x,y,1));
        	}
        	else {
        		pq.add(new xy(x,y,0));
        	}
        }
        
        while(!pq.isEmpty()) {
        	xy node = pq.poll();
        	
        	if(find(parent[node.x])!=find(parent[node.y])) {
        		if(node.val==1) continue;
        		else union(node.x,node.y);
        	}
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        int[] count = new int[N+1];
        
        for(int i = 1; i<=N; i++) {
        	if(!set.contains(find(parent[i]))){
        		set.add(find(parent[i]));
        	}
        	count[find(parent[i])]++;
        }
        
        if(set.size()==1) System.out.println(0);
        else {
        	long mul = 1;
        	for(int x : set) {
        		mul *= count[x];
        	}
        	System.out.println(mul);
        }
    }
    
    static int find(int x) {
    	if(x==parent[x]) return x;
    	else return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
    	int a = find(parent[x]);
    	int b = find(parent[y]);
    	
    	if(a<b) parent[b] = a;
    	else parent[a] = b;
    }

}
