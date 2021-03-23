import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_14891_gear_210323 {
	static class gear{
		int direct;
		int location;
		gear(int direct, int location){
			this.direct = direct;
			this.location = location;
		}
	}
	public static void main(String[] args) throws IOException {
		int[][] array = new int[5][8];
		LinkedList<gear> link = new LinkedList<gear>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		link.add(new gear(0,0));
		int score = 0;
		for(int i = 1; i<=4; i++) {
			String k = br.readLine();
			link.add(new gear(0,1000));
			for(int j = 0; j<8; j++) {
				array[i][j] = Integer.parseInt(k.charAt(j)+"");
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int i = 1; i<=K; i++) {
			String[] ka = br.readLine().split(" ");
			int a = Integer.parseInt(ka[0]);
			int b = Integer.parseInt(ka[1]);
			link.get(a).direct = b;
			for(int j = a; j>1; j--) {
				int x = (link.get(j).location+6)%8;
				int y = (link.get(j-1).location+2)%8;
				if(array[j][x]!=array[j-1][y]) {
//					System.out.println(i+"번째 왼쪽 "+(j-1));
//					System.out.println(i+"번째에서 "+j+"순서 "+j+"의 ");
					link.get(j-1).direct = link.get(j).direct*(-1);
				}
				else {
					link.get(j-1).direct = 0;
				}
			}
			for(int j=a; j<4; j++) {
				int x = (link.get(j).location+2)%8;
				int y = (link.get(j+1).location+6)%8;
				if(array[j][x]!=array[j+1][y]) {
					link.get(j+1).direct = link.get(j).direct*(-1);
//					System.out.println(i+"번째 오른쪽 "+(j+1)+" "+link.get(j+1).direct);
				}
				else {
					link.get(j+1).direct = 0;
				}
			}
			
			for(int j = 1; j<=4; j++) {
				link.get(j).location += (link.get(j).direct)*-1;
//				System.out.println(j+" 방향 "+link.get(j).direct+" 위치 "+(link.get(j).location%8));
			}
//			System.out.println("ㅡㅡㅡㅡ");
		}
		for(int i = 1; i<=4; i++) {
			int a = link.get(i).location;
			if(a<0) a = (800+a)%8;
			else a %= 8;
			if(array[i][a]==0) {
				score += 0;
			}
			else if(i == 1 && array[i][a]==1) {
				score += 1;
			}
			else if(i == 2 && array[i][a]==1) {
				score += 2;
			}
			else if(i == 3 && array[i][a]==1) {
				score += 4;
			}
			else if(i == 4 && array[i][a]==1) {
				score += 8;
			}
		}
		System.out.println(score);
	}

}
