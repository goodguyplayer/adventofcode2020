package challenges.challenge3;

import interfaces.ChallengeBasics;
import models.FileHandler;

public class Challenge3 implements ChallengeBasics {
    String pathexample = "src/main/java/challenges/challenge3/example.txt";
    String pathchallenge = "src/main/java/challenges/challenge3/challenge.txt";
    FileHandler fileHandler;

    public Challenge3() {
    }

    private void setFilePath(Boolean isTestingExample){
        if (isTestingExample){
            this.fileHandler = new FileHandler(pathexample);
        } else {
            this.fileHandler = new FileHandler(pathchallenge);
        }
    }

    @Override
    public void part1(Boolean isTestingExample){
        setFilePath(isTestingExample);
    }

    @Override
    public void part2(Boolean isTestingExample){
        setFilePath(isTestingExample);
    }

    
}
