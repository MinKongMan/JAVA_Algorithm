import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Baek_1068_tree_210310 {
	static class dfs{
		int x;
		int y;
		LinkedList<dfs> link;
		dfs(int x, int y){
			this.x = x;
			this.y = y;
			link = new LinkedList<dfs>();
		}
	}
	static int[] array, array2;
	static int[] dx = {1};
	static LinkedList<dfs> ar = new LinkedList<dfs>();
	static ArrayList<ArrayList<Integer>> ar2 = new ArrayList<>();
	static int N, temp = 0, check = 0;;
	static int count = 0,k;
	public static int cut;
	static int min;
	static boolean[] marked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		array = new int[N];
		for(int i = 0; i<N; i++) {
			ar2.add(new ArrayList<Integer>());
		}
		for(int i = 0; i<N; i++) {
			int a = sc.nextInt();
			if(a==-1) {
				check = i;
				continue;
			}
			ar2.get(a).add(i);
			array[i] = a;
		}
		k = sc.nextInt();
		marked = new boolean[N];
		marked[k] = true;
		ar2.get(k).clear();
		dfs(check);
		System.out.println(temp);
		
	}
	static void dfs(int a) {
		if(ar2.get(a).size()<1 && a!=k) {
			temp++;
			return;
		}
		else if(ar2.get(a).size()==1 && ar2.get(a).contains(k)) {
			temp++;
			return;
		}
		for(Integer t : ar2.get(a)) {
			dfs(t);
		}
	}
}
