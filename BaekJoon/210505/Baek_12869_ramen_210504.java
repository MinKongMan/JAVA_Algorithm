import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class ramen implements Comparable<ramen>{
	int deadline;
	int ramen;
	ramen(int deadline, int ramen){
		this.deadline = deadline;
		this.ramen = ramen;
	}
	@Override
	public int compareTo(ramen arg0) {
		// TODO Auto-generated method stub
		if(this.deadline==arg0.deadline) {
			return -this.ramen+arg0.ramen;
		}
		else return this.deadline-arg0.deadline;
	}
	
}

class ramen2 implements Comparable<ramen2>{
	int ramen;
	ramen2(int ramen){
		this.ramen = ramen;
	}
	@Override
	public int compareTo(ramen2 arg0) {
		// TODO Auto-generated method stub
		return -arg0.ramen+this.ramen;
	}
	
}
public class Baek_12869_ramen_210504 {
	static PriorityQueue<ramen> pq = new PriorityQueue<ramen>();
	static PriorityQueue<ramen2> pq2 = new PriorityQueue<ramen2>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sum = 0;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new ramen(a,b));
		}
		int count = 0;
		int a = 0;
		int b = 0;
		while(!pq.isEmpty()) {
			ramen hyo = pq.poll();
			int ram = hyo.ramen;
			int dead = hyo.deadline;
			if(dead>count) {
//				if(a==dead) {
//					if(ram>pq2.peek().ramen) {
//						pq2.add(new ramen2(ram));
//						sum -= pq2.poll().ramen;
//						
//					}
//				}
//				else {
					pq2.add(new ramen2(ram));
					a = dead;
					sum+=ram;
					count++;
//				}
			}
			else if(dead==count) {
				if(ram>pq2.peek().ramen) {
					pq2.add(new ramen2(ram));
					sum -= pq2.poll().ramen;
					sum += ram;
				}
			}
			
		}
		System.out.println(sum);
	}

}
