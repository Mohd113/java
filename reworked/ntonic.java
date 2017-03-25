package ntonic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cline;
		List<Integer> test = new ArrayList<Integer>();
		String a = "";
		String[] sp = null;
		Queue<String> all = new LinkedList<String>();
		String result;
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chiefan\\Documents\\ntonic1.txt"))) {
			while ((cline = br.readLine()) != null) {
				if (!cline.startsWith("0")) {
					a = a + " " + cline;
				}
			}
			
			sp = a.split("\\s+");
			for (int i = 1; i < sp.length; i++) {
				all.add(sp[i]);
			}
			
			while (!all.isEmpty()) {
				int num = Integer.parseInt(all.poll());
				for (int t = 0; t < num; t++) {
					test.add(Integer.parseInt(all.poll()));
				}
				result = check(test);
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Chiefan\\Documents\\ntonic2.txt", true))) {
					bw.write(result);
					bw.newLine();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(result);
				test.clear();
			
			}		
		}
	
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int seq = 0;
	
	public static String check(List<Integer> tt) { 
		int[] ar = new int[tt.size()];
		int i = 0;
		for (Integer a : tt) {
			ar[i++] = a.intValue();
			
		}
		int change = 0;
		int dir = 0;
		
		for (int ii = 0; ii < ar.length - 1; ii++) {
			if (ar[ii] < ar[ii+1]) {
				if (dir == 0) {
					dir = 1;
				}
				else if (dir == -1) {
					change ++;
					dir = 1;
				}
			}
			else if(ar[ii] > ar[ii+1]) {
				if (dir == 0) {
					dir = -1;
				}
				else if (dir == 1) {
					change ++;
					dir = -1;
				}
			}
		}
		if (change == 0) {
			seq ++;
			return  Integer.toString(seq) + " mono";
			
		}
		else if (change == 1) {
			seq ++;
			return Integer.toString(seq) + " bi";
		}
		else {
			seq ++;
			return Integer.toString(seq) + " poly";
		}
	}

}
