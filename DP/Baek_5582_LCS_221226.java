import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_5582_LCS_221226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a1 = br.readLine();
        String b1 = br.readLine();
        
        int[][] array;
        
        String temp1 = "";
        String temp2 = "";
        
        if(a1.length()<b1.length()) {
        	array = new int[a1.length()+1][b1.length()+1];
        	temp1 = b1;
        	temp2 = a1;
        }
        else {
        	array = new int[b1.length()+1][a1.length()+1];
        	temp1 = a1;
        	temp2 = b1;
        }
        
        for(int i = 0; i<temp2.length(); i++) {
        	for(int j = 0; j<temp1.length(); j++) {
        		if(temp2.charAt(i)==temp1.charAt(j)) {
        			if(array[i][j]==0) {
        				int count = 1;
        				while(i+count<temp2.length() && j+count<temp1.length()) {
        					if(temp2.charAt(i+count)==temp1.charAt(j+count)) {
        						
        					}
        					else break;
        					count++;
        				}
        				
        				for(int k = i; k<i+count; k++) {
        					array[k][j+k-i] = Math.max(count, array[k][j+k-i]);
        				}
        				
        			}
        			else continue;
        		}
        	}
        }
        
        int max = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<=temp2.length(); i++) {
        	for(int j = 0; j<temp1.length(); j++) {
//        		System.out.println(i+" "+j+" / "+array[i][j]);
        		max = Math.max(array[i][j], max);
        	}
        }
        System.out.println(max);
	}

}
