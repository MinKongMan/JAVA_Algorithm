import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_7469_NstNum_210718 {

	static int[] tree;
	static ArrayList<Integer>[] ar_tree;
	static int answer = Integer.MAX_VALUE;
	static int max = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		int N = Integer.parseInt(k[0]);
		int M = Integer.parseInt(k[1]);
		ar_tree = new ArrayList[4*N+1];
		tree = new int[N+1];
		
		for(int i = 1; i<=4*N; i++) {
			ar_tree[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 1; i<=N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		make_tree(1, 1, N);
		StringBuilder sb = new StringBuilder();
//		for(int i = 1; i<=4*N; i++) {
//			System.out.println(ar_tree[i]);
//		}
		int count = 0;
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			answer = Integer.MAX_VALUE;
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = -max;
			int r = max;
			while(l<=r) {
				int mid = (l+r)/2;
				int kl = query(1,a,b,1,N,mid);
				if(kl<c) {
					l = mid+1;
				}
				else {
					r = mid-1;
				}
			}
			sb.append(r+"\n");
		}
		System.out.println(sb);
	}
	
	static int query(int idx, int start, int end, int l, int r, int val) {
		int mid = (l+r)/2;
		
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) {
			int left = 0;
			int right = ar_tree[idx].size();
			int midd = (left+right)/2;
//			System.out.print(start+" "+end+" / "+l+" "+r+" "+val+" /// ");
			while(left<right) {
				midd = (left+right)/2;
				if(ar_tree[idx].get(midd)<val) {
					left = midd+1;
				}
				else right = midd;
			}
//			System.out.println("аб : "+left);
			return left;
		}
		return query(idx*2, start, end, l, mid, val)+query(idx*2+1, start, end, mid+1, r, val);
	}
	
	static ArrayList<Integer> make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			ar_tree[idx].add(tree[l]);
			return ar_tree[idx];
		}
		ar_tree[idx*2] = make_tree(idx*2, l, mid);
		ar_tree[idx*2+1] = make_tree(idx*2+1, mid+1, r);
		
		return ar_tree[idx] = merge_tree(ar_tree[idx*2], ar_tree[idx*2+1]);
	}
	
	static ArrayList<Integer> merge_tree(ArrayList<Integer> l_ar, ArrayList<Integer> r_ar){
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int l = 0, r = 0;
		while(l<l_ar.size() && r<r_ar.size()) {
			if(l_ar.get(l)<r_ar.get(r)) {
				ar.add(l_ar.get(l));
				l++;
			}
			else {
				ar.add(r_ar.get(r));
				r++;
			}
		}
		while(l<l_ar.size()) {
			ar.add(l_ar.get(l));
			l++;
		}
		while(r<r_ar.size()) {
			ar.add(r_ar.get(r));
			r++;
		}
		return ar;
	}
}
