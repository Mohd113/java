import java.io.*;
import java.util.*;
public class arabic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("arabic.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				int num = Integer.parseInt(sc.nextLine());
				String words = sc.nextLine();
				System.out.println(fix(num, words));
			}
		}

	}
	public static String fix(int num, String words) {
		try (Scanner sc1 = new Scanner(words)) {
			List<String> all = new ArrayList<String>();
			String eng = "";
			String fixed = "";
			while (num-- > 0) {
				String tmp = sc1.next();
				all.add(tmp);
				if (!tmp.contains("#")) {
					eng = tmp;
				}
			}
			
			for (int i = all.indexOf(eng) + 1; i < all.size(); i++) {
				fixed += " " + all.get(i);
			}
			fixed += " " + eng;
			for (int i = 0; i < all.indexOf(eng); i++) {
				fixed += " " + all.get(i);
			}		
			
			return fixed.substring(1);
			
		}
				
	}

}
