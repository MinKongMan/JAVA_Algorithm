import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16928_snakeLadder_230112 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] ladder = new int[101];
		int[] snake = new int[101];
		int[] answer = new int[101];
		
		Arrays.fill(answer, 10000000);
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladder[x] = y;
		}
		
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			snake[x] = y;
		}
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		answer[1] = 0;
		qx.add(1);
		qy.add(0);
		
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int count = qy.poll();
			
			for(int i = 1; i<=6; i++) {
				int temp_x = x+i;
				if(temp_x>100) break;
				if(ladder[temp_x]!=0) {
					if(answer[ladder[temp_x]]>count+1) {
						qx.add(ladder[temp_x]);
						qy.add(count+1);
						answer[temp_x] = count+1;
						answer[ladder[temp_x]] = count+1;
					}
				}
				else if(snake[temp_x]!=0) {
					if(answer[snake[temp_x]]>count+1) {
						qx.add(snake[temp_x]);
						qy.add(count+1);
						answer[temp_x] = count+1;
						answer[snake[temp_x]] = count+1;
					}
				}
				else {
					if(answer[temp_x]>count+1) {
						qx.add(temp_x);
						qy.add(count+1);
						answer[temp_x] = count+1;
					}
					
				}
			}
		}
		
		System.out.println(answer[100]);
	}

}
