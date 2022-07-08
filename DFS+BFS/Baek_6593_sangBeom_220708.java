import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_6593_sangBeom_220708 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {-1,0,1,0}, dy = {0,1,0,-1}, dz = {-1,1};
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(N==0 && M == 0 && K==0) break;
			int[][][] array = new int[N+1][M+1][K+1];
			
			int start_1 = 0, end1 = 0;
			int start_x = 0, end_x = 0;
			int start_y = 0, end_y = 0;
			
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					String l = br.readLine();
					for(int k = 1; k<=K; k++) {
						if(l.charAt(k-1)=='S') {
							start_1 = i;
							start_x = j;
							start_y = k;
							array[i][j][k] = 5;
						}
						else if(l.charAt(k-1)=='#') array[i][j][k] = -1;
						else if(l.charAt(k-1)=='E') {
							end1 = i;
							end_x = j;
							end_y = k;
							array[i][j][k] = 9;
						}
					}
				}
				br.readLine();
			}
			
			Queue<Integer> qq = new LinkedList<Integer>();
			Queue<Integer> qx = new LinkedList<Integer>();
			Queue<Integer> qy = new LinkedList<Integer>();
			Queue<Integer> qc = new LinkedList<Integer>();
			qq.add(start_1);
			qx.add(start_x);
			qy.add(start_y);
//			System.out.println(start_1+" "+start_x+" "+start_y+" / "+end1+" "+end_x+" "+end_y);
			qc.add(0);
			boolean check = true;
			boolean[][][] marked = new boolean[N+1][M+1][K+1];
			marked[start_1][start_x][start_y] = true;
			while(!qq.isEmpty()) {
				int z = qq.poll();
				int x = qx.poll();
				int y = qy.poll();
				int c = qc.poll();
//				System.out.println(z+" "+x+" "+y);
				if(z==end1 && x==end_x && y==end_y) {
					sb.append("Escaped in "+c+" minute(s).\n");
					check = false;
					break;
				}
				for(int i = 0; i<4; i++) {
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if(temp_x>M || temp_y>K || temp_x<1 || temp_y<1) continue;
					if(array[z][temp_x][temp_y]==-1) continue;
					if(marked[z][temp_x][temp_y]) continue;
					marked[z][temp_x][temp_y] = true;
					qq.add(z);
					qx.add(temp_x);
					qy.add(temp_y);
					qc.add(c+1);
				}
				for(int i = 0; i<2; i++) {
					int temp_z = z+dz[i];
					if(temp_z<1 || temp_z>N) continue;
					if(array[temp_z][x][y]==-1) continue;
					if(marked[temp_z][x][y]) continue;
					marked[temp_z][x][y] = true;
					qq.add(temp_z);
					qx.add(x);
					qy.add(y);
					qc.add(c+1);
				}
			}
			if(check) {
				sb.append("Trapped!\n");
			}
		}
		System.out.println(sb);
	}

}
