package largest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fline;
		try (Scanner sc = new Scanner(new File("largest.in"))) {
			fline = sc.nextInt();
			while (fline-- > 0) {
			
				int size = sc.nextInt();
				ArrayNumber[] array = new ArrayNumber[size];
				for (int i = 0; i < size; i++) {
					array[i] = new ArrayNumber(sc.next());
				}
				
				Arrays.sort(array);
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("largest2.txt", true))) {
				for (int i = 0; i <size; i++) {
					System.out.print(array[i].str);
					bw.write(array[i].str);
					
				}
				System.out.println();
				bw.newLine();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
class ArrayNumber implements Comparable<ArrayNumber> {
	String str;
	ArrayNumber(String str) {
		this.str = str;
	}
	@Override
	public int compareTo(ArrayNumber obj) {
		Long num1 = Long.parseLong(this.str + (String) obj.str);
		Long num2 = Long.parseLong((String) obj.str + this.str);
		return (int) (num2 - num1);
		
	}
	
}
