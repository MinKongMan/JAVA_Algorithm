import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14727_puzzleCut_220704 {
	static int[] tree,array;
	static int N,count = 0;
	static long max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tree = new int[4*N+1];
		array = new int[N+1];
		array[0] = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		make_tree(1,1,N);
//		for(int i = 1; i<=4*N; i++) {
//			System.out.print(tree[i]+" ");
//		}
//		System.out.println();
		update(1,N);
		System.out.println(max);
	}
	
	static int get_val(int idx, int start, int end, int l, int r) {
		
		int mid = (l+r)/2;
		
		if(l>end || r<start) return 0;
		if(l==r) {
//			System.out.println("같음 : "+l+" "+tree[idx]);
			return tree[idx];
		}
		if(l>=start && r<=end) {
//			System.out.println("안으로 들어옴 : "+l+" "+r+" / "+tree[idx]);
			return tree[idx];
		}
		int idx1 = get_val(idx*2, start, end, l, mid);
		int idx2 = get_val(idx*2+1, start, end, mid+1, r);
//		System.out.println(l+" "+r+" "+idx1+" "+idx2);
//		System.out.println(start+" "+end+" / "+l+" "+r+" / "+idx1+" "+idx2);
		return array[idx1]<array[idx2]?idx1:idx2;
	}
	
	static int make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			tree[idx] = l;
			return l;
		}
		tree[idx*2] = make_tree(idx*2, l, mid);
		tree[idx*2+1] = make_tree(idx*2+1, mid+1, r);
		return tree[idx] = array[tree[idx*2]]<array[tree[idx*2+1]]?tree[idx*2]:tree[idx*2+1];
	}
	
	static void update(int l, int r) {
		if(l==r) {
			max = Math.max(max, array[l]);
			return;
		}
		if(r<l) return;
		int idx = get_val(1, l, r, 1, N);
		
		long now = (r-l+1)*array[idx];
//		System.out.println(idx+" / "+l+" "+r);
		long left = (long)array[get_val(1, l, idx-1, 1, N)]*(long)(idx-l);
		long right = (long)array[get_val(1, idx+1, r, 1, N)]*(long)(r-(idx+1)+1);
		update(l,idx-1);
		update(idx+1,r);
		if(left>right) {
//			System.out.println(l+" "+idx);
			
			long temp_val = Math.max(left, now);
			max = Math.max(max, temp_val);
		}
		else {
			
			long temp_val = Math.max(right,now);
			max = Math.max(max, temp_val);
		}
		
	}

}
