import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_2262_tournament_230116 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		
		xy(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			return -this.y+arg0.y;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x);
			pq.add(new xy(i-1,x));
		}
		
		long val = 0;
		int count = N-1;
		while(!pq.isEmpty()) {
			if(pq.size()==1) break;
			xy node = pq.poll();
			if(node.x==count) {
				int x = list.get(node.x-1);
				val += Math.abs(x-node.y);
			}
			else if(node.x==0) {
				int x = list.get(node.x+1);
				val += Math.abs(x-node.y);
			}
			else {
				int x = Math.abs(list.get(node.x-1)-node.y);
				int y = Math.abs(list.get(node.x+1)-node.y);
				val += Math.min(x, y);
			}
			list.remove(node.x);
			count--;
			pq.clear();
			for(int x = 0; x<list.size(); x++) {
//				System.out.print(x+" ");
				pq.add(new xy(x,list.get(x)));
			}
//			System.out.println();
		}
		System.out.println(val);
	}

}
