import java.io.File;
import java.util.Arrays;

public class MitCommand {

    File directory;

    public MitCommand(String path) {
        this.directory = new File(path);
    }

    void list(){
        Arrays.stream(directory.listFiles()).forEach(f -> System.out.println(f.getName() + " " + f.length()/1000 + "KB"));
    }

    void hash(){
        Arrays.stream(directory.listFiles()).forEach(f -> System.out.println(getSHA256(f)));
    }

    String getSHA256(File file){
        return new String();
    }
    
}
