import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_14395_4yeonsan_220822 {
	static class xy implements Comparable<xy>{
		long x;
		String l;
		xy(long x, String l){
			this.x = x;
			this.l = l;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			int t1 = this.l.length();
			int t2 = arg0.l.length();
			if(t1==t2) {
				if(t1<t2) {
					for(int i = 0; i<t1; i++) {
						if(this.l.charAt(i)==arg0.l.charAt(i)) continue;
						else if(this.l.charAt(i)<arg0.l.charAt(i)) return -1;
						else return 1;
					}
					return -1;
					
				}
				else if(t1==t2){
					for(int i = 0; i<t1; i++) {
						if(this.l.charAt(i)==arg0.l.charAt(i)) continue;
						else if(this.l.charAt(i)<arg0.l.charAt(i)) return -1;
						else return 1;
					}
					return -1;
				}
				else {
					for(int i = 0; i<t1; i++) {
						if(this.l.charAt(i)==arg0.l.charAt(i)) continue;
						else if(this.l.charAt(i)<arg0.l.charAt(i)) return -1;
						else return 1;
					}
					return 1;
					
				}
			}
			else return t1-t2;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N==M) {
			System.out.println(0);
			return;
		}
		PriorityQueue<xy> q = new PriorityQueue<xy>();
		HashMap<Long, String> hash = new HashMap<Long, String>();
		q.add(new xy(N, ""));
		while(!q.isEmpty()) {
			xy node = q.poll();
			long x = node.x;
			
			String a1 = node.l+"*";
			String a2 = node.l+"+";
			String a3 = node.l+"/";
			String a4 = node.l+"-";
			
			if(x==M) {
				System.out.println(node.l);
				return;
			}
			if(x*x<=1000000000) {
				if(!hash.containsKey(x*x)) {
					hash.put(x*x, a1);
					q.add(new xy(x*x,a1));
				}
			}
			if(x+x<=1000000000) {
				if(!hash.containsKey(x+x)) {
					hash.put(x+x, a2);
					q.add(new xy(x+x,a2));
				}
			}
			if(x!=0 && x/x>=0) {
				if(!hash.containsKey(x/x)) {
					hash.put(x/x, a3);
					q.add(new xy(x/x,a3));
				}
			}
			if(x-x==0) {
				if(!hash.containsKey(x-x)) {
					hash.put(x-x, a4);
					q.add(new xy(x-x,a4));
				}
			}
		}
		
		System.out.println(-1);
	}

}
