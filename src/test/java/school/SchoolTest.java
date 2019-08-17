package school;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void addStudentFirstTime() {
        School s = new School("aaa");
        s.addStudent(new Student("a", 19, "a"));
        Assert.assertEquals(s.getStudentsCollection().size(), 1);
    }

    @Test
    public void addStudentAsSecondItem() {
        School s = new School("aaa");
        s.addStudent(new Student("a", 19, "a"));
        s.addStudent(new Student("b", 19, "a"));
        Assert.assertEquals(s.getStudentsCollection().size(), 2);
    }

    @Test
    public void addStudentDuplicateFail() {
        School s = new School("sch");
        s.addStudent(new Student("a", 17, "aa"));
        s.addStudent(new Student("a", 18, "bb"));
        Assert.assertEquals(s.getStudentsCollection().size(), 1);
    }

    @Test
    public void sortStudentsByCreationDate() {
        School s = new School("sch");
        s.addStudent(new Student("a", 20, "aa", Date.from(Instant.parse("2007-12-03T10:15:30.00Z"))));
        s.addStudent(new Student("aa", 22, "bb", Date.from(Instant.parse("2007-11-03T10:15:30.00Z"))));
        s.addStudent(new Student("aaa", 21, "bb", Date.from(Instant.parse("2007-10-03T10:15:30.00Z"))));
        s.sortStudentsByCreationDate();
        Assert.assertEquals(s.getStudentsCollection().size(), 3);
        for (int i = 0; i < s.getStudentsCollection().size() - 1; i++) {
            Assert.assertTrue(s.getStudentsCollection().get(i).getStudentCreationDate().before(s.getStudentsCollection().get(i + 1).getStudentCreationDate()));
        }
    }

    @Test
    public void getSubjectsForStudent() {
        School s = new School("sch");
        Student stu = new Student("a", 20, "aa");
        ArrayList<Subject> subjs = new ArrayList<>();
        subjs.add(new Subject(SubjectTitle.CHEMISTRY));
        subjs.add(new Subject(SubjectTitle.BIOLOGY));
        subjs.add(new Subject(SubjectTitle.PHYSICS));
        subjs.add(new Subject(SubjectTitle.IT));
        for (Subject eachSub : subjs) {
            stu.registerSubject(eachSub);
        }
        ArrayList<StudentSubject> expectedSubjsForStudent = new ArrayList<>();
        for (int i = 0; i < subjs.size(); i++) {
            expectedSubjsForStudent.add(new StudentSubject(stu, subjs.get(i)));
        }
        ArrayList<StudentSubject> gotSubjectsForStudent = s.getSubjectsForStudent(stu);
        Assert.assertEquals(gotSubjectsForStudent, expectedSubjsForStudent);
    }

    public void sortedStudentsByDegree(){
        //TODO
//        Student s = new Student("a",20,"aa");
//        Subject ss = new Subject(SubjectTitle.CHEMISTRY);
//        StudentSubject a = new StudentSubject(s, ss);
//        StudentSubject b = new StudentSubject(s, ss);
//        Assert.assertEquals(a, b);
//        School sch = new School("SDA");
//        Student stu = new Student("a", 20, "aa");
//        ArrayList<Subject> subjs = new ArrayList<>();
//        subjs.add(new Subject(SubjectTitle.CHEMISTRY,20, Date.from(Instant.now())));
//        subjs.add(new Subject(SubjectTitle.BIOLOGY));
//        subjs.add(new Subject(SubjectTitle.PHYSICS));
//        subjs.add(new Subject(SubjectTitle.IT));
    }
}
