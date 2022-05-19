import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_18405_junyeom_220520 {
	static class xy implements Comparable<xy>{
		int x;
		int y;
		int vir;
		int count;
		xy(int x, int y, int vir, int count){
			this.x = x;
			this.y = y;
			this.vir = vir;
			this.count = count;
		}
		@Override
		public int compareTo(xy arg0) {
			// TODO Auto-generated method stub
			if(this.count==arg0.count) {
				return this.vir-arg0.vir;
			}
			return this.count-arg0.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] array = new int[N+1][N+1];
		
		PriorityQueue<xy> pq = new PriorityQueue<xy>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]!=0) pq.add(new xy(i,j,array[i][j],0));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
		
		while(!pq.isEmpty()) {
			xy node = pq.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;
			int vir = node.vir;
			if(count==K) break;
			
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>N) continue;
				if(array[temp_x][temp_y]!=0) continue;
				array[temp_x][temp_y] = vir;
				pq.add(new xy(temp_x,temp_y,vir,count+1));
			}
//			for(int i = 1; i<=N; i++) {
//				for(int j =1 ; j<=N; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		}
		
		System.out.println(array[X][Y]);
	}

}
