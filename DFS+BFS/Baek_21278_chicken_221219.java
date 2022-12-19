import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_21278_chicken_221219 {
	static int N,M;
	static ArrayList<Integer>[] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        ar = new ArrayList[N+1];
        
        for(int i = 1; i<=N; i++) {
        	ar[i] = new ArrayList<Integer>();
        }
        
        for(int i = 1; i<=M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	ar[x].add(y);
        	ar[y].add(x);
        }
        
        int min = Integer.MAX_VALUE;
        int a1 = 0, b1 = 0;
        for(int i = 1; i<=N; i++) {
        	for(int j = i+1; j<=N; j++) {
        		int[] array = new int[N+1];
        		Arrays.fill(array, Integer.MAX_VALUE);
        		
        		Queue<Integer> qx = new LinkedList<Integer>();
        		Queue<Integer> qc = new LinkedList<Integer>();
        		qx.add(i);
        		qx.add(j);
        		qc.add(0);
        		qc.add(0);
        		
        		array[i] = 0;
        		array[j] = 0;
        		
        		while(!qx.isEmpty()) {
        			int x = qx.poll();
        			int count = qc.poll();
        			
        			for(int a : ar[x]) {
        				if(array[a]>count+1) {
        					array[a] = count+1;
        					qx.add(a);
        					qc.add(count+1);
        				}
        			}
        		}
        		
        		int sum = 0;
        		
        		for(int k = 1; k<=N; k++) {
        			sum += array[k]*2;
        		}
        		
        		if(sum<min) {
//        			System.out.println(sum+" "+min);
        			min = sum;
        			a1 = i;
        			b1 = j;
        		}
        	}
        }
        System.out.println(a1+" "+b1+" "+min);
	}

}
