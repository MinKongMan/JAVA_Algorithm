import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
class link_16235{
	int x;
	int y;
	int age;
	int life;
	link_16235(int x, int y, int age, int life){
		this.x = x;
		this.y = y;
		this.age = age;
		this.life = life;
	}
}
public class Baek_16235_treeFinancial_210308 {
	static int[][] array,eat;
	static int N,M,K,year = 1, turn = -1, tree = 0;
	static int[] dx = {1,0,-1,0,1,1,-1,-1};
	static int[] dy = {0,1,0,-1,-1,1,1,-1};
	static LinkedList<link_16235> link = new LinkedList<link_16235>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		K = Integer.parseInt(k[2]);
		array = new int[N+1][N+1];
		eat = new int[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				eat[i][j] = Integer.parseInt(st.nextToken());
				array[i][j] = 5;
			}
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			link.add(new link_16235(a, b, c, 1));
		}
		while(year<=K) {
			for(link_16235 a : link) {
				if(array[a.x][a.y]>=a.age) {
					array[a.x][a.y]-=a.age;
					a.age++;
				}
				else if(array[a.x][a.y]<a.age) {
					a.life = 0;
				}
			}
			for(Iterator<link_16235> t = link.iterator(); t.hasNext();) {
				link_16235 m = t.next();
				if(m.life==0) {
					array[m.x][m.y] += m.age/2; 
					t.remove();
				}
			}
			
			LinkedList<link_16235> ad = new LinkedList<link_16235>();
			for(link_16235 a: link) {
				if(a.age%5==0) {
					for(int i = 0; i<8; i++) {
						if(a.x+dx[i]<1 || a.x+dx[i]>N || a.y+dy[i]<1 || a.y+dy[i]>N) continue;
						ad.add(new link_16235(a.x+dx[i], a.y+dy[i], 1, 1));
					}
				}
			}
			link.addAll(0,ad);
			winter();
			year++;
		}
		System.out.println(link.size());
	}
	
	static void winter() {
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				array[i][j] += eat[i][j];
			}
		}
	}

}
