import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_17136_colorPaper_210407 {
	static class square{
		int x;
		int y;
		square(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int min = Integer.MAX_VALUE;
	static int[][] array;
	static int[] arr;
	static LinkedList<square> link = new LinkedList<square>();
	static boolean[][] marked;
	static int count =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		array = new int[11][11];
		marked = new boolean[11][11];
		arr = new int[6];
		for(int i = 0; i<=4; i++) {
			arr[i] = 5;
		}
		for(int i = 1; i<=10; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=10; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j]==1) {
					link.add(new square(i,j));
				}
			}
		}
		tracking(0,0,0);
		System.out.println(min==Integer.MAX_VALUE?"-1":min);
	}
	
	static void tracking(int a, int b, int c) {
		if(a==link.size()) {
			min = min<b?min:b;
			return;
		}
		
			int x = link.get(c).x;
			int y = link.get(c).y;
			if(marked[x][y]) tracking(a,b,c+1);
			for(int i = 1; i<=5; i++) {
				if(arr[i-1]==0) continue;
				if(x+i>11 || y+i>11) return;
				for(int k = x; k<x+i; k++) {
					for(int l = y; l<y+i; l++) {
						if(marked[k][l] || array[k][l]==0) {
							return;
						}
					}
				}
				if(find(x,y,i)) {
					arr[i-1]--;
					tracking(a+(i*i),b+1,c+1);
					arr[i-1]++;
				}
				refresh(x,y,i);
			}
			return;
	}
	
	static boolean find(int a, int b, int c) {
		for(int i = a; i<a+c; i++) {
			for(int j = b; j<b+c; j++) {
				marked[i][j] = true;
			}
		}
		return true;
	}
	
	static void refresh(int a, int b, int c) {
		for(int i = a; i<a+c; i++) {
			for(int j = b; j<b+c; j++) {
				marked[i][j] = false;
			}
		}
	}
}
