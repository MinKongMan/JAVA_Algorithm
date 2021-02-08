import java.util.Arrays;
import java.util.Scanner;

public class Baek_2512_yesan_210208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N+1];
		int sum = 0;
		for(int i = 1; i<=N; i++) {
			array[i] = sc.nextInt();
			sum += array[i];
		}
		int M = sc.nextInt();
		Arrays.sort(array);
		if(sum<=M) {
			System.out.println("ㅋ");
			System.out.println(array[N]);
		}
		else {
		int left = 1;
		int right = N;
		int mid = 0;
		int temp = 0;
		while(left<=right) { // 여기서는 가장 적절한 인덱스만 찾아줌
			mid = (left+right)/2;
			temp = M;
			for(int i= 1; i<=N; i++) {
				if(array[i]<array[mid]) {
					temp -= array[i];
				}
				else if(array[i]>=array[mid]) {
					temp -= array[mid];
				}
			}
			if(temp<0) {
				right = mid-1;
			}
			else if(temp>=0) {
				left = mid+1;
			}
			else if(temp==0){
				System.out.println(array[right]);
				break;
			}
		}
		if(right == N) {
			System.out.println(array[right]);
		}
		else {
			int x = array[right];
			int y = array[right+1];
			while(x<=y) {
				mid = (x+y)/2;
				temp = M;
				for(int i = 1; i<=N; i++) {
					if(mid>=array[i]) {
						temp -= array[i];
					}
					else {
						temp -= mid;
					}
				}
				if(temp>=0) {
					x = mid+1;
				}
				else if(temp<0) {
					y = mid-1;
				}
			}
			System.out.println(y);
		}
		}
	}
}


//int value = array[right];
//while(true) {
//	temp = M;
//	value++;
//	for(int i = 1; i<=N; i++) {
//		if(value>array[i]) {
//			temp -= array[i];
//		}
//		else {
//			temp -= value;
//		}
//	}
//	if(temp<0) {
//		break;
//	}
//}
