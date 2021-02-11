import java.util.Scanner;

public class Baek_1072_game_210211 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long M = sc.nextInt();
		long Z = (M*100/N);
		long percent = 0;
		long left = 1;
		long right = N;
		long mid = 0;
		if(N==M || (int)Z==99) {
			System.out.println(-1);
		}
		else {
			while(left<=right) {
				mid = (left+right)/2;
				percent = (M+mid)*100/(N+mid);
				if(percent>Z) {
					right = mid-1;
				}
				else if(percent<=Z) {
					left = mid+1;
				}
			}
			System.out.println(right+1);
		}
	}

}
