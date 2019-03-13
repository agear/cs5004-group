import java.util.Scanner;

/**
 * Represents a text document (e.g., a .doc file)
 */
public class TextDocumentImpl implements TextDocument {

  private String text;


  /**
   * Initializes a text document object by assigning input to the text file field.
   *
   * @param input The text that the document contains
   */
  public TextDocumentImpl(String input) {
    this.text = input;
  }


  /**
   * Counts the number of words in this document.
   *
   * @return the number of words in this document
   */
  public int getWordCount() {
    int wordCount = 0;
    Scanner s = new Scanner(this.text);
    while (s.hasNext()) {
      s.next();
      wordCount += 1;
    }
    s.close();
    return wordCount;
  }

  /**
   * Returns the text in this document as a String.
   *
   * @return the text in this document as a String
   */
  public String getText() {
    return this.text;
  }

  /**
   * The algorithm attempts to fit as many words as possible on a line without breaking them. When
   * it runs out of space it breaks into a new line and continues this process until all the words
   * have been placed.
   *
   * <p>Since it uses the scanner class, more than 1 whitespace character
   * in a row is not preserved.</p>
   *
   * <p>Note that once a word is broken up,
   * then the getWordClass will count the broken up words as unique.</p>
   *
   * @return returns the wrapped version of the text in this document
   */
  public TextDocument wrap(int columnWidth) {

    // Columns must be at least one character in length.
    if (columnWidth < 1) {
      throw new IllegalArgumentException("Columns must be at least one character in length.");
    }


    // Initialize an empty string that will be the TextWrapped document.
    String modifiedText = "";

    //Let w = next word in the input text.
    String w;
    int currentLineWidth = 0;
    Scanner s = new Scanner(this.text);

    // Traverse through the text, word by word.
    while (s.hasNext()) {
      w = s.next();


      //Keep track of the current Width of the line.
      int potentialWidth = currentLineWidth + w.length();


      // If it's an issue with the word, then break up the word
      // Do this continuously until the potential width is not more than the column width
      while (w.length() > columnWidth) {

        //System.out.println("column width is " + columnWidth);
        //System.out.println("current line width is " + currentLineWidth);

        modifiedText = modifiedText + w.substring(0,columnWidth - currentLineWidth) + "\n";
        w = w.substring(columnWidth - currentLineWidth);
        currentLineWidth = 0;

      }


      //If the word does not fit in the current line,
      // add a new line character to the output and reset line width to 0.
      if (potentialWidth > columnWidth) {

        // Adds the current w on a new line
        if (currentLineWidth != 0 ) {
          modifiedText = modifiedText + "\n" + w;
        }
        else {
          modifiedText = modifiedText + w;
        }
        currentLineWidth = w.length();

        // If a space can fit in the current line then add it (and update the length of the line).
        if (currentLineWidth + 1 <= columnWidth) {
          modifiedText = modifiedText + " ";
          currentLineWidth += 1;
        }
      }

      // If the word does fit on the current line,
      // add the word to the current line and update the length of the line.
      else {
        modifiedText = modifiedText + w;
        currentLineWidth += w.length();

        //If a space can fit in the current line then add it (and update the length of the line).
        if (currentLineWidth + 1 <= columnWidth) {
          modifiedText = modifiedText + " ";
          currentLineWidth += 1;
        }
      }
    }
    //Return the processed output after removing trailing spaces if any.
    modifiedText = modifiedText.trim();
    TextDocument modifiedTextDocument = new TextDocumentImpl(modifiedText);
    return modifiedTextDocument;
  }

}

