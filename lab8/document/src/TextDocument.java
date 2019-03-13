/**
 * A text document, in its simplest form, stores text as a single long sequence of characters.
 * A text document can do several operations on the text, such as:
 * finding its word count,
 * counting the number of lines in it
 * word-wrapping it for viewing in a document
 *
 */
public interface TextDocument {


  /** Counts the number of words in this document.
   * @return the number of words in this document
   */
  int getWordCount();


  /**
   * Returns the text in this document as a String with whatever formatting it has.
   *
   * @return the text in this document as a String
   */
  String getText();


  /** Method attempts to fit as many words as possible on a line of length input without
   * breaking them. When it runs out of space it adds a newline character and continues
   * this process until all the words have been placed.
   * @param columnWidth The max length of each line in characters
   * @return returns the wrapped version of the text in this document
   */
  TextDocument wrap(int columnWidth);


}
