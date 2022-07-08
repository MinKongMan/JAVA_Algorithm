import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_17131_fox_220706 {
	static class cl{
		int x;
		int y;
		int idx;
		cl(int x, int y, int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}
	static class xy implements Comparable<xy>{
		int x;
		int y;
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(xy arg0) {
			return this.y-arg0.y;
		}
	}
	
	static class xy2 implements Comparable<xy2>{
		int x;
		int y;
		int idx;
		xy2(int x, int y, int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(xy2 arg0) {
			if(this.x==arg0.x) return -this.y+arg0.y;
			else return this.x-arg0.x;
		}
	}
	
	static class xy3 implements Comparable<xy3>{
		int x;
		int y;
		int idx;
		xy3(int x, int y, int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(xy3 arg0) {
			if(this.x==arg0.x) return -this.y+arg0.y;
			else return -this.x+arg0.x;
		}
	}
	
	static long[] tree_l, tree_r;
	
	static long get_val1(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
//		System.out.println("彰嬪 : "+start+" "+end+" / "+"褻瞰 : "+l+" "+r+" / "+idx);
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) {
//			System.out.println(start+" "+end+" "+l+" "+r+" / "+tree_l[idx]+" "+idx);
			return tree_l[idx];
		}
		return get_val1(idx*2, start, end, l, mid) + get_val1(idx*2+1, start, end, mid+1, r);
	}
	
	static long get_val2(int idx, int start, int end, int l, int r) {
		int mid = (l+r)/2;
		if(l>end || r<start) return 0;
		if(l>=start && r<=end) return tree_r[idx];
		return get_val2(idx*2, start, end, l, mid) + get_val2(idx*2+1, start, end, mid+1, r);
	}
	
	static long update1(int idx, int l, int r, int val) {
		int mid = (l+r)/2;
//		System.out.println("機筍 : "+l+" "+r+" "+val+" "+idx);
		if(val>r || val<l) return tree_l[idx];
		if(l==r && l==val) {
			tree_l[idx]++;
//			System.out.println(tree_l[idx]+" "+idx);
			return tree_l[idx];
		}
		return tree_l[idx] = update1(idx*2, l, mid, val) + update1(idx*2+1, mid+1, r, val);
	}
	
	static long update2(int idx, int l, int r, int val) {
//		System.out.println(l+" "+r+" "+val);
		int mid = (l+r)/2;
		if(val>r || val<l) return tree_r[idx];
		if(l==r && l==val) {
			tree_r[idx]++;
			return tree_r[idx];
		}
		return tree_r[idx] = update2(idx*2, l, mid, val) + update2(idx*2+1, mid+1, r, val);		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		tree_l = new long[4*N+1];
		tree_r = new long[4*N+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new xy(x,y));
		}
		
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		
		PriorityQueue<xy2> pq2 = new PriorityQueue<xy2>();
		PriorityQueue<xy3> pq3 = new PriorityQueue<xy3>();
		
		
		int counting = 0;
		int index = 0;
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			if(!hash.containsKey(node.y)) {
				hash.put(node.y, counting);
//				System.out.println(node.y+" "+hash.get(node.y));
				counting++;
			}
			pq2.add(new xy2(node.x,hash.get(node.y),0));
//			pq3.add(new xy3(node.x,hash.get(node.y),index));
		}
		
		List<xy2> list2 = new ArrayList<xy2>();
		List<xy3> list3 = new ArrayList<xy3>();
		counting--;
		int count2 = 0;
		
		HashMap<Integer, Integer> hash2 = new HashMap<Integer,Integer>();
		
		while(!pq2.isEmpty()) {
			xy2 node2 = pq2.poll();
			if(!hash2.containsKey(node2.x)) {
				hash2.put(node2.x, count2);
				count2++;
			}
			node2.idx = index;
			list2.add(node2);
			pq3.add(new xy3(node2.x, node2.y, index));
			index++;
		}
		
//		System.out.println(count2);
		ArrayList<cl>[] ar2 = new ArrayList[count2];
		ArrayList<cl>[] ar3 = new ArrayList[count2];
		
		while(!pq3.isEmpty()) {
			xy3 node3 = pq3.poll();
			list3.add(node3);
		}
		for(int i = 0; i<count2; i++) {
			ar2[i] = new ArrayList<cl>();
			ar3[i] = new ArrayList<cl>();
		}
//		
//		
		for(int i= 0; i<N; i++) {
			xy2 node2 = list2.get(i);
			xy3 node3 = list3.get(i);
			ar2[hash2.get(node2.x)].add(new cl(node2.x, node2.y, node2.idx));
			ar3[hash2.get(node3.x)].add(new cl(node3.x, node3.y, node3.idx));
		}
		
		long[] array1 = new long[N];
		long[] array2 = new long[N];
		
		for(int i = 0; i<count2; i++) {
			for(cl node2 : ar2[i]) {
//				System.out.println("檣策蝶1 : "+node2.idx+" / "+node2.x+" "+node2.y);
				array1[node2.idx] = get_val1(1, node2.y+1, counting, 0, counting);
			}
			
			for(cl node3: ar3[count2-i-1]) {
//				System.out.println("檣策蝶2 : "+node3.idx+" / "+node3.x+" "+node3.y);
				array2[node3.idx] = get_val2(1, node3.y+1, counting, 0, counting);
			}
			
			for(cl node2 : ar2[i]) {
				update1(1, 0, counting, node2.y);
			}
			
			for(cl node3: ar3[count2-i-1]) {
//				System.out.println(node3.x+" "+node3.y);
				update2(1, 0, counting, node3.y);
			}
//			for(int j = 1; j<=4*N; j++) {
//				System.out.print(tree_l[j]+" ");
//			}
//			System.out.println();
		}
		
		long answer = 0;
//		System.out.println("天天天天天天天天天天天天天天天天天天天天天");
		for(int i = 0; i<N; i++) {
//			System.out.println(array1[i]+" "+array2[i]);
			answer += (array1[i]*array2[i])%1000000007;
			answer %= 1000000007;
		}
		System.out.println(answer);
		
	}

}
