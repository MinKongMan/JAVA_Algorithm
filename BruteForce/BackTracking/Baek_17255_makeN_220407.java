import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Baek_17255_makeN_220407 {
	static HashSet<Integer> hash = new HashSet<Integer>();
	static HashSet<ArrayList<Integer>> hash_ar = new HashSet<>();
	static int count = 0, length = 0, temp=0;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = br.readLine();
		
		length = l.length();
		array = new int[length+1];
		temp = Integer.parseInt(l);
		for(int i = 0; i<l.length(); i++) {
			if(!hash.contains(l.charAt(i)-'0')) {
				hash.add(l.charAt(i)-'0');
			}
		}
		for(int val : hash) {
			array[1] = val;
			dfs(1,val);
		}
		System.out.println(count);
	}
	
	static void dfs(int a, int b) {
		if(a==length) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			if(temp==b)	{
				if(check(array,1)) {
					for(int i = 1; i<=a; i++) {
						ar.add(array[i]);
					}
					hash_ar.add(ar);
//					for(int i = 1; i<=a; i++) {
//						System.out.print(array[i]+" ");
//					}
//					System.out.println();
					count++;
				}
			}
			return;
		}
		
		for(int val : hash) {
			int temp_val1 = b*10+val;
			int temp_val2 = (int)Math.pow(10, a)*val+b;
			array[a+1] = temp_val1;
			dfs(a+1,temp_val1);
			array[a+1] = temp_val2; 
			dfs(a+1,temp_val2);
		}
	}
	
	static boolean check(int[] array, int a) {
		for(ArrayList<Integer> val : hash_ar) {
			boolean check = true;
			for(int i = 0; i<length; i++) {
//				System.out.println(i+" "+array[i+1]+" "+val.get(i));
				if(val.get(i)!=array[i+1]) {
					check = false;
					break;
				}
			}
			if(check) return false;
		}
		return true;
	}

}
