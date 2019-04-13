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
    prepareAdjustmentMenuItems();
    prepareFileMenuItems();

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


  private void prepareFileMenuItems() {

  }



}
