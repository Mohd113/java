package format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private static final String FILE = ("C:\\Users\\Chiefan\\Documents\\format2.txt");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fline;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\format1.txt"))) {
			fline = br.readLine();
			String temp = "";
			StringBuilder cline = new StringBuilder(br.readLine());
			cline.setCharAt(0, Character.toUpperCase(cline.charAt(0)));
			System.out.println(format(cline.toString()));
			int dot = 1;
			int first = 0;
			do { 
				if ((temp = br.readLine()) != null) {
					if (first == 0) { 
						String tmp = temp.substring(0,1);
						String rst = temp.substring(1);
						temp = tmp.toUpperCase() + rst;
						first = 1;
					}
					try (BufferedWriter bw = new BufferedWriter (new FileWriter(FILE, true))) {
					bw.write(format(temp));
					bw.newLine();
					}
					catch (IOException e1) { 
						e1.printStackTrace();
					}
					System.out.println(format(temp));
							
					}
					if (temp != null && temp.charAt(temp.length() -1 ) == '.') {
						dot = dot + 1;
						first = 0;
					}
				}
				while (dot <= Integer.parseInt(fline));
			}
		catch (IOException e) { 
		e.printStackTrace();
		}
	}
	public static String format(String text) {
		StringBuilder bld = new StringBuilder(text);
		for (int i = 0; i < bld.length(); i++) {
			char a = bld.charAt(i);
			switch(a) { 
				
			case 'i':
				
				if (i > 0) { 
					if (bld.charAt(i-1) == ' ' && bld.charAt(i+1) == ' ' || bld.charAt(i+1) == '\'') {
						bld.setCharAt(i, 'I');
					}
				}
				else { 
					if (bld.charAt(i+1) == ' ' || bld.charAt(i+1) == '\'') {
						bld.setCharAt(i, 'I');
					}
				}
				break;
			case '[': case '{': case '(':
				if (bld.charAt(i-1) != ' ' && i != 0) { 
					bld.insert(i-1, ' ');
				}
				else if (bld.charAt(i+1) == ' ') {
						bld.deleteCharAt(i+1);
					}
				
				break;
			case ']': case '}': case ')':
				if (bld.charAt(i-1) == ' ') { 
					bld.deleteCharAt(i-1);
					if (bld.charAt(i+1) != '!' && bld.charAt(i+1) != '?' && bld.charAt(i+1) != '.' && bld.charAt(i+1) != ' ') {
						bld.insert(i, ' ');
					}
				}
				break;
			case ' ':
				if (bld.charAt(i-1) == ' ' || bld.charAt(i+1) == ' ') { 
					bld.deleteCharAt(i);
				}
				break;
			case '.': case '!': case '?': case ',': case ';': case '\'': case '’':
				if (bld.charAt(i-1) == ' ') { 
					bld.deleteCharAt(i-1);
				}
				if (i < bld.length() - 1) {
					if (bld.charAt(i+1) != ' ' && bld.charAt(i) != '\'') { 
						bld.insert(i, ' ');
					}
				}
				break;
			default: 
				
				if (i >= 2 && bld.charAt(i-1) == ' ') { 
					if (bld.charAt(i-2) == '?' || bld.charAt(i-2) == '!' || bld.charAt(i-2) == '.') {
						bld.setCharAt(i, Character.toUpperCase(bld.charAt(i)));
					}
				}
				break;	
				
			}
		
		}
		return bld.toString();
	}
}
