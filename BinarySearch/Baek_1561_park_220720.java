import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1561_park_220720 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N<=M) System.out.println(N);
		else {
			long left = 1;
			long right = (long)2000000000*30;
			
			int[] array = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=M; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			long child = 0;
			while(left<right) {
				long mid = (left+right)/2;
				child = M;
				for(int i = 1; i<=M; i++) {
					child += mid/array[i];
				}
//				System.out.println(left+" "+right+" "+mid+" / "+child);
				
				if(child<N) {
					left = mid+1;
				}
				else {
					right = mid;
				}
			}
//			System.out.println(left);
			left--;
			
			long children = M;
			for(int i = 1; i<=M; i++) {
				children += left/array[i];
			}
			
//			System.out.println(children);
			left++;
			for(int i = 1; i<=M; i++) {
				if(left%array[i]==0) children++;
				if(children==N) {
					System.out.println(i);
					return;
				}
//				System.out.println(children+" / "+left+" "+array[i]);
			}
		}
	}

}
