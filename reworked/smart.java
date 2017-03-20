package smart;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int fline; 
		Scanner sc = new Scanner(new File("C:\\Users\\Chiefan\\Documents\\smart.txt"));
		fline = Integer.parseInt(sc.nextLine());
		while (fline-- > 0) {
			String data = sc.nextLine();
			System.out.println(calc(data));
		}
		sc.close();
		

	}
	public static String calc(String data) {
		Scanner sc1 = new Scanner(data);
		int left = 0;
		int right = 0;
		int pos = 0;
		String first = sc1.next();
		right = right - Integer.parseInt(first);
		
		while (sc1.hasNext()) {
			String tmp = sc1.next();
			
			if (tmp.equals("+")) {
				String tmp1 = sc1.next();
				if (tmp1.equals("?")) {
					if (left == 0) { 
						pos = -1;
					}
					else { 
						pos = 1;
					}
				}
				else { 
					if (left == 0) {
						
					
					right = right - Integer.parseInt(tmp1);
					}
					else {
						right = right + Integer.parseInt(tmp1);
					}
				}
				
			}
			else if (tmp.equals("–") || tmp.equals("-")) {
				String tmp1 = sc1.next();
				if (tmp1.equals("?")) {
					if (left == 0) {
					pos = 1;
					}
					else { 
						pos = -1;
					}
				}
				else {
					if (left == 0) {
					right = right + Integer.parseInt(tmp1);
					}
					else { 
						right = right - Integer.parseInt(tmp1);
					}
				}
			}
			else if (tmp.equals("=")) {
				String tmp1 = sc1.next();
				left = 1;
				if (tmp1.equals("?")) {
					pos = 1;
				}
				else { 
					right = right + Integer.parseInt(tmp1);
				}
				
			}

			
		}
		sc1.close();
		if (pos == -1) {
			return Integer.toString(right);
		}
		else if (pos == 1) { 
			right = right * -1;
			return Integer.toString(right);
		}
		else { 
			return "Error";
		}
	}

}
