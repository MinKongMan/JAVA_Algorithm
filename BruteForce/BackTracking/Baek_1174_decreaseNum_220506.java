import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1174_decreaseNum_220506 {
	static int N;
	static long[] array, ar;
	static int count = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		array = new long[1000001];
		Arrays.fill(array, -1);
		ar = new long[11];
		count = 1;
		ar[0] = 10;
		
		for(int i = 0; i<=9; i++) {
			array[count] = i;
			count++;
		}
		
		for(int i = 2; i<=10; i++) {
			dfs(i, 1, 0);
		}
		
//		System.out.println((long)987654321*(long)10+" / "+"¤»¤»");
		array[1023] = (long)987654321*(long)10;
//		System.out.println(array[1023]);
		System.out.println(array[N]);
		
		
	}
	
	
	static void dfs(int a, int b, long val) {
		if(a+1==b) {
			array[count] = val;
//			System.out.println(count+" "+val+" / "+array[count]);
			count++;
			return;
		}
		for(int i = 0; i<=9; i++) {
			if(ar[b-1]>i) {
				ar[b] = i;
				dfs(a, b+1, val*10+i);
			}
		}
	}
}
