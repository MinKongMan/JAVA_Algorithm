import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1722_permOrder_221222 {
	static int N, num = 0;
	static int[] array;	
	static long[] temp;
	static boolean[] marked;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        array = new int[N+1];
        temp = new long[N+1];
        marked = new boolean[N+1];
        
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        
        long val = 1;
        
        for(int i = 1; i<=N; i++) {
        	val *= i;
        	temp[i] = val;
        }
        if(count==1) {
        	long value = Long.parseLong(st.nextToken());
        	findArray(value);
        	System.out.println(sb);
        }
        else {
	        for(int i =1 ; i<=N; i++) {
	        	array[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        System.out.println(findNum()+1);
        }
	}
    
    
    static long findNum() {
    	long count = 0;
    	
    	for(int i = 1; i<=N; i++) {
    		long counting = 0;
    		for(int j = 1; j<array[i]; j++) {
    			if(marked[j]) continue;
    			else counting++;
    		}
    		marked[array[i]] = true;
    		
    		count += (temp[N-i+1]/(N-i+1))*counting;
    	}
    	return count;
    }
    
    static void findArray(long num) {
    	num--;
    	for(int i = 1; i<=N; i++) {
    		long counting = 1;
    		int idx = 0;
    		for(int j = 1; j<=N; j++) {
    			if(marked[j]) continue;
    			if(((temp[N-i+1]/(N-i+1))*counting)>num) {
    				sb.append(j+" ");
    				marked[j] = true;
    				num -= (temp[N-i+1]/(N-i+1))*(counting-1);
    				break;
    			}
    			else {
//    				System.out.println(((counting*temp[N-i+1]/(N-i+1))*counting));
//    				System.out.println(counting*temp[N-i+1]/(N-i+1)+" "+counting+" "+temp[N-i+1]+" "+(N-i+1));
//    				System.out.println((long)counting*temp[N-i+1]/(long)(N-i+1)+" / "+(counting*temp[N-i+1]));
    				counting++;
    			}
    		}
    		
    	}
//    	System.out.println(num+" / "+(2*temp[20]/20));
//    	System.out.println("243290200817664000");
    	
//    	for(int i = N; i>=1;i--) {
//    		if(!marked[i]) sb.append(i+" ");
//    	}
    }
}
