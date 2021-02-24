import java.util.Scanner;

public class Baek_14888_oPerator_210224 {
	static int N;
	static int[] array,op;
	static int max,min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = 0;
		min = Integer.MAX_VALUE;
		array = new int[N+1];
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
		}
		op = new int[4];
		for(int i = 0; i<4; i++) {
			op[i] = sc.nextInt();
		}
		find(array[1],1);
		System.out.println(max);
		System.out.println(min);
	}
	static void find(int a, int b) {
		if(b==N) {
			max = max>a?max:a;
			min = min<a?min:a;
			return;
		}
		for(int i = 0; i<4; i++) {
			if(op[i]>0){
				op[i]--;
				if(i == 0) {
					find(a+array[b+1],b+1);
				}
				else if(i==1) {
					find(a-array[b+1],b+1);
				}
				else if(i==2) {
					find(a*array[b+1],b+1);
				}
				else if(i==3) {
					find(a/array[b+1],b+1);
				}
				op[i]++;
			}
		}
	}

}
