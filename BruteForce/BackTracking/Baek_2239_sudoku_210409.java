import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baek_2239_sudoku_210409 {
	static class link{
		int x;
		int y;
		link(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static StringBuilder sb = new StringBuilder();
	static int[][] array;
	static int count = 0;
	static LinkedList<link> li = new LinkedList<link>();
	public static void main(String[] args) throws IOException {
		array = new int[10][10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i<=9; i++) {
			String k = br.readLine();
			for(int j = 1; j<=9; j++) {
				array[i][j] = k.charAt(j-1)-'0';
				if(array[i][j]==0) li.add(new link(i,j));
			}
		}
		find(0);
		System.out.println(sb);
	}
	
	static boolean find(int a) {
		if(a==li.size()) {
			for(int i = 1; i<=9; i++) {
				for(int j = 1; j<=9; j++) {
					sb.append(array[i][j]);
				}
				sb.append("\n");
			}
			return true;
		}
//		for(int i = 1; i<=9; i++) {
//			for(int j = 1; j<=9; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		int x = li.get(a).x;
		int y = li.get(a).y;
		for(int j = 1; j<=9; j++) {
			array[x][y] = j;
//			System.out.println(a+" "+array[x][y]);
			boolean flag = check(x,y);
			if(flag) {
//				System.out.println("들어감");
				if(find(a+1)) {
					return true;
				}
			}
			array[x][y] = 0;
		}
		return false;
	}
	
	static boolean check(int a, int b) {
		int x = ((a-1)/3);
		int y = ((b-1)/3);
//		System.out.println("들어옴  "+a+" "+b+" "+(x+1)+" "+(x+1)*3+" "+(y+1)+" "+(y+1)*3+" "+array[a][b]);
		for(int i = 3*x+1; i<=3*x+3; i++) {
			for(int j = 3*y+1; j<=3*y+3; j++) {
				if((i!=a && j!=b) && array[i][j]==array[a][b]) {
//					System.out.println("틀림 : "+i+" "+j+" "+array[i][j]);
					return false;
				}
			}
		}
		for(int i = 1; i<=9; i++) {
			if(a!=i && array[i][b]==array[a][b]) {
//				System.out.println("틀림");
				return false;
			}
		}
		for(int i = 1; i<=9; i++) {
			if(b!=i && array[a][i]==array[a][b]) {
				return false;
			}
		}
		return true;
	}
}
