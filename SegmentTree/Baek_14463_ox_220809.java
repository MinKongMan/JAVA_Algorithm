import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_14463_ox_220809 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(xy arg0) {
			return this.x-arg0.x;
		}
	}
	static long[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		tree = new long[8*N+1];
		int[][] array = new int[N+1][3];
		int[] ar = new int[N+1];
		
		for(int i = 1; i<=N*2; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(ar[x]==0) {
				ar[x]++;
				array[x][1] = i;
			}
			else {
				array[x][2] = i;
			}
		}
		
		long val = 0;
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			int x = array[i][1];
			int y = array[i][2];
			pq.add(new xy(x,y));
		
		}
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			val += get_val(1, x, y, 1, 2*N);
			update(1, 1, 2*N, x);
			update(1, 1, 2*N, y);
			System.out.println("天天天天天天天天天天天天天天天天天天");
			System.out.println(val+" / "+x+" "+y);
		}
		System.out.println(val);
	}
	
	static long get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) return tree[idx];
		
		return get_val(idx*2, start, end, l, mid) + get_val(idx*2+1, start, end, mid+1, r);
	}
	
	static long update(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
		if(val<l || val>r) return tree[idx];
		if(l==r && r==val) {
//			System.out.println(l+" "+val);
			tree[idx]++;
			return tree[idx];
		}
		return tree[idx] = update(idx*2, l, mid, val) + update(idx*2+1, mid+1, r, val);
	}

}
