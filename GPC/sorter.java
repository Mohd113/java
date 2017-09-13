package sorter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int fline;
		String word;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\sorter1.txt"))) {
			fline = Integer.parseInt(br.readLine());
			for (int i = 1; i <= fline; i++) {
				word = br.readLine();
				System.out.println(rotate(word, word.length()));
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\sorter2.txt", true))) {
					bw.write(rotate(word, word.length()));
					bw.newLine();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static String rotate(String s, int n) {
		List<String> list = new ArrayList<String>();
		for (int r = 0; r < n; r++) {
			int t = r % n;
			String rotated = s.substring(t) + s.substring(0, t);
			list.add(rotated);
		}
		Collections.sort(list);
		String pos = Integer.toString(list.indexOf(s));
		return pos;
	}

}
