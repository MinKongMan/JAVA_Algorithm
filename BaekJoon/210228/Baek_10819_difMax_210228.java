import java.util.Scanner;

public class Baek_10819_difMax_210228 {
	static int[] array, array2;
	static boolean[] marked;
	static int N, max = 0, temp = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new int[N+1];
		marked = new boolean[N+1];
		array2 = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		make_dif(1);
		System.out.println(max);
	}
	
	static void make_dif(int a) {
		if(a==N+1) {
			temp = 0;
			for(int i = 1; i<N; i++) {
				temp += Math.abs(array2[i]-array2[i+1]);
			}
			max = max>temp?max:temp;
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(marked[i]==false) {
				marked[i] = true;
				array2[a] = array[i];
				make_dif(a+1);
				marked[i] = false;
			}
		}
		
	}

}
