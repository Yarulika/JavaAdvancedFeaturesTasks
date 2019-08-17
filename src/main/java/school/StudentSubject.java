package school;

import java.util.Objects;

public class StudentSubject {
    private Student student;
    private Subject subject;

    public StudentSubject(Student student, Subject subject) {
        this.student= student;
        this.subject= subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSubject that = (StudentSubject) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, subject);
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }
}
