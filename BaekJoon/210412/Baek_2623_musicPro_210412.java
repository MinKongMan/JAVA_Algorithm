import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2623_musicPro_210412 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> qx = new LinkedList<Integer>();
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] ar = new ArrayList[N+1];
		int[] stack = new int[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int[] array = new int[a+1];
			for(int j = 1; j<=a; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 1; j<=a; j++) {
				for(int k = j+1; k<=a; k++) {
					ar[array[j]].add(array[k]);
					stack[array[k]]++;
				}
			}
			
		}
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			if(stack[i]==0) {
				sb.append(i+"\n");
				count++;
				qx.add(i);
			}
		}
		while(!qx.isEmpty()) {
			int x = qx.poll();
			for(int hyo : ar[x]) {
				stack[hyo]--;
				if(stack[hyo]==0) {
					sb.append(hyo+"\n");
					count++;
					qx.add(hyo);
				}
			}
		}
		StringBuilder bdb = new StringBuilder();
		System.out.println(bdb.length());
		System.out.println(count==N?sb:"0");
	}

}
