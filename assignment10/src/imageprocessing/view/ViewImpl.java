package imageprocessing.view;

// Import packages needed for Swing.
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import imageprocessing.controller.Features;
import imageprocessing.model.image.IImage;
import imageprocessing.model.image.Image;



/**
 * The user interface of the image processing package, a simple GUI with a menu bar on the top
 * and a main image displayed in the background. The menu bar has these items: File, Edit,
 * Adjustments, Draw, and Images. //todo are we still doing the images thing?
 */
public class ViewImpl extends JFrame implements IView { //}, ActionListener {

  // Global fields required for setup.
  private JFrame mainFrame;

  // Fields required for menu:
  private JMenuBar menuBar;
  private JMenu menuFile, menuEdit, menuAdj, menuDraw, menuImages;
  private JMenuItem blurMenuItem, sharpenMenuItem, ditherMenuItem,
  mosaicMenuItem, sepiaMenuItem, greyscaleMenuItem, flagMenuItem, checkerBoardMenuItem,
  rainbowMenuItem, loadMenuItem, saveMenuItem, undoMenuItem, redoMenuItem, quitMenuItem,
          batchLoadMenuItem, batchWriteMenuItem;
  private JScrollPane imageScrollPane;

  private JPanel imagePanel;
  private JLabel fileSaveDisplay;
  JComboBox countryListComboBox, widthComboBox, rainbowComboBox, heightComboBox;
  private String path;


  /**
   * Initializes the window and all containers of the imageprocessing GUI.
   */
  public ViewImpl() throws IOException {
    System.out.println("Trying to set up ...");
    prepareGui("./res/welcome.png");
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

    // Adjustments to the design of the GUI
    mainFrame.pack();
    mainFrame.setVisible(true);

  }


  /** Sets the size of the image so that the image panel is 100 pixels wider and taller
   * than the input width and height specifications.
   * @param width The desired width
   * @param height The desired height
   */
  public void setSize(int width, int height) {
    imagePanel.setSize(width +100, height+100);
}

//TODO Delete debug statements
  /**
   * Creates the adjustment menu, which has each type of adjustment of the image that the
   * user can click on to change the current image, and the File menu, which has
   * 'administrative' type capabilities.
   */
  private void prepareMenuBar() {
//    System.out.println("Trying to set up the menu ..."); //TODO can we delete debugging statements like this now?

    // Create the menu bar:
    menuBar = new JMenuBar();

    // Add each category
    prepareFileMenuItems();
//    System.out.println("File menu..OK!");
    prepareEditMenuItems();
//    System.out.println("Edit menu..OK!");
    prepareAdjustmentMenuItems();
//    System.out.println("Adjustment menu..OK!");
    prepareDrawMenuItems();
//    System.out.println("Draw menu..OK!");

    // Add the menu bar to the frame at the top.
    mainFrame.setJMenuBar(menuBar);
    mainFrame.add(menuBar, BorderLayout.NORTH);
    menuBar.setVisible(true);

  }

  /**
   * Creates the File menu, which contains Load, Save, Batch Load, and Quit.
   */
  private void prepareFileMenuItems() {
//    System.out.println("Preparing file menu....");

    // If the user types "F" for "F"ile (VK_F), this menu opens up
    menuFile = new JMenu("File");
    menuFile.setMnemonic(KeyEvent.VK_F);

    // Sets the AccessibleContext associated with this JMenuBar.
    menuFile.getAccessibleContext().setAccessibleDescription("Open or save an image");

    // Add load item to this menu:
    loadMenuItem = new JMenuItem("Load", KeyEvent.VK_L); // If the person hits "L", it goes here
    loadMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_L, ActionEvent.ALT_MASK)); //
    loadMenuItem.getAccessibleContext().setAccessibleDescription("Load an image");
    menuFile.add(loadMenuItem);

    // Add save item to this menu:
    saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
    saveMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK));
    saveMenuItem.getAccessibleContext().setAccessibleDescription("Save image");
    menuFile.add(saveMenuItem);

    // Separate batch load, and add Load batch script option
    menuFile.addSeparator();
    batchLoadMenuItem = new JMenuItem("Load Batch Script", KeyEvent.VK_B);
    batchLoadMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK));
    batchLoadMenuItem.getAccessibleContext().setAccessibleDescription("Load batch script");
    menuFile.add(batchLoadMenuItem);

    // Separate quit, and add Quit as a menu item
    // Write a batch script
    batchWriteMenuItem = new JMenuItem("Write Batch Script", KeyEvent.VK_B);
    batchWriteMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK));
    batchWriteMenuItem.getAccessibleContext().setAccessibleDescription("Write batch script");
    menuFile.add(batchWriteMenuItem);


    // Separate quit
    menuFile.addSeparator();

    quitMenuItem = new JMenuItem("Quit", KeyEvent.VK_Q);
    quitMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Q, ActionEvent.ALT_MASK));
    quitMenuItem.getAccessibleContext().setAccessibleDescription("Quit");
    menuFile.add(quitMenuItem);

    // Add this new menu to the bar.
    menuBar.add(menuFile);
  }

  /**
   * Creates the Edit menu button, which includes only Undo and Redo.
   */
  private void prepareEditMenuItems() {
    // Build the first menu (File):
    menuEdit = new JMenu("Edit");

    // If the user types "E" for "E"dit (VK_F), this menu opens up:
    menuEdit.setMnemonic(KeyEvent.VK_E);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuEdit.getAccessibleContext().setAccessibleDescription(
            "Edit menu");

    // Add all edit item to this menu:
    undoMenuItem = new JMenuItem("Undo", KeyEvent.VK_Z);
    quitMenuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Z, ActionEvent.ALT_MASK));

    undoMenuItem.getAccessibleContext().setAccessibleDescription("Undo last command");
    undoMenuItem.setActionCommand("undo");

    //Undo is only be enabled if the the undo stack is not empty
    undoMenuItem.setEnabled(false);
    menuEdit.add(undoMenuItem);

    redoMenuItem = new JMenuItem("Redo", KeyEvent.VK_R);
    redoMenuItem.getAccessibleContext().setAccessibleDescription("Redo last command");

    //Redo is only be enabled if the redo stack is not empty
    redoMenuItem.setEnabled(false);
    menuEdit.add(redoMenuItem);

    // Add this new menu to the menu bar.
    menuBar.add(menuEdit);
  }

  /**
   * Adds each particular item to the Adjustment Menu, such as blur and greyscale.
   */
  private void prepareAdjustmentMenuItems() {

    // Build the adjustments menu
    menuAdj = new JMenu("Adjustments");

    // If the user types "A" for "A"djustments (VK_A), this menu opens up:
    menuAdj.setMnemonic(KeyEvent.VK_A);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuAdj.getAccessibleContext().setAccessibleDescription("Change the image.");

    // Add all adjustments item to this menu:
    blurMenuItem = new JMenuItem("Blur", KeyEvent.VK_B); // If the person hits "b", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    blurMenuItem.getAccessibleContext().setAccessibleDescription("Blur your image");
    menuAdj.add(blurMenuItem);

    sharpenMenuItem = new JMenuItem("Sharpen");
    sharpenMenuItem.getAccessibleContext().setAccessibleDescription("Sharpen your image");
    menuAdj.add(sharpenMenuItem);

    // Add a separator to categorize types of adjustments
    menuAdj.addSeparator();

    ditherMenuItem = new JMenuItem("Dither", KeyEvent.VK_D);
    ditherMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    menuAdj.add(ditherMenuItem);

    mosaicMenuItem = new JMenuItem("Mosaic", KeyEvent.VK_M);
    mosaicMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in dither");
    menuAdj.add(mosaicMenuItem);

    // Add a seperator to categorize types of adjustments
    menuAdj.addSeparator();


    sepiaMenuItem = new JMenuItem("Sepia");
    sepiaMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in sepia");
    menuAdj.add(sepiaMenuItem);

    greyscaleMenuItem = new JMenuItem("Greyscale", KeyEvent.VK_G);
    greyscaleMenuItem.getAccessibleContext().setAccessibleDescription("Make your image in greyscale");
    menuAdj.add(greyscaleMenuItem);

    // Add this new menu to the bar.
    menuBar.add(menuAdj);

  }


  /**
   * Creates the Draw menu section, which includes Rainbow, Checkerboard, and Flag.
   */
  private void prepareDrawMenuItems() {
    menuDraw = new JMenu("Draw");
    menuDraw.setMnemonic(KeyEvent.VK_D);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuDraw.getAccessibleContext().setAccessibleDescription("Draw menu");

    // Add all adjustments item to this menu:
    flagMenuItem = new JMenuItem("Flag", KeyEvent.VK_F); // If the person hits "F"
    flagMenuItem.getAccessibleContext().setAccessibleDescription("Draws Flag");
    menuDraw.add(flagMenuItem);

    rainbowMenuItem = new JMenuItem("Rainbow", KeyEvent.VK_R);
    rainbowMenuItem.getAccessibleContext().setAccessibleDescription("Draws Rainbow");
    menuDraw.add(rainbowMenuItem);

    checkerBoardMenuItem = new JMenuItem("Checkerboard", KeyEvent.VK_C);
    checkerBoardMenuItem.getAccessibleContext().setAccessibleDescription("Draws Checkerboard");
    menuDraw.add(checkerBoardMenuItem);

    // Add this new menu to the bar.
    menuBar.add(menuDraw);
  }


  //TODO Commented out the add.(menuImages) at the end ot get rid of this functionality for now with
  // out breaking anything else hopefully...
  private void prepareImagesMenuItems() {
    // Build the Images menu
    menuImages = new JMenu("Images");

    // If the user types "F" for "F"ile (VK_F), this menu opens up:
    menuImages.setMnemonic(KeyEvent.VK_I);

    // Gets the AccessibleContext associated with this JMenuBar.
    menuImages.getAccessibleContext().setAccessibleDescription(
            "Image menu");

    // Add this new menu to the bar.
//    menuBar.add(menuImages);
  }

  /**
   * Creates the scrollable panel to hold an image.
   */
  private void prepareScrollPane(String file) throws IOException {

    // Creates the panel, adds a title, alters the size
    imagePanel = new JPanel();
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current image"));
    imagePanel.setLayout(new GridLayout(1,0, 10, 10));
    imagePanel.setMaximumSize(null);
    fileSaveDisplay = new JLabel("File path will appear here");
//    imagePanel.add(fileSaveDisplay);
    mainFrame.add(imagePanel);


    // Create the image in the background on display
    IImage image = new Image(file);
    BufferedImage buffered = image.convertToBufferedImage(file);
    JLabel imageLabel = new JLabel("");
    imageScrollPane = new JScrollPane(imageLabel);
    imageLabel.setIcon(new ImageIcon(buffered));
    imagePanel.add(imageScrollPane);
    imagePanel.setVisible(true);

  }


  /** Adds an image on the display and removes the current image on display.
   * @param image The image to be displayed
   */
  public void displayImage(BufferedImage image) {

    // Remove current image
    this.imagePanel.remove(this.imagePanel);
    this.imagePanel.remove(this.imageScrollPane);

    // Build a new image panel
    JLabel imageLabel = new JLabel("");
    imageLabel.setIcon(new ImageIcon(image));
    this.imageScrollPane = new JScrollPane(imageLabel);
    imagePanel.add(imageScrollPane);

    // Repaint and update the new image
    this.imagePanel.revalidate();
    imagePanel.repaint();
    this.mainFrame.add(imagePanel);
  }


  /** Returns the most previously loaded filepath of this View.
   * @return the filepath stored in the view
   */
  public String getFilePath(){
    return path;
  }


  /**
   * Prompts the user to choose a .txt file in memory which has a series of
   * batch-processing commands.
   */
  public void openBatchLoadDialogue() {
    // Creates a JFileChooser options, which opens a dialog box that lets the user choose a file.
    final JFileChooser fchooser = new JFileChooser(".");

    // Limits the options to just .txt files
    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
    fchooser.setFileFilter(filter);

    // The return value is the path that the user chooses.
    int retValue = fchooser.showOpenDialog(ViewImpl.this);
    if (retValue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      path = f.getAbsolutePath();
      System.out.println("In the View, user has selected this path: " + path);
    }
  }

  /**
   * Prompts the user to choose a .jpg, .gif, or .png image to load in the view.
   * It returns the path that the user has chosen for the controller to process.
   */
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
      path = f.getAbsolutePath();
    }
  }


  /**
   * Prompts the user to choose where to save the currently open image into a file.
   */
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

  // TODO figure this out.
  public boolean openUnsavedChanges() {

    int result = JOptionPane.showConfirmDialog(
            null,
            "You have unsaved changes. Do you want to save your work?",
            "no wait don't go",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);


    if (result == JOptionPane.YES_OPTION) {
      return true;
    }

    return false;
  }

  /**
   * Prompts the user to choose a country of which they want to make a flag of.
   * @return the country chosen
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
   * Prompts the user to enter the orientation of the desired rainbow image they want drawn.
   * @return the chosen orientation
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
   * Prompts the user to choose a width in pixels for their image (a flag or rainbow).
   * @return the width chosen
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
    String input = (String)JOptionPane.showInputDialog(null,
            "What width (px)?",
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
   * Prompts the user to enter a height between 54 (minimum for a flag) and 1000.
   * @return the height that the user has selected
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
   * Prompts the user to select a number between 1 and 150 (a reasonable maximum), which
   * will be the square size in pixels of the checkerboard they'd like to create.
   * @return the square size in pixels of the checkerboard
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


  /**
   * Allows or disallows the undo button to be clicked on.
   * @param b If b is //TODO i'm not sure how set enabled works
   */
  public void toggleUndo(boolean b){
    undoMenuItem.setEnabled(b);
  }

  /**
   * Allows or disallows the redo button to be clicked on.
   * @param b If b is //TODO i'm not sure how set enabled works
   */
  public void toggleRedo(boolean b) {
    redoMenuItem.setEnabled(b);
  }

  /**
   * Allows or disallows the adjustment menu items to be clicked.
   * @param b If b is //TODO i'm not sure how set enabled works
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
   * Adds every menu item as listeners to the features interface.
   * @param features //TODO i don't know what the feature interface does tbh
   */



  @Override
  public void addFeatures(Features features) {

    //File menu action listeners
    loadMenuItem.addActionListener(l->features.load());
    saveMenuItem.addActionListener(l->{
      try {
        features.save();
      }
      catch (IOException e) {
        System.out.println("Couldn't save the file"); //TODO Popup alert instead of print to terminal.
      }
    });
    batchLoadMenuItem.addActionListener(l->features.batchLoad());
    JTextArea ta = new JTextArea(20, 20);
    batchWriteMenuItem.addActionListener(l->{
      JOptionPane.showConfirmDialog(null, new JScrollPane(ta));
      features.batchWrite(ta.getText());
    });
    quitMenuItem.addActionListener(l-> {
      try {
        features.quit();
      }
      catch (IOException e) {
      System.out.println("Couldn't save the file");
    }
  });

    //Edit menu action listeners
    undoMenuItem.addActionListener(l->features.undo());
    redoMenuItem.addActionListener(l->features.redo());

    //Adjustment menu action listeners
    blurMenuItem.addActionListener(l->features.blur());
    sharpenMenuItem.addActionListener(l->features.sharpen());
    ditherMenuItem.addActionListener(l->features.dither());
    mosaicMenuItem.addActionListener(l->features.mosaic(Integer.parseInt(
            JOptionPane.showInputDialog("Enter a number to use as the seed:")))); //TODO should this be the same as the other number selectors to avoid exceptions?/Better way to do this
    sepiaMenuItem.addActionListener(l->features.sepia());
    greyscaleMenuItem.addActionListener(l->features.greyscale());

    //Draw menu action listeners
    flagMenuItem.addActionListener(l->features.flag());
    rainbowMenuItem.addActionListener(l->features.rainbow());
    checkerBoardMenuItem.addActionListener(l->features.checkerboard());

  }
}
