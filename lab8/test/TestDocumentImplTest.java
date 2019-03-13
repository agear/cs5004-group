import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
//TODO Write more tests

/**
 *
 */
public class TestDocumentImplTest {
  String test;
  String testWrapped;
  TextDocumentImpl testDoc;

  @Before
  public void setup() {
    test = "The algorithm attempts to fit as many words as possible on a line without breaking " +
            "them. When it runs out of space it breaks into a new line and continues this " +
            "process until all the words have been placed.";
    testWrapped = "The algorithm attempts \nto fit as many words as \npossible on a line " +
            "\nwithout breaking them. \nWhen it runs out of \nspace it breaks into a \nnew " +
            "line and continues \nthis process until all \nthe words have been \nplaced.";
    testDoc = new TextDocumentImpl(test);
  }

  @Test
  public void getTextTest() {
    assertEquals(test, testDoc.getText());
    //TODO test edge cases-> empty string
  }

  @Test
  public void getWordCountTest() {
    assertEquals(39, testDoc.getWordCount());
    //TODO test edge cases-> Empty string, one word, numbers etc.

  }

  @Test
  public void wrapTest() {
    TextDocument wrapResult = testDoc.wrap(24);
    assertEquals(testWrapped, wrapResult.getText());
    //TODO Test edge cases->columnWidth = 1, words longer than columnWidth, string = "       " etc.
  }
}
