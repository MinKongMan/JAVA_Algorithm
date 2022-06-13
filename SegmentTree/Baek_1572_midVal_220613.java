import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_1572_midVal_220613 {
	static int[] array,temp_array,tree,val_tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, K;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		temp_array = new int[N+1];
		
		tree = new int[4*N+1];
		val_tree = new int[4*N+1];
		
		array[0] = Integer.MIN_VALUE;
		temp_array[0] = Integer.MIN_VALUE;
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
			temp_array[i] = array[i];
		}
		
		Arrays.sort(temp_array);
		for(int i = 1; i<=N; i++) {
			hash.put(temp_array[i], i);
		}
		
		long answer = 0;
		
		for(int i = 1; i<=N; i++) {
			if(i<K) {
				update(1,1,N,hash.get(array[i]),1);
			}
			else {
				update(1,1,N,hash.get(array[i]),1);
				int ptr = get_val(1, 1, N, 1, N, (1+K)/2);
				answer += temp_array[ptr];
				update(1,1,N,hash.get(array[i-K+1]),-1);
			}
			
		}
		System.out.println(answer);
	}
	
	static int update(int idx, int start, int end, int val, int a) {
		int mid = (start+end)/2;
		if(start>val || end<val) return tree[idx];
		if(start==val && end == val) {
			val_tree[idx] = val;
			return tree[idx] += a;
		}
		return tree[idx] = update(idx*2, start, mid, val,a) + update(idx*2+1, mid+1, end, val,a);
	}
	
	static int get_val(int idx, int l, int r, int start, int end, int val) {
		int mid = (start+end)/2;
		if(start==end) {
			return val_tree[idx];
		}
		if(tree[idx*2]>=val) {
			return get_val(idx*2, l, r, start, mid, val);
		}
		else {
			return get_val(idx*2+1, l, r, mid+1, end, val-tree[idx*2]);
		}
	}

}
