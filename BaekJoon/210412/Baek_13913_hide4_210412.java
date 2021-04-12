import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baek_13913_hide4_210412 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qz = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		int[] array = new int[400001];
		boolean[] marked = new boolean[400001];
		int N = Integer.parseInt(k[0]);
		int M = Integer.parseInt(k[1]);
		marked[N] = true;
		array[0] = 1;
		qx.add(N);
		qz.add(0);
		int count = 0;
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int z = qz.poll();
			if(x==M) {
				count = z;
				break;
			}
			if(2*x>=200001) continue;
			if(!marked[x+1]) {
				marked[x+1] = true;
				array[x+1] = x;
				qx.add(x+1);
				qz.add(z+1);
			}
			
			if(!marked[2*x]) {
				marked[2*x] = true;
				array[2*x] = x;
				qx.add(x*2);
				qz.add(z+1);
			}
			if(x<=0) continue;
			if(!marked[x-1]) {
				marked[x-1] = true;
				array[x-1] = x;
				qx.add(x-1);
				qz.add(z+1);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count+"\n");
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		while(i<=count) {
			st.push(M);
			M = array[M];
			i++;
		}
		while(!st.isEmpty()) {
			sb.append(st.pop()+" ");
		}
		System.out.println(sb+" ");
	}

}
