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
  rainbowMenuItem, loadMenuItem, saveMenuItem, undoMenuItem, redoMenuItem, image1MenuItem, image2MenuItem;
  private JScrollPane imageScrollPane;

  private JPanel imagePanel;
  private JRadioButtonMenuItem rbMenuItem;
  private JCheckBoxMenuItem cbMenuItem;
  private JLabel fileOpenDisplay;
  private JLabel fileSaveDisplay;
  JComboBox countryListComboBox;
  ControllerImpl controller;
  private String path;


  /**
   * Initializes the window and all containers of the imageprocessing GUI.
   */
  public ViewImpl() throws IOException {
    System.out.println("Trying to set up ...");
    prepareGui("./res/shadowresize.jpg");
    System.out.println("Initialization complete.");
  }


  private void prepareGui(String file) throws IOException {
    /// always call the constructor of JFrame: it contains important initialization.
    mainFrame = new JFrame("Image Processing Software");
    // setSize creates a frame with a specific size.
    mainFrame.setSize(400,400);
    mainFrame.setLayout(new BorderLayout());
    // setDefaultCloseOperation determines the behavior when the “close-window” button is clicked.
    // Options are to close the application, close the window but not the application, or do
    // nothing.
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Prepare the menu
    prepareMenuBar();

    // Prepare scrolly area
    prepareScrollPane(file);

    pack();
    mainFrame.setVisible(true);

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
    menuEdit.add(undoMenuItem);

    redoMenuItem = new JMenuItem("Redo", KeyEvent.VK_X);
    redoMenuItem.getAccessibleContext().setAccessibleDescription("Redo last command");
    redoMenuItem.setActionCommand("redo");
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

//    final String[] countryList = { "Greece", "France", "Switzerland" };
//    countryListComboBox = new JComboBox(countryList);
//    countryListComboBox.setSelectedIndex(countryList.length-1);

//    flagMenuItem.addActionListener(new java.awt.event.ActionListener() {
//      @Override
//      public void actionPerformed(java.awt.event.ActionEvent evt) {
//
//        countryListComboBox.addActionListener(this);
//
//        String input = (String)JOptionPane.showInputDialog(null, "What country?",
//                "Choose your country carefully", JOptionPane.QUESTION_MESSAGE, null, countryList,
//                countryList[0]);
//
//        System.out.println("In view, this was selected: " + input);
//        countryListComboBox.setVisible(true);
//        countryListComboBox.setActionCommand(input);
//      }
//    });


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

    // Add all adjustments item to this menu:
    image1MenuItem = new JMenuItem("Image_1",
            KeyEvent.VK_Z); // If the person hits "Z", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    image1MenuItem.getAccessibleContext().setAccessibleDescription("Select Image_1");
    image1MenuItem.setActionCommand("image_1");
    menuImages.add(image1MenuItem);

    image2MenuItem = new JMenuItem("Image_2", KeyEvent.VK_X);
    image2MenuItem.getAccessibleContext().setAccessibleDescription("Select Image_2");
    image2MenuItem.setActionCommand("image_2");
    menuImages.add(image2MenuItem);


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
    final JFileChooser fchooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF and PNG Images", "jpg","gif","png");
    fchooser.setFileFilter(filter);
    int retvalue = fchooser.showOpenDialog(ViewImpl.this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
//      fileOpenDisplay.setText(f.getAbsolutePath());
      path = f.getAbsolutePath();
      System.out.println("View: "+path);
    }
  }

  /**
   * Invoked when an action occurs.
   */
//  @Override
//  public void actionPerformed(ActionEvent e) {
//
//    switch (e.getActionCommand()) {
//      case "load": {
//        final JFileChooser fchooser = new JFileChooser(".");
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png");
//        fchooser.setFileFilter(filter);
//        int retvalue = fchooser.showOpenDialog(ViewImpl.this);
//        if (retvalue == JFileChooser.APPROVE_OPTION) {
//          File f = fchooser.getSelectedFile();
//          fileOpenDisplay.setText(f.getAbsolutePath());
//          String path = f.getAbsolutePath();
//          System.out.println(path);
//          try {
//            //TODO command should be sent to controller which then loads the image into the model
//            // and returns the buffered image from the model, for display
//            loadMenuItem.setActionCommand("load "+path);
//            System.out.println("load "+path);
//            IImage image = new Image(path);
//            BufferedImage buffered = image.convertToBufferedImage(path);
//            displayImage(buffered);
//          }
//          catch (IOException exception) {
//            throw new IllegalArgumentException("No such element");
//          }
////          displayImage(path);
//        }
//      }
//      break;
//      case "Save file": {
//        final JFileChooser fchooser = new JFileChooser(".");
//        int retvalue = fchooser.showSaveDialog(ViewImpl.this);
//        if (retvalue == JFileChooser.APPROVE_OPTION) {
//          File f = fchooser.getSelectedFile();
//          fileSaveDisplay.setText(f.getAbsolutePath());
//        }
//      }
//      case "flag": {
//        countryListComboBox.setVisible(true);
//      }
//    }
//  }

  @Override
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
    this.flagMenuItem.addActionListener(controller);
    this.rainbowMenuItem.addActionListener(controller);
    this.checkerBoardMenuItem.addActionListener(controller);

    //Image Menu
    this.image1MenuItem.addActionListener(controller);
    this.image2MenuItem.addActionListener(controller);
//    this.countryListComboBox.addActionListener(controller);
  }
}
