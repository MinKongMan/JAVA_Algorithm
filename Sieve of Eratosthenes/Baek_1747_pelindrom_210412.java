import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1747_pelindrom_210412 {
	static int[] array = new int[2000002];
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i = 2; i<=2000001; i++) {
			array[i] = i;
		}
		for(int i = 2; i<=2000001; i++) {
			if(array[i]==0) continue;
			for(int j = i*2; j<=2000001; j+=i) {
				array[j] = 0;
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = N; i<=2000001; i++) {
			if(array[i]!=0) {
				
				if(find(array[i])) {
					System.out.println(array[i]);
					break;
				}
			}
		}
	}
	
	static boolean find (int a) {
		String k = a+"";
		for(int i = 0; i<k.length(); i++) {
			if(k.charAt(i)!=k.charAt(k.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

}
