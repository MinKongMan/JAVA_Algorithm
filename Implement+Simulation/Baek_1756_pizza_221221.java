import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_1756_pizza_221221 {
	static class  xy implements Comparable<xy>{
		int x;
		int depth;
		
		xy(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
		
		@Override
		public int compareTo(xy arg0) {
			if(this.x==arg0.x) return this.depth-arg0.depth; 
			return this.x-arg0.x;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] array = new int[N+1];
        int[] find = new int[M+1];
        
        st = new StringTokenizer(br.readLine());

        array[0] = Integer.MAX_VALUE;
        for(int i = 1; i<=N; i++) {
        	int x = Integer.parseInt(st.nextToken());
        	array[i] = Math.min(x, array[i-1]);
        }
        
        st = new StringTokenizer(br.readLine());

        int now_depth = N;
        
        for(int i = 1; i<=M; i++) {
        	find[i] = Integer.parseInt(st.nextToken());
        	while(now_depth>0 && find[i]>array[now_depth]) {
        		now_depth--;
        	}
//        	System.out.println(now_depth);
        	if(now_depth==0) {
        		System.out.println(0);
        		return;
        	}
        	now_depth--;
        	
        }
        
        System.out.println(now_depth+1);
        

        

	}
    
    /*
        Set<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        Collections.sort(ar);
        
        HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
        int count = 1;
        for(int i : ar) {
        	hash.put(i, count);
        	count++;
        	System.out.println(i+" "+hash.get(i));
        }
        
        int[] pizza = new int[N+1];
        Arrays.fill(pizza, Integer.MAX_VALUE);
        
        for(int i = 1; i<=N; i++) {
        	pizza[hash.get(array[i])] = Math.min(pizza[hash.get(array[i])], i);
        	pq.add(new xy(hash.get(array[i]),pizza[hash.get(array[i])]));
//        	System.out.println(pizza[array[i]]);
        }
        
        int depth = N;
        int now = 0;
        
        for(int i = 1; i<=M; i++) {
        	int x = find[i];
        	
        	if(pizza[hash.get(x)]==Integer.MAX_VALUE) {
        		now = depth;
        	}
        	else {
        		if(pizza[hash.get(x)]<now) {
        			now = pizza[hash.get(x)];
        		}
        	}
        }
     */

}
