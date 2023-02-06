import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_17299_fifthBigNumber {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[N+1];
		int[] counting = new int[1000001];
		int[] answer = new int[N+1];
		Stack<Integer> stack = new Stack<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			int x = Integer.parseInt(st.nextToken());
			array[i] = x;
			counting[x]++;
		}
		
		for(int i = N; i>=1; i--) {
			if(stack.isEmpty()) {
				stack.add(array[i]);
				answer[i] = -1;
			}
			else {
				while(!stack.isEmpty()) {
					int x = stack.peek();
					if(counting[x]>counting[array[i]]) {
						answer[i] = stack.peek();
						stack.add(array[i]);
						break;
					}
					else {
						stack.pop();
					}
					
					if(stack.isEmpty()) {
						answer[i] = -1;
						stack.add(array[i]);
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
	}

}
