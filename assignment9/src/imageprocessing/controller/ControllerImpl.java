package imageprocessing.controller;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import imageprocessing.model.IModel;

public class ControllerImpl implements IController {
  final Readable in;
//  final Appendable out;
  IModel model;
 // IView view;

  public ControllerImpl(IModel model, Readable in) {
    this.in = in;
//    this.out = out;
    this.model = model;
  }

  //TODO Change to switch statement
  public void go() throws IOException {
    Objects.requireNonNull(model);
    String command = "";
    String filename = "";
    String imagename = "";

    Scanner scan = new Scanner(this.in);
    while(scan.hasNext()) {
      command = scan.next();
      if(command.equals("load")) {
        filename = scan.next();
        imagename = scan.next();
        this.model.load(filename, imagename);
        System.out.println("Loading "+filename+" as "+imagename+"...");
      }
      else if(command.equals("dither")){ this.model.applyDither(imagename);
        System.out.println("Dithering "+imagename+"...");}
      else if(command.equals("blur")){ this.model.applyBlur(imagename);
        System.out.println("Applying blur to "+imagename+"...");}
      else if(command.equals("sepia")){ this.model.applySepia(imagename);
        System.out.println("Applying sepia transformation to "+imagename+"...");}
      else if(command.equals("greyscale")){ this.model.applyGreyscale(imagename);
      System.out.println("Applying greyscale transformation to "+imagename+"...");}
      else if(command.equals("save")){ imagename = scan.next();
        System.out.println("Saving "+imagename+" to "+imagename+".png");
      model.save(imagename);}
      //else if (command.equals("exit")){break;}
      else{System.out.println("Command not found");}
    }
  }
}
