import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_15823_card_230307 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] array = new int[N+1];
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 1; i<=N; i++) {
        	array[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 1;
        int right = N/M;
        int max = 0;
        
        while(left<=right) {
        	int mid = (left+right)/2;
        	int l = 1;
        	int r = 1;
        	
        	boolean check = false;
        	int count = 0;
//        	System.out.println("mid : "+mid);
        	while(true) {
        		if(r>N) {
        			if(count>=M) check = true;
        			else check = false;
        			break;
        		}
        		HashSet<Integer> set = new HashSet<Integer>();
        		boolean mark = false;
        		
        		while(r<=N) {
        			if(!set.contains(array[r])) {
        				set.add(array[r]);
        				r++;
        			}
        			else {
        				set.remove(array[l]);
        				l++;
        			}
        			if(set.size()==mid) {
//        				System.out.println(l+" "+r+" "+mid);
        				l = r;
//        				System.out.println("¹Ù²ï l, r "+l+" "+r);
        				mark = true;
        				break;
        			}
        		}
        		
        		if(mark) {
        			count++;
        		}
        	}
//        	System.out.println(left+" "+right+" / mid : "+mid+" / "+count);
        	if(check) {
//        		System.out.println("¼º°ø : "+mid);
        		left = mid+1;
        		max = Math.max(max, mid);
        	}
        	else right = mid-1;
        }
//        System.out.println(left);
        System.out.println(right);

	}

}
