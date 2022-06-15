import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12837_gagye_220616 {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		tree = new long[4*N+1];
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if(x==1) {
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				update(1, 1, N, z, y);
			}
			else {
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				sb.append(get(1, y, z, 1, N)+"\n");
			}
//			for(int j = 1; j<=4*N; j++) {
//				System.out.print(tree[j]+" ");
//			}
//			System.out.println();
		}
		System.out.println(sb);
	}
	
	static long update(int idx, int l, int r, long val, int ptr) {
		int mid = (l+r)/2;
		if(ptr<l || ptr>r) return tree[idx];
		if(ptr==l && ptr==r) {
			return tree[idx] += val;
		}
		return tree[idx] = update(idx*2, l, mid, val, ptr) + update(idx*2+1, mid+1, r, val, ptr);
		
	}
	
	static long get(int idx, int l, int r, int start, int end) {
		int mid = (start+end)/2;
		if(start>r || end<l) return 0;
		if(start>=l && end<=r) {
			return tree[idx];
		}
		return get(idx*2, l, r, start, mid) + get(idx*2+1, l, r, mid+1, end);
		
	}

}
