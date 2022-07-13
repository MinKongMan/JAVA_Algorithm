import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_13537_query1_220713 {
	static ArrayList<Integer>[] ar;
	static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		st = new StringTokenizer(br.readLine());
		ar = new ArrayList[4*N+1];
		
		for(int i =1; i<=N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=4*N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		make_tree(1, 1, N);
//		for(int i = 1; i<=4*N; i++) {
//			for(int j : ar[i]) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sb.append(find(1, x, y, 1, N, z)+"\n");
		}
		System.out.println(sb);
	}
	
	static ArrayList<Integer> make_tree(int idx, int l, int r){
		int mid = (l+r)/2;
		if(l==r) {
			ar[idx].add(array[l]);
			return ar[idx];
		}
		ar[idx*2] = make_tree(idx*2, l, mid);
		ar[idx*2+1] = make_tree(idx*2+1, mid+1, r);
		return ar[idx] = merge(ar[idx*2], ar[idx*2+1]);
	}
	
	static ArrayList<Integer> merge(ArrayList<Integer> ar1, ArrayList<Integer> ar2){
		ArrayList<Integer> temp_ar = new ArrayList<Integer>();
		int i = 0, j = 0;
		while(i<ar1.size() && j<ar2.size()) {
			if(ar1.get(i)<ar2.get(j)) {
				temp_ar.add(ar1.get(i));
				i++;
			}
			else {
				temp_ar.add(ar2.get(j));
				j++;
			}
		}
		while(i<ar1.size()) {
			temp_ar.add(ar1.get(i));
			i++;
		}
		while(j<ar2.size()) {
			temp_ar.add(ar2.get(j));
			j++;
		}
		return temp_ar;
	}
	
	static int find(int idx, int start, int end, int l, int r, int val) {
		int midd = (l+r)/2;
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) {
			
			int left = 0;
			int right = ar[idx].size()-1;
			if(ar[idx].get(right)<=val) return 0;
			while(left<right) {
				
				int mid = (left+right)/2;
//				System.out.println("변하기 전 "+left+" / "+right+" / "+mid);
				if(ar[idx].get(mid)>val) right = mid;
				else left = mid+1;
//				System.out.println("변한 후 "+left+" / "+right+" / "+mid);
			}
//			System.out.println(ar[idx]+" / "+val+" / "+left+" "+(ar[idx].size()-left));
			return ar[idx].size()-left;
		}
		return find(idx*2, start, end, l, midd, val)+find(idx*2+1, start, end, midd+1, r, val);
	}
}
