import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_9177_wordMix_221205 {
	static String a="",b="",c="";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[] dx = {1,0}, dy = {0,1,};
		
		for(int i = 1; i<=N; i++) {
			String[] l = br.readLine().split(" ");
			a = l[0];
			b = l[1];
			c = l[2];
			
			boolean[][] marked = new boolean[a.length()+1][b.length()+1];
			
			Queue<String> q = new LinkedList<String>();
			Queue<Integer> qx = new LinkedList<Integer>();
			Queue<Integer> qy = new LinkedList<Integer>();
			if(c.charAt(0)==a.charAt(0)) {
				q.add(a.charAt(0)+"");
				marked[1][0] = true;
				qx.add(1);
				qy.add(0);
			}
			if(c.charAt(0)==b.charAt(0)) {
				q.add(b.charAt(0)+"");
				marked[0][1] = true;
				qx.add(0);
				qy.add(1);
			}
			
			while(!q.isEmpty()) {
				String str = q.poll();
				int x = qx.poll();
				int y = qy.poll();
//				System.out.println(str+" "+x+" "+y);
				if(x==a.length() && y==b.length()) break;
				for(int j = 0; j<2; j++) {
					int temp_x = x+dx[j];
					int temp_y = y+dy[j];
					
					if(temp_x>a.length() || temp_y>b.length()) continue;
//					System.out.println(c.charAt(str.length()));
					if(marked[temp_x][temp_y]) continue;
					if(j==0) {
						if(c.charAt(str.length())==a.charAt(temp_x-1)){
							marked[temp_x][temp_y] = true;
							qx.add(temp_x);
							qy.add(temp_y);
							q.add(str+a.charAt(temp_x-1));
						}
					}
					else {
						if(c.charAt(str.length())==b.charAt(temp_y-1)){
							marked[temp_x][temp_y] = true;
							qx.add(temp_x);
							qy.add(temp_y);
							q.add(str+b.charAt(temp_y-1));
						}
					}
				}
			}
			
			if(marked[a.length()][b.length()]) {
				sb.append("Data set "+i+": yes\n");
			}
			else {
				sb.append("Data set "+i+": no\n");
			}
		}
		System.out.println(sb);
	}
	
//	static void dfs(int x, int y, int count) {
//		if(count==c.length()) {
//			check = true;
//			return;
//		}
//		if(check) return;
//		
//		if(x<a.length() && c.charAt(count)==a.charAt(x)) {
//			dfs(x+1,y,count+1);
//		}
//		if(y<b.length() && c.charAt(count)==b.charAt(y)) {
//			dfs(x,y+1,count+1);
//		}
//	}

}
