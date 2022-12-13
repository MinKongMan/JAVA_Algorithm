import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1477_restArea_221213 {
	static class xy implements Comparable<xy>{
		int start;
		int end;
		int val;
		
		xy(int start, int end, int val){
			this.start = start;
			this.end = end;
			this.val = val;
		}
		
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return -this.val+arg0.val;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] array = new int[N+2];
        boolean[] marked = new boolean[K+1];
        array[N+1] = K;
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i<=N; i++) {
        	array[i] = Integer.parseInt(st.nextToken());
        	marked[array[i]] = true;
        }
        
        Arrays.sort(array);
        
        int left = 1;
        int right = K;
        
        while(left<right) {
        	int mid = (left+right)/2;
        	int sum = 0;
        	
        	for(int i = 1; i<N+2; i++) {
        		sum += (array[i]-array[i-1]-1)/mid;
        	}
        	
        	if(sum>M) left = mid+1;
        	else right = mid;
        }
        
        System.out.println(left);
    }

}
