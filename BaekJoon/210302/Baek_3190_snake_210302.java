import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class snake{
	int x;
	int y;
	int turn;
	int count;
	snake(int x, int y, int z, int m){
		this.x = x;
		this.y = y;
		this.turn = z;
		this.count = m;
	}
}
public class Baek_3190_snake_210302 {
	static int N,M,L = 101, count = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<snake> q = new LinkedList<snake>();
	static int[][] array;
	static int[] turn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[N+2][N+2];
		turn = new int[10001];
		array[1][1] = 5;
		for(int i = 1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			array[a][b] = 2;
		}
		int K = sc.nextInt();
		for(int i = 1; i<=K; i++) {
			int a = sc.nextInt();
			String b = sc.next();
			if(b.equals("D")) {
				turn[a]++;
			}
			if(b.equals("L")) {
				turn[a]--;
			}
		}
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		q.add(new snake(1,1,L,0));
		while(!q.isEmpty()) {
			snake s = q.poll();
			int a = s.x;
			int b = s.y;
			int c1 = s.turn;
			int d = s.count;
//			System.out.println(a+" "+b+" "+c1+" "+d+" "+"疏魚 高2");
			int c2 = (c1+turn[d]);
			int k = c2%4;
			int temp_a = a+dx[k];
			int temp_b = b+dy[k];
//			System.out.println("天天天天天天天天天天天天天雖毽檜天天天天天天天天天天");
			if(d>=56) {
//			System.out.println(a+" "+b+" "+c1+" "+d+" "+temp_a+" "+temp_b+" "+"疏魚 高1");
			}
			if(array[temp_a][temp_b]==5||temp_a<1||temp_b<1||temp_a>N||temp_b>N) {
				count = d;
				break;
			}
			if(array[temp_a][temp_b]==0) {
				array[a][b] = 0;
				array[temp_a][temp_b] = 5;
				q.add(new snake(temp_a,temp_b,c2,d+1));
			}
			else if(array[temp_a][temp_b]==2) {
				q.add(new snake(temp_a,temp_b,c2,d+1));
				q.add(new snake(a,b,c1,d));
//				System.out.println(temp_a+" "+temp_b+" "+c2+" "+(d+1));
//				System.out.println(a+" "+b+" "+c2+" "+d);
				for(int i = 1; i<q.size()-1; i++) {
					snake t = q.poll();
//					System.out.println(t.x+" "+t.y+" "+t.turn+" "+t.count);
					q.add(new snake(t.x,t.y,t.turn,t.count));
				}
				array[temp_a][temp_b] = 5;
			}
			if(d>=55) {
//			for(int i = 1; i<=N; i++) {
//				for(int j = 1; j<=N; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
			}
		}
		System.out.println(count+1);
	}

}
