package school;

import java.util.Date;
import java.util.Objects;

public class Subject {
    private SubjectTitle subjectTitle;
    private int subjectDegree;
    private Date examDate;

    public Subject(SubjectTitle subjectTitle) {
        this(subjectTitle, 0, new Date());
    }

    public Subject(SubjectTitle subjectTitle, int subjectDegree, Date examDate) {
        this.subjectTitle = subjectTitle;
        this.subjectDegree = subjectDegree;
        this.examDate = examDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectDegree == subject.subjectDegree &&
                subjectTitle == subject.subjectTitle &&
                Objects.equals(examDate, subject.examDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectTitle, subjectDegree, examDate);
    }

    public SubjectTitle getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(SubjectTitle subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public int getSubjectDegree() {
        return subjectDegree;
    }

    public void setSubjectDegree(int subjectDegree) {
        this.subjectDegree = subjectDegree;
        this.examDate = new Date();
    }

    public Date getExamDate() {
        return examDate;
    }

    public boolean getSubjectIsPassed() {
        return this.subjectDegree >= 50;
    }
}
