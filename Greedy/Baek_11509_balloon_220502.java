import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11509_balloon_220502 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[1000001];
		st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 1; i<=N; i++) {
			int input = Integer.parseInt(st.nextToken());
	        if (array[input + 1] == 0)
	        {
	            ++array[input];
	            ++count;
	        }
	        else
	        {
	            --array[input+1];
	            ++array[input];
	        }
		}
		
		
//		int height = array[1];
//		
//		for(int i = 1; i<=N; i++) {
//	        if (array[i]+1 == 0)
//	        {
//	            ++asd[array[i]];
//	            ++count;
//	        }
//	        else
//	        {
//	            --asd[array[i]+1];
//	            ++asd[array[i]];
//	        }
//		}
		System.out.println(count);
	}

}
