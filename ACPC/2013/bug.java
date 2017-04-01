import java.util.*;
import java.io.*;

public class bug {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("bug.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				System.out.println(gen(sc.nextLine()));
			}
		}
	}
	public static String gen(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			int len = sc1.nextInt();
			int x = sc1.nextInt();
			int c = sc1.nextInt();
			int[] arr = new int[len];
			if (c == 1) {
				
				for (int i = 0; i < len - 1; i++) {
					arr[i] = i+1;
				}
				
				arr[len-1] = x > len ? x+1 : len+1;					
				
			}
			else if (c == 2) {
				for (int i = 0; i < len - 1; i++) {
					arr[i] = i+1;
				}
				
				arr[len-1] = x > len ? x : len;
				
			}
			
			String result = "";
			for (int d : arr)
				result += " " + Integer.toString(d);
				
			
			return result.substring(1);
		}
		
	}

}
