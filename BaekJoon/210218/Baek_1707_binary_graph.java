import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class Baek_1707_binary_graph {
	static boolean[] marked;
	static int[] binary;
	static int stack = 0;
	static ArrayList<ArrayList<Integer>> array;
	static Stack<Integer> st = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int i = 1; i<=TC; i++) {
			stack = 0;
			int V = sc.nextInt();
			int E = sc.nextInt();
			array = new ArrayList<>();
			marked = new boolean[V+1];
			binary = new int[V+1];
			for(int j = 0; j<=V; j++) {
				array.add(new ArrayList<Integer>());
			}
//			for(int j = 1; j<=V; j++) {
//				System.out.println(array[j]);
//			}
			for(int j = 0; j<E; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				array.get(a).add(b);
				array.get(b).add(a);
				if(j==0) {
					st.push(a);
				}
			}
			marked[st.peek()]=true;
			make_binary(st.peek());
//			for(int k = 1; k<=V; k++) {
//				System.out.print(binary[k]+" ");
//			}
			marked = new boolean[V+1];
//			for(int j = 1; j<=V; j++) {
//				for(int k:array.get(j)) {
//					System.out.print(k+" ");
//				}
//				System.out.println();
//			}
			check(st.pop());
			for(int j = 1; j<E; j++) {
				if(marked[j]==false) {
					check(j);
				}
			}
//			System.out.println(p);
			if(stack!=1) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	public static void check(int a) {
		for(int get : array.get(a)) {
			if(binary[a]==binary[get]) {
				stack = 1;
				return;
			}
			if(marked[get]==false) {
				st.push(get);
//				System.out.println("¿©±â"+get+" "+stack);
				marked[get] = true;
				check(get);
			}
		}
	}
	public static void make_binary(int a) {
		for(int get : array.get(a)) {
			if(marked[get]==false) {
				if(binary[a]==0 && binary[get]==0) {
					binary[a] = 1;
					binary[get] = 2;
				}
				else if(binary[a]==1 && binary[get]==0) {
					binary[get] = 2;
				}
				else if(binary[a]==2 && binary[get]==0) {
					binary[get] = 1;
				}
				else if(binary[a]==0 && binary[get]==1) {
					binary[a] = 2;
				}
				else if(binary[a]==0 && binary[get]==2) {
					binary[a] = 1;
				}
//				System.out.println(a+" "+get+" "+binary[a]+" "+binary[get]);
				marked[get]=true;
				make_binary(get);
			}
		}
	}

}
