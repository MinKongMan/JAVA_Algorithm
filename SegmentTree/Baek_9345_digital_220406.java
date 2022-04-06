import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9345_digital_220406 {
	static long[] tree, node, temp_tree;
	static int num = 0;
	static void make_tree(int idx, int l, int r, long[] array) {
		int mid = (l+r)/2;
		if(r==l) {
			tree[idx] = array[l];
			temp_tree[idx] = array[l];
			return;
		}
		make_tree(idx*2, l, mid, array);
		make_tree(idx*2+1, mid+1, r, array);
		temp_tree[idx] = temp_tree[idx*2]<temp_tree[idx*2]?temp_tree[idx*2]:temp_tree[idx*2];
		tree[idx] = tree[idx*2]>tree[idx*2+1]?tree[idx*2]:tree[idx*2+1];
//		System.out.println(l+" "+r+" / 최대 : "+tree[idx]+" 최소 : "+temp_tree[idx]);
		return;
	}
	
	static long query_max(int idx, int start, int end, int l, int r, long[] array) {
//		System.out.println(start+" "+end+" / "+l+" "+r);
		if(l>=start && r<=end) {
//			System.out.println("최대 리턴 "+array[idx]+" "+l+" "+r);
			return array[idx];
		}
		if(l>end || r<start) return 0;
		int mid = (l+r)/2;
		long temp1 = query_max(idx*2, start, end, l, mid, array);
		long temp2 = query_max(idx*2+1, start, end, mid+1, r, array);
//		System.out.println("최대 : "+temp1+" "+temp2+" / "+l+" "+r+" / "+start+" "+end);
		return temp1>temp2?temp1:temp2; 
	}
	
	static long query_min(int idx, int start, int end, int l, int r, long[] array) {
//		System.out.println(start+" "+end+" / "+l+" "+r);
		if(l>=start && r<=end) {
//			System.out.println("최소 리턴 "+array[idx]+" "+l+" "+r);
			return array[idx];
		}
		if(l>end || r<start) return Long.MAX_VALUE;
		int mid = (l+r)/2;
		long temp1 = query_min(idx*2, start, end, l, mid, array);
		long temp2 = query_min(idx*2+1, start, end, mid+1, r, array);
//		System.out.println("최소 "+temp1+" "+temp2+" / "+l+" "+r+" / "+start+" "+end);
		return temp1<temp2?temp1:temp2;
	}
	
	
	static long update1(int idx, int l, int r, int val, long val2) {
		int mid = (l+r)/2;
		if(l==val && r==val) {
//			System.out.print(val+" "+val2+" / "+temp_tree[idx]);
			temp_tree[idx] = val2;
//			System.out.println(" "+temp_tree[idx]);
			return temp_tree[idx];
		}
		if(l>val || r<val) return temp_tree[idx];
		long temp1 = update1(idx*2, l, mid, val, val2);
		long temp2 = update1(idx*2+1, mid+1, r, val, val2);
		return temp_tree[idx] = temp1<temp2?temp1:temp2;
	}
	
	static long update2(int idx, int l, int r, int val, long val2) {
		int mid = (l+r)/2;
		if(l==val && r==val) {
//			System.out.print(val+" "+val2+" / "+temp_tree[idx]);
			tree[idx] = val2;
//			System.out.println(" "+temp_tree[idx]);
			return tree[idx];
		}
		if(l>val || r<val) return tree[idx];
		long temp1 = update2(idx*2, l, mid, val, val2);
		long temp2 = update2(idx*2+1, mid+1, r, val, val2);
		return tree[idx] = temp1>temp2?temp1:temp2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int Test = 1; Test<=TC; Test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			node = new long[N];
			tree = new long[4*N];
			temp_tree = new long[4*N];
			
			for(int i = 0; i<N; i++) {
				node[i] = i;
			}
			
			make_tree(1,0,N-1,node);
			
//			for(int k = 1; k<4*N; k++) {
//				System.out.println(k+" "+temp_tree[k]+" "+tree[k]);
//			}
			
			for(int i = 1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				if(x==1) {
					long val1 = query_min(1, y, z, 0, N-1, temp_tree);
					long val2 = query_max(1, y, z, 0, N-1, tree);
					if(val1==y && val2==z) {
						sb.append("YES\n");
					}
					else {
						sb.append("NO\n");
					}
//					System.out.println("정답 : "+val1+" "+val2+" / "+y+" "+z+" / ");
				}
				else {
					long temp = node[y];
					node[y] = node[z];
					node[z] = temp;
					update1(1, 0, N-1, y,node[y]);
					update1(1, 0, N-1, z,node[z]);
					
					update2(1,0,N-1,y,node[y]);
					update2(1,0,N-1,z,node[z]);
					
//					make_tree2(1,0,N-1,node);
//					for(int k = 1; k<4*N; k++) {
//						System.out.println(k+" "+temp_tree[k]+" "+tree[k]);
//					}
				}
			}
		}
		System.out.println(sb);
	}

}
