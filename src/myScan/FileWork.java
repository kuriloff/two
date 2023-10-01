package myScan;

import java.io.*;
import java.nio.file.Files;

public class FileWork {
    public void writeFile(String filename, String content){
        try(FileWriter writer = new FileWriter("res.csv",false)){
            writer.write(content);
            writer.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
