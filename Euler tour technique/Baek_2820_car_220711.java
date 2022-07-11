import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_2820_car_220711 {
	static long[] temp_tree, tree, temp_val, val;
	static ArrayList<Integer>[] ar;
	static int[][] euler;
	static int[] array;
	static int count = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ar = new ArrayList[N+1];
		
		array = new int[N+1];
		tree = new long[4*N+1];
		temp_tree = new long[4*N+1];
		euler = new int[N+1][3];
		temp_val = new long[N+1];
		val = new long[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		temp_val[1] = Integer.parseInt(st.nextToken());
		
		for(int i = 2; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar[y].add(i);
			temp_val[i] = x;
		}
		
		StringBuilder sb = new StringBuilder();
		dfs(1);
		for(int i = 1; i<=N; i++) {
			val[i] = temp_val[array[i]];
//			System.out.println(euler[i][1]+" "+euler[i][2]+" / "+val[i]+" "+temp_val[array[i]]);
		}
		make_tree(1, 1, N);
//		for(int i = 1; i<=4*N; i++) {
//			System.out.println(tree[i]+" ");
//		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			if(a=='u') {
				int x = Integer.parseInt(st.nextToken());
				sb.append(get_val(1, euler[x][1], 1, N)+"\n");
			}
			else {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				update(1, euler[x][1]+1, euler[x][2], 1, N, y);
			}
		}
//		System.out.println("天天天天天天天天天天天天");
//		for(int i = 1; i<=4*N; i++) {
//			System.out.println(tree[i]+" "+temp_tree[i]);
//		}
		System.out.println(sb);
	}
	
	static void dfs(int a) {
		euler[a][1] = count;
		array[count] = a;
		for(int x : ar[a]) {
			count++;
			dfs(x);
		}
		euler[a][2] = count;
	}
	
	static void make_tree(int idx, int l, int r) {
		int mid = (l+r)/2;
		if(l==r) {
			tree[idx] += val[l];
			return;
		}
		make_tree(idx*2, l, mid);
		make_tree(idx*2+1, mid+1, r);
	}
	
	static long get_val(int idx, int start, int l, int r) {
		int mid = (l+r)/2;
		if(temp_tree[idx]!=0) seg_tree(idx, l, r);
		if(start>r || start<l) return 0;
		if(l==r) {
			seg_tree(idx, l, r);
			return tree[idx];
		}
		return get_val(idx*2, start, l, mid) + get_val(idx*2+1, start, mid+1, r);
	}
	
	static void update(int idx, int start, int end, int l, int r, int val) {
		int mid = (l+r)/2;
		
		if(l>end || r<start) return;
		if(temp_tree[idx]!=0) seg_tree(idx,l, r);
		if(l>=start && r<=end) {
			temp_tree[idx]+=val;
			seg_tree(idx, l, r);
			return;
		}
		update(idx*2, start, end, l, mid, val);
		update(idx*2+1, start, end, mid+1, r, val);
	}
	
	static void seg_tree(int idx, int l , int r) {
		if(l==r) {
			tree[idx] += temp_tree[idx];
			temp_tree[idx] = 0;
			return;
		}
		else {
			temp_tree[idx*2] += temp_tree[idx];
			temp_tree[idx*2+1] += temp_tree[idx];
			tree[idx] += temp_tree[idx];
			temp_tree[idx] = 0;
			return;
		}
	}
}
