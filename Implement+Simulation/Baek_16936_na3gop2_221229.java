import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_16936_na3gop2_221229 {
	static class xy implements Comparable<xy>{
		long idx;
		int count;
		xy(long idx, int count){
			this.idx = idx;
			this.count = count;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return arg0.count-this.count;
		}
		
	}
	static HashMap<Long, Integer> hash;
	static Set<Long> set1;
	static Set<Long> set12; 
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		set1 = new HashSet<Long>();
		hash = new HashMap<Long,Integer>();
		Set<Long> set2 = new HashSet<Long>();
		st = new StringTokenizer(br.readLine());
		Queue<xy> q = new LinkedList<xy>();
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		for(int i = 1; i<=N; i++) {
			long x1 = Long.parseLong(st.nextToken());
			if(!set1.contains(x1)) {
				set1.add(x1);
				hash.put(x1,1);
			}
			else {
				hash.put(x1, hash.get(x1)+1);
			}
		}
		
		Queue<Long> q1 = new LinkedList<Long>();
		
		for(long x : set1) {
			long temp1 = -1;
			long temp2 = -1;
			long temp3 = -1;
			long temp4 = -1;
			temp1 = x*3;
			temp2 = x*2;
			if(x%2==0) temp3 = x/2;
			if(x%3==0) temp4 = x/3;
			
			int count = 0;
			if(set1.contains(temp1)) count++;
			if(set1.contains(temp2)) count++;
			if(set1.contains(temp3)) count++;
			if(set1.contains(temp4)) count++;
			if(count<2) {
//				System.out.println(x+" "+temp1+" "+temp2+" / "+set1.contains(temp1)+" "+set1.contains(temp2));
				q1.add(x);
			}
		}
		
		Queue<Long> qq = new LinkedList<Long>();
		StringBuilder sb = new StringBuilder();
		for(long x : q1) {
			long temp1 = -1;
			if(x%3==0) temp1 = x/3;
			long temp2 = x*2;
//			System.out.println(x+" "+temp1+" "+temp2);
			if(!set1.contains(temp1) && !set1.contains(temp2)) continue;
			else {
				qq.add(x);
				while(!qq.isEmpty()) {
					long xx = qq.poll();
					long temp11 = -1;
					if(xx%3==0) temp11 = xx/3;
					long temp22 = xx*2;
					sb.append(xx+" ");
					if(set1.contains(temp11)) {
						if(hash.get(temp11)==1) {
							hash.remove(temp11);
							set1.remove(temp11);
						}
						else {
							hash.put(temp11, hash.get(temp11)-1);
						}
						qq.add(temp11);
					}
					if(set1.contains(temp22)) {
						if(hash.get(temp22)==1) {
							hash.remove(temp22);
							set2.remove(temp22);
						}
						else {
							hash.put(temp22, hash.get(temp22)-1);
						}
						
						qq.add(temp22);
					}
				}
			}
		}
		
		System.out.println(sb);
	}


}
