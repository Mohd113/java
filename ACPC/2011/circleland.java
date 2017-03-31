import java.io.*;
import java.util.*;

public class circleland {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("circleland.txt"))) {
			long fline = Long.parseLong(sc.nextLine());
			while (fline-- > 0) {
				String cline = sc.nextLine();
				System.out.println(check(cline));
			}
		}
	}
	public static String check(String data) {
		try (Scanner sc1 = new Scanner(data)) {
			long num = sc1.nextLong();
			long result = 0;
			List<Long> all = new ArrayList<Long>();
			while (num-- > 0) {
				all.add(sc1.nextLong());
			}
			
			long tmp = all.get(0);
			long tmp1 = all.get(all.size()-1);
			long fnl = tmp > tmp1 ? tmp : tmp1;
			all.remove(all.indexOf(fnl));
			for (Long l : all) {
				result += l;
			}
			return Long.toString(result);
			
				
		}
		
	}

}
