import java.util.Arrays;
import java.util.Scanner;

public class Baek_1759_makePassword_210224 {
	static String[] array;
	static String K="";
	static int N,M,count = 0, count2 = 0;
	static boolean[] marked;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		array = new String[M];
		for(int i=0; i<M; i++) {
			array[i] = sc.next();
		}
		marked = new boolean[M];
		Arrays.sort(array);
		find(0,0);
		System.out.println(sb);
		
	}
	static void find(int a, int b) {
		if(b==N) {
			for(int i = 0; i<M; i++) {
				if(marked[i]==true) {
					K = K+array[i];
					if(array[i].equals("a") || array[i].equals("e") || array[i].equals("i") || array[i].equals("o") || array[i].equals("u")) {
						count++;
					}
					else {
						count2++;
					}
				}
			}
			if(count>=1 && count2>=2) {
				sb.append(K+"\n");
			}
			K = "";
			count2 = 0;
			count = 0;
		}
		for(int i = a; i<M; i++) {
			if(marked[i]==false) {
				marked[i] = true;
				find(i+1,b+1);
				marked[i] = false;
			}
		}
	}

}
