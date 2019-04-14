package imageprocessing.view;

// Import packages needed for Swing.
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BorderFactory;



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
    prepareGui("./res/shadowresize.jpg");
  }


  private void prepareGui(String file) {
    mainFrame = new JFrame("Image Processing Software");
    mainFrame.setSize(400,400);
    mainFrame.setLayout(new BorderLayout());
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Prepare the menu
    prepareMenu();

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
    menuAdj.getAccessibleContext().setAccessibleDescription("Draw menu");

    //TODO Sub menus or dialogue boxes to specify options/dimensions?

    // Add all adjustments item to this menu:
    menuItem = new JMenuItem("Flag", KeyEvent.VK_F); // If the person hits "F", it goes here
    // menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK)); //
    menuItem.getAccessibleContext().setAccessibleDescription("Draws Flag");
    menuAdj.add(menuItem);

    menuItem.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {



        String[] countryList = { "Greece", "France", "Switzerland"};
        JComboBox petList = new JComboBox(countryList);
        petList.setSelectedIndex(countryList.length-1);
        petList.addActionListener(this);

        String input = (String)JOptionPane.showInputDialog(null, "What country?",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, countryList,
                countryList[0]);
        System.out.println(input);
        petList.setVisible(true);

      }
    });



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

  /**
   * Creates the scrollable panel to hold an image.
   */
  private void prepareScrollPane(String file) {
    System.out.println("Preparing scroll pane...");

    JPanel imagePanel = new JPanel();
    imagePanel.setBorder(BorderFactory.createTitledBorder(file));
    imagePanel.setLayout(new GridLayout(1,0, 10, 10));
    imagePanel.setMaximumSize(null);
    mainFrame.add(imagePanel);

    String[] images = {file};
    JLabel[] imageLabel = new JLabel[images.length];
    JScrollPane[] imageScrollPane = new JScrollPane[images.length];

    for (int i = 0; i < imageLabel.length; i++) {
      imageLabel[i] = new JLabel();
      imageScrollPane[i] = new JScrollPane(imageLabel[i]);
      imageLabel[i].setIcon(new ImageIcon(images[i]));
      imageScrollPane[i].setPreferredSize(new Dimension(100, 600));
      imagePanel.add(imageScrollPane[i]);
    }

    // ImageIcon image = new ImageIcon("./res/shadowresize.jpg");
    JTextArea textArea = new JTextArea(100,100);
    textArea.setText("xx\nxx\nxx\nxx\nxx\nxx\ndjfnjksdnfjkbsdjhsdbfjhsdbfjhsdbfhjbsdjhfsd\nx\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nx\nxx\nxx\nxx\nxx\nxx\nxx\n");

    // Put the content into a pane
    JScrollPane scrollPane = new JScrollPane(textArea);


    // Put the scrolly area into a frame
//    mainFrame.add(scrollPane, BorderLayout.CENTER);


    // center the frame
    //mainFrame.setLocationRelativeTo(null);
//    scrollPane.setVisible(true);
//    textArea.setVisible(true);
    imagePanel.setVisible(true);
    System.out.println("Scroll pane added");

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
                "JPG & GIF Images", "jpg", "gif", "png");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog(ViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          //fileOpenDisplay.setText(f.getAbsolutePath());
          String path = f.getAbsolutePath();
          System.out.println(path);
//          prepareScrollPane(path);
          prepareGui(path);
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
