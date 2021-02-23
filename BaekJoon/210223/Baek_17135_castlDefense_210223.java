import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point{
	int x;
	int y;
	int z;
	Point(int a, int b, int c){
		this.x = a;
		this.y = b;
		this.z = c;
	}
}
public class Baek_17135_castlDefense_210223 {
	static Queue<Integer> s_y = new LinkedList<Integer>();
	static Queue<Integer> q_x = new LinkedList<Integer>();
	static Queue<Integer> q_y = new LinkedList<Integer>();
	static Queue<Integer> kill_x = new LinkedList<Integer>();
	static Queue<Integer> kill_y = new LinkedList<Integer>();
	static LinkedList<Point> link = new LinkedList<Point>();
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[][] array,array2;
	static int kill = 0, temp = 0;
	static int turn = 1;
	static boolean[][] marked;
	static int N, M, P;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		P = sc.nextInt();
		array = new int[N+2][M+1];
		array2 = new int[N+1][M+1];
		marked = new boolean[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			for(int j =1; j<=M; j++) {
				array[i][j] = sc.nextInt();
				array2[i][j] = array[i][j];
			}
		}
		for(int i = 1; i<=M-2; i++) {
			for(int j = i+1; j<=M-1; j++) {
				for(int k = j+1; k<=M; k++) {
					link.add(new Point(i,j,k));
				}
			}
		}
		
		for(int i = 0; i<link.size(); i++) {
//			System.out.println(link.get(i).x+" "+link.get(i).y+" "+link.get(i).z);
			s_y.add(link.get(i).x);
			s_y.add(link.get(i).y);
			s_y.add(link.get(i).z);
			BFS(link.get(i).x, link.get(i).y, link.get(i).z);
//			BFS(i);
			for(int j = 1; j<=N; j++) {
				for(int k = 1; k<=M; k++) {
					array[j][k] = array2[j][k];
				}
			}
		}
		
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=M; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(temp);
		
	}
	public static void BFS(int jjj, int kkk, int lll) {
		while(turn<=N) {
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
			for(int i = 1; i<=3; i++) {
				int y1 = s_y.poll();
				s_y.add(y1);
				q_x.add(N+1);
				q_y.add(y1);
				while(!q_x.isEmpty()) {
					int x = q_x.poll();
					int y = q_y.poll();
					for(int t = 0; t<4; t++) {
						int temp_x = x+dx[t];
						int temp_y = y+dy[t];
//						System.out.println(x+" "+y+" "+temp_x+" "+temp_y);
						if(temp_y>0 && temp_y<=M && temp_x>0 && temp_x<=N && marked[temp_x][temp_y]==false) {
							
							if(Math.abs(y1-temp_y)+Math.abs(N+1-temp_x)<=P) {
//								System.out.println(temp_x+" "+temp_y+" "+y1);
								q_x.add(temp_x);
								q_y.add(temp_y);
								marked[temp_x][temp_y] = true;
								if(array[temp_x][temp_y]==1) {
//									System.out.println(why+1+" "+temp_x+" "+temp_y+" "+P);
									kill_x.add(temp_x);
									kill_y.add(temp_y);
									marked = new boolean[N+1][M+1];
									q_x.clear();
									q_y.clear();
									break;
								}
							}
						}
					}
				}
				marked = new boolean[N+1][M+1];
			}
			while(!kill_x.isEmpty()) {
				int x_temp = kill_x.poll();
				int y_temp = kill_y.poll();
				if(array[x_temp][y_temp]==1) {
//					System.out.println(x_temp+" "+y_temp);
					array[x_temp][y_temp] = 0;
					kill++;
				}
			}
//			System.out.println("kill"+" "+kill+" "+jjj+" "+kkk+" "+lll);
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=M; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("next");
			jinkyuk();
			
		}
		s_y.clear();
//		System.out.println(kill);
		temp = temp>kill?temp:kill;
		kill = 0;
		turn = 1;
	}
	
	
	
	public static void jinkyuk() {
		for(int i = 1; i<=M; i++) {
			array[N][i] = 0;
		}
		for(int i = N-1; i>0; i--) {
			for(int j = 1; j<=M; j++) {
				if(array[i][j]==1) {
					array[i+1][j] = 1;
					array[i][j] = 0;
				}
			}
		}
		turn++;
		marked = new boolean[N+1][M+1];
	}
	
}
