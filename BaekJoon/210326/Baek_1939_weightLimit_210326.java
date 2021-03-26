import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1939_weightLimit_210326 {
	static class baek{
		int end;
		int weight;
		baek(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	static 	ArrayList<ArrayList<baek>> ar = new ArrayList<>();
	static int N, M, start, end, max = 0, answer = 0;
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] marked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		marked = new boolean[N+1];
		for(int i = 0; i<=N; i++) {
			ar.add(new ArrayList<baek>());
		}
		for(int i = 1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			ar.get(a).add(new baek(b,c));
			ar.get(b).add(new baek(a,c));
			max = max>c?max:c;
		}
		start = sc.nextInt();
		end = sc.nextInt();
		int left = 1;
		int right = max;
		while(left<=right) {
			int mid = (left+right)/2;
			q.add(start);
			boolean check = find(mid);
			if(check) {
				answer = answer>mid?answer:mid;
				left = mid+1;
			}
			else right = mid-1;
			Arrays.fill(marked, false);
			q.clear();
		}
		System.out.println(answer);
	}
	
	static boolean find(int mid) {
		while(!q.isEmpty()) {
			int x = q.poll();
			marked[x] = true;
			for(baek hyo : ar.get(x)) {
				int q_end = hyo.end;
				int q_weight = hyo.weight;
				if(q_weight>=mid) {
					if(end == q_end) {
						return true;
					}
					else if(!marked[q_end]){
						marked[q_end] = true;
						q.add(q_end);
					}
				}
			}
		}
		return false;
	}
}
  