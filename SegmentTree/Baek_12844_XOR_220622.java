import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12844_XOR_220622 {
	static int[] tree, temp_tree, array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		tree = new int[4*N+1];
		temp_tree = new int[4*N+1];
		
		array = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		make_tree(1,1,N);
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			
			if(l==1) {
				int x = Integer.parseInt(st.nextToken())+1;
				int y = Integer.parseInt(st.nextToken())+1;
				int z = Integer.parseInt(st.nextToken());
				update_val(1,x,y,1,N,z);
			}
			else {
				int x = Integer.parseInt(st.nextToken())+1;
				int y = Integer.parseInt(st.nextToken())+1;
				sb.append(get_val(1,x,y,1,N)+"\n");
			}
//			for(int j = 1; j<=4*N; j++) {
//				System.out.print(tree[j]+" ");
//			}
//			System.out.println();
//			for(int j = 1; j<=4*N; j++) {
//				System.out.print(temp_tree[j]+" ");
//			}
//			System.out.println();
//			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		}
		System.out.println(sb);
	}
	
	static int make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			tree[idx] = array[l];
			return tree[idx];
		}
		return tree[idx] = make_tree(idx*2, l, mid)^make_tree(idx*2+1, mid+1, r);
	}
	
	static int get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
//		System.out.println(idx+" "+l+" "+r+" "+temp_tree[idx]);
		if(temp_tree[idx]!=0) {
			seg_tree(idx, l, r);
		}
		if(l>end || r<start) return 0;
		else if(l>=start && r<=end) {
			return tree[idx];
		}
		return get_val(idx*2, start, end, l, mid)^get_val(idx*2+1, start, end, mid+1, r);
	}
	
	static int update_val(int idx, int start, int end, int l, int r, int val) {
		int mid = (l+r)/2;
//		System.out.println(idx+" "+l+" "+r+" "+temp_tree[idx]);
		if(temp_tree[idx]!=0) {
			seg_tree(idx, l, r);
		}
		if(l>end || r<start) return tree[idx];
		else if(l==r) {
//			System.out.println(idx+" "+l+" "+tree[idx]);
			tree[idx] ^= val;
//			System.out.println(idx+" "+l+" "+tree[idx]);
			return tree[idx];
		}
		else if(l>=start && r<=end){
			temp_tree[idx] ^= val;
			seg_tree(idx, l, r);
//			tree[idx] ^= val;
//			System.out.println(idx+" "+l+" "+r+" / "+temp_tree[idx]+" "+val);
			return tree[idx];
		}
		update_val(idx*2, start, end, l, mid, val);
		update_val(idx*2+1, start, end, mid+1, r, val);
		return tree[idx] = tree[idx*2]^tree[idx*2+1];
	}
	
	static void seg_tree(int idx, int l, int r) {
		if(l==r) {
			tree[idx] ^= temp_tree[idx];
			temp_tree[idx] = 0;
			return;
		}
		else {
			if((r-l+1)%2==1) {
				tree[idx] ^= temp_tree[idx];
			}
			temp_tree[idx*2] ^= temp_tree[idx];
			temp_tree[idx*2+1] ^= temp_tree[idx];
			temp_tree[idx] = 0;
			return;
		}
	}

}
