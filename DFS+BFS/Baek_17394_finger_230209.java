import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17394_finger_230209 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		boolean[] che = new boolean[100001];
		che[1] = true;
		for(int i = 2; i<=100000; i++) {
			if(che[i]) continue;
			for(int j = i*2; j<=100000; j+=i) {
				che[j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<Integer>();
			Queue<Integer> qc = new LinkedList<Integer>();
			int[] array = new int[1000001];
			Arrays.fill(array, Integer.MAX_VALUE);
			
			q.add(N);
			qc.add(0);
			array[N] = 0;
			
			while(!q.isEmpty()) {
				int x = q.poll();
				int count = qc.poll();
				
				if(x+1<=1000000 && array[x+1]>count+1) {
					array[x+1] = count+1;
					q.add(x+1);
					qc.add(count+1);
				}
				
				if(x-1>=0 && array[x-1]>count+1) {
					array[x-1] = count+1;
					q.add(x-1);
					qc.add(count+1);
				}
				
				if(x/2>=0 && array[x/2]>count+1) {
					array[x/2] = count+1;
					q.add(x/2);
					qc.add(count+1);
				}
				
				if(x/3>=0 && array[x/3]>count+1) {
					array[x/3] = count+1;
					q.add(x/3);
					qc.add(count+1);
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i = a; i<=b; i++) {
				if(!che[i] && array[i]<min) min = array[i];
			}
			if(min==Integer.MAX_VALUE) sb.append(-1+"\n");
			else sb.append(min+"\n");
		}
		System.out.println(sb);
	}

}
