import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_16566_cardGame_220803 {
	static int[] tree, array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		array = new int[N+1];
		tree = new int[4*N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=M; i++) {
			array[Integer.parseInt(st.nextToken())]++;
		}
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		make_tree(1, 1, N);
		
		for(int i = 1; i<=K; i++) {
			int x = Integer.parseInt(st.nextToken());
			int a = get_val(1, x+1, N, 1, N);
			sb.append(a+"\n");
			update(1, 1, N, a);
		}
		System.out.println(sb);
	}

	public static int make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		
		if(l==r) {
			if(array[l]>0) return tree[idx] = l;
			else return tree[idx] = Integer.MAX_VALUE;
		}
		tree[idx*2] = make_tree(idx*2, l, mid);
		tree[idx*2+1] = make_tree(idx*2+1, mid+1, r);
		return tree[idx] = Math.min(tree[idx*2], tree[idx*2+1]);
	}
	
	public static int get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		if(l>end || r<start) return Integer.MAX_VALUE;
		if(l>=start && r<=end) return tree[idx];
		return Math.min(get_val(idx*2, start, end, l, mid), get_val(idx*2+1, start, end, mid+1, r));
	}
	
	public static int update(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
		if(val<l || val>r) return tree[idx];
		if(val==l && val==r) return tree[idx] = Integer.MAX_VALUE;
		tree[idx*2] = update(idx*2, l, mid, val);
		tree[idx*2+1] = update(idx*2+1, mid+1, r, val);
		return tree[idx] = Math.min(tree[idx*2], tree[idx*2+1]);
	}
}
