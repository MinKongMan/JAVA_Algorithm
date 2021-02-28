import java.util.LinkedList;
import java.util.Scanner;
class w{
	int x;
	int y;
	int z;
	w(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
class t{
	int a;
	int b;
	int c;
	int d;
	t(int a, int b, int c, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}
public class Baek_15683_watch_210228 {
	static LinkedList<w> link = new LinkedList<w>();
	static LinkedList<t> link2 = new LinkedList<t>();
	static int [][] array, array2;
	static int N,M,count = 0, check = 0, min = Integer.MAX_VALUE, t = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		array = new int[N+1][M+1];
		array2 = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				array[i][j] = sc.nextInt();
				array2[i][j] = array[i][j];
				if(array[i][j]!=0 && array[i][j]!=6) {
					link.add(new w(i,j,array[i][j]));
					link2.add(new t(0,0,0,0));
				}
			}
		}
//		for(int i = 0; i<link.size(); i++) {
//			System.out.println(link.get(i).x+" "+link.get(i).y+" "+link.get(i).z);
//		}
		count = link.size();
		act(0);
		
		System.out.println(min);
	}
	static void act(int a) {
		if(a == count) {
			for(int j = 0; j<link2.size(); j++) {
				
				int x = link2.get(j).a;
				int y = link2.get(j).b;
				int z = link2.get(j).c;
				int i = link2.get(j).d;
//				if(t<20) {
//				System.out.println(x+" "+y+" "+z+" "+i);
//				}
				if(z==1) {
					if(i==1) {
						cctvN(x,y);
					}
					else if(i==2) {
						cctvE(x,y);
					}
					else if(i==3) {
						cctvW(x,y);
					}
					else if(i==4) {
						cctvS(x,y);
					}
				}
				else if(z==2) {
					if(i%2==0) {
						cctvE(x,y);
						cctvW(x,y);
					}
					else if(i%2==1) {
						cctvS(x,y);
						cctvN(x,y);
					}
				}
				else if(z==3) {
					if(i==1) {
						cctvN(x,y);
						cctvE(x,y);
					}
					else if(i==2) {
						cctvE(x,y);
						cctvS(x,y);
					}
					else if(i==3) {
						cctvS(x,y);
						cctvW(x,y);
					}
					else if(i==4) {
						cctvN(x,y);
						cctvW(x,y);
					}
				}
				else if(z==4) {
					if(i==1) {
						cctvN(x,y);
						cctvE(x,y);
						cctvS(x,y);
					}
					else if(i==2) {
						cctvE(x,y);
						cctvS(x,y);
						cctvW(x,y);
					}
					else if(i==3) {
						cctvN(x,y);
						cctvS(x,y);
						cctvW(x,y);
					}
					else if(i==4) {
						cctvE(x,y);
						cctvN(x,y);
						cctvW(x,y);
					}
				}
				else if(z==5) {
					cctvS(x,y);
					cctvE(x,y);
					cctvN(x,y);
					cctvW(x,y);
				}
//				if(t<10) {
//					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ생성 중ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//				for(int k = 1; k<=N; k++) {
//					for(int l = 1; l<=M; l++) {
//						System.out.print(array[k][l]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println("ㅡㅡㅡㅡㅡㅡㅡ생서중ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//				}
			}
//			if(t<20) {
//			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
//					System.out.print(array[i][j]+" ");
					if(array[i][j]==0) {
						check++;
					}
				}
//				System.out.println();
			}
//			System.out.println("정답은 : "+check+" "+min);
//			}
			min = min<check?min:check;
			check = 0;
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					array[i][j] = array2[i][j];
				}
			}
			return;
		}
		int x = link.get(a).x;
		int y = link.get(a).y;
		int z = link.get(a).z;
		t++;
//		System.out.println(x+" "+y+" "+z+" "+a+" "+t);
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			for(int j = 1; j<=4; j++) {
				link2.get(a).a = x;
				link2.get(a).b = y;
				link2.get(a).c = z;
				link2.get(a).d = j;
				act(a+1);
			}
		
	}
	
	static void cctvE(int x, int y) {
		for(int i = y+1; i<=M; i++) {
			if(array[x][i]==0||array[x][i]==9) {
				array[x][i] = 9;
			}
			else if(array[x][i] == 6) {
				break;
			}
		}
	}
	static void cctvN(int x, int y) {
		for(int i = x-1; i>0; i--) {
			if(array[i][y]==0||array[i][y]==9) {
				array[i][y] = 9;
			}
			else if(array[i][y] == 6) {
				break;
			}
		}
	}
	static void cctvS(int x, int y) {
		for(int i = x+1; i<=N; i++) {
			if(array[i][y]==0 || array[i][y]==9) {
				array[i][y] = 9;
			}
			else if(array[i][y]==6) {
				break;
			}
		}
	}		
	static void cctvW(int x, int y) {
		for(int i = y-1; i>0; i--) {
			if(array[x][i]==0 || array[x][i]==9) {
				array[x][i] = 9;
			}
			else if(array[x][i]==6) {
				break;
			}
		}
	}
}
