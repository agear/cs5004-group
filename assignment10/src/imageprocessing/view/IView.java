package imageprocessing.view;

import java.awt.image.BufferedImage;

import imageprocessing.controller.ControllerImpl;

/**
 * The user interface of the image processing package. To be implemented in v3.0.
 */
public interface IView {


  /*
  Creates a channel for the view to communicate information to the controller,
  in order for the controller to tell the model which actions to take based on
  what happened in the view.
   */
  void setListener(ControllerImpl controller);

  void displayImage(BufferedImage image);
}
