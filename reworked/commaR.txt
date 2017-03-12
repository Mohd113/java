package csv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fline;
		String cline;
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\csv1.txt"))) {
			fline = br.readLine();
			for (int i = 1; i <= Integer.parseInt(fline); i++) {
				cline = br.readLine();
				int oc = 1;
				char[] temp = cline.toCharArray();
				int ii = 0;
				for (char a : temp) {
					if (a == '#' || a == '$' || a == '|' || a == '%') {
						temp[ii] = ',';
						oc++;	
					}
					
					ii++;
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\csv2.txt", true))) {
					bw.write(String.valueOf(temp) + "," + oc);
					bw.newLine();
				}
				catch (IOException e1) { 
					e1.printStackTrace();
				}
				System.out.println(String.valueOf(temp) + "," + oc);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
