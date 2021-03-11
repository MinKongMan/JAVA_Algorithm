import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Baek_19236_youthShark_210311 {
	static class fish{
		int num;
		int go;
		fish(int num, int go){
			this.num = num;
			this.go = go;
		}
	}
	static class link{
		int x;
		int y;
		link(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static boolean[] marked = new boolean[17];
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static boolean[][] mark = new boolean[17][17];
	static int max = 0, temp = 1, count = 1;
	static fish shark;
	static fish[][] array,array2;
	static int[][][] go,num;
	static int[][] lx,ly;
	static LinkedList<fish> fish = new LinkedList<fish>();
	static LinkedList<link> link = new LinkedList<link>();
	static LinkedList<link> link2 = new LinkedList<link>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		array = new fish[5][5];
		array2 = new fish[5][5];
		go = new int[17][17][17];
		num = new int[17][17][17];
		lx = new int[17][17];
		ly = new int[17][17];
		shark = new fish(0,0);
		for(int i = 0; i<17; i++) {
			link.add(new link(0,0));
			link2.add(new link(0,0));
		}
		for(int i = 1; i<=4; i++) {
			for(int j = 1; j<=4; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				link.get(a).x = i;
				link.get(a).y = j;
				array[i][j] = new fish(a,b-1);
				array2[i][j] = new fish(a,b-1);
			}
		}
		marked[array[1][1].num] = true;
		mark[1][1] = true;
		shark.go = array[1][1].go;
		shark.num = array[1][1].num;
		
		fish_go(1,1);
		
		System.out.println(max);
	}
	
	static void fish_go(int a1, int b1) {
		fish change = new fish(0,0);
		int x = a1;
		int y = b1;
		for(int i = 1; i<=16; i++) {
			if(marked[i]==true) continue;
			boolean check = true;
			int x1 = link.get(i).x;
			int y1 = link.get(i).y;//바꿔야 하는 기준 좌표
			
			while(check) {
				int temp_x = x1+dx[array[x1][y1].go%8]; // 그 방향으로 간 좌표
				int temp_y = y1+dy[array[x1][y1].go%8];
				if(temp_x<1 || temp_y<1 || temp_x>4 || temp_y>4 || (temp_x==x && temp_y==y)) {
					array[x1][y1].go++;
				}
				else {
					change = array[temp_x][temp_y];
					int ka = link.get(array[temp_x][temp_y].num).x;
					int kb = link.get(array[temp_x][temp_y].num).y;
					
					link.get(array[temp_x][temp_y].num).x = link.get(array[x1][y1].num).x;
					link.get(array[temp_x][temp_y].num).y = link.get(array[x1][y1].num).y;
					array[temp_x][temp_y] = array[x1][y1];
					
					
					array[x1][y1] = change;
					
					link.get(array[temp_x][temp_y].num).x = ka;
					link.get(array[temp_x][temp_y].num).y = kb;
					check = false;
				}
			}
			
			
		}
		eat(x,y);
	}
	static void eat(int a, int b) {
		int x1 = a;
		int y1 = b;
		for(int i = 0; i<4; i++) {
			x1 += dx[array[a][b].go%8];
			y1 += dy[array[a][b].go%8];
			if(x1>4 || x1<1 || y1>4 || y1<1) {
				max = max>shark.num?max:shark.num;
				return;
			}
			if( marked[array[x1][y1].num]==false) {
				count++;
				mark[a][b] = true;
				shark.num += array[x1][y1].num;
				marked[array[x1][y1].num] = true;
				for(int l = 1; l<=4; l++) {
					for(int m = 1; m<=4; m++) {
						go[count][l][m] = array[l][m].go;
						num[count][l][m] = array[l][m].num;
					}
				}
				for(int l = 1; l<=16; l++) {
					lx[count][l] = link.get(l).x;
					ly[count][l] = link.get(l).y;
				}
				
				fish_go(x1, y1);
				
				for(int l = 1; l<=4; l++) {
					for(int m = 1; m<=4; m++) {
						array[l][m].go = go[count][l][m];
						array[l][m].num = num[count][l][m];
					}
				}
				
				for(int l = 1; l<=16; l++) {
					link.get(l).x = lx[count][l];
					link.get(l).y = ly[count][l];
				}
				count--;
				marked[array[x1][y1].num] = false;
				shark.num -= array[x1][y1].num;
				mark[x1][y1] = false;
			}
		}
	}

}
