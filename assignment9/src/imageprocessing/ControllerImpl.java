package imageprocessing;

import java.util.Scanner;

public class ControllerImpl implements IController {
  public static void main(String[] args){
    int num1, num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", num1 + num2);
  }
}
