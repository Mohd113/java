import java.util.*;
import java.io.*;

public class numbers {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("numbers.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			int count = 1;
			while (fline-- > 0) {
				System.out.println("Case " + count++ + ": " + check(sc.nextLine()));
			}
		}
		
	}
	public static String check(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			int x = sc1.nextInt();
			int y = 0;
			int n = sc1.nextInt();
			int b = sc1.nextInt();
			int m = sc1.nextInt();
			int d = 0;
			for (int i = 0; i < m; i++) {
				if (i == n) {
					if (x > y) {
						x += b;
					}
					else { 
						y += b;
					}
				}
				else { 
					if (x > y) {
						y += x;
					}
					else { 
						x += y;
					}
				}
			}
			int temp = x > y ? x : y;
			for (int i = 1; i < temp; i++) {
				if (x % i == 0 && y % i == 0) {
					d = i;
				}
			}
			return Integer.toString(d);
		}
	}

}
