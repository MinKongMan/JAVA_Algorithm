import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_2493_top_230126 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] array = new int[N+1];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.add(1);
		StringBuilder sb = new StringBuilder();
		sb.append(0+" ");
		for(int i = 2; i<=N; i++) {
			while(true) {
				if(array[stack.peek()]>array[i]) {
					sb.append(stack.peek()+" ");
					stack.add(i);
					break;
				}
				else stack.pop();
				if(stack.isEmpty()) {
					sb.append(0+" ");
					stack.add(i);
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
