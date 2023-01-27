import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_7662_dualPriorityQueue_230127 {
	static class pq1 implements Comparable<pq1>{
		int x;
		pq1(int x){
			this.x = x;
		}
		@Override
		public int compareTo(pq1 o) {
			// TODO Auto-generated method stub
			if(this.x<o.x) return -1;
			return 1;
		}
		
	}
	
	static class pq2 implements Comparable<pq2>{
		int x;
		pq2(int x){
			this.x = x;
		}
		@Override
		public int compareTo(pq2 o) {
			// TODO Auto-generated method stub
			if(this.x>o.x) return -1;
			return 1;
		}
	}
	static PriorityQueue<pq1> pq1;
	static PriorityQueue<pq2> pq2;
	static HashMap<Integer, Integer> hash;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int tc = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int T = 1; T<=tc; T++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			pq1 = new PriorityQueue<pq1>();
			pq2 = new PriorityQueue<pq2>();
			int in = 0;
			int out = 0;
			hash = new HashMap<Integer,Integer>();
			for(int i = 1; i<=N; i++) {
				String[] l = br.readLine().split(" ");
				
				char a = l[0].charAt(0);
				int x = Integer.parseInt(l[1]);
//				System.out.println(a+" "+x);
				if(a=='I') {
					if(hash.containsKey(x)) {
						hash.put(x, hash.get(x)+1);
					}
					else {
						hash.put(x, 1);
					}
					pq1.add(new pq1(x));
					pq2.add(new pq2(x));
					in++;
				}
				else {
					out++;
					if(out>in) {
						clear();
						in = 0;
						out = 0;
						continue;
					}
					if(x==-1) {
						if(pq1.isEmpty()) {
							clear();
							continue;
						}
						int t = pq1.peek().x;
						if(hash.containsKey(t) && hash.get(t)>=1) {
							if(hash.get(t)>1) {
								hash.put(t, hash.get(t)-1);
							}
							else if(hash.get(t)==1) {
								hash.put(t,0);
							}
						}
						else {
							while(!pq1.isEmpty()) {
								if(!hash.containsKey(pq1.peek().x) || hash.get(pq1.peek().x)==0) pq1.poll();
								else break;
							}
							int asd = pq1.poll().x;
							hash.put(asd, hash.get(asd)-1);
							continue;
						}
						pq1.poll();
					}
					else {
						if(pq2.isEmpty()) {
							clear();
						}
						int t = pq2.peek().x;
						if(hash.containsKey(t) && hash.get(t)>=1) {
							if(hash.get(t)>1) {
								hash.put(t, hash.get(t)-1);
							}
							else if(hash.get(t)==1) {
								hash.put(t,0);
							}
						}
						else {
							while(!pq2.isEmpty()) {
								if(!hash.containsKey(pq2.peek().x) || hash.get(pq2.peek().x)==0) pq2.poll();
								else break;
							}
							int asd = pq2.poll().x;
							hash.put(asd, hash.get(asd)-1);
							continue;
						}
						pq2.poll();
					}
				}
			}
			while(!pq1.isEmpty()) {
				if(!hash.containsKey(pq1.peek().x) || hash.get(pq1.peek().x)==0) pq1.poll();
				else break;
			}
			while(!pq2.isEmpty()) {
				if(!hash.containsKey(pq2.peek().x) || hash.get(pq2.peek().x)==0) pq2.poll();
				else break;
			}
			if(pq1.isEmpty() || pq2.isEmpty()) sb.append("EMPTY\n");
			else sb.append(pq2.poll().x+" "+pq1.poll().x+"\n");
		}
		System.out.println(sb);
	}
	
	static void clear() {
		hash.clear();
		pq1.clear();
		pq2.clear();
	}
}
