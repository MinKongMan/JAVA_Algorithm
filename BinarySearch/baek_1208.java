import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baek_1208 {

	static int[] left_array_sum, right_array_sum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c;
		long stack = 0;
		int f = 0;
		int d = 0;
		if(a%2==1) {
			f = a/2+1;
			d = (int)Math.pow(2, (a/2)+1);
		}
		else {
			f = a/2;
			d = (int)Math.pow(2, (a/2));
		}
		
		HashMap<Integer, Long> hash_l = new HashMap<Integer,Long>();
		HashMap<Integer, Long> hash_r = new HashMap<Integer,Long>();
		
		int[] l_array = new int[a/2];
		int[] r_array = new int[f];
		
		left_array_sum =new int[(int) Math.pow(2, a/2)-1];
		right_array_sum = new int[d-1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<a/2; i++) {
			l_array[i] = Integer.parseInt(st.nextToken());
			left_array_sum[(int)Math.pow(2, i)-1] = l_array[i];
		}
		
		for(int i = 0; i<f; i++) {
			r_array[i] = Integer.parseInt(st.nextToken());
			right_array_sum[(int)Math.pow(2, i)-1] = r_array[i];
		}
		Arrays.sort(l_array);
		Arrays.sort(r_array);
		
		for(int i = 0; i<a/2; i++) {
			int cntr = 0;
			c = (int) (Math.pow(2, i)-1);
			
			if(hash_l.containsKey(left_array_sum[c])) {
				long t = hash_l.get(left_array_sum[c]);
				hash_l.put(left_array_sum[c],1+t);
			}
			else {
				hash_l.put(left_array_sum[c],(long)1);
			}
			
			while(cntr<c) {
				left_array_sum[c+cntr+1]=left_array_sum[c]+left_array_sum[cntr];
				
				if(hash_l.containsKey(left_array_sum[c+cntr+1])) {
					long t = hash_l.get(left_array_sum[c+cntr+1]);
					hash_l.put(left_array_sum[c+cntr+1],1+t);
				}
				else {
					hash_l.put(left_array_sum[c+cntr+1],(long)1);
				}
				
				cntr++;
			}
		}
		
//		System.out.println(f+" "+d+" ");
		
		for(int i = 0; i<f; i++) {
			int cntr = 0;
			c = (int) (Math.pow(2, i)-1);
//			System.out.println(i+" "+c);
			if(hash_r.containsKey(right_array_sum[c])) {
				long t = hash_r.get(right_array_sum[c]);
				hash_r.put(right_array_sum[c],1+t);
			}
			else {
				hash_r.put(right_array_sum[c],(long)1);
			}
			while(cntr<c) {
				right_array_sum[c+cntr+1]=right_array_sum[c]+right_array_sum[cntr];
//				System.out.println(right_array_sum[c+cntr+1]);
				if(hash_r.containsKey(right_array_sum[c+cntr+1])) {
					long t = hash_r.get(right_array_sum[c+cntr+1]);
					hash_r.put(right_array_sum[c+cntr+1],(long)1+t);
				}
				else {
					hash_r.put(right_array_sum[c+cntr+1],(long)1);
				}
				cntr++;
			}
		}
//		System.out.println(hash_r.get(123123));
		
		Arrays.sort(left_array_sum);
		Arrays.sort(right_array_sum);
//		for(int i = 0; i<left_array_sum.length; i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		for(int i = 0; i<right_array_sum.length; i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		
		long t = 0;
		if(hash_r.containsKey(b)) {
			t = hash_r.get(b);
		}
		
		long tt = 0;
		
		if(hash_l.containsKey(b)) {
			tt = hash_l.get(b);
		}
//		System.out.println(t+" "+tt);
		stack = tt+t;
		
		for(int i = 0; i< Math.pow(2, a/2)-1; i++) {
			int l = 0;
			int r = d-1;
//			System.out.println(left_array_sum[i]);
			while(l<r) {
				int mid = (l+r)/2;
//				System.out.println(i+" "+right_array_sum[mid]+" / "+left_array_sum[i]);
				if(left_array_sum[i]+right_array_sum[mid]>b) {
					r = mid;
				}
				else if(left_array_sum[i]+right_array_sum[mid]==b) {
					if(hash_r.containsKey(right_array_sum[mid])) {
						t = hash_r.get(right_array_sum[mid]);
//						System.out.println(t+" ");
//						hash_r.put(right_array_sum[mid],1+t);
						stack += t;
					}
//					System.out.println(left_array_sum[i]+" "+right_array_sum[mid]);
					break;
					
				}
				else {
					l = mid+1;
				}
			}
		}
		
		System.out.println(stack);
//		System.out.println(stack);
	}
	
}
