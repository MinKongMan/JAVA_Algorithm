import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class hide implements Comparable<hide>{
	int a;
	int count;
	hide(int a, int count){
		this.a = a;
		this.count = count;
	}
	@Override
	public int compareTo(hide arg0) {
		// TODO Auto-generated method stub
		return this.count-arg0.count;
	}
	
}
public class Baek_13549_hideAndSeek_210402 {
	static PriorityQueue<hide> pq = new PriorityQueue<hide>();
	static boolean[] marked;
	static int N,M;
	static int[] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int big = N>M?N:M;
		marked = new boolean[200001];
		array = new int[200001];
		Arrays.fill(array, Integer.MAX_VALUE);
		array[N] = 0;
		pq.add(new hide(N,0));
		while(!pq.isEmpty()) {
			hide hyo = pq.poll();
			if(!marked[hyo.a]) {
				marked[hyo.a]= true; 
				if(hyo.a+1<=200000) {
					array[hyo.a+1] = array[hyo.a+1]<array[hyo.a]+1?array[hyo.a+1]:array[hyo.a]+1;
					pq.add(new hide(hyo.a+1,array[hyo.a+1]));
				}
				if(hyo.a-1>=0) {
					array[hyo.a-1] = array[hyo.a-1]<array[hyo.a]+1?array[hyo.a-1]:array[hyo.a]+1;
					pq.add(new hide(hyo.a-1,array[hyo.a-1]));
				}
				if(hyo.a*2<=200000) {
					array[hyo.a*2] = array[hyo.a*2]<array[hyo.a]?array[hyo.a*2]:array[hyo.a];
					pq.add(new hide(hyo.a*2,array[hyo.a*2]));
				}
			}
//			System.out.println(hyo.a);
//			for(int i = 1; i<=big; i++) {
//				System.out.print(array[i]+" ");
//			}
//			System.out.println();
		}
		System.out.println(array[M]);
	}

}
