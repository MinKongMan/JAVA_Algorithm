import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baek_1931_meetingRoom_210315 {
	static int N;
	static int max = 0,count = 0;
	static int[] start,end;
	static int[][] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new int[N+1][2];
		for(int i = 1; i<=N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			array[i][0] = a;
			array[i][1] = b;
		}
		Arrays.sort(array, new Comparator<int[] >() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o2[1]==o1[1]) {
					return o1[0]-o2[0];
				}
				else {
					return o1[1]-o2[1];
				}
			}
		});
		int temp = 0;
		for(int i =1; i<=N; i++) {
			if(array[i][0]>=temp) {
				count++;
				temp = array[i][1];
			}
		}
		System.out.println(count);
	}
}
