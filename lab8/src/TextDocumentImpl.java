import java.util.Scanner;

/**
 * Represents a text document (e.g., a .doc file)
 */
public class TextDocumentImpl implements TextDocument {

  private String text;


  /**
   * Initializes a text document object by assigning input to the text file field
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

  //TODO Step 3 has a potential problem. What if the word is longer than the specified line width?
  // In this case you should break the word into multiple lines (each such line except the one that
  // has the last part of the word will end with - as is normal in such situations).

  /**
   * the algorithm attempts to fit as many words as possible on a line without breaking them. When
   * it runs out of space it breaks into a new line and continues this process until all the words
   * have been placed.
   *
   * @return returns the wrapped version of the text in this document
   */
  public TextDocument wrap(int columnWidth) {
    // Initialize an empty string that will be the TextWrapped document.
    String modifiedText = "";

    //Start at the first line.
    //
    //Let w = next word in the input text.
    String w;
    int currentLineWidth = 0;
    Scanner s = new Scanner(this.text);
    while (s.hasNext()) {
      w = s.next();
      //Keep track of the current Width of the line.
      int potentialWidth = currentLineWidth + w.length();
      //TODO Step 3
      //If the word does not fit in the current line, add a new line character to the output and reset line width to 0.
      if (potentialWidth > columnWidth) {
        modifiedText = modifiedText + "\n" + w;
        currentLineWidth = w.length();
        //If a space can fit in the current line then add it (and update the length of the line).
        if (!(currentLineWidth + 1 > columnWidth)) {
          modifiedText = modifiedText + " ";
          currentLineWidth += 1;

        }//TODO New line (alice understands this.)
        //Add the word to the current line and update the length of the line.
        else {
          modifiedText = modifiedText + w;
          currentLineWidth += w.length();
          //If a space can fit in the current line then add it (and update the length of the line).
          if (!(currentLineWidth + 1 > columnWidth)) {
            modifiedText = modifiedText + " ";
            currentLineWidth += 1;
          }
        }
      }
    }

    //Return the processed output after removing trailing spaces if any.
    modifiedText.trim();
    TextDocument modifiedTextDocument = new TextDocumentImpl(modifiedText);
    return modifiedTextDocument;
  }
}
