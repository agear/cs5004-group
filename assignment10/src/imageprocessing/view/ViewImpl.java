package imageprocessing.view;

// Import packages needed for Swing.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * The user interface of the image processing package. To be implemented in v3.0.
 * TODO update javadoc
 */
public class ViewImpl implements IView {

  // Fields required for setup.
  private JFrame mainFrame;

  // Fields required for menu:
  JMenuBar menuBar;
  JMenu menu, submenu, menuAdj;
  JMenuItem menuItem;
  JRadioButtonMenuItem rbMenuItem;
  JCheckBoxMenuItem cbMenuItem;



  /**
   * Initializes the window and all containers of the imageprocessing GUI.
   */
  public ViewImpl() {
    System.out.println("Trying to set up ...");
    prepareGui();
  }


  private void prepareGui() {
    mainFrame = new JFrame("Image Processing Software");
    mainFrame.setSize(400,400);
    mainFrame.setLayout(new BorderLayout());
    mainFrame.setVisible(true);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Prepare the menu
    prepareMenu();
    mainFrame.setVisible(true);

  }








  /**
   * Creates the adjustment menu, which has each type of adjustment of the image that the
   * user can click on to change the current image, and the File menu, which has
   * 'administrative' type capabilities.
   */
  private void prepareMenu() {
    System.out.println("Trying to set up the menu ...");


    // Create the menu bar:
    menuBar = new JMenuBar();

    // Add each category
    prepareFileMenuItems();
    prepareEditMenuItems();
    prepareAdjustmentMenuItems();
    prepareDrawMenuItems();
    prepareImagesMenuItems();


    // Add the menu bar to the frame at the top.
    mainFrame.setJMenuBar(menuBar);
    mainFrame.add(menuBar, BorderLayout.NORTH);
    menuBar.setVisible(true);

    System.out.println("Menu has been set up.");

  }


  /**
   * Adds each particular item to the Adjustment Menu, such as blur and greyscale.
   */
  private void prepareAdjustmentMenuItems() {

    // Build the first menu (Adjustments):
    menuAdj = new JMenu("Adjustments");

    // If the user types "A" for "A"djustments (VK_A), this menu opens up:
    menuAdj.setMnemonic(KeyEvent.VK_A);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuAdj.getAccessibleContext().setAccessibleDescription(
            "Change the image.");

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Blur",
            KeyEvent.VK_B); // If the person hits "b", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Blur your image");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Sharpen", KeyEvent.VK_S);
    menuItem.getAccessibleContext().setAccessibleDescription("Sharpen your image");
    menuAdj.add(menuItem);

    // Add a seperator to categorize types of adjustments
    menuAdj.addSeparator();


    menuItem = new JMenuItem("Dither", KeyEvent.VK_G);
    menuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Mosaic", KeyEvent.VK_G);
    menuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    menuAdj.add(menuItem);

    // Add a seperator to categorize types of adjustments
    menuAdj.addSeparator();

    // TODO: Two menu items begin with S
    menuItem = new JMenuItem("Sepia", KeyEvent.VK_S);
    menuItem.getAccessibleContext().setAccessibleDescription("Make your image in sepia");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Greyscale", KeyEvent.VK_G);
    menuItem.getAccessibleContext().setAccessibleDescription("Make your image in greyscale");
    menuAdj.add(menuItem);



    // Add this new menu to the bar.
    menuBar.add(menuAdj);

  }

  //TODO Copied an pasted -- Update comments
  private void prepareFileMenuItems() {
    // Build the first menu (File):
    menuAdj = new JMenu("File");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuAdj.setMnemonic(KeyEvent.VK_F);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuAdj.getAccessibleContext().setAccessibleDescription(
            "Open or save an image");

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Load",
            KeyEvent.VK_L); // If the person hits "L", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Load an image");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Save", KeyEvent.VK_S);
    menuItem.getAccessibleContext().setAccessibleDescription("Save image");
    menuAdj.add(menuItem);


    // Add this new menu to the bar.
    menuBar.add(menuAdj);
  }

  //TODO copied and pasted--update comments.
  private void prepareEditMenuItems() {
    // Build the first menu (File):
    menuAdj = new JMenu("Edit");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuAdj.setMnemonic(KeyEvent.VK_E);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuAdj.getAccessibleContext().setAccessibleDescription(
            "Edit menu");

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Undo",
            KeyEvent.VK_Z); // If the person hits "Z", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Undo last command");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Redo", KeyEvent.VK_X);
    menuItem.getAccessibleContext().setAccessibleDescription("Redo last command");
    menuAdj.add(menuItem);


    // Add this new menu to the bar.
    menuBar.add(menuAdj);
  }

  //TODO copied and pasted--update comments.
  private void prepareDrawMenuItems() {
    // Build the first menu (File):
    menuAdj = new JMenu("Draw");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuAdj.setMnemonic(KeyEvent.VK_D);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuAdj.getAccessibleContext().setAccessibleDescription(
            "Draw menu");

    //TODO Sub menus or dialogue boxes to specify options/dimensions?

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Flag",
            KeyEvent.VK_L); // If the person hits "L", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Draws Flag");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Rainbow", KeyEvent.VK_R);
    menuItem.getAccessibleContext().setAccessibleDescription("Draws Rainbow");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Checkerboard", KeyEvent.VK_C);
    menuItem.getAccessibleContext().setAccessibleDescription("Draws Checkerboard");
    menuAdj.add(menuItem);

    // Add this new menu to the bar.
    menuBar.add(menuAdj);
  }

  //TODO copied and pasted--update comments.
  private void prepareImagesMenuItems() {
    // Build the first menu (File):
    menuAdj = new JMenu("Images");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuAdj.setMnemonic(KeyEvent.VK_I);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuAdj.getAccessibleContext().setAccessibleDescription(
            "Image menu");

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Image_1",
            KeyEvent.VK_Z); // If the person hits "Z", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Select Image_1");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Image_2", KeyEvent.VK_X);
    menuItem.getAccessibleContext().setAccessibleDescription("Select Image_2");
    menuAdj.add(menuItem);


    // Add this new menu to the bar.
    menuBar.add(menuAdj);
  }
}
