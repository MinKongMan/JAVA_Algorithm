import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baek_2331_suyeol_210217 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		int[] array = new int[50000];
		Scanner sc = new Scanner(System.in);
		array[1] = sc.nextInt();
		int N = sc.nextInt();
		int count = 1;
		int sum = 0;
		int temp = 0;
		int check = 0;
		while(true) {
			sum = 0;
			temp = array[count];
			while(temp!=0) {
				sum += (int) Math.pow(temp%10, N);
				temp /= 10;
			}
			array[count+1] = sum;
			if(!set.contains(array[count+1])) {
				set.add(array[count+1]);
				count++;
			}
			else {
				while(true) {
					if(array[check]==sum) {
						break;
					}
					else {
						check++;
					}
				}
				break;
			}
		}
		System.out.println(check);
	}

}
