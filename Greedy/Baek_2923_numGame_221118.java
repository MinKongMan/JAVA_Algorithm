import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2923_numGame_221118 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int[] right = new int[101];
		int[] left = new int[101];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			right[x]++;
			left[y]++;
			
			int l = 1;
			int r = 100;
			
			int[] tl = new int[101];
			int[] tr = new int[101];
			
			for(int j = 1; j<=100; j++) {
				tl[j] = left[j];
				tr[j] = right[j];
			}
			
			int ans = 0;
			
			while(l<=100 && r>=1) {
				while(l<=100 && tl[l]==0) l++;
				while(r>=1 && tr[r]==0) r--;
				if(l>100 || r<1) break;
				ans = Math.max(ans, l+r);
				
				if(tl[l]>=tr[r]) {
					tl[l] -= tr[r];
					tr[r] = 0;
				}
				else if(tr[r]>=tl[l]) {
					tr[r] -= tl[l];
					tl[l] = 0;
				}
			}
			sb.append(ans+"\n");
			
		}
		System.out.println(sb);
	}

}
