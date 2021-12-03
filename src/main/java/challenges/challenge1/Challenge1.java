package challenges.challenge1;

import interfaces.ChallengeBasics;
import models.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class Challenge1 implements ChallengeBasics {
    String pathexample = "src/main/java/challenges/challenge1/example.txt";
    String pathchallenge = "src/main/java/challenges/challenge1/challenge.txt";
    FileHandler fileHandler;

    public Challenge1() {
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
        List<String> thedata = this.fileHandler.readFile();
        List<Integer> totest = new ArrayList<>();
        for (String item: thedata) {
            totest.add(Integer.parseInt(item));
        }
        for (Integer index1: totest) {
            for (Integer index2: totest) {
                if (index1+index2 == 2020){
                    System.out.println("Items found.");
                    System.out.println(index1 + " + " + index2 + "= 2020");
                    System.out.println(index1 + " * " + index2 + "= " + (index1*index2));
                    break;
                }
            }
        }
    }

    @Override
    public void part2(Boolean isTestingExample){
        setFilePath(isTestingExample);
        List<String> thedata = this.fileHandler.readFile();
        List<Integer> totest = new ArrayList<>();
        for (String item: thedata) {
            totest.add(Integer.parseInt(item));
        }
        for (Integer index1: totest) {
            for (Integer index2: totest) {
                for (Integer index3: totest) {
                    if (index1+index2+index3 == 2020){
                        System.out.println("Items found.");
                        System.out.println(index1 + " + " + index2 + " + " + index3 + "= 2020");
                        System.out.println(index1 + " * " + index2 + " * " + index3 + "= " + (index1*index2*index3));
                        break;
                    }
                }
            }
        }

    }




}
