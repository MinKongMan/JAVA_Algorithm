import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_14003_longArray_220718 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[N+1];
		int[] temp_array = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 1; i<=N; i++) {
			int x = array[i];
			if(ar.size()==0) {
				temp_array[i] = 1;
				ar.add(x);
			}
			else {
				int l = 0;
				int r = ar.size()-1;
				if(x>ar.get(r)) {
					ar.add(x);
					temp_array[i] = ar.size();
					continue;
				}
				while(l<r) {
					int mid = (l+r)/2;
					if(ar.get(mid)<x) {
						l = mid+1;
					}
					else {
						r = mid;
					}
				}
				temp_array[i] = l+1;
				ar.set(l, x);
			}
		}
		System.out.println(ar.size());
		StringBuilder sb = new StringBuilder();
		
		int idx = 0;
		
		for(int i = 1; i<=N; i++) {
			if(temp_array[i]==ar.size()) {
				idx = i;
				break;
			}
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int val = ar.size();
		
		for(int i = idx; i>=1; i--) {
			if(temp_array[i]==val) {
				stack.add(array[i]);
				val--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb);
	}

}
