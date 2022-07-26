import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9463_perMutation_220726 {
	
	static int[] tree, array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=test; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			array = new int[N+1];
			tree = new int[4*N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i<=N; i++) {
				array[Integer.parseInt(st.nextToken())] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			
			long val = 0;
			for(int i = 1; i<=N; i++) {
				int x = Integer.parseInt(st.nextToken());
				val += get_val(1, array[x]+1, N, 1, N);
				update(1, 1, N, array[x]);
			}
			sb.append(val+"\n");
		}
		System.out.println(sb);
	}
	
	
	static int get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) {
			return tree[idx];
		}
		
		return get_val(idx*2, start, end, l, mid) + get_val(idx*2+1, start, end, mid+1, r);
	}
	
	static int update(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
		if(val<l || val>r) return tree[idx];
		if(val==l && val==r) {
			tree[idx]++;
			return tree[idx];
		}
		return tree[idx] = update(idx*2, l, mid, val) + update(idx*2+1, mid+1, r, val);
	}
}
