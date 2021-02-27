import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class cleaner{
	int x;
	int y;
	int z;
	cleaner(int a, int b, int t){
		this.x = a;
		this.y = b;
		this.z = t;
	}
}
public class Baek_14503_robotCleaner_210227 {
	static int N,M;
	static int[][] array;
	static boolean[][] marked;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static StringTokenizer st;
	static Queue<cleaner> q = new LinkedList<cleaner>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		int count = 0;
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		array = new int[N+2][M+2];
		for(int i = 0; i<=N+1; i++) {
			for(int j = 0; j<=M+1; j++) {
				array[i][j] = 1;
			}
		}
		marked = new boolean[N+2][M+2];
		
		
		k = br.readLine().split(" ");
		q.add(new cleaner(Integer.parseInt(k[0])+1,Integer.parseInt(k[1])+1,Integer.parseInt(k[2])));
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!q.isEmpty()) {
			cleaner c = q.poll();
			int x = c.x;
			int y = c.y;
			int z = c.z;
			if(marked[x][y]==false && array[x][y]==0) {
				marked[x][y] = true;
				array[x][y] = 2;
				q.add(new cleaner(x,y,z));
				count++;
//				System.out.println(count+" "+x+" "+y+" "+z);
//				for(int i = 1; i<=N; i++) {
//					for(int j = 1; j<=M; j++) {
//						System.out.print(array[i][j]+" ");
//					}
//					System.out.println();
//				}
				
			}
			else if(marked[x][y]==true && x>0 && y>0 && x<=N && y<=M) {
//				System.out.println(x+" "+y+" "+z+"Ã»¼Ò µÊ");
				if(z%4==0) {
					if((array[x-1][y]==1 || marked[x-1][y]==true) &&
						(array[x][y-1]==1 || marked[x][y-1]==true) &&
						(array[x][y+1]==1 || marked[x][y+1]==true) &&
						marked[x+1][y]==true) {
						q.add(new cleaner(x+1,y,z));
					}
					
					else if((array[x-1][y]==1 || marked[x-1][y]==true) &&
						(array[x][y-1]==1 || marked[x][y-1]==true) &&
						(array[x][y+1]==1 || marked[x][y+1]==true) &&
						array[x+1][y]==1) {
						System.out.println("¤»");
						break;
					}
					
					else if(array[x][y-1]==0 && marked[x][y-1]==false) {
						q.add(new cleaner(x,y-1,z+3));
					}
					else if(array[x][y-1]==1 || marked[x][y-1]==true) {
						q.add(new cleaner(x,y,z+3));
					}
				}
				else if(z%4==1) {
					if((array[x-1][y]==1 || marked[x-1][y]==true) &&
						(array[x+1][y]==1 || marked[x+1][y]==true) &&
						(array[x][y+1]==1 || marked[x][y+1]==true) &&
						marked[x][y-1]==true) {
						q.add(new cleaner(x,y-1,z));
					}
					else if((array[x-1][y]==1 || marked[x-1][y]==true) &&
							(array[x+1][y]==1 || marked[x+1][y]==true) &&
							(array[x][y+1]==1 || marked[x][y+1]==true) &&
							array[x][y-1]==1) {
						break;
						}
					else if(array[x-1][y]==0 && marked[x-1][y]==false) {
						q.add(new cleaner(x-1,y,z+3));
					}
					else if(array[x-1][y]==1 || marked[x-1][y]==true) {
						q.add(new cleaner(x,y,z+3));
					}
				}
				else if(z%4==2) {
					if((array[x][y-1]==1 || marked[x][y-1]==true) &&
						(array[x+1][y]==1 || marked[x+1][y]==true) &&
						(array[x][y+1]==1 || marked[x][y+1]==true) &&
						(marked[x-1][y]==true)) {
						q.add(new cleaner(x-1,y,z));
					}
					else if((array[x][y-1]==1 || marked[x][y-1]==true) &&
							(array[x+1][y-1]==1 || marked[x+1][y]==true) &&
							(array[x][y+1]==1 || marked[x][y+1]==true) &&
							array[x-1][y]==1) {
						break;
						}
					else if(array[x][y+1]==0 && marked[x][y+1]==false) {
						q.add(new cleaner(x,y+1,z+3));
					}
					else if(array[x][y+1]==1 || marked[x][y+1]==true) {
						q.add(new cleaner(x,y,z+3));
					}
					
				}
				else if(z%4==3) {
					if((array[x-1][y]==1 || marked[x-1][y]==true) &&
						(array[x+1][y]==1 || marked[x+1][y]==true) &&
						(array[x][y-1]==1 || marked[x][y-1]==true) &&
						marked[x][y+1]==true) {
						q.add(new cleaner(x,y+1,z));
					}
					else if((array[x-1][y]==1 || marked[x-1][y]==true) &&
							(array[x+1][y]==1 || marked[x+1][y]==true) &&
							(array[x][y-1]==1 || marked[x][y-1]==true) &&
							array[x][y+1]==1) {
						break;
						}
					else if(array[x+1][y]==0 && marked[x+1][y]==false) {
						q.add(new cleaner(x+1,y,z+3));
					}
					else if(array[x+1][y]==1 || marked[x+1][y]==true) {
						q.add(new cleaner(x,y,z+3));
					}
				}
			}
		}
		System.out.println(count);
	}

}
