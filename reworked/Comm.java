import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

class Base {
	double x, y;
	public Base(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

public class Comm {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("comm.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			int count = 1;
			while (fline-- > 0) {
				int num = Integer.parseInt(sc.nextLine());
				String points = sc.nextLine();
				System.out.println(count++ + ". " + check(num, points));
			}
		}
	}
	public static String check(int num, String points) { 
		List<Base> all = new ArrayList<Base>();
		Scanner sc1 = new Scanner(points);
		while (num-- > 0) {
			double x = sc1.nextDouble();
			double y = sc1.nextDouble();
			all.add(new Base(x, y));
		}
		sc1.close();
		double dist = 0;
		for (Base b : all) {
			double d = 0;
			for (int i = 0; i < all.size(); i++) {
				d += Math.sqrt(Math.pow(b.x - all.get(i).x, 2) + Math.pow(b.y - all.get(i).y, 2));
				
			}
			if (dist == 0) {
				dist = d;
			}
			else if (d < dist) {
				dist = d;
			}
		}
		DecimalFormat round = new DecimalFormat("#######0.00");
		return round.format(dist);
		
	}

}
