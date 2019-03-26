import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests the observer/subject design between a student's record and information about
 * their record, such as if they're in good standing, etc.
 */
public class TestGradeRecord {


  @Test
  public void testAGoodALIGNStudent() {
    GradeRecord testGradeRecord = new GradeRecord();
    testGradeRecord.addCourseGrade("CS5004", "A");
    testGradeRecord.addCourseGrade("CS5005", "B");
    testGradeRecord.addCourseGrade("CS5007", "A-");

    assertEquals(3.53, testGradeRecord.getGPA(), .01);
    assertEquals(4.0, testGradeRecord.getCoreGPA(), .01);

    testGradeRecord.addCourseGrade("CS5013", "A");
    assertEquals(3.66, testGradeRecord.getGPA(), .01);
    assertEquals(4.0, testGradeRecord.getCoreGPA(), .01);


  }

  @Test(expected = IllegalArgumentException.class)
  public void testNotACourse() {
    GradeRecord testGradeRecord = new GradeRecord();
    testGradeRecord.addCourseGrade("CS5000", "A");
  }


  @Test
  public void studentTest() {

    GradeRecord testGradeRecord = new GradeRecord();
    Observer testGoodStanding = new IsInGoodStanding(testGradeRecord);
    Observer testCanGraduate = new CanGraduate(testGradeRecord);
    Observer testCoOp = new CoOp(testGradeRecord);

    // The student has 0 courses taken
    assertEquals(false, testGoodStanding.getStatus());
    assertEquals(false, testCanGraduate.getStatus());
    assertEquals(false, testCoOp.getStatus());



    // The student has only taken one course and they withdrew from it.
    testGradeRecord.addCourseGrade("CS5005", "W");
    assertEquals(false, testGoodStanding.getStatus());
    assertEquals(false, testCanGraduate.getStatus());
    assertEquals(false, testCoOp.getStatus());

    // The student takes a core course and fails.
    testGradeRecord.addCourseGrade("CS5010", "F");
    assertEquals(false, testGoodStanding.getStatus());
    assertEquals(false, testCanGraduate.getStatus());
    assertEquals(false, testCoOp.getStatus());


    // The student has over 16 hours, but not a high enough GPA for co-op.
    testGradeRecord.addCourseGrade("CS5010", "F");
    testGradeRecord.addCourseGrade("CS5011", "F");
    testGradeRecord.addCourseGrade("CS5012", "F");
    testGradeRecord.addCourseGrade("CS5013", "F");
    testGradeRecord.addCourseGrade("CS5014", "F");
    assertEquals(false, testGoodStanding.getStatus());
    assertEquals(false, testCanGraduate.getStatus());
    assertEquals(false, testCoOp.getStatus());

    // This student has a high cumulative GPA (3.6), but not enough core GPA (2.0)
    // for graduation.
    testGradeRecord.addCourseGrade("CS5010", "C");
    testGradeRecord.addCourseGrade("CS5011", "A");
    testGradeRecord.addCourseGrade("CS5012", "A");
    testGradeRecord.addCourseGrade("CS5013", "A");
    testGradeRecord.addCourseGrade("CS5014", "A");

    assertEquals(true, testGoodStanding.getStatus());
    assertEquals(false, testCanGraduate.getStatus());
    assertEquals(true, testCoOp.getStatus());

    // This student has a high GPA (retook CS5010) but not enough hours for co-op
    // As they withdrew from the rest of their courses:
    testGradeRecord.addCourseGrade("CS5010", "A");
    testGradeRecord.addCourseGrade("CS5011", "W");
    testGradeRecord.addCourseGrade("CS5012", "W");
    testGradeRecord.addCourseGrade("CS5013", "W");
    testGradeRecord.addCourseGrade("CS5014", "W");
    assertEquals(true, testGoodStanding.getStatus());
    assertEquals(true, testCanGraduate.getStatus());
    assertEquals(false, testCoOp.getStatus());


    // This student is NOT in good standing (2.4 cGPA),
    // but has done well in their core courses (4.0 GPA) so can graduate.
    testGradeRecord.addCourseGrade("CS5010", "A");
    testGradeRecord.addCourseGrade("CS5600", "A");
    testGradeRecord.addCourseGrade("CS5500", "A");
    testGradeRecord.addCourseGrade("CS5011", "F");
    testGradeRecord.addCourseGrade("CS5012", "F");
    assertEquals(false, testGoodStanding.getStatus());
    assertEquals(true, testCanGraduate.getStatus());
    assertEquals(false, testCoOp.getStatus());

    // This student has a high cGPA (3.25) and core GPA (3.33)
    // and has taken exactly 16 hours.
    testGradeRecord.addCourseGrade("CS5010", "B+");
    testGradeRecord.addCourseGrade("CS5600", "B");
    testGradeRecord.addCourseGrade("CS5500", "A-");
    testGradeRecord.addCourseGrade("CS5011", "B");
    testGradeRecord.addCourseGrade("CS5012", "W");
    assertEquals(true, testGoodStanding.getStatus());
    assertEquals(true, testCanGraduate.getStatus());
    assertEquals(true, testCoOp.getStatus());

    // This student has a high GPA (4.0) and 16+ hrs but has taken 0 core courses.
    testGradeRecord.addCourseGrade("CS5004", "W");
    testGradeRecord.addCourseGrade("CS5005", "W");
    testGradeRecord.addCourseGrade("CS5010", "W");
    testGradeRecord.addCourseGrade("CS5600", "W");
    testGradeRecord.addCourseGrade("CS5500", "W");
    testGradeRecord.addCourseGrade("CS5011", "A");
    testGradeRecord.addCourseGrade("CS5012", "A");
    testGradeRecord.addCourseGrade("CS5013", "A");
    testGradeRecord.addCourseGrade("CS5014", "A");


    assertEquals(true, testGoodStanding.getStatus());
    assertEquals(false, testCanGraduate.getStatus());
    assertEquals(true, testCoOp.getStatus());



  }


}
