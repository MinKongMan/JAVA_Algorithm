import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek_1715_cardSort_210318 {

	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i<=N; i++) {
			q.add(sc.nextInt());
		}
		while(q.size()>1) {
			int a = q.poll();
			int b = q.poll();
			count += a+b;
			q.add(a+b);
		}
		System.out.println(count);
	}

}
