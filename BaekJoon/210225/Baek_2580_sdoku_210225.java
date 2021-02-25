import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point_2580{
		int a1;
		int b1;
		Point_2580(int x, int y){
			this.a1 = x;
			this.b1 = y;
		}
	}
public class Baek_2580_sdoku_210225 {
	static int[][] array;
	static LinkedList<Point_2580> p = new LinkedList<Point_2580>();
	static int N = 0, min = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[9][9];
		for(int i = 0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<9; j++) {
				int M = Integer.parseInt(st.nextToken());
				array[i][j] = M;
				
				if(array[i][j] == 0) {
					N++;
					p.add(new Point_2580(i,j));
				}
			}
		}
		find(0,0);
//		for(int i = 0; i<=8; i++) {
//			for(int j = 0; j<9; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.print(sb);
		
	}
	
	static void find(int a, int b) {
		if(sb.length()>0) {
			return;
		}
		if(b==N) {
//			min++;
//			if(min==15) {
//			for(int i = 0; i<=8; i++) {
//				for(int j = 0; j<9; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
//					int x = array[i][j];
//					System.out.println(i+" "+j+" "+x);
//					if(!row2(i,j,x) || !col2(j,i,x) || !place2(i,j,x)) {
//						sb = new StringBuilder();
//						return;
//					}
					sb.append(array[i][j]+" ");
				}
				sb.append("\n");
//				System.out.println();
			}
//			sb.append(min+"\n");
//			for(int i = 0; i<9; i++) {
//				for(int j = 0; j<9; j++) {
//					sb.append(array[i][j]+" ");
//				}
//				sb.append("\n");
//			}
//			sb.append("\n");
//			}
		}
		
		else{
			for(int k = 1; k<=9; k++) {
				int x = p.get(b).a1;
				int y = p.get(b).b1;
//				System.out.print(x+" "+y+" ");
				if(row2(x,y,k) && col2(y,x,k) && place2(x,y,k)) {
					array[x][y] = k;
					find(b+1,b+1);
					array[x][y] = 0;
				}
			}	
		}
	}
	
	static boolean row(int a, int b) {
		for(int i = 0; i<9; i++) {
//			if(a==i) continue;
			if(array[a][i]==b) {
				return false;
			}
		}
		return true;
	}
	
	static boolean col(int a, int b) {
		for(int i = 0; i<9; i++) {
//			if(a==i) continue;
			if(array[i][a]==b ) {
				return false;
			}
		}
		return true;
	}
	
	static boolean place(int x, int y, int z) {
		for(int i = (x/3)*3; i<((x/3)+1*3); i++) {
			for(int j = (y/3)*3; j<(((y/3)+1)*3); j++) {
//				if(i==x && j==y) continue;
				if(array[i][j]==z) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean row2(int a, int c,int b) {
		for(int i = 0; i<9; i++) {
			
			if(i==c) continue;
			if(array[a][i]==b) {
//				System.out.println(a+" За "+c+" "+b+" "+i);
				return false;
			}
		}
		return true;
	}
	
	static boolean col2(int a, int c,int b) {
		for(int i = 0; i<9; i++) {
			if(c==i) continue;
			if(array[i][a]==b ) {
//				System.out.println(a+" ї­ "+b);
				return false;
			}
		}
		return true;
	}
	
	static boolean place2(int x, int y, int z) {
		for(int i = (x/3)*3; i<(((x/3)+1)*3); i++) {
			for(int j = (y/3)*3; j<(((y/3)+1)*3); j++) {
//				if(x==0 && y==4) {
//				System.out.println(i+" "+j+" "+x+" "+y);
//				}
				if(i==x && j==y) continue;
				if(array[i][j]==z) {
//					System.out.println(x+" "+y+" "+i+" "+j+" "+z);
					return false;
				}
			}
		}
		return true;
	}
}

