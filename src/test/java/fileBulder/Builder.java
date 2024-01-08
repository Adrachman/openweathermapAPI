package fileBulder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Builder {
    public static void getFile(){
        try {
            File file = new File("metcast.txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void putFile(String s, String a){
        try {
            FileWriter writer = new FileWriter("metcast.txt");
            writer.write(s);
            writer.write(a);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
