import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_9489_sibling_230208 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			
			int[] array = new int[N+1];
			int[] ar = new int[N+1];
			int[] up = new int[N+1];
			int[] set = new int[N+1];
			st = new StringTokenizer(br.readLine());
			int ptr = 0;
			for(int i = 1; i<=N; i++) {
				int x = Integer.parseInt(st.nextToken());
				array[i] = x;
				if(x==M) ptr = i;
			}
			int count = 1;
			int parent = 1;
			for(int i = 2; i<=N; i++) {
				if(set[i]!=0) continue;
				int a = i;
				int b = i+1;
				while(b<=N) {
					int x = array[a];
					int y = array[b];
					if(x+1==y) {
						a++;
						b++;
					}
					else break;
				}
				
				
				for(int j = i; j<b; j++) {
					ar[parent]++;
					up[j] = parent;
					set[j] = count;
				}
				parent++;
				count++;
			}
			int k = 0;
			
			for(int i = 1; i<=N; i++) {
				if(set[up[ptr]]==set[i]) {
					k += ar[i];
				}
			}
			sb.append(k-ar[up[ptr]]+"\n");
		}
		System.out.println(sb);
	}

}
