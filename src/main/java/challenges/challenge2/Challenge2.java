package challenges.challenge2;

import models.FileHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private String[] splitItem(String item){
        return item.split(" ");
    }

    // As much as I love regex, might be best to work it later;
    private Pattern regexMaker(String range, String letter){
        String[] properrange = range.split("-");
        String regexpattern = letter + "{" + properrange[0] + "," + properrange[1] + "}";
        System.out.println(regexpattern);
        return Pattern.compile(regexpattern, Pattern.CASE_INSENSITIVE);
    }

    private int manualCount(String letter, String tocheck){
        int count = 0;
        for (String character:tocheck.split("")) {
            if (character.equals(letter)){
                count +=1;
            }
        }
        return count;
    }

    private Boolean compareCount(String range, int count){
        String[] properrange = range.split("-");
        if ((count >= Integer.parseInt(properrange[0])) && (count <= Integer.parseInt(properrange[1]))){
            return true;
        }
        return false;
    }

    private Boolean isTheSameLetter(String letter1, String letter2){
        return (letter1.equals(letter2)) ? true : false;
    }

    private Boolean manualCheck(String positions, String character, String tocheck){
        String[] properpositions = positions.split("-");
        String[] toproperlycheck = tocheck.split("");
        if (isTheSameLetter(toproperlycheck[Integer.parseInt(properpositions[0])-1], character)
                ^ isTheSameLetter(toproperlycheck[Integer.parseInt(properpositions[1])-1], character)){
            return true;
        }
        return false;
    }

    public void part1(Boolean isTestingExample){
        setFilePath(isTestingExample);
        String[] splititems;
        Pattern pattern;
        int result = 0;
        for (String item:fileHandler.readFile()) {
            splititems = splitItem(item);
            manualCount(splititems[1].split(":")[0], splititems[2]);
            System.out.println(manualCount(splititems[1].split(":")[0], splititems[2]));
            if (compareCount(splititems[0], manualCount(splititems[1].split(":")[0], splititems[2]))){
                result += 1;
            }
        }
        System.out.println("Result.: " + result);

    }

    public void part2(Boolean isTestingExample){
        setFilePath(isTestingExample);
        String[] splititems;
        int result = 0;
        for (String item:fileHandler.readFile()) {
            splititems = splitItem(item);
            if (manualCheck(splititems[0], splititems[1].split(":")[0], splititems[2])){
                result += 1;
            }
        }
        System.out.println("Result.: " + result);
    }
}
