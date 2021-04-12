import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12100_2048Easy_210412 {
	static int[][] array,array_cpy;
	static int N;
	static int temp = 0, max = 0;
	static boolean[] marked;
	static int[] array2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		array_cpy = new int[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j<=N; j++) {
				array_cpy[i][j] = Integer.parseInt(st.nextToken());
				array[i][j] = array_cpy[i][j];
			}
		}
		marked = new boolean[6];
		array2 = new int[6];
		
		find(1);
		System.out.println(max);
	}
	static void find(int a) {
		if(a==6) {
			temp = 0;
			for(int i = 1; i<=5; i++) {
				if(array2[i]==1) func1();
				else if(array2[i]==2) func2();
				else if(array2[i]==3) func3();
				else if(array2[i]==4) func4();
			}
			for(int i= 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					temp = temp>array[i][j]?temp:array[i][j];
					array[i][j] = array_cpy[i][j];
				}
			}
			max = max>temp?max:temp;
			return;
		}
		for(int i = 1; i<=4; i++) {
			if(!marked[a]) {
				marked[a] = true;
				array2[a] = i;
				find(a+1);
				marked[a] = false;
			}
		}
	}
	
	static void func1() {
		for(int i = 1; i<=N; i++) {
			int j = 2;
			while(j<=N) {
				if(array[j][i]==0) {
					j++;
					continue;
				}
				else if(j>=2 && array[j][i]!=0 && array[j-1][i]==0){
					array[j-1][i] = array[j][i];
					array[j][i] = 0;
					j = j-1;
				}
				else if(array[j][i]!=0 && array[j][i]!=0) {
					j++;
				}
			}
			for(j = 1; j<N; j++) {
				if(array[j][i]==array[j+1][i]) {
					array[j][i] = 2*array[j][i];
					array[j+1][i] = 0;
					j = j+1;
				}
			}
			j = 2;
			while(j<=N) {
				if(array[j][i]==0) {
					j++;
					continue;
				}
				else if(array[j][i]!=0 && array[j-1][i]==0){
					array[j-1][i] = array[j][i];
					array[j][i] = 0;
					j = j-1;
				}
				else if(array[j][i]!=0 && array[j][i]!=0) {
					j++;
				}
			}
		}
	}
	static void func2() {
		for(int i = 1; i<=N; i++) {
			int j = N-1;
			while(j>=1) {
				if(array[i][j]==0) {
					j--;
					continue;
				}
				else if(j<=N-1 && array[i][j]!=0 && array[i][j+1]==0){
					array[i][j+1] = array[i][j];
					array[i][j] = 0;
					j = j+1;
				}
				else if(array[i][j]!=0 && array[i][j]!=0) {
					j--;
				}
			}
			for(j = N; j>1; j--) {
				if(array[i][j]==array[i][j-1]) {
					array[i][j] = 2*array[i][j];
					array[i][j-1] = 0;
					j = j-1;
				}
			}
			j = N-1;
			while(j>=1) {
				if(array[i][j]==0) {
					j--;
					continue;
				}
				else if(array[i][j]!=0 && array[i][j+1]==0){
					array[i][j+1] = array[i][j];
					array[i][j] = 0;
					j = j+1;
				}
				else if(array[i][j]!=0 && array[i][j]!=0) {
					j--;
				}
			}
		}
	}
	static void func3() {
		for(int i = 1; i<=N; i++) {
			int j = N-1;
			while(j>=1) {
				if(array[j][i]==0) {
					j--;
					continue;
				}
				else if(j <= N-1 && array[j][i]!=0 && array[j+1][i]==0){
					array[j+1][i] = array[j][i];
					array[j][i] = 0;
					j = j+1;
				}
				else if(array[j][i]!=0 && array[j][i]!=0) {
					j--;
				}
			}
			for(j = N; j>1; j--) {
				if(array[j][i]==array[j-1][i]) {
					array[j][i] = 2*array[j][i];
					array[j-1][i] = 0;
					j = j-1;
				}
			}
			j = N-1;
			while(j>=1) {
				if(array[j][i]==0) {
					j--;
					continue;
				}
				else if(array[j][i]!=0 && array[j+1][i]==0){
					array[j+1][i] = array[j][i];
					array[j][i] = 0;
					j = j+1;
				}
				else if(array[j][i]!=0 && array[j][i]!=0) {
					j--;
				}
			}
		}
	}
	static void func4() {
		for(int i = 1; i<=N; i++) {
			int j = 2;
			while(j<=N) {
				if(array[i][j]==0) {
					j++;
					continue;
				}
				else if(j>=2 && array[i][j]!=0 && array[i][j-1]==0){
					array[i][j-1] = array[i][j];
					array[i][j] = 0;
					j = j-1;
				}
				else if(array[i][j]!=0 && array[i][j]!=0) {
					j++;
				}
			}
			for(j = 1; j<N; j++) {
				if(array[i][j]==array[i][j+1]) {
					array[i][j] = 2*array[i][j];
					array[i][j+1] = 0;
					j = j+1;
				}
			}
			j = 2;
			while(j<=N) {
				if(array[i][j]==0) {
					j++;
					continue;
				}
				else if(array[i][j]!=0 && array[i][j-1]==0){
					array[i][j-1] = array[i][j];
					array[i][j] = 0;
					j = j-1;
				}
				else if(array[i][j]!=0 && array[i][j]!=0) {
					j++;
				}
			}
		}
	}
}
