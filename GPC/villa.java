package villa;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("C:\\Users\\Chiefan\\Documents\\villa.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			List<Villa> old = new ArrayList<Villa>();
			while (fline-- > 0) {
				String[] villa = sc.nextLine().split("\\s+");
				old.add(new Villa(Double.parseDouble(villa[0]), Double.parseDouble(villa[1]), villa[2]));
			}
			String nvilla;
			while (!(nvilla = sc.nextLine()).equals("-1")) {
				System.out.println(check(nvilla, old));
			}
		}
	}
	public static String check(String n, List<Villa> old) {
		String[] tmp = n.split("\\s+");
		Villa nvilla = new Villa(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]), "c");
		double dist = 0;
		String clr = "";
		for (Villa v : old) {
			
			double d = Math.sqrt(Math.pow(nvilla.x - v.x, 2) + Math.pow(nvilla.y - v.y, 2));
			if (dist == 0) {
				dist = d;
				clr = v.c;
			}
			else if (d < dist) { 
				
				dist = d;
				clr = v.c;
			}
		}
		
		nvilla.c = clr;
		return nvilla.c;	
	}
}

class Villa {
	double x, y;
	String c;
	public Villa(double x, double y, String c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
