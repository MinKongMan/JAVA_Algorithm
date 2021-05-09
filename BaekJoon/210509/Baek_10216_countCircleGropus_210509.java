import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10216_countCircleGropus_210509 {
	static int[] find;
	static int[][] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC<=N; TC++) {
			
			int M = Integer.parseInt(br.readLine());
			array = new int[4][M+1];
			find = new int[M+1];
			int answer = M;
			for(int i = 1; i<=M; i++) {
				String[] k = br.readLine().split(" ");
				int a = Integer.parseInt(k[0]);
				int b = Integer.parseInt(k[1]);
				int c = Integer.parseInt(k[2]);
				array[1][i] = a;
				array[2][i] = b;
				array[3][i] = c;
				find[i] = i;
			}
			
			for(int i = 1; i<=M; i++) {
				int oh = array[1][i];
				int my = array[2][i];
				int girl = array[3][i];
				for(int j = i+1; j<=M; j++) {
					int hyo = array[1][j];
					int jung = array[2][j];
					int choi = array[3][j];
					if((oh-hyo)*(oh-hyo)+(my-jung)*(my-jung)<=(girl+choi)*(girl+choi)) {
//						System.out.println(Math.sqrt((oh-hyo)*(oh-hyo)+(my-jung)*(my-jung))+" "+(girl+choi)+" / "+oh+" "+my+" "+girl+" "+hyo+" "+jung+" "+choi);
						if(find(i)!=find(j)) {
							union(i,j);
							answer--;
						}
					}
				}
			}
			sb.append(answer+"\n");
		}
		System.out.print(sb);
	}

	static int find(int a) {
		if(find[a]==a) return a;
		else return find[a] = find(find[a]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x==y) return;
		if(x<y) {
			find[y] = x;
		}
		else {
			find[x] = y;
		}
	}
}
