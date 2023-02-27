import java.io.File;
import java.util.Arrays;

public class MitCommand {
    
    void list(String path){
        File directory = new File(path);
        Arrays.stream(directory.listFiles()).forEach(System.out::println);
    }
}
