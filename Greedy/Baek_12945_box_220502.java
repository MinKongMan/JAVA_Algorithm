import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_12945_box_220502 {
	static int[] VX;
	static int ptr, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		int l = 0;
		int r = N/2;
		int count = 0;
		while(l<N/2 && r<N) {
			if(array[l]*2<=array[r]) {
				count += 1;
				l++;
			}
			r++;
		}
		System.out.println(N-count);
	}
}
