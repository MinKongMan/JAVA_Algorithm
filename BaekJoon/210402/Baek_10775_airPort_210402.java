import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10775_airPort_210402 {
	static int[] parent,count;
	static int hyo = 0, jung = 0;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] array = new int[N+1];
		count = new int[N+1];
		parent = new int[N+1];
		for(int i = 1; i<=N; i++) {
			parent[i] = i;
		}
		int i = 1;
		for(i = 1; i<=M; i++) {
			int x = Integer.parseInt(br.readLine());
			if(count[x]==0) {
				count[x]++;
				hyo = find(x);
				jung = find(x-1);
				if(hyo!=jung) {
					union(x-1,x);
				}
			}
			else {
				hyo = find(x);
				if(hyo==0) break;
				else if(count[hyo]==0) {
					count[hyo]++;
					union(hyo-1,hyo);
				}
			}
		}
		System.out.println(i-1);
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		hyo = find(a);
		jung = find(b);
		if(a<b) {
			parent[jung] = hyo;
		}
		else {
			parent[hyo] = jung;
		}
	}

}
