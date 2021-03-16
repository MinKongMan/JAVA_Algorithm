import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_16953_aTob_210316 {
	static class f{
		int x;
		int count;
		f(int x, int count){
			this.x =x;
			this.count = count;
		}
	}
	static int N,M,count = 0,min = Integer.MAX_VALUE;
	static Queue<f> q = new LinkedList<f>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) sc.nextLong();
		M = (int) sc.nextLong();
		q.add(new f(N,count));
		while(!q.isEmpty()) {
			f hyo = q.poll();
			int x = hyo.x;
			int cnt = hyo.count;
			if(x==M) {
				min = min<cnt?min:cnt;
			}
			else {
				if(x*2<=M) {
					q.add(new f(x*2,cnt+1));
				}
				if((x*10+1)<=M) {
					q.add(new f(x*10+1,cnt+1));
				}
			}
		}
		System.out.println(min==Integer.MAX_VALUE?"-1":min+1);
	}
}
