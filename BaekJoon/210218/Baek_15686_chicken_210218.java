import java.util.LinkedList;
import java.util.Scanner;
class Point{
	int x;
	int y;
	Point(int a, int b){
		this.x = a;
		this.y = b;
	}
}

public class Baek_15686_chicken_210217 {
	static LinkedList<Point> home = new LinkedList<Point>();
	static LinkedList<Point> chicken = new LinkedList<Point>();
	static int[] map;
	static int N, M, temp, sum = 0, answer;
	static boolean[] marked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] array = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				array[i][j] = sc.nextInt();
				if(array[i][j]==1) {
					home.add(new Point(i,j));
				}
				if(array[i][j]==2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		marked = new boolean[chicken.size()];
		map = new int[home.size()];
		
		answer = Integer.MAX_VALUE;
		Combination(0, M);
		
		System.out.println(answer);
	}
	public static void Combination(int a, int b) {//b°¡ °¹¼ö
		if(b==0) {
			sum = 0;
			for(int i = 0; i<map.length; i++) {
				map[i] = N*N;
			}
			for(int i = 0; i<home.size(); i++) {
				for(int j = 0; j<marked.length; j++) {
					if(marked[j]==true) {
//						System.out.print(chicken.get(j).x+" "+chicken.get(j).y+" ");
						temp = Math.abs(home.get(i).x-chicken.get(j).x)+Math.abs(home.get(i).y-chicken.get(j).y);
						map[i] = temp<map[i]?temp:map[i];
					}
				}
			}
//			System.out.println();
			for(int i = 0; i<map.length; i++) {
//				System.out.print(map[i]+" ");
				sum += map[i];
			}
//			System.out.println(" "+sum);
			answer = answer<sum?answer:sum;
			return;
		}
		for(int i = a; i<chicken.size(); i++) {
			marked[i] = true;
//			System.out.println("È½¼ö : "+i+" "+a+" "+b);
			Combination(i+1,b-1);
			marked[i] = false;
		}
	}
}
