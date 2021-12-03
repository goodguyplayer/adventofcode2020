package challenges.challenge3;

import interfaces.ChallengeBasics;
import models.FileHandler;

import java.util.List;

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

    private String expandLine(String line){
        return line.concat(line);
    }

    private List<String> expandMap(List<String> map, int times){
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < map.size(); j++) {
                map.set(j, expandLine(map.get(j)));
            }
        }
//        printMap(map);

        return map;
    }

    private void printMap(List<String> map){
        for (String line: map) {
            System.out.println(line);
        }
    }

    private Boolean isPositionATree(String position){
        return (position.equals("#")) ? true : false;
    }

    // get proper line, split it, get "down" number"
    private String getPositionSymbol(List<String> map, int[] coordinates){
        return map.get(coordinates[0]).split("")[coordinates[1]];
    }

    private void calculateTheTrees(List<String> map, int right, int down){
        List<String> expandedmap = expandMap(map, 4);
        int[] position = {0,0}; //  "Down", "Right", starts at 0,0
        String symbol = "";
        int count = 0;
        for (int i = 1; i < map.size(); i++) {
            try {
                position[0] += down;
                position[1] += right;
                symbol = getPositionSymbol(expandedmap, position);
                if (isPositionATree(symbol)){
                    count += 1;
                }
            } catch (Exception e){

            }
        }
        System.out.println(count);
    }

    @Override
    public void part1(Boolean isTestingExample){
        setFilePath(isTestingExample);
        List<String> thedata = fileHandler.readFile();
        calculateTheTrees(thedata, 3, 1);
//        thedata = expandMap(thedata,6);
//        int[] position = {0,0}; //  "Down", "Right", starts at 0,0
//        String symbol = "";
//        int count = 0;
//        for (int i = 1; i < thedata.size(); i++) {
//            position[0] += 1;
//            position[1] += 3;
//            symbol = getPositionSymbol(thedata, position);
//            if (isPositionATree(symbol)){
//                count += 1;
//            }
//        }
//        System.out.println(count);
    }

    @Override
    public void part2(Boolean isTestingExample){
        setFilePath(isTestingExample);
        List<String> thedata = fileHandler.readFile();
        calculateTheTrees(thedata, 1, 1);
        calculateTheTrees(thedata, 3, 1);
        calculateTheTrees(thedata, 5, 1);
        calculateTheTrees(thedata, 7, 1);
        calculateTheTrees(thedata, 7, 2);
    }


}
