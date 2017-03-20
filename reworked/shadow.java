package shadow;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int fline;
		Scanner sc = new Scanner(new File("C:\\Users\\Chiefan\\Documents\\shadow.txt"));
		fline = Integer.parseInt(sc.nextLine());
		while (fline-- > 0) {
			String all = sc.nextLine();
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\shadow1.txt", true));
			bw.write(shadow(all));
			if (fline > 0) {
				bw.newLine();
			}
			bw.close();
			System.out.println(shadow(all));
		}
		sc.close();

	}
	public static String shadow(String data) { 
		Scanner sc1 = new Scanner(data);
		int num = sc1.nextInt();
		Queue<String> temp = new LinkedList<String>();
		while (num-- > 0) { 
			String tmp = sc1.next();
			temp.add(tmp);
		}
		String result = "b";
		while (!temp.isEmpty()) {
			String s = temp.poll();
			if (s.length() > 3) {
			result = result + s.substring(0,1);
			String l = s.substring(s.length()-1, s.length());
			char[] t = s.substring(1,s.length()-1).toCharArray();
			List<String> rev = new ArrayList<String>();
			for (char k : t) { 
				rev.add(String.valueOf(k));
			}
			Collections.reverse(rev);
			for (String ss : rev) { 
				result = result + ss;
			}
			result = result + l + " ";
			}
			else { 
				result = result + s + " ";
			}
		}
		sc1.close();
		return result.substring(1, result.length()-1);
		
	}

}
