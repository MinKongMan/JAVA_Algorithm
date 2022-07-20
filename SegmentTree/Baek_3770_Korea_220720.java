import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_3770_Korea_220720 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(xy arg0) {
			if(this.x==arg0.x)return this.y-arg0.y; 
			else return this.x-arg0.x;
		}
	}
	static long[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			PriorityQueue<xy> pq = new PriorityQueue<xy>();
			
			tree = new long[4*M+1];
			
			for(int i = 1; i<=K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pq.add(new xy(x,y));
			}
			
			long val = 0;
			
			while(!pq.isEmpty()) {
				xy node = pq.poll();
				int x = node.x;
				int y = node.y;
				val += get_val(1, y+1, M, 1, M);
				update(1, 1, M, y);
			}
			sb.append("Test case "+tc+": "+val+"\n");
		}
		System.out.println(sb);
	}
	
	static long update(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
		if(val<l || val>r) return tree[idx];
		if(val==l && val==r) {
			tree[idx]++;
			return tree[idx];
		}
		return tree[idx] = update(idx*2, l, mid, val) + update(idx*2+1, mid+1, r, val);
	}
	
	static long get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) return tree[idx];
		return get_val(idx*2, start, end, l, mid) + get_val(idx*2+1, start, end, mid+1, r);
	}
}
