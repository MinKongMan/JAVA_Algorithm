import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class start implements Comparable<start>{
	int start;
	int end;
	double val;
	start(int start, int end, double val){
		this.start = start;
		this.end = end;
		this.val = val;
	}
	@Override
	public int compareTo(start arg0) {
		// TODO Auto-generated method stub
		return (int) (this.val-arg0.val);
	}
}
class star{
	double x;
	double y;
	star(double x, double y){
		this.x = x;
		this.y = y;
	}
}
public class Baek_4386_star_210504 {
	static PriorityQueue<start> pq = new PriorityQueue<start>();
	static int[] array;
	static LinkedList<star> link = new LinkedList<star>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = i;
		}
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			link.add(new star(a,b));
		}
		for(int i = 0; i<link.size(); i++) {
			for(int j = i+1; j<link.size(); j++) {
				double a = link.get(i).x;
				double b = link.get(i).y;
				double c = link.get(j).x;
				double d = link.get(j).y;
				double k = Math.round((Math.sqrt((a-c)*(a-c)+(b-d)*(b-d)))*100)/100.0;
				pq.add(new start(i+1,j+1,k));
			}
		}
		double val = 0;
		while(!pq.isEmpty()) {
			start hyo = pq.poll();
			int start = hyo.start;
			int end = hyo.end;
			if(find(start)!=find(end)) {
				union(start,end);
				val += hyo.val;
			}
		}
		System.out.println(val);
	}
	
	static int find(int a) {
		if(a==array[a]) return a;
		else return array[a] = find(array[a]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x<y) array[y] = x;
		else array[x] = y;
	}
	
}
