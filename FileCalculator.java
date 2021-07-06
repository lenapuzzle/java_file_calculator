//import java.io.FileWriter;
//import java.util.Scanner;
//import java.io.File;
//import java.io.IOException;
//
//public class FileCalculator {
//
//public static final String PROBLEM_FILE = "problem.txt";
//public static final String MY_RESULTS = "results.txt";
//
//  public static void main(String[] args) throws IOException {
//    File problem = new File(PROBLEM_FILE);
//    Scanner scanner = new Scanner(problem);
//    String operation = scanner.useDelimiter("\\n").next();
//    System.out.println(operation);
//
//    String numString = "";
//    int sum = 0;
//    while(!numString.equals("=")) {
//      numString = scanner.useDelimiter("\\n").next();
//
//      if(numString.equals("=")) {
//        break;
//      }
//      int num = Integer.parseInt(numString);
//      sum = sum + num;
//      System.out.println(sum);
//    }
//
//    File fileToCreate = new File(MY_RESULTS);
//    FileWriter fileWriter = new FileWriter(fileToCreate, true);
//    fileWriter.write(String.valueOf(sum) + "\n");
//    fileWriter.close();
//
//    if(fileToCreate.exists()) {
//      System.out.println("Results file created.");
//      String allContent = new Scanner(fileToCreate).useDelimiter("\\z").next();
//      System.out.println(allContent);
//    }
//  }
//}

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;

public class FileCalculator {

  //part 1
//  private static final String PROBLEM_PATH = "problem.txt";
  private static final String PROBLEM_PATH = "problems.txt";
  private static final String RESULTS_PATH = "results.txt";

  public static void main(String[] args) throws IOException {
    File problemFile = new File(PROBLEM_PATH);
    File resultsFile = new File(RESULTS_PATH);
    FileWriter fileWriter = new FileWriter(resultsFile);
    Scanner scanner = new Scanner(problemFile);
    String allContent = scanner.useDelimiter("\\z").next();
    System.out.println(allContent);
  int result = 0;
  boolean addition = false;
  boolean multiplication = false;

    while (scanner.hasNextLine()) {
        String currentLine = scanner.nextLine();

        if (currentLine.equals("+")) {
        addition = true;
        multiplication = false;
        System.out.println("Looks like an addition problem");
        } else if (currentLine.equals("*")) {
        multiplication = true;
        addition = false;
        result = 1;
        System.out.println("Multiplication time!");
        } else if (currentLine.equals("=")) {
        System.out.println("The operation is over");
        fileWriter.write(result + "\n");
        result = 0;
        } else {

        int currentNum = Integer.parseInt(currentLine);
        if (addition) {
        result += currentNum;
        } else if (multiplication) {
        result *= currentNum;
        }
        System.out.println("current Result: " + result);
        }
        }
//    fileWriter.write(String.valueOf(result));
//    fileWriter.write(Integer.toString(result));

        fileWriter.close();
        }
        }