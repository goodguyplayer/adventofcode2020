package challenges.challenge2;

import models.FileHandler;

public class Challenge2 {
    String pathexample = "src/main/java/challenges/challenge2/example.txt";
    String pathchallenge = "src/main/java/challenges/challenge2/challenge.txt";
    FileHandler fileHandler;

    public Challenge2() {
    }

    private void setFilePath(Boolean isTestingExample){
        if (isTestingExample){
            this.fileHandler = new FileHandler(pathexample);
        } else {
            this.fileHandler = new FileHandler(pathchallenge);
        }
    }

    public void part1(Boolean isTestingExample){

    }

    public void part2(Boolean isTestingExample){

    }
}
