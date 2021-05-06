import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class dik_9370 implements Comparable<dik_9370>{
	int end;
	int val;
	dik_9370(int end, int val){
		this.end = end;
		this.val = val;
	}
	@Override
	public int compareTo(dik_9370 arg0) {
		// TODO Auto-generated method stub
		return this.val-arg0.val;
	}
	
}
public class Baek_9370_unknownDestination_210506 {
	static ArrayList<dik_9370>[] array;
	static int[] des;
	static int[][] ar1;
	static boolean[] marked;
	static int a,b,c,d,e,f;
	static ArrayList<Integer> link = new ArrayList<Integer>();
	static PriorityQueue<dik_9370> pq = new PriorityQueue<dik_9370>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC<=N; TC++) {
			String[] ar = br.readLine().split(" ");
			a = Integer.parseInt(ar[0]);
			b = Integer.parseInt(ar[1]);
			c = Integer.parseInt(ar[2]);
			
			des = new int[c+1];
			array = new ArrayList[a+1];
			marked = new boolean[a+1];
			ar1 = new int[4][a+1];
			for(int i = 1; i<=a; i++) {
				for(int j = 1; j<=3; j++) {
					ar1[j][i] = 100000000;
				}
				array[i] = new ArrayList<dik_9370>();
			}
			
			ar = br.readLine().split(" ");
			d = Integer.parseInt(ar[0]);
			e = Integer.parseInt(ar[1]);
			f = Integer.parseInt(ar[2]);
			
			for(int i = 1; i<=b; i++) {
				ar = br.readLine().split(" ");
				
				int start = Integer.parseInt(ar[0]);
				int end = Integer.parseInt(ar[1]);
				int val = Integer.parseInt(ar[2]);
				
				array[start].add(new dik_9370(end, val));
				array[end].add(new dik_9370(start,val));
			}
			cal(d,1);
			cal(e,2);
			cal(f,3);
			
			for(int i = 1; i<=c; i++) {
				des[i] = Integer.parseInt(br.readLine());
			}
			link.clear();
			for(int i = 1; i<=c; i++) {
				int answer = ar1[1][e]+ar1[2][f]+ar1[3][des[i]]<ar1[1][f]+ar1[3][e]+ar1[2][des[i]]?
						ar1[1][e]+ar1[2][f]+ar1[3][des[i]]:ar1[1][f]+ar1[3][e]+ar1[2][des[i]];
				if(ar1[1][des[i]] >= answer) {
					link.add(des[i]);
				}
			}
			Collections.sort(link);
			for(int i = 0; i<link.size(); i++) {
				sb.append(link.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void cal(int val, int num) {
		pq.add(new dik_9370(val, 0));
		marked = new boolean[a+1];
		ar1[num][val] = 0;
		while(!pq.isEmpty()) {
			dik_9370 hyo = pq.poll();
			if(marked[hyo.end]) continue;
			marked[hyo.end] = true;
			for(dik_9370 jung : array[hyo.end]) {
				if(ar1[num][jung.end]>ar1[num][hyo.end]+jung.val) {
					ar1[num][jung.end] = ar1[num][hyo.end]+jung.val;
					pq.add(new dik_9370(jung.end, ar1[num][jung.end]));
				}
			}
		}
	}

}
