import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Baek_1946_newB_210211 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=TC; i++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N+1];
			for(int j = 1; j<=N; j++) {
				String[] a;
				a = br.readLine().split(" ");
				array[Integer.parseInt(a[0])] = Integer.parseInt(a[1]);
			}
			int min = 100001;
			for(int j = 1; j<=N; j++) {
				if(array[j]<min) {
					count++;
				}
				min = min<array[j]?min:array[j];
			}
//			for(int j = 1; j<=N; j++) {
//				for(int k = 1; k<=j; k++) {
//					if(array[j]>array[k]) {
//						count++;
//						break;
//					}
//				}
//			}
//			count = N-count;
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}

}
//int Num1 = 0;
//int Num2 = 0;
//int temp = 1;
//int[][] array = new int[N+1][3];
//int[][] array2 = new int[N+1][3];
//for(int j = 1; j<=N; j++) {
//	for(int k = 1; k<=2; k++) {
//		array[j][k] = sc.nextInt();
//		if(array[j][1]==1) {
//			Num1 = array[j][2];
//		}
//		if(array[j][2]==1) {
//			Num2 = array[j][1];
//		}
//	}
//}
//
//for(int j = 1; j<=N; j++) {
//	if(array[j][2]<Num1||array[j][1]<Num2) {
//		array2[temp][1] = array[j][1];
//		array2[temp][2] = array[j][2];
//		temp++;
//	}
//}
//for(int j = 1; j<array2.length; j++) {
//	for(int k = 1; k<array2.length; k++) {
//		if(array2[j][1]>array2[k][1] && array2[j][2]>array2[k][2]) {
//			count++;
//			break;
//		}
//	}
//}
//System.out.println(temp);
//count = temp-count+1;
//System.out.println(count);



//if(array[j][1]==1||array[j][2]==1) {
//	break;
//}
//if(array[j][1]==N||array[j][2]==N) {
//	count++;
//	break;
//}
//if(array[j][1]>array[k][1] && array[j][2]>array[k][2]) {
//	count++;
//	break;
//}