import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import imageprocessing.controller.ControllerImpl;
import imageprocessing.controller.IController;
import imageprocessing.model.IModel;
import imageprocessing.model.MockModel;
import imageprocessing.view.IView;
import imageprocessing.view.ViewImpl;

/**
 * Tests for the image processing class.
 */
public class TestImage {

  @Test
  public void testController() {
    IModel m = new MockModel();
    IView v = new ViewImpl();
    String s = "Load ./res/santaferesized.jpg";
    StringReader in = new StringReader(s);
    IController c = new ControllerImpl(m, v, in);
    //assertEquals(1, m.getCode());
  }
}
