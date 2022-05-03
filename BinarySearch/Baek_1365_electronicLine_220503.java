import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_1365_electronicLine_220503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		
		ar.add(0);
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(ar.get(ar.size()-1)<x) ar.add(x);
			else {
				int l = 1;
				int r = ar.size()-1;
				while(l<r) {
					int mid = (l+r)/2;
					if(ar.get(mid)>x) {
						r = mid;
					}
					else {
						l = mid+1;
					}
				}
				ar.set(l, x);
			}
		}
		for(int x : ar) {
			System.out.println(x);
		}
		System.out.println(N-(ar.size()-1));
	}

}
