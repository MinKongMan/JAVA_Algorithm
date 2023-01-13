import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_12892_present_230113 {

	static class xy implements Comparable<xy>{
		int x;
		long y;
		
		xy(int x, long y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return this.x-arg0.x;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<Integer>();
		HashMap<Integer,Long> hash = new HashMap<Integer,Long>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			long y = Long.parseLong(st.nextToken());
		
			if(set.contains(x)) {
				hash.put(x, hash.get(x)+y);
			}
			else {
				set.add(x);
				hash.put(x, y);
			}
		}
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int x : set) {
			pq.add(new xy(x,hash.get(x)));
		}
		
		ArrayList<xy> list = new ArrayList<xy>();
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			list.add(node);
		}
		
		int left = 0;
		int l_p = 0;
		int right = 0;
		int r_p = 0;
		long val = 0, max = 0;
		
		for(int i = 0; i<list.size(); i++) {
//			System.out.println("val : "+val+" max : "+max);
			if(list.get(i).x-l_p>=M) {
//				System.out.println(i+" "+list.get(i).x+" "+l_p);
				boolean mark = false;
				for(int j = left; j<i; j++) {
					if(list.get(i).x-list.get(j).x>=M) {
//						System.out.println("…ß"+" "+left+" "+j);
						val -= list.get(j).y;
					}
					else {
						left = j;
						l_p = list.get(j).x;
						mark = true;
						break;
					}
				}
				if(!mark) left = i;
//				System.out.print(val+" ");
				val += list.get(i).y;
//				System.out.println(val);
				max = Math.max(val, max);
			}
			else {
				val += list.get(i).y;
				max = Math.max(max, val);
			}
		}
//		System.out.println(val);
		
		System.out.println(max);
	}

}
