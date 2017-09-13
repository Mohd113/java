package delivery2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fline;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\delivery1.txt"))) {
			fline = br.readLine();
			for (int i = 1; i <= Integer.parseInt(fline); i++) { 
				String cline = br.readLine();
				List<Integer> all = new ArrayList<Integer>();
				for (int t = 1; t <= Integer.parseInt(cline); t++) {
					all.add(Integer.parseInt(br.readLine()));
				}
				int result = 0;
				for (Integer s : all) {
					result = result + (s * 2);
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\delivery2.txt", true))) {
					bw.write(i + ". " + result);
					bw.newLine();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(i + ". " + result);
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
