import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_17940_subway_220517 {
	static class find implements Comparable<find>{
		int x;
		int val;
		int count;
		int hwan;
		find(int x, int hwan, int count, int val){
			this.x = x;
			this.val = val;
			this.count = count;
			this.hwan = hwan;
		}
		@Override
		public int compareTo(find arg0) {
			// TODO Auto-generated method stub
			if(this.count==arg0.count) return this.val-arg0.val;
			return this.count-arg0.count;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		M++;
		int[] array = new int[N+1];
		Arrays.fill(array, Integer.MAX_VALUE);
		
		int[][] val = new int[N+1][N+1];
		int[] station = new int[N+1];
		int[] count = new int[N+1];
		Arrays.fill(count, Integer.MAX_VALUE);
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			station[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				val[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<find> pq = new PriorityQueue<find>();
		
		pq.add(new find(1,station[1],0,0));
		count[1] = 0;
		array[1] = 0;
		boolean[] marked = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			find node = pq.poll();
			if(marked[node.x]) continue;
			marked[node.x] = true;
			for(int i = 1; i<=N; i++) {
				if(i==node.x) continue;
				if(val[node.x][i]==0) continue;
				if(station[i]==station[node.x]) {
					if(count[i]>=node.count) {
						if(array[i]>node.val+val[i][node.x]) {
//							System.out.println(node.x+" : "+i+" / 카운트 : "+count[i]+" "+node.count+" / "+array[i]+" "+(array[node.x]+val[i][node.x]));
							array[i] = node.val+val[i][node.x];
							count[i] = node.count;
							pq.add(new find(i, station[i], count[i], array[i]));
						}
					}
				}
				else {
					if(count[i]>node.count+1) {
//						System.out.println(node.x+" : "+i+" / 카운트 : "+count[i]+" "+node.count+" / "+array[i]+" "+(array[node.x]+val[i][node.x]));
						count[i] = node.count+1;
						array[i] = node.val+val[i][node.x];
						pq.add(new find(i,station[i],count[i],array[i]));
					}
					else if(count[i]==node.count+1) {
						if(array[i]>node.val+val[i][node.x]) {
//							System.out.println(node.x+" : "+i+" / 카운트 : "+count[i]+" "+node.count+" / "+array[i]+" "+(array[node.x]+val[i][node.x]));
							count[i] = node.count+1;
							array[i] = node.val+val[i][node.x];
							pq.add(new find(i,station[i],count[i],array[i]));
						}
					}
				}
			}
		}
//		for(int i = 1; i<=N; i++) {
//			System.out.println(i+" / "+count[i]+" "+array[i]);
//		}
		System.out.println(count[M]+" "+array[M]);
	}

}
