import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_12015_biggerNum_220429 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[N+1];
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(0);
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			if(array[i]>ar.get(ar.size()-1)) ar.add(array[i]);
			else {
				int l = 1;
				int r = ar.size()-1;
				while(l<r) {
					int mid = (l+r)/2;
					if(ar.get(mid)>=array[i]) r = mid;
					else l = mid+1;
				}
				ar.set(l,array[i]);
			}
			
		}
		System.out.println(ar.size()-1);
	}

}
