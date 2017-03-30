import java.util.*;
import java.io.*;

public class tawla {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("tawla.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			int count = 1;
			while (fline-- > 0) {
				System.out.println("Case " + count++ + ": " + check(sc.nextLine()));
			}
		}
	}
	public static String check(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			int f = sc1.nextInt();
			int s = sc1.nextInt();
			String first = "";
			String second = "";
			switch(f) {
			case 1: 
				first = "Yakk";
				break;
			case 2:
				first = "Doh";
				break;
			case 3:
				first = "Seh";
				break;
			case 4:
				first = "Ghar";
				break;
			case 5:
				first = "Bang";
				break;
			case 6:
				first = "Sheesh";
				break;
			}
			switch(s) {
			case 1: 
				second = "Yakk";
				break;
			case 2:
				second = "Doh";
				break;
			case 3:
				second = "Seh";
				break;
			case 4:
				second = "Ghar";
				break;
			case 5:
				second = "Bang";
				break;
			case 6:
				second = "Sheesh";
				break;
			}
			if (f > s) {
				return first + " " + second;
			}
			else {
				return second + " " + first;
			}
		}
	}

}
