import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1168_yoseph_220725 {

	static int[] tree;
	static int index, vol;
	static void query(int idx, int start, int end, int left, int right) {
		int mid = (left+right)/2;
		if(vol<=0) return;
//		System.out.println(left+" "+right+" / "+start+" "+end+" / "+vol+" "+tree[idx]);
		if(left>end || right<start) {
			return;
		}
		if(left>=start && right<=end) {
			if(left==right) {
				if(tree[idx]==0) return;
//				System.out.println(left+" "+tree[idx]+" "+vol);
				vol--;
				if(vol==0) {
					index = left;
					return;
				}
				return;
			}
			if(tree[idx]<vol) {
				vol -= tree[idx];
				return;
			}
			if(tree[idx*2]>=vol) {
				query(idx*2, start, end, left, mid);
			}
			else {
				vol -= tree[idx*2];
				query(idx*2+1, start, end, mid+1, right);
			}
			
			return;
		}
		query(idx*2, start, end, left, mid);
		query(idx*2+1, start, end, mid+1, right);
		
	}
	static void dfs(int x, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			System.out.println(l+" "+tree[x]);
			return;
		}
		dfs(x*2, l, mid);
		dfs(x*2+1, mid+1, r);
	}
	
	static int update(int idx, int left, int right, int val) {
		if(val<left || val>right) return tree[idx];
		if(left==right && left==val) {
			return tree[idx] = 0;
		}
		return tree[idx] = update(idx*2, left, (left+right)/2, val) + update(idx*2+1, (left+right)/2+1, right, val);
	}
	
	static int make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			return tree[idx] = 1;
		}
		return tree[idx] = make_tree(idx*2, l, mid) + make_tree(idx*2+1, mid+1, r);
	}
	
	static int get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) return tree[idx];
		return get_val(idx*2, start, end, l, mid) + get_val(idx*2+1, start, end, mid+1, r);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		int N = Integer.parseInt(k[0]);
		int M = Integer.parseInt(k[1]);
		tree = new int[4*N+1];
		
		make_tree(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		index = 1;
		int temp_M = M;
		
		for(int i = 1; i<=N; i++) {
			int temp_val = get_val(1, index, N, 1, N);
			if(i==N) temp_M = 1;
			else if(N-i+1<M) {
				temp_M = M%(N-i+1);
				if(temp_M==0) temp_M = (N-i+1);
			}
			if(temp_val>=temp_M) {
				vol = temp_M;
//				System.out.println(i+" "+vol+" / "+index);
//				System.out.println((index+" "+vol+" / "+i));
				query(1, index, N, 1, N);
				sb.append(index+", ");
				update(1, 1, N, index);
			}
			else {
				temp_val = temp_M-temp_val;
				vol = temp_val;
//				System.out.println(i+" "+vol+" ? "+index);
//				System.out.println(index+" "+vol+" / "+i);
				query(1, 1, N, 1, N);
//				System.out.println(index);
				sb.append(index+", ");
				update(1, 1, N, index);
			}
			index++;
			if(index>N) index = 1;
//			dfs(1, 1, N);
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		System.out.println(sb);
	}

}
