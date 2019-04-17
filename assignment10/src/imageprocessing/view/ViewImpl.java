package imageprocessing.view;

// Import packages needed for Swing.
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BorderFactory;

import imageprocessing.model.image.IImage;
import imageprocessing.model.image.Image;
import imageprocessing.controller.ControllerImpl;



/**
 * The user interface of the image processing package. To be implemented in v3.0.
 * TODO update javadoc
 */
public class ViewImpl extends JFrame implements IView { //}, ActionListener {

  // Fields required for setup.
  private JFrame mainFrame;

  // Fields required for menu:

  private JMenuBar menuBar;
  private JMenu menuFile, menuEdit, menuAdj, menuDraw, menuImages;
  private JMenuItem blurMenuItem, sharpenMenuItem, ditherMenuItem,
  mosaicMenuItem, sepiaMenuItem, greyscaleMenuItem, flagMenuItem, checkerBoardMenuItem,
  rainbowMenuItem, loadMenuItem, saveMenuItem, undoMenuItem, redoMenuItem, image1MenuItem, image2MenuItem, imageMenuItem;
  private JScrollPane imageScrollPane;

  private JPanel imagePanel;
  private JRadioButtonMenuItem rbMenuItem;
  private JCheckBoxMenuItem cbMenuItem;
  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;
  JComboBox countryListComboBox, widthComboBox, rainbowComboBox, heightComboBox;
  ControllerImpl controller;
  private String path;


  /**
   * Initializes the window and all containers of the imageprocessing GUI.
   */
  public ViewImpl() throws IOException {
    System.out.println("Trying to set up ...");
    prepareGui("./res/welcome.jpeg");
    System.out.println("Initialization complete.");
  }


  /** Creates the Java Swing GUI -- a simple border layout with the image in the center
   * of the screen and a menu bar with options on top.
   * @param file The file to initialize the background image of the window to.
   * @throws IOException If that file can not be found
   */
  private void prepareGui(String file) throws IOException {
    /// always call the constructor of JFrame: it contains important initialization.
    mainFrame = new JFrame("Image Processing Software");

    // setSize creates a frame with a specific size in the center of the screen.
//    mainFrame.setSize(400,400);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setLayout(new BorderLayout());

    // setDefaultCloseOperation determines the behavior when the “close-window” button is clicked.
    // Options are to close the application, close the window but not the application, or do
    // nothing.
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Prepare the menu
    prepareMenuBar();

    // Prepare scrolling area
    prepareScrollPane(file);

    mainFrame.pack();
//    mainFrame.mi
    mainFrame.setBackground(Color.red);
    mainFrame.setVisible(true);


  }

public void setSize(int width, int height) {
    imagePanel.setSize(width +100, height+100);
//    mainFrame.pack();
}
  /**
   * Creates the adjustment menu, which has each type of adjustment of the image that the
   * user can click on to change the current image, and the File menu, which has
   * 'administrative' type capabilities.
   */
  private void prepareMenuBar() {
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


  //TODO adjustment menu items should be setEnabled(false) if no image is loaded.
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
    blurMenuItem = new JMenuItem("Blur", KeyEvent.VK_B); // If the person hits "b", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    blurMenuItem.getAccessibleContext().setAccessibleDescription("Blur your image");
    blurMenuItem.setActionCommand("blur");
    menuAdj.add(blurMenuItem);

    sharpenMenuItem = new JMenuItem("Sharpen", KeyEvent.VK_S);
    sharpenMenuItem.getAccessibleContext().setAccessibleDescription("Sharpen your image");
    sharpenMenuItem.setActionCommand("sharpen");
    menuAdj.add(sharpenMenuItem);

    // Add a separator to categorize types of adjustments
    menuAdj.addSeparator();

    ditherMenuItem = new JMenuItem("Dither", KeyEvent.VK_D);
    ditherMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    ditherMenuItem.setActionCommand("dither");
    menuAdj.add(ditherMenuItem);

    mosaicMenuItem = new JMenuItem("Mosaic", KeyEvent.VK_M);
    mosaicMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    mosaicMenuItem.setActionCommand("mosaic");
    menuAdj.add(mosaicMenuItem);

    // Add a seperator to categorize types of adjustments
    menuAdj.addSeparator();


    sepiaMenuItem = new JMenuItem("Sepia", KeyEvent.VK_S);
    sepiaMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in sepia");
    sepiaMenuItem.setActionCommand("sepia");
    menuAdj.add(sepiaMenuItem);

    greyscaleMenuItem = new JMenuItem("Greyscale", KeyEvent.VK_G);
    greyscaleMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in greyscale");
    greyscaleMenuItem.setActionCommand("greyscale");
    menuAdj.add(greyscaleMenuItem);


    // Add this new menu to the bar.
    menuBar.add(menuAdj);

  }

  //TODO Copied an pasted -- Update comments
  private void prepareFileMenuItems() {
    // Build the first menu (File):
    menuFile = new JMenu("File");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuFile.setMnemonic(KeyEvent.VK_F);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuFile.getAccessibleContext().setAccessibleDescription("Open or save an image");

    // Add all adjustments item to this menu:
    loadMenuItem = new JMenuItem("Load", KeyEvent.VK_L); // If the person hits "L", it goes here
    loadMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_L, ActionEvent.ALT_MASK)); //
    loadMenuItem.getAccessibleContext().setAccessibleDescription("Load an image");

    loadMenuItem.addActionListener(controller);
    JPanel fileloadPanel = new JPanel();
    menuFile.add(loadMenuItem);
    loadMenuItem.setActionCommand("load");
    //TODO???




    saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
    saveMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK)); //
    saveMenuItem.getAccessibleContext().setAccessibleDescription("Save image");
    saveMenuItem.addActionListener(controller);
    JPanel filesavePanel = new JPanel();
    menuFile.add(saveMenuItem);
    saveMenuItem.setActionCommand("save");


    // Add this new menu to the bar.
    menuBar.add(menuFile);
  }

  //TODO copied and pasted--update comments.
  private void prepareEditMenuItems() {
    // Build the first menu (File):
    menuEdit = new JMenu("Edit");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuEdit.setMnemonic(KeyEvent.VK_E);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuEdit.getAccessibleContext().setAccessibleDescription(
            "Edit menu");

    // Add all edit item to this menu:
    undoMenuItem = new JMenuItem("Undo",
            KeyEvent.VK_Z); // If the person hits "Z", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    undoMenuItem.getAccessibleContext().setAccessibleDescription("Undo last command");
    undoMenuItem.setActionCommand("undo");
    //TODO Undo should only be enabled if the the undo stack is not empty
    undoMenuItem.setEnabled(false);
    menuEdit.add(undoMenuItem);

    redoMenuItem = new JMenuItem("Redo", KeyEvent.VK_X);
    redoMenuItem.getAccessibleContext().setAccessibleDescription("Redo last command");
    redoMenuItem.setActionCommand("redo");
    //TODO Redo should only be enabled if the redo stack is not empty
    redoMenuItem.setEnabled(false);
    menuEdit.add(redoMenuItem);


    // Add this new menu to the bar.
    menuBar.add(menuEdit);
  }

  //TODO copied and pasted--update comments.
  private void prepareDrawMenuItems() {
    // Build the first menu (File):
    menuDraw = new JMenu("Draw");
    menuDraw.setMnemonic(KeyEvent.VK_D);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuDraw.getAccessibleContext().setAccessibleDescription("Draw menu");

    // Add all adjustments item to this menu:
    flagMenuItem = new JMenuItem("Flag", KeyEvent.VK_F); // If the person hits "F", it goes here
    flagMenuItem.getAccessibleContext().setAccessibleDescription("Draws Flag");
    menuDraw.add(flagMenuItem);
    flagMenuItem.setActionCommand("flag");

    rainbowMenuItem = new JMenuItem("Rainbow", KeyEvent.VK_R);
    rainbowMenuItem.getAccessibleContext().setAccessibleDescription("Draws Rainbow");
    rainbowMenuItem.setActionCommand("rainbow");
    menuDraw.add(rainbowMenuItem);

    checkerBoardMenuItem = new JMenuItem("Checkerboard", KeyEvent.VK_C);
    checkerBoardMenuItem.getAccessibleContext().setAccessibleDescription("Draws Checkerboard");
    checkerBoardMenuItem.setActionCommand("checkerboard");
    menuDraw.add(checkerBoardMenuItem);

    // Add this new menu to the bar.
    menuBar.add(menuDraw);
  }


  //TODO copied and pasted--update comments.
  private void prepareImagesMenuItems() {
    // Build the first menu (File):
    menuImages = new JMenu("Images");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuImages.setMnemonic(KeyEvent.VK_I);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuImages.getAccessibleContext().setAccessibleDescription(
            "Image menu");

    // Add this new menu to the bar.
    menuBar.add(menuImages);
  }

  /**
   * Creates the scrollable panel to hold an image.
   */
  private void prepareScrollPane(String file) throws IOException {
    System.out.println("Preparing scroll pane...");

    imagePanel = new JPanel();
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current image"));
    imagePanel.setLayout(new GridLayout(1,0, 10, 10));
    imagePanel.setMaximumSize(null);
    mainFrame.add(imagePanel);

    IImage image = new Image(file);
    BufferedImage buffered = image.convertToBufferedImage(file);
    JLabel imageLabel = new JLabel("");
    imageScrollPane = new JScrollPane(imageLabel);
    imageLabel.setIcon(new ImageIcon(buffered));
    imagePanel.add(imageScrollPane);
    imagePanel.setVisible(true);
    System.out.println("Scroll pane added");

  }


  public void displayImage(BufferedImage image) {
    this.imagePanel.remove(this.imagePanel);
    this.imagePanel.remove(this.imageScrollPane);
    //this.mainFrame.remove(imagePanel);
    JLabel imageLabel = new JLabel("");
    imageLabel.setIcon(new ImageIcon(image));
    this.imageScrollPane = new JScrollPane(imageLabel);
    imagePanel.add(imageScrollPane);
    this.imagePanel.revalidate();
    imagePanel.repaint();
    this.mainFrame.add(imagePanel);
  }

  public String getFilePath(){
    return path;
  }

  public void openLoadDialogue() {

    // Creates a JFileChooser options, which opens a dialog box that lets the user choose a file.
    final JFileChooser fchooser = new JFileChooser(".");

    // Limits the options to just .jpg, .gif, and .png images.
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF and PNG Images", "jpg","gif","png");
    fchooser.setFileFilter(filter);

    // The return value is the path that the user chooses.
    int retValue = fchooser.showOpenDialog(ViewImpl.this);
    if (retValue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
//      fileOpenDisplay.setText(f.getAbsolutePath());
      path = f.getAbsolutePath();
      System.out.println("In the View, user has selected this path: " + path);
    }
  }


  public void openSaveDialogue() {

        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showSaveDialog(ViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          fileSaveDisplay.setText(f.getAbsoluteFile().getAbsolutePath());
          path = f.getAbsoluteFile().getAbsolutePath();
          System.out.println("In the View, user has chosen to save to this path: \n" + path);
        }
  }

  /**
   * TODO Java doc
   * @return
   */
  public String flagDialog() {

    final String[] countryList = { "Greece", "France", "Switzerland" };
    countryListComboBox = new JComboBox(countryList);
    countryListComboBox.setSelectedIndex(countryList.length-1);
    String input = (String)JOptionPane.showInputDialog(null, "What country?",
                "Choose your country carefully", JOptionPane.QUESTION_MESSAGE,
            null, countryList, countryList[0]);

    System.out.println("In view, this was selected: " + input);
    return input;
  }

  /**
   * TODO javadoc
   * @return
   */
  public String rainbowDialog() {
    final String[] orientationList = { "Horizontal", "Vertical" };
    rainbowComboBox = new JComboBox(orientationList);
    rainbowComboBox.setSelectedIndex(orientationList.length-1);
    String input = (String)JOptionPane.showInputDialog(null, "What orientation?",
            "makin' a rainbow", JOptionPane.QUESTION_MESSAGE,
            null, orientationList, orientationList[0]);
    return input;
  }

  /**
   * TODO javadoc
   * @return
   */
  public int widthDialog() {

    // Initialize 1000 numbers to display to user to choose.
    String[] stringNumberList = new String[1000];
    int j = 0;
    for (int i = 54; i < stringNumberList.length - 1; i++ ) {
      stringNumberList[j] = Integer.toString(i);
      j++;
    }

    // Presents the user with a list of 1000 numbers to choose from.
    widthComboBox = new JComboBox(stringNumberList);
    widthComboBox.setSelectedIndex(stringNumberList.length-1);
    String input = (String)JOptionPane.showInputDialog(null, "What width?",
            "Selecting the width for your image.", JOptionPane.QUESTION_MESSAGE,
            null, stringNumberList, stringNumberList[0]);

    try {
      return Integer.valueOf(input);
    }

    // If they cancel the operation, it's no big deal.
    catch (NumberFormatException e) {
      return 0;
    }
  }

  /**
   * TODO Java doc
   * @return
   */
  public int heightDialog() {

    // Initialize 1000 numbers to display to user to choose.
    String[] stringNumberList = new String[1000];
    int j = 0;
    for (int i = 54; i < stringNumberList.length - 1; i++ ) {
      stringNumberList[j] = Integer.toString(i);
      j++;
    }

    // Presents the user with a list of 1000 numbers to choose from.
    heightComboBox = new JComboBox(stringNumberList);
    heightComboBox.setSelectedIndex(stringNumberList.length-1);
    String input = (String)JOptionPane.showInputDialog(null, "What height?",
            "Selecting the height for your image.", JOptionPane.QUESTION_MESSAGE,
            null, stringNumberList, stringNumberList[0]);

    try {
      return Integer.valueOf(input);
    }

    // If they cancel the operation, it's no big deal.
    catch (NumberFormatException e) {
      return 0;
    }
  }

  /**
   * TODO javadoc.
   * @return
   */
  public int checkerboardDialog() {

    // Initialize 150 numbers to display to user to choose.
    String[] stringNumberList = new String[150];
    int j = 0;
    for (int i = 1; i < stringNumberList.length - 1; i++ ) {
      stringNumberList[j] = Integer.toString(i);
      j++;
    }

    // Presents the user with a list of 1000 numbers to choose from.
    heightComboBox = new JComboBox(stringNumberList);
    heightComboBox.setSelectedIndex(stringNumberList.length-1);
    String input = (String)JOptionPane.showInputDialog(null,
            "How big do you want each square to be?",
            "popping the question", JOptionPane.QUESTION_MESSAGE,
            null, stringNumberList, stringNumberList[0]);

    try {
      return Integer.valueOf(input);
    }

    // If they cancel the operation, it's no big deal.
    catch (NumberFormatException e) {
      return 0;
    }
  }




  @Override
  /**
   * TODO javadoc.
   */
  public void setListener(ActionListener controller) {
//    this.controller = controller;

    //File Menu
    this.loadMenuItem.addActionListener(controller);
    this.saveMenuItem.addActionListener(controller);

    //Edit Menu
    this.undoMenuItem.addActionListener(controller);
    this.redoMenuItem.addActionListener(controller);

    //Adjustment Menu
    this.blurMenuItem.addActionListener(controller);
    this.sharpenMenuItem.addActionListener(controller);
    this.ditherMenuItem.addActionListener(controller);
    this.mosaicMenuItem.addActionListener(controller);
    this.sepiaMenuItem.addActionListener(controller);
    this.greyscaleMenuItem.addActionListener(controller);

    //Draw Menu
    this.flagMenuItem.addActionListener(controller); //TODO this section will probably be deleted when we figure out how to do dialog boxes correctly
    this.rainbowMenuItem.addActionListener(controller);
    this.checkerBoardMenuItem.addActionListener(controller);

    //Image Menu
    this.image1MenuItem.addActionListener(controller);
    this.image2MenuItem.addActionListener(controller);
//    this.countryListComboBox.addActionListener(controller);
  }

  /**
   * TODO java doc
   * @param b
   */
  public void toggleUndo(boolean b){
    undoMenuItem.setEnabled(b);
  }

  /**
   * TODO Javadoc
   * @param b
   */
  public void toggleRedo(boolean b) {
    redoMenuItem.setEnabled(b);
  }

  /**
   * TODO Javadoc
   * @param b
   */
  public void toggleAdjustments(boolean b) {
    blurMenuItem.setEnabled(b);
    sharpenMenuItem.setEnabled(b);
    ditherMenuItem.setEnabled(b);
    mosaicMenuItem.setEnabled(b);
    sepiaMenuItem.setEnabled(b);
    greyscaleMenuItem.setEnabled(b);
    saveMenuItem.setEnabled(b);
  }

  /**
   * TODO Javadoc.
   * @param imageName
   */
  public void updateImageMenu(String imageName) {
    // Add all adjustments item to this menu:
    imageMenuItem = new JMenuItem(imageName, KeyEvent.VK_Z); // If the person hits "Z", it goes here
    imageMenuItem.getAccessibleContext().setAccessibleDescription(imageName);
    imageMenuItem.setActionCommand(imageName);
    menuImages.add(imageMenuItem);
  }
}
