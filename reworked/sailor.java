package sailor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final String FILE = "C:\\Users\\Chiefan\\Documents\\sailor2.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fline = null;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\sailor1.txt"))) { 
			fline = br.readLine();
			for (int i = 1; i <= Integer.parseInt(fline); i++) {
				String[] cline = br.readLine().split("\\s+");
				String pier = cline[0];
				String pos = cline[1];
				String steps = cline[2];
				List<String> moves = new ArrayList<String>();
				for (int t = 1; t <= Integer.parseInt(steps); t++) { 
				moves.add(br.readLine());
				
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) { 
					bw.write(i + ". " + check(pier, pos, steps, moves));
					bw.newLine();
				}
				System.out.println(i + ". " + check(pier, pos, steps, moves));
				
				
				
			}
		}
			
		catch (IOException e) { 
			e.printStackTrace();
		}

	}
	public static String check(String pier1, String pos1, String steps1, List<String> moves) {
		int pp = Integer.parseInt(pier1);
		int ps = Integer.parseInt(pos1);
		int stp = Integer.parseInt(steps1);
		int ps1 = ps;
		String right = "R";
		String left = "L";
		
		String failcheck = "";
		
		for (int ii = 0; ii < stp; ii++) { 
			String[] test = moves.get(ii).split("\\s+");
			if (right.equals(test[1]) && ps + Integer.parseInt(test[0]) <= pp) { 
				ps1 = ps + Integer.parseInt(test[0]);
				
				
			}
			else if (left.equals(test[1]) && ps - Integer.parseInt(test[0]) >= 1) { 
				ps1 = ps - Integer.parseInt(test[0]);
				
			}
			else { 
				failcheck = "Fail!";
				
			}
			
			
		}
		if (failcheck == "Fail!") { 
			return "Fail!";
		}
		else {
			return Integer.toString(ps1);
		}
	}

}
