//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//import java.io.StringReader;
//
//import imageprocessing.controller.ControllerImpl;
//import imageprocessing.controller.IController;
//import imageprocessing.model.IModel;
//import imageprocessing.model.MockModel;
//import imageprocessing.view.IView;
//import imageprocessing.view.ViewImpl;
//
///**
// * Tests for the image processing class.
// */
//public class TestImage {
//
//  @Test
//  public void testController() throws IOException {
//    MockModel m = new MockModel();
//    IView v = new ViewImpl();
//    String s = "load ./res/santaferesized.jpg santafe";
//    StringReader in = new StringReader(s);
//    IController c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load", m.getCode());
//
//
//    s = "blur santafe";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load blur", m.getCode());
//
//    s = "sharpen santafe";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load blur sharpen", m.getCode());
//
//    s = "mosaic santafe 1000";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load blur sharpen mosaic 1000", m.getCode());
//
//    s = "dither santafe";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load blur sharpen mosaic 1000 dither", m.getCode());
//
//    s = "greyscale santafe";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load blur sharpen mosaic 1000 dither greyscale", m.getCode());
//
//    s = "sepia santafe";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("load blur sharpen mosaic 1000 dither greyscale sepia", m.getCode());
//
//
//    m = new MockModel();
//    s = "flag greece 200";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("flag 200 GREECE", m.getCode());
//
//    m = new MockModel();
//    s = "flag france 50";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("flag 50 FRANCE", m.getCode());
//
//    m = new MockModel();
//    s = "flag switzerland 505";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("flag 505 SWITZERLAND", m.getCode());
//
//
//    m = new MockModel();
//    s = "checkerboard 505";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("checkerboard 505", m.getCode());
//
//
//    m = new MockModel();
//    s = "rainbow horizontal 60 900";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("rainbow h:60 w:900 HORIZONTAL", m.getCode());
//
//    m = new MockModel();
//    s = "rainbow vertical 90 60";
//    in = new StringReader(s);
//    c = new ControllerImpl(m, v, in);
//    c.goGo();
//    assertEquals("rainbow h:90 w:60 VERTICAL", m.getCode());
//
//
//  }
//}
