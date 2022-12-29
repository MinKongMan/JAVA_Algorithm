import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_16958_teleport_221230 {
	static class xy{
		int idx;
		int x;
		int y;
		
		xy(int idx, int x, int y){
			this.idx = idx;
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		ArrayList<xy>[] ar = new ArrayList[N+1];
		int[] array = new int[N+1];
		ArrayList<xy> list = new ArrayList<xy>();
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			array[i] = x;
			ar[i] = new ArrayList<xy>();
			if(x==1) list.add(new xy(i,y,z));
			ar[i].add(new xy(i,y,z));
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int xx = ar[x].get(0).x;
			int xy = ar[x].get(0).y;
			
			int yx = ar[y].get(0).x;
			int yy = ar[y].get(0).y;
			
			int dis = Math.abs(xx-yx)+Math.abs(xy-yy);
			if(array[x]==1 && array[y]==1) {
				
				sb.append(Math.min(T, dis)+"\n");
			}
			else if(array[x]==0 && array[y]==0) {
				
				int min1 = Integer.MAX_VALUE;
				int min2 = Integer.MAX_VALUE;
				
				for(xy node : list) {
					int sx = node.x;
					int sy = node.y;
					min1 = Math.min(min1, Math.abs(sx-xx)+Math.abs(sy-xy));
				}
				
				for(xy node : list) {
					int sx = node.x;
					int sy = node.y;
					min2 = Math.min(min2, Math.abs(sx-yx)+Math.abs(sy-yy));
				}
				int val = min1+min2+T;
//				System.out.println(dis+" "+val+" / "+min1+" "+min2);
				sb.append(Math.min(dis, val)+"\n");
			}
			else if(array[x]==0) {
				int min = dis;
				for(xy node : list) {
					int sx = node.x;
					int sy = node.y;
					
					min = Math.min(min, Math.abs(sx-xx)+Math.abs(sy-xy)+T);
					
				}
				sb.append(min+"\n");
			}
			else if(array[y]==0) {
				int min = dis;
				for(xy node : list) {
					int sx = node.x;
					int sy = node.y;
					min = Math.min(min, Math.abs(sx-yx)+Math.abs(sy-yy)+T);
					
				}
				sb.append(min+"\n");
			}
		}
		
		System.out.println(sb);
	}

}
