import java.io.*;
import java.util.*;
public class robot {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(new File("robot.txt"))) {
			int fline = Integer.parseInt(sc.nextLine());
			while (fline-- > 0) {
				char[] cline = sc.nextLine().toCharArray();
				int x = 0, y = 0, min = 0;
				for (char c : cline) {
					if (c == 'R')
						x++;
					else if(c == 'L')
						x--;
					else if(c == 'U')
						y++;
					else if(c == 'D')
						y--;
					else
						min++;
				}
				System.out.println(Integer.toString(x-min) + " " +  Integer.toString(y-min) + " " + Integer.toString(x+min) + " " + Integer.toString(y+min));
				
			}
		}
	}
}
