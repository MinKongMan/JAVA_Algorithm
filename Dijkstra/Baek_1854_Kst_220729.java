package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1854_Kst_220729 {
	static class xy implements Comparable<xy>{
		int end;
		long val;
		xy(int end, long val){
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			if(this.val<o.val) return -1;
			else return 1;
		}
	}
	
	static class l implements Comparable<l>{
		long i;
		l(long i){
			this.i = i;
		}
		@Override
		public int compareTo(l o) {
			// TODO Auto-generated method stub
			if(o.i>this.i) return 1;
			else return -1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<xy>[] ar = new ArrayList[N+1];
		PriorityQueue<l>[] pqr = new PriorityQueue[N+1];
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			pqr[i] = new PriorityQueue<l>();
			ar[i] = new ArrayList<xy>();
		}
		
		for(int i = 1; i<=M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			ar[x].add(new xy(y,z));
		}
		
		pq.add(new xy(1,0));
		pqr[1].add(new l(0));
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.end;
			
			for(xy temp_node : ar[x]) {
				if(pqr[temp_node.end].size()<K) {
					pqr[temp_node.end].add(new l(node.val+temp_node.val));
					pq.add(new xy(temp_node.end, node.val+temp_node.val));
				}
				else if(pqr[temp_node.end].size()<=K && pqr[temp_node.end].peek().i>node.val+temp_node.val){
//					if(pqr[temp_node.end].peek().i>node.val+temp_node.val) {
						pqr[temp_node.end].poll();
						pqr[temp_node.end].add(new l(node.val+temp_node.val));
						pq.add(new xy(temp_node.end, node.val+temp_node.val));
//					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
//			System.out.println(pqr[i].size());
//			while(!pqr[i].isEmpty()) {
//				System.out.println(i+" "+pqr[i].poll().i);
//			}
			if(pqr[i].size()<K) sb.append(-1+"\n");
			else sb.append(pqr[i].peek().i+"\n");
		}
		System.out.println(sb);
	}

}
