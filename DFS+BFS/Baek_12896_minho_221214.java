import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_12896_minho_221214 {
	static ArrayList<Integer>[] ar;
	static int N;
	static int[] array;
	static boolean[] marked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        array = new int[N+1];
        ar = new ArrayList[N+1];
        marked = new boolean[N+1];
        
        for(int i = 1; i<=N; i++) {
        	ar[i] = new ArrayList<Integer>();
        }
        
        for(int i = 1; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	ar[x].add(y);
        	ar[y].add(x);
        }
        int max = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> qc = new LinkedList<Integer>();
        q.add(1);
        qc.add(0);
        marked[1] = true;
        int node = 1;
        while(!q.isEmpty()) {
        	int count = qc.poll();
        	int x = q.poll();
        	for(int a : ar[x]) {
        		if(marked[a]) continue;
        		marked[a] = true;
        		q.add(a);
        		qc.add(count+1);
        		if(count+1>max) {
        			max = count+1;
        			node = a;
        		}
        	}
        }
        
        qc.add(0);
        q.add(node);
        max = 0;
        marked = new boolean[N+1];
        marked[node] = true;
        
        while(!q.isEmpty()) {
        	int x = q.poll();
        	int count = qc.poll();
        	
        	for(int a : ar[x]) {
        		if(marked[a]) continue;
        		marked[a] = true;
        		q.add(a);
        		qc.add(count+1);
        		max = Math.max(count+1, max);
        	}
        }
        System.out.println((max+1)/2);
        
	}
    
    static void dfs(int x, int count) {
    	array[x] = Math.max(array[x], count);
//    	System.out.println(x);
    	for(int a : ar[x]) {
    		if(marked[a]) continue;
    		marked[a] = true;
    		
//    		System.out.println("¿Œµ¶Ω∫ : "+x+" "+a);
    		dfs(a,count+1);
    		array[x] = Math.max(array[x], array[a]);
    		marked[a] = false;
    	}
//    	System.out.println(x+" "+array[x]);
    }

}
