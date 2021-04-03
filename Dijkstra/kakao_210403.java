import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class PQ implements Comparable<PQ>{
	int end;
	int val;
	PQ(int end, int val){
		this.end = end;
		this.val = val;
	}
	@Override
	public int compareTo(PQ arg0) {
		// TODO Auto-generated method stub
		return this.val-arg0.val;
	}
	
}
public class kakao_210403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		int N = Integer.parseInt(k[0]);
		
		
		PriorityQueue<PQ> q = new PriorityQueue<PQ>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] array = new int[N+1];
		int[] array2 = new int[N+1];
		int[] val = new int[N+1];
		boolean[] marked = new boolean[N+1];
		ArrayList<PQ>[] ar = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<PQ>();
			array[i] = Integer.parseInt(st.nextToken());
			array2[i] = array[i];
		}
		
		for(int i = 1; i<=N; i++) {
			val[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i<=N-1; i++) {
			k = br.readLine().split(" ");
			int a = Integer.parseInt(k[0]);
			int b = Integer.parseInt(k[1]);
			ar[a].add(new PQ(b,array[b]));
			ar[b].add(new PQ(a,0));
		}
		val[1] = array[1];
		q.add(new PQ(1,0));
		while(!q.isEmpty()) {
			PQ kwang = q.poll();
			int x = kwang.end;
			int y = kwang.val;
			if(!marked[x]) {
				marked[x] = true;
				for(PQ kang: ar[x]) {
					if(val[kang.end]>val[x]+array[kang.end]) {
						val[kang.end]= val[x]+array[kang.end];
						q.add(new PQ(kang.end,val[kang.end]));
					}
				}
			}
		}
			
		int max = 0;
		for(int i = 1; i<=N; i++) {
			max = max>val[i]?max:val[i];
		}
		int destination = 0;
		for(int i = 1; i<=N; i++) {
			if(val[i]==max) {
				destination = i;
			}
		}
		System.out.println(destination+" "+max);
	}

}