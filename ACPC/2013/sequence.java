import java.util.*;
import java.io.*;
public class sequence {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("sequence.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				System.out.println(check(sc.nextLine()));
			}
		}
	}
	public static String check(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			long l1 = sc1.nextLong();
			long f1 = sc1.nextLong();
			long i1 = sc1.nextLong();
			long l2 = sc1.nextLong();
			long f2 = sc1.nextLong();
			long i2 = sc1.nextLong();
			long result = 0;
			List<Long> seq1 = new ArrayList<Long>();
			for (long i = f1, x = 0; x < l1; i+=i1, x++) {
				seq1.add(i);
			}
			for (long i = f2, x = 0; x < l2; i+=i2, x++) {
				if (seq1.contains(i))
					result++;
			}
			return Long.toString(result);
			
		}
	}

}
