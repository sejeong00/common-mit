import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    String getSHA256(File file) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            int bufferSize = 8192;
            byte[] buffer = new byte[bufferSize];
            byte[] hashResult = null;
            long read = 0;
            long offset = file.length();
            int unitSize;

            while (read < offset) {
                unitSize = (int) ((((offset - read)) >= bufferSize) ? bufferSize : offset - read);
                fis.read(buffer, 0, unitSize);
                md.update(buffer, 0, unitSize);
                read += unitSize;
            }
            fis.close();

            hashResult = md.digest();

            for (int i = 0; i < hashResult.length; i++) {
                sb.append(Integer.toString((hashResult[i] & 0xff) + 0x100, 16).substring(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return sb.toString();
    }
    
}
