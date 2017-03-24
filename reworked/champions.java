import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		try (Scanner sc = new Scanner(new File("C:\\Users\\Chiefan\\Documents\\champions.txt"))) {
			int fline;
			int count = 1;
			fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				String first = sc.nextLine();
				String second = sc.nextLine();
				System.out.println(count++ + ". " + check(first, second));
			}
			
		}
	}
	public static String check(String f, String s) {
		int team1 = 0;
		int team2 = 0;
		Scanner sc1 = new Scanner(f);
		team1 = sc1.nextInt();
		team2 = sc1.nextInt() * 2;
		sc1.close();
		Scanner sc2 = new Scanner(s);
		team2 = team2 + sc2.nextInt();
		team1 = team1 + (sc2.nextInt() * 2);
		sc2.close();
		if (team1 == team2) {
			return "Extra time is needed!";
		}
		else {	
			return (team1 > team2 ? "The first team wins!" : "The second team wins!");
		}
	}

}
