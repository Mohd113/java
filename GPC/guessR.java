package prob2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fline; 
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\prob1.txt"))) {
			fline = br.readLine();
			for (int i = 1; i <= Integer.parseInt(fline); i++) {
				String[] all = br.readLine().split("\\s+");
				double x = Double.parseDouble(all[0]);
				double y = Double.parseDouble(all[1]);
				long t = Long.parseLong(all[2]);
				double z = x-y;
				double ch = Math.pow(10, z);
				double prob = ((t / ch) * 100);
				DecimalFormat round = new DecimalFormat("######0.00");
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\prob2.txt", true))) {
				if (t == 0) {
					bw.write(i + ". " + "0.00%");
					System.out.println(i + ". " + "0.00%");
					
				}
				else if (x == y && t != 0) { 
					bw.write(i + ". " + "100.00%");
					System.out.println(i + ". " + "100.00%");
				}
				else if (prob > 100) {
					bw.write(i + ". " + "100.00%");
					System.out.println(i + ". " + "100.00%");
				}
				else { 
					bw.write(i + ". " + round.format(prob) + "%");
					System.out.println(i + ". "+ round.format(prob) + "%");
				}
				bw.newLine();
				}
			}
		}
		catch (IOException e) { 
			e.printStackTrace();
		}

	}

}
