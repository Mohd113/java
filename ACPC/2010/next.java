import java.util.*;
import java.io.*;
public class next {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("next.txt"))) {
			
			while (sc.hasNextLine()) {
				String cline = sc.nextLine();
				if (!cline.equals("0 0 0")) {
					System.out.println(check(cline));
				}
			}
		}
	}
	public static String check(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			int fst = sc1.nextInt();
			int snd = sc1.nextInt();
			int trd = sc1.nextInt();
			int val = 0;
			String seq = "";
			if (trd - snd == snd - fst) {
				val = trd - snd;
				seq = "AP";
			}
			else if (trd / snd == snd / fst) {
				val = trd / snd;
				seq = "GP";
			}
			int next = seq.equals("AP") ? trd + val : trd * val;
			return seq + " " + Integer.toString(next);
		}
	}

}
