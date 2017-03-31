import java.util.*;
import java.io.*;
public class candy {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("candy.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				String cline = sc.nextLine();
				String candies = sc.nextLine();
				System.out.println(check(cline, candies));
			}
		}
	}
	public static String check(String data, String candies) {
		try (Scanner sc1 = new Scanner(data)) {
			int candy = sc1.nextInt();
			int k = sc1.nextInt();
			int result = 0;
			Scanner sc2 = new Scanner(candies);
			Queue<Integer> all = new LinkedList<Integer>();
			while (candy-- > 0) {
				all.add(sc2.nextInt());
			}
			sc2.close();
			while (!all.isEmpty()) {
				int tmp = all.poll();
				tmp /= k;
				result += tmp;
			}
			return Integer.toString(result);
		}
	}

}
