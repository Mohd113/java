import java.util.*;
import java.io.*;

public class between {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("between.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				String first = sc.nextLine();
				String second = sc.nextLine();
				System.out.println(check(first, second));
			}
		}
	}
	public static String check(String first, String second) {
		List<Integer> all = new ArrayList<Integer>();
		List<Integer> all1 = new ArrayList<Integer>();
		try (Scanner sc1 = new Scanner(first)) {
			int num = sc1.nextInt();
			
			while (num-- > 0) {
				all.add(sc1.nextInt());
			}
		}
		try (Scanner sc2 = new Scanner(second)) {
			int num = sc2.nextInt();
			while (num-- > 0) {
				all1.add(sc2.nextInt());
			}
			
		}
		int finaldist = 0;
		for (int j = 0; j < all.size(); j++) {
			int dist = 0;
			for (int i = 0; i < all1.size(); i++) {
				int dist1 = Math.abs(all.get(j) - all1.get(i));
				if (i == 0) {
					dist = dist1;
				}
				else if (dist1 < dist) {
					dist = dist1;
				}
			}
			if (j == 0) {
				finaldist = dist;
			}
			else if (dist < finaldist) {
				finaldist = dist;
			}
		}
		return Integer.toString(finaldist);
	}

}
