import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_3745_rising_221129 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		String line = "";
		int count = 0;
		while((line = br.readLine()) != null) {
		    if(count>=1) break;int N = Integer.parseInt(line.trim());
		    st = new StringTokenizer(br.readLine().trim());
		    
			int[] array = new int[N+1];
			
			for(int i = 1; i<=N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer> ar = new ArrayList<Integer>();
			
			for(int i = 1; i<=N; i++) {
				if(ar.size()==0) ar.add(array[i]);
				else {
					int l = 0;
					int r = ar.size()-1;
					
					if(array[i]>ar.get(r)) ar.add(array[i]);
					else {
						int mid = 0;
						while(l<r) {
							mid = (l+r)/2;
							if(ar.get(mid)>=array[i]) r = mid;
							else l = mid+1;
						}
						ar.set(l, array[i]);
					}
				}
				
			}
			count++;
			sb.append(ar.size()+"\n");
		}
		System.out.println(sb);
		
		

	}

}
