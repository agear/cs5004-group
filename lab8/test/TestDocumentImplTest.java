import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the methods getText, getWordCount and wrap from the TextDocumentImpl class
 * are working according to defined documentation.
 */
public class TestDocumentImplTest {
  String text;
  String textWrapped;
  TextDocumentImpl testDoc;

  @Before
  public void setup() {
    text = "The algorithm attempts to fit as many words as possible on a line without breaking "
            + "them. When it runs out of space it breaks into a new line and continues this "
            + "process until all the words have been placed.";
    textWrapped = "The algorithm attempts \nto fit as many words as \npossible on a line "
            + "\nwithout breaking them. \nWhen it runs out of \nspace it breaks into a \nnew "
            + "line and continues \nthis process until all \nthe words have been \nplaced.";
    testDoc = new TextDocumentImpl(text);
  }

  @Test
  public void getTextTest() {

    // Tests that the getter functions.
    assertEquals(text, testDoc.getText());

  }

  @Test
  public void getTextLongWordTest() {

    // Tests that a word that is longer than max column length gets broken up correctly.
    text = "abcdefghij";
    testDoc = new TextDocumentImpl(text);
    assertEquals("abcde\nfghij", testDoc.wrap(5).getText());

    // Tests that a word that is longer than max column length gets broken up correctly.
    text = "hi abcdefghij";
    testDoc = new TextDocumentImpl(text);
    assertEquals("hi ab\ncdefg\nhij", testDoc.wrap(5).getText());
  }

  @Test
  public void getWordCountTest() {
    assertEquals(39, testDoc.getWordCount());

    // Tests that an empty string returns 0.
    text = "";
    testDoc = new TextDocumentImpl(text);
    assertEquals(0, testDoc.getWordCount());
    assertEquals(0, testDoc.wrap(5).getWordCount());


    // Tests that one word is good.
    text = "poodles";
    testDoc = new TextDocumentImpl(text);
    assertEquals(1, testDoc.getWordCount());
    assertEquals(1, testDoc.wrap(15).getWordCount());

    // If a word gets broken up in the wrapping process, it is split into different words.
    assertEquals(2, testDoc.wrap(5).getWordCount());


    // Tests that numbers count as words.
    text = "1 2 3";
    testDoc = new TextDocumentImpl(text);
    assertEquals(3, testDoc.getWordCount());

    // Tests that punctuation doesn't count as words.
    text = "the cutest dogs... are german? !shepherds";
    testDoc = new TextDocumentImpl(text);
    assertEquals(6, testDoc.getWordCount());

  }


  @Test
  public void wrapTextWithNewLineCharTest() {

    // Tests that a text that contains \n characters are preserved.
    text = "my first line \nmy second line \nmy third line";
    testDoc = new TextDocumentImpl(text);
    assertEquals("my \n"
                    + "first\n"
                    + "line \n"
                    + "my se\n"
                    + "cond \n"
                    + "line \n"
                    + "my \n"
                    + "third\n"
                    + "line",
            testDoc.wrap(5).getText());
  }

  @Test
  public void simpleWrapTest() {
    TextDocument wrapResult = testDoc.wrap(24);
    assertEquals(textWrapped, wrapResult.getText());

  }


  @Test (expected = IllegalArgumentException.class)
  public void shortColumn() {
    TextDocument wrapResult = testDoc.wrap(0);
  }

  @Test
  public void emptyStringWrap() {
    text = "             ";
    testDoc = new TextDocumentImpl(text);
    assertEquals("", testDoc.wrap(5).getText());
  }


}
