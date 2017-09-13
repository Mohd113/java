import java.nio.file.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
		
	try (Stream<String> stream = Files.lines(Paths.get("csv1.txt"))) {
	    stream.skip(1)
   	          .map(x -> x = x.replaceAll("[#$%|]", ",") + ",")
	          .forEach(x -> System.out.printf("%s%d%n", x, x.length()-x.replaceAll(",", "").length()));
	}
    }
}
