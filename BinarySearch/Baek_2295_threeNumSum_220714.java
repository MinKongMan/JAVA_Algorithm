import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_2295_threeNumSum_220714 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		long[] array = new long[N];
		ArrayList<Long> ar = new ArrayList<Long>();
		HashSet<Long> hash = new HashSet<Long>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
			hash.add(array[i]);
		}
		Arrays.sort(array);
		for(int i = 0; i<N; i++) {
			for(int j = i; j<N; j++) {
				ar.add(array[i]+array[j]);
			}
		}
		Collections.sort(ar);
		long max = 0;
//		System.out.println(ar.size());
//		System.out.println(ar);
		for(int i = N-1; i>=0; i--) {
			for(int j = 0; j<=i; j++) {
				int l = 0;
				int r = ar.size()-1;
				int mid = 0;
//				System.out.println(i+" "+j+" / "+array[i]+" "+array[j]);
				while(l<r) {
					mid = (l+r)/2;
//					System.out.println(ar.get(mid)+" / "+l+" "+r+" "+mid);
					if(array[i]-array[j]==ar.get(mid)) {
						max = Math.max(max, array[i]);
						break;
					}
					else if(array[i]-array[j]>ar.get(mid)) {
//						r = mid;
						l = mid+1;
					}
					else {
						r = mid;
//						l = mid+1;
					}
				}
//				System.out.println(i+" "+j+" "+ar.get(l)+" / "+l+" "+mid+" "+r);
				if(array[i]-array[j]==ar.get(l)) {
					max = Math.max(max, array[i]);
				}
			}
		}
		System.out.println(max);

	}

}
