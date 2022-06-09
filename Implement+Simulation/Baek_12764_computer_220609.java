import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Baek_12764_computer_220609 {
	static class xy implements Comparable<xy>{
		int start;
		int end;
		xy(int start, int end) {
			this.end = end;
			this.start = start;
		}
		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}
	}
	
	static class com implements Comparable<com>{
		int num;
		int end;
		
		com(int end, int num){
			this.num = num;
			this.end = end;
		}
		@Override
		public int compareTo(com arg0) {
			return this.end-arg0.end;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
	
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		PriorityQueue<com> q = new PriorityQueue<com>();
		PriorityQueue<Integer> num = new PriorityQueue<Integer>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new xy(x,y));
			num.add(i);
		}
		
		int[] array = new int[N+1];
		
		int count = 0;
		
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
//			System.out.println("½ÃÀÛ : "+node.start+" "+node.end);
			while(!q.isEmpty()) {
				if(q.peek().end<=node.start) {
					com temp = q.poll();
//					System.out.println(temp.end+" "+temp.num);
					num.add(temp.num);
				}
				else break;
			}
			int number = num.poll();
			q.add(new com(node.end,number));
			array[number]++;
			count = Math.max(count, q.size());
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(count);
		for(int i = 1; i<=count; i++) {
			sb.append(array[i]+" ");
		}
		System.out.println(sb);
	}

}
