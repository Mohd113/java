package rotate2;

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
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\rotate1.txt"))) {
			fline = br.readLine();
			for (int i = 1; i <= Integer.parseInt(fline); i++) {
				cline = br.readLine();
				String[] all = cline.split("\\s+");
				int num = Integer.parseInt(all[0]);
				int rot = Integer.parseInt(all[1]);
				int r = 1;
				double result = num;
				while (r <= rot) {
					result = result / 10;
					r++;
				}
				String temp = Double.toString(result);
				String[] temp1 = temp.split("\\.");
				System.out.println(i + ". " + temp1[1] + temp1[0]);
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\rotate2.txt", true))) {
					bw.write(i + ". " + temp1[1] + temp1[0]);
					bw.newLine();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		catch (IOException e) { 
			e.printStackTrace();
		}

	}

}
