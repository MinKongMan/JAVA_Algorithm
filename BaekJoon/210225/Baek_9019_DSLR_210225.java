import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_9019_DSLR_210225 {
	static int[] array;
	static boolean[] marked;
	static String[] array2;
	static Queue<Integer> q_x = new LinkedList<Integer>();
	static int N,M,temp,x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[100001];
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			temp = Integer.parseInt(st.nextToken());
			marked = new boolean[10000];
			array2 = new String[10000];
            marked[M] = true;
			for(int k = 0; k<10000; k++) {
				array2[k] = "";
			}
			q_x.add(M);
			while(!q_x.isEmpty()) {
				x = q_x.poll();
				if(marked[temp]==true) {
					q_x.clear();
				}
				if(marked[temp]==false) {
					D(x);
					S(x);
					L(x);
					R(x);
				}
			}
			System.out.println(array2[temp]);
		}
	}
	
	static void D(int a) {
//		if(array2[temp].length()>0) {
//			return;
//		}
		int val = a*2;
		if(val>9999) {
			val = val%10000;
		}
		if(marked[val]==false) {
			q_x.add(val);
			marked[val] = true;
			array2[val] = array2[a]+"D";
		}
//		System.out.println(val+" D "+a+" "+array2[val]);
	}
	static void S(int a) {
//		if(array2[temp].length()>0) {
//			return;
//		}
		int val = 0;
		if(a<=0) {
			val = 9999;
		}
        else if(a>0){
            val = a-1;
        }
		if(marked[val]==false) {
			q_x.add(val);
			marked[val] = true;
			array2[val] = array2[a]+"S";
		}
//		System.out.println(val+" S "+a+" "+array2[val]);
	}
	static void L(int a) {
//		if(array2[temp].length()>0) {
//			return;
//		}
		int val = (a % 1000) * 10 + a/1000;
		if(marked[val]==false) {
			q_x.add(val);
			marked[val] = true;
			array2[val] = array2[a]+"L";
		}
//		System.out.println(val+" L "+a+" "+array2[val]);
		
	}
	static void R(int a) {
//		if(array2[temp].length()>0) {
//			return;
//		}
		int val = (a % 10) * 1000 + a/10;
		if(marked[val]==false) {
			q_x.add(val);
			marked[val] = true;
			array2[val] = array2[a]+"R";
		}
//		System.out.println(val+" R "+a+" "+array2[val]);
	}

}
