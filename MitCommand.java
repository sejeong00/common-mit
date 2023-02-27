import java.io.File;
import java.util.Arrays;

public class MitCommand {

    File directory;

    public MitCommand(String path) {
        this.directory = new File(path);
    }

    void list(String path){
        Arrays.stream(directory.listFiles()).forEach(System.out::println);
    }
    
}
