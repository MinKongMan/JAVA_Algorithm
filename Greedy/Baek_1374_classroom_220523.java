import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1374_classroom_220523 {
	static class xy implements Comparable<xy>{
		int start;
		int end;
		int num;
		xy(int num, int start, int end){
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(xy arg0) {
			if(this.start==arg0.start) return this.end-arg0.end;
			return this.start - arg0.start;
		}
	}
	
	static class find implements Comparable<find>{
		int start;
		int end;
		find(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(find o) {
			// TODO Auto-generated method stub
			return this.end-o.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new xy(x,y,z));
		}
		
		int[][] array = new int[N+1][2];
		int count = 1;
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			array[count][0] = node.start;
			array[count][1] = node.end;
			count++;
		}
		
		int max = 0;
		PriorityQueue<find> pq2 = new PriorityQueue<find>();
		
		for(int i =1 ; i<=N; i++) {
			int start = array[i][0];
			int end = array[i][1];
			if(pq2.isEmpty()) pq2.add(new find(start,end));
			else {
				while(!pq2.isEmpty()) {
					if(pq2.peek().end<=start) pq2.poll();
					else break;
				}
				pq2.add(new find(start,end));
			}
			max = Math.max(pq2.size(), max);
		}
		System.out.println(max);
		
	}

}
