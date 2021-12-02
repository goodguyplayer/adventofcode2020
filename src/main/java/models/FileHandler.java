package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    File file;

    public FileHandler(String path) {
        this.file = new File(path);
    }

    public List<String> readFile(){
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }
        myReader.close();
        return data;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
