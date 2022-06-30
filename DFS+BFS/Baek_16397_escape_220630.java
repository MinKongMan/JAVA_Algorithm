import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16397_escape_220630 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> qc = new LinkedList<Integer>();
		
		q.add(N);
		qc.add(0);
		
		boolean[] marked = new boolean[100000];
		marked[N] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			int c = qc.poll();
			if(c>T) {
				System.out.println("ANG");
				return;
			}
			
			if(node==M) {
				System.out.println(c);
				return;
			}
//			System.out.println(node);
			if(node+1>=100000) {}
			else {
				if(marked[node+1]) {}
				else{
					marked[node+1] = true;
					q.add(node+1);
					qc.add(c+1);
				}
			}
			if(node*2>=100000) {}
			else {
				int n = node*2;
				if(node*2>=0 && node*2<10) {
					n -= 1;
				}
				else if(n>=10 && n<100) {
					n -= 10;
				}
				else if(n>=100 && n<1000) {
					n -= 100;
				}
				else if(n>=1000 && n<10000) {
					n -= 1000;
				}
				else {
					n -= 10000;
				}
				if(n<0) continue;
//				System.out.println(node+" "+(node*2)+" "+n);
				if(marked[n]) {}
				else {
					marked[n] = true;
					q.add(n);
					qc.add(c+1);
				}
			}
		}
		
		System.out.println("ANG");
	}

}
