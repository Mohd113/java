import java.io.*;
import java.util.*;

public class balloons {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("balloons.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				String cline = sc.nextLine();
				String colors = sc.nextLine();
				System.out.println(check(cline, colors));
			}
		}

	}
	public static String check(String b, String c) {
		try (Scanner sc1 = new Scanner(b)) {
			int num = sc1.nextInt();
			int fnot = sc1.nextInt();
			int lnot = sc1.nextInt();
			Scanner sc2 = new Scanner(c);
			List<Integer> all = new ArrayList<Integer>();
			while (num-- > 0) {
				all.add(sc2.nextInt());
			}
			sc2.close();
			String result = "";
			if (all.get(0) == fnot && all.get(all.size()-1) == lnot) 
				result = "BOTH";
			else if (all.get(0) == fnot && all.get(all.size()-1) != lnot) 
				result = "EASY";
			else if (all.get(0) != fnot && all.get(all.size()-1) == lnot)
				result = "HARD";
			else
				result = "OKAY";
				
			return result;
			
		}
	}

}
