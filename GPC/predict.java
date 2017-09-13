package query3;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fline;
		List<String> words = new ArrayList<String>();
		Queue<String> query = new LinkedList<String>();
		Scanner sc = new Scanner(new File("C:\\Users\\Chiefan\\Documents\\query1.txt"));
		fline = sc.nextLine();
		while (!fline.equals("0")) {
			int word = Integer.parseInt(fline);
			while (word-- > 0) {
				String temp = sc.next();
				words.add(temp);
			}
			sc.nextLine();
			String check = sc.nextLine();
			while (!check.equals("###")) {
				query.add(check);
				check = sc.nextLine();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\query2.txt", true));
			while (!query.isEmpty()) {
				String q = query.poll();
				
				bw.write(query(words, q));
				if (!query.isEmpty()) {
					bw.newLine();
				}
				System.out.println(query(words, q));
			}
			fline = sc.nextLine();
			if (!fline.equals("0")) {
				bw.newLine();
			}
			bw.close();
			words.clear();
			query.clear();
			
			
		}
		sc.close();

	}
	public static String query(List<String> words, String q) {
		List<String> all = new ArrayList<String>();
		List<String> all1 = new ArrayList<String>();
		List<String> repeated = new ArrayList<String>();
		List<String> repeated1 = new ArrayList<String>();
		for (String s : words) { 
			if (s.startsWith(q)) {
				all.add(s);
			}
		}
		for (String s : all) { 
			if (!all1.contains(s)) {
				all1.add(s);
				
			}
			if (Collections.frequency(all, s) > 1) {
				repeated.add(Integer.toString(Collections.frequency(all1, s)) + " " + s);
				all1.remove(all1.indexOf(s));
			}
			
		}
		for (String s : repeated) { 
			if (!repeated1.contains(s)) {
				repeated1.add(s);
			}
		}
		Collections.sort(repeated1, Collections.reverseOrder());
		int i = 0;
		ArrayList<String> result = new ArrayList<String>();
		String fresult = "";
		for (String s : repeated1) {
			if (i < 3) {
				result.add(s.substring(2));
				i++;
			}
		}
		
		int t = 0;
		for (int ii = i; ii < 3; ii++) { 
			if (ii < all1.size() ) {
				if (!result.contains(all1.get(t))) {
					result.add(all1.get(t));
				}
				
			
			}
			t++;
		}
		if (result.isEmpty()) {
			fresult = q;
		}
		for (String s : result) { 
			fresult = fresult + " " + s;
		}
		return q + ": " + fresult.substring(1);
	}

}
