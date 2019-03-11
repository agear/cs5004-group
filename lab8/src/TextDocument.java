/**
 * A text document, in its simplest form, stores text as a single long sequence of characters.
 * A text document can do several operations on the text, such as:
 *    finding its word count,
 *    counting the number of lines in it
 *    word-wrapping it for viewing in a document
 *
 */
public interface TextDocument {


  /** Counts the number of words in this document.
   * @return the number of words in this document
   */
  int getWordCount();


  /**
   *  Returns the text in this document as a String.
   *
   * @return the text in this document as a String
   */
  String getText();


  /**  the algorithm attempts to fit as many words as possible on a line without
   * breaking them. When it runs out of space it breaks into a new line and continues
   * this process until all the words have been placed.
   * @param columnWidth
   * @return returns the wrapped version of the text in this document
   */
  TextDocument wrap(int columnWidth);


}
