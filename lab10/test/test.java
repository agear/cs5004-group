import org.junit.Test;

/**
 * TODO Javadoc.
 */
public class test {

  @Test
  public void testA() {
    GradeRecord testGradeRecord;
    Observer testGoodStanding;
    Observer testCanGraduate;
    Observer testCoOp;

    testGradeRecord = new GradeRecord();
    testGoodStanding = new GoodStanding(testGradeRecord);
    testCanGraduate = new CanGraduate(testGradeRecord);
    testCoOp = new CoOp(testGradeRecord);
  }
}
