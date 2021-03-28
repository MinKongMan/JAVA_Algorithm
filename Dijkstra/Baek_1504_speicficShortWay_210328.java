import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class baek_1504 implements Comparable<baek_1504>{
	int end;
	int value;
	baek_1504 (int end, int value){
		this.end = end;
		this.value = value;
	}
	@Override
	public int compareTo(baek_1504 o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}
	
}
public class Baek_1504_speicficShortWay_210328 {
	static ArrayList<baek_1504>[] ar;
	static int N,M, m_s, m_e,min = Integer.MAX_VALUE,temp = 0;
	static int[] array;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		M = Integer.parseInt(k[1]);
		ar = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ar[i] = new ArrayList<baek_1504>();
		}
		for(int i = 1; i<=M; i++) {
			k = br.readLine().split(" ");
			int a = Integer.parseInt(k[0]);
			int b = Integer.parseInt(k[1]);
			int c = Integer.parseInt(k[2]);
			ar[a].add(new baek_1504(b, c));
			ar[b].add(new baek_1504(a, c));
		}
		k = br.readLine().split(" ");
		m_s = Integer.parseInt(k[0]);
		m_e = Integer.parseInt(k[1]);
		array = new int[N+1];
		Arrays.fill(array, Integer.MAX_VALUE);
		check = new boolean[N+1];
		for(int i = 1; i<=2; i++) {
			temp = 0;
			if(i==1) {
				find(1);
				if(check[m_s]) {
					temp += array[m_s];
//					System.out.println(array[m_s]);
				}
				else continue;
				find(m_s);
				if(check[m_e]) {
					temp += array[m_e];
				}
				else continue;
				find(m_e);
				if(check[N]) {
					temp += array[N];
					min = min<temp?min:temp;
				}
				else continue;
			}
			else {
				find(1);
				if(check[m_e]) {
					temp += array[m_e];
				}
				else continue;
				find(m_e);
				if(check[m_s]) {
					temp += array[m_s];
				}
				else continue;
				find(m_s);
				if(check[N]) {
					temp += array[N];
					min = min<temp?min:temp;
				}
				else continue;
			}
		}
		System.out.println(min==Integer.MAX_VALUE?"-1":min);
	}
	static void find(int a) {
		PriorityQueue<baek_1504> q = new PriorityQueue<baek_1504>();
		array = new int[N+1];
		Arrays.fill(array, Integer.MAX_VALUE);
		check = new boolean[N+1];
		array[a] = 0;
		check[a] = true;
		q.add(new baek_1504(a,0));
		while(!q.isEmpty()) {
			baek_1504 hyo = q.poll();
			int x = hyo.end;
			check[x] = true;
			for(baek_1504 jung : ar[x]) {
				if(check[jung.end]) continue;
//				System.out.println(x+" "+jung.end+" / "+jung.value);
				if(array[jung.end]>array[x]+jung.value) {
					array[jung.end] = array[x]+jung.value;
					q.add(new baek_1504(jung.end,array[jung.end]));
//					System.out.println(q.peek().end+" "+q.peek().value);
				}
			}
		}
	}
}

