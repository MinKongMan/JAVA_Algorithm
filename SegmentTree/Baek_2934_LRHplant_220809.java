import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2934_LRHplant_220809 {
	static long[] tree, temp_tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		tree = new long[400001];
		temp_tree =new long[400001];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long a = get_val(1, 1, 100000, x);
			long b = get_val(1, 1, 100000, y);
			sb.append(a+b+"\n");
			
			update(1, x, x, 1, 100000, 0);
			update(1, y, y, 1, 100000, 0);
			update(1, x+1, y-1, 1, 100000, 1);
//			System.out.println(a+" "+b+" / "+(x+1)+" "+(y-1));
//			System.out.println("天天天天天天天天天天天天天天天天天");
		}
		System.out.println(sb);
	}
	
	static long get_val(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
		if(temp_tree[idx]!=0) update_temp_tree(idx, l, r);
		if(val<l || val>r) return 0;
		if(l==val && r==val) return tree[idx];
		
		return get_val(idx*2, l, mid, val)+ get_val(idx*2+1, mid+1, r, val);
	}
	
	static long update(int idx, int start, int end, int l, int r, int val) {
		if(start>end) return 0;
		int mid = (l+r)/2;
		if(temp_tree[idx]!=0) update_temp_tree(idx, l, r);
//		System.out.println(start+" "+end+" /// "+l+" "+r);
		if(r<start || l>end) return tree[idx];
		if(l>=start && r<=end) {
			update_temp_tree(idx, l, r);
			if(val==0) {
				tree[idx] = 0;
			}
			else {
				temp_tree[idx] += val;
				update_temp_tree(idx, l, r);
			}
//			System.out.println(start+" "+end+" / "+l+" "+r);
			return tree[idx];
		}
		return tree[idx] = update(idx*2, start, end, l, mid, val) + update(idx*2+1, start, end, mid+1, r, val);
	}
	
	static void update_temp_tree(int idx, int l, int r) {
		if(l==r) {
			tree[idx] += temp_tree[idx];
//			System.out.println(l+" "+r+" / "+tree[idx]);
			temp_tree[idx] = 0;
			return;
		}
		tree[idx] += temp_tree[idx];
		temp_tree[idx*2] += temp_tree[idx];
		temp_tree[idx*2+1] += temp_tree[idx];
		temp_tree[idx] = 0;
		
	}

}
