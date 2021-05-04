import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class shark{
	int left;
	int right;
	int speed;
	int direct;
	int size;
	shark(int left, int right, int speed, int direct, int size){
		this.left = left;
		this.right = right;
		this.speed = speed;
		this.direct = direct;
		this.size = size;
	}
}
		
public class Baek_17143_fishKing_210503 {
	static int N,M,R,sum = 0;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	static int[][] array,array2;
	static HashMap<Integer,shark> set = new HashMap<Integer,shark>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		R = Integer.parseInt(k[2]);
		
		StringTokenizer st;
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		for(int i = 1; i<=R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			array[r][c] = b;
			set.put(b,new shark(r,c,s,d,b));
		}
		for(int i = 1; i<=M; i++) {
			
			getShark(i);
			
			array2 = new int[N+1][M+1];
			Queue<Integer> li = new LinkedList<Integer>();
			for(Integer jung : set.keySet()) {
				shark hyo = set.get(jung);
				int x = hyo.left;
				int y = hyo.right;
				int go = hyo.direct;
				int sp = hyo.speed;
				int si = hyo.size;
				array[x][y] = 0;
				int speed = sp;
				int temp_x = x+speed%(2*N-2)*dx[go];
				int temp_y = y+speed%(2*M-2)*dy[go];
				while(true) {
					if(temp_x<1 || temp_y<1 || temp_x>N || temp_y>M) {
						if(go==1) {
							speed = speed-(x-1);
							temp_x = 1+Math.abs(speed);
							x = 1;
							go = 2;
						}
						else if(go==2) {
							speed = speed-(N-x);
							temp_x = N-Math.abs(speed);
							x = N;
							go = 1;
						}
						else if(go==3) {
							speed = speed-(M-y);
							temp_y = M-Math.abs(speed);
							y = M;
							go = 4;
						}
						else if(go==4) {
							speed = speed-(y-1);
							temp_y = 1+Math.abs(speed);
							y = 1;
							go = 3;
						}
					}
					else {
						x = temp_x;
						y = temp_y;
						break;
					}
				}
//				System.out.println(set.get(jung).left+" "+set.get(jung).right+" "+x+" "+y+" "+jung);
				hyo.left = x;
				hyo.right = y;
				hyo.direct = go;
				if(array2[x][y]==0) {
					array2[x][y] = si;
					
				}
				if(array2[x][y]>0) {
					if(array2[x][y]<si) {
						li.add(array2[x][y]);
						array2[x][y] = si;
					}
				}
//				System.out.println(set.get(jung).left+" "+set.get(jung).right+" "+x+" "+y);
			}
			
//			for(Integer hyo : set.keySet()) {
//				int x = set.get(hyo).left;
//				int y = set.get(hyo).right;
//				int si = set.get(hyo).size;
//				if(array[x][y]==0) {
//					array[x][y] = si;
//					
//				}
//				if(array[x][y]>0) {
//					if(array[x][y]<si) {
//						li.add(array[x][y]);
//						array[x][y] = si;
//					}
//				}
//			}
			while(!li.isEmpty()) {
				set.remove(li.poll());
			}
			for(Integer hyo : set.keySet()) {
				shark jung = set.get(hyo);
				array[jung.left][jung.right] = array2[jung.left][jung.right];
			}
		}
		System.out.println(sum);
	}
	
	static void getShark(int a) {
		for(int i = 1; i<=N; i++) {
			if(array[i][a]>0) {
				sum += array[i][a];
				set.remove(array[i][a]);
				array[i][a] = 0;
				return;
			}
		}
	}
}
