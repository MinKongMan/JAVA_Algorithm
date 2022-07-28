import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_18227_waterTank_220728 {
	static ArrayList<Integer>[] ar;
	static int[][] array;
	static int N,M,count = 0;
	static long[] tree;
	static long[] depth;
	static boolean[] marked;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new ArrayList[N+1];
		array = new int[N+1][3];
		depth = new long[N+1];
		
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		marked = new boolean[N+1];
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ar[x].add(y);
			ar[y].add(x);
		}
		
		st = new StringTokenizer(br.readLine());
		
		tree = new long[4*N+1];
		int K = Integer.parseInt(st.nextToken());
		marked[M] = true;
		depth[M] = 1;
		dfs(M);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x==1) {
				update(1, 1, N, array[y][1]);
			}
			else {
				sb.append((get_val(1, array[y][1], array[y][2], 1, N)*depth[y])+"\n");
			}
//			System.out.println("天天天天天天天天天天天天天天天天");
		}
		System.out.println(sb);
		
		

	}
	
	static long get_val(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) {
			return tree[idx];
		}
		
		return get_val(idx*2, start, end, l, mid) + get_val(idx*2+1, start, end, mid+1, r);
	}
	
	static void update(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
		
		if(val<l || val>r) return;
		tree[idx]++;
//		System.out.println(start+" "+end+" / "+l+" "+r+" "+tree[idx]);
		if(val==l && val ==r) return;
		
		update(idx*2, l, mid, val);
		update(idx*2+1, mid+1, r, val);
	}
	
	static void dfs(int x) {
		count++;
		array[x][1] = count;
		for(int a : ar[x]) {
			if(marked[a]) continue;
			if(depth[a]==0) depth[a] = depth[x] +1;
			marked[a] = true;
			dfs(a);
		}
		array[x][2] = count;
	}

}
