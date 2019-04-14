package imageprocessing.view;

// Import packages needed for Swing.
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * The user interface of the image processing package. To be implemented in v3.0.
 * TODO update javadoc
 */
public class ViewImpl extends JFrame implements IView, ActionListener {

  // Fields required for setup.
  private JFrame mainFrame;

  // Fields required for menu:

  private JMenuBar menuBar;
  private JMenu menu, submenu, menuAdj, menuFile;
  private JMenuItem menuItem;
  private JRadioButtonMenuItem rbMenuItem;
  private JCheckBoxMenuItem cbMenuItem;
  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;



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
    System.out.println("Creating menu bar...");

    // Add each category
    prepareFileMenuItems();
    System.out.println("Preparing File Menu...");
    prepareEditMenuItems();
    System.out.println("Preparing Edit Menu...");
    prepareAdjustmentMenuItems();
    System.out.println("Preparing Adjustment Menu...");
    prepareDrawMenuItems();
    System.out.println("Preparing Draw Menu...");
    prepareImagesMenuItems();
    System.out.println("Preparing Images Menu...");



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
    menuAdj.getAccessibleContext().setAccessibleDescription("Change the image.");

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Blur", KeyEvent.VK_B); // If the person hits "b", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Blur your image");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Sharpen", KeyEvent.VK_S);
    menuItem.getAccessibleContext().setAccessibleDescription("Sharpen your image");
    menuAdj.add(menuItem);

    // Add a separator to categorize types of adjustments
    menuAdj.addSeparator();


    menuItem = new JMenuItem("Dither", KeyEvent.VK_D);
    menuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    menuAdj.add(menuItem);

    menuItem = new JMenuItem("Mosaic", KeyEvent.VK_M);
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
    menuFile = new JMenu("File");
    System.out.println("Making File Menu");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuFile.setMnemonic(KeyEvent.VK_F);
    System.out.println("Setting Mnemonic");

    // Gets the AccessibleContext associated with this JMenuBar.
    menuFile.getAccessibleContext().setAccessibleDescription("Open or save an image");

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Load", KeyEvent.VK_L); // If the person hits "L", it goes here
    menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_L, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Load an image");
    menuItem.addActionListener(this);
    JPanel fileopenPanel = new JPanel();
    menuFile.add(menuItem);
    menuItem.setActionCommand("Open file");




    menuItem = new JMenuItem("Save", KeyEvent.VK_S);
    menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Save image");
    menuItem.addActionListener(this);
    JPanel filesavePanel = new JPanel();
    menuFile.add(menuItem);
    menuItem.setActionCommand("Save file");


    // Add this new menu to the bar.
    menuBar.add(menuFile);
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
  
  private void prepareScrollPane() {

    // ImageIcon image = new ImageIcon("./res/shadowresize.jpg");
    JTextArea textArea = new JTextArea();
    textArea.setText("xx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\n");
    JScrollPane scrollPane = new JScrollPane(textArea);


  }


  /**
   * Invoked when an action occurs.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Open file": {
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog(ViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          fileOpenDisplay.setText(f.getAbsolutePath());
        }
      }
      break;
      case "Save file": {
        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showSaveDialog(ViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          fileSaveDisplay.setText(f.getAbsolutePath());
        }
      }
    }
  }
}
