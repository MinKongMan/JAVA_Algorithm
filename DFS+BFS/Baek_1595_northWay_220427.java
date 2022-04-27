import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_1595_northWay_220427 {
	static class node{
		int y;
		int val;
		node(int y, int val){
			this.y = y;
			this.val = val;
		}
	}
	static boolean[] marked = new boolean[10001];
	static int max = Integer.MIN_VALUE;
	static ArrayList<node>[] ar;
	static int ptr = 0;
	public static void main(String[] args) throws IOException {
		ar = new ArrayList[10001];
		StringTokenizer st;
		for(int i = 1; i<=10000; i++) {
			ar[i] = new ArrayList<node>();
		}
		int tt = 1;
		String line = "";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			while(!(line = br.readLine()).isEmpty()) {
//				String[] l = br.readLine().split(" ");
				st = new StringTokenizer(line);
//				if(l.length<1) break;
//				if(l[0].equals(null) || l[0].equals("") || l[0].length()<1 || l[0].isEmpty()) break;
//				int x = Integer.parseInt(l[0]);
//				int y = Integer.parseInt(l[1]);
//				int val = Integer.parseInt(l[2]);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				ar[x].add(new node(y,val));
				ar[y].add(new node(x,val));
//				System.out.println(x+" "+y);
				tt++;
			}
		}catch(Exception e) {}
		
		marked[1] = true;
		dfs(1,0);
		marked[1] = false;
//		System.out.println(max);
		max = Integer.MIN_VALUE;
//		System.out.println("天天天天天天天天天天天天天天");
		marked[ptr] = true;
		dfs(ptr,0);
		marked[ptr] = false;
		System.out.println(max);
	}
	
	static void dfs(int a, int val) {
//		System.out.println(a+" "+val+" "+max);
		if(max<val) {
			ptr = a;
			max = val;
		}
		for(node temp : ar[a]) {
			if(marked[temp.y]) continue;
//			System.out.println(temp.y);
			marked[temp.y]= true;
			dfs(temp.y, val+temp.val);
			marked[temp.y]= false; 
		}
	}

}
