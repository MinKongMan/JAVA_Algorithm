import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_1541_lostBracket_210315 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String k = br.readLine();
		String[] p = new String[50];
		Arrays.fill(p, "");
		int i = 0;
		for(int l = 0; l<k.length(); l++) {
			if(k.charAt(l)=='-' || k.charAt(l)=='+') {
				i++;
			}
			p[i] +=k.charAt(l);
		}
		int[] array = new int[i+1];
		if(p[0].equals("")) {
			array[0] = 0;
			for(int x = 1; x<array.length; x++) {
				array[x] = Integer.parseInt(p[x]);
			}
		}
		else {
			for(int x = 0; x<array.length; x++) {
				array[x] = Integer.parseInt(p[x]);
			}
		}
		int temp = 0;
		boolean mark = false;
		for(int x = 0; x<array.length; x++) {
			if(!mark) {
				if(array[x]<0) {
					mark = true;
					temp += array[x];
				}
				else {
					temp += array[x];
				}
			}
			else {
				if(array[x]<0) {
					mark = true;
					temp += array[x];
				}
				else {
					temp -= array[x];
				}
			}
		}
		System.out.println(temp);
	}

}
