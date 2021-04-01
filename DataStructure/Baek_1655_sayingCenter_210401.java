import java.util.PriorityQueue;
import java.util.Scanner;
class pqq implements Comparable<pqq>{
	int x;
	pqq(int x){
		this.x = x;
	}
	@Override
	public int compareTo(pqq o) {
		// TODO Auto-generated method stub
		return o.x-this.x;
	}
}
public class Baek_1655_sayingCenter_210401 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PriorityQueue<pqq> pq1 = new PriorityQueue<pqq>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int a1 = sc.nextInt();
		sb.append(a1+"\n");
		if(N>=2) {
			int b1 = sc.nextInt();
			if(a1<=b1) {
				pq1.add(new pqq(a1));
				pq.add(b1);
			}
			else {
				pq1.add(new pqq(b1));
				pq.add(a1);
			}
			sb.append(pq1.peek().x+"\n");
			for(int i = 3; i<=N; i++) {
				int a = sc.nextInt();
				if(i%2==0) {
					pq.add(a);
					if(pq.peek()<pq1.peek().x) {
						pqq k = pq1.poll();
						int y = pq.poll();
						pq.add(k.x);
						pq1.add(new pqq(y));
						sb.append(pq1.peek().x+"\n");
					}
					else {
						sb.append(pq1.peek().x+"\n");
					}
				}
				else {
					pq1.add(new pqq(a));
					if(pq1.peek().x>pq.peek()) {
						pqq k = pq1.poll();
						int y = pq.poll();
						pq.add(k.x);
						pq1.add(new pqq(y));
						sb.append(y+"\n");
					}
					else {
						sb.append(pq1.peek().x+"\n");
					}
				}
			}
			
		}
		System.out.print(sb);
		
	}

}
