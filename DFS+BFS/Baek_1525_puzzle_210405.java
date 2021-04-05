import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_1525_puzzle_210405 {
	static int N;
	static String hyo = "";
	static HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Integer> qx = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i<=3; i++) {
			String[] l = br.readLine().split(" ");
			for(int j = 1; j<=3; j++) {
				if(l[j-1].equals("0")) {
					int a = 9;
					N = N*10+a;
				}
				else {
					int a = Integer.parseInt(l[j-1]);
					N = N*10+a;
				}
			}
		}
		hash.put(N, 0);
		qx.add(N);
		while(!qx.isEmpty()) {
			int temp = qx.poll();
			hyo = String.valueOf(temp);
			int a = hyo.indexOf('9');
			int x = a/3;
			int y = a%3;
			for(int i = 0; i<4; i++) {
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if(temp_x<0 || temp_x>2 || temp_y<0 || temp_y>2) continue;
				StringBuilder sb = new StringBuilder(hyo);
				int val = temp_x*3 + temp_y;
				char b = sb.charAt(val);
				sb.setCharAt(val, '9');
				sb.setCharAt(a,b);
				int answer = Integer.parseInt(sb.toString());
				if(!hash.containsKey(answer)) {
					hash.put(answer, hash.get(temp)+1);
					qx.add(answer);
				}
				else if(hash.containsKey(123456789)) {
					qx.clear();
					break;
				}
			}
		}
		if(hash.containsKey(123456789)) System.out.println(hash.get(123456789));
		else System.out.println(-1);
	}

}
