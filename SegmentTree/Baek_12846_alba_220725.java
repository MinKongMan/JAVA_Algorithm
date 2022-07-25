import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12846_alba_220725 {
	static int[] array, tree;
	static int N, count = 0;
	static long max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		array = new int[N+1];
		tree = new int[4*N+1];
		
		st = new StringTokenizer(br.readLine());
		array[0] = Integer.MAX_VALUE;
		
		for(int i =1 ; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		make_tree(1, 1, N);
		
		get_val(1, 1, N);
		System.out.println(max);
		
		
	}
	
	static int make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			tree[idx] = l;
			return tree[idx];
		}
		tree[idx*2] = make_tree(idx*2, l, mid);
		tree[idx*2+1] = make_tree(idx*2+1, mid+1, r);
		
		
		return tree[idx] = array[tree[idx*2]]<array[tree[idx*2+1]]?tree[idx*2]:tree[idx*2+1];
	}
	
	static void get_val(int idx, int l, int r) {
		if(r<l) return;
		int index = get_idx(1, l, r, 1, N);
		long val = array[index]*(r-l+1);
		
		max = Math.max(val, max);
		get_val(idx, l, index-1);
		get_val(idx, index+1, r);
	}
	
	static int get_idx(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		
		if(r<start || l>end) return 0;
		if(l>=start && r<=end) {
			return tree[idx];
		}
		
		int a = get_idx(idx*2, start, end, l, mid);
		int b = get_idx(idx*2+1, start, end, mid+1, r);
		
		return array[a]<array[b]?a:b;
	}
	
	

}
