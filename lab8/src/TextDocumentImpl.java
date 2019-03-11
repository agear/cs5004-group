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

  /**
   * the algorithm attempts to fit as many words as possible on a line without breaking them. When
   * it runs out of space it breaks into a new line and continues this process until all the words
   * have been placed.
   *
   * @return returns the wrapped version of the text in this document
   */
  public TextDocument wrap(int columnWidth) {
    return null;
  }
}
