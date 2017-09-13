package land2;

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
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\land1.txt"))) { 
			fline = br.readLine();
			for (int i = 1; i <= Integer.parseInt(fline); i++) {
				String cline = br.readLine();
				List<String> all = new ArrayList<String>();
				for (int t = 1; t <= Integer.parseInt(cline); t++) {
					all.add(br.readLine());
					
				}
				int cm = 0;
				int ar = 0;
				int price = 0;
				for (String s : all) { 
					String[] land = s.split("\\s+");
					int ar2 = Integer.parseInt(land[0]);
					int p2 = Integer.parseInt(land[1]);
					int cm2 = p2 / ar2;
					if (cm == 0) { 
						cm = cm2;
						price = p2;
						ar = ar2;
					}
					else if (cm2 < cm) { 
						cm = cm2;
						price = p2;
						ar = ar2;
					}
					else if (cm2 == cm) { 
						if (p2 < price) { 
							cm = cm2;
							price = p2;
							ar = ar2;
						}
					}
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\land2.txt", true))) {
					bw.write(i + ". " + ar + " " + price);
					bw.newLine();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(i + ". " + ar + " " + price);
				
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
