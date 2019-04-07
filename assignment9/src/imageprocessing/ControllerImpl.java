package imageprocessing;

import java.io.IOException;
import java.util.Scanner;

public class ControllerImpl implements IController {
  public static void main(String[] args) throws IOException {
    String command = "";
    String filename = "";
    String imagename = "";

    IModel model = new ModelImpl();
    Scanner scan = new Scanner(System.in);
    while(!command.equals("exit")) {
      command = scan.next();
      if(command.equals("load")) {
        filename = scan.next();
        imagename = scan.next();
        model.load(filename, imagename);
        System.out.println("Loading "+imagename+"...");
      }
      else if(command.equals("dither")){ model.applyDither(imagename);
        System.out.println("Dithering "+imagename+"...");}
      else if(command.equals("blur")){ model.applyBlur(imagename);
        System.out.println("Applying blur to "+imagename+"...");}
      else if(command.equals("sepia")){ model.applySepia(imagename);
        System.out.println("Applying sepia transformation to "+imagename+"...");}
      else if(command.equals("greyscale")){ model.applyGreyscale(imagename);
      System.out.println("Applying greyscale transformation to "+imagename+"...");}
      else if(command.equals("save")){ imagename = scan.next();
        System.out.println("Saving "+imagename+" to "+imagename+".png");
      model.save(imagename);}
      else{System.out.println("Command not found");}
      //System.out.println("thank you for entering "+ command);
    }
  }
}
