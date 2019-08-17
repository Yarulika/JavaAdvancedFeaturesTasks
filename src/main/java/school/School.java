package school;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class School {
    private String name;
    private ArrayList<Student> studentsCollection;

    public School(String schoolName) {
        this.name = schoolName;
        this.studentsCollection = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) &&
                Objects.equals(studentsCollection, school.studentsCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentsCollection);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !"".equals(name)) {
            this.name = name;
        } else {
            System.out.println("School name is needed");
        }
    }

    public void addStudent(Student newStudent) {
        for (Student stud : studentsCollection) {
            if (stud.getName() == newStudent.getName()) {
                System.out.println("Student is already in school");
                return;
            }
        }
        studentsCollection.add(newStudent);
    }

    public ArrayList<Student> getStudentsCollection() {
        return studentsCollection;
    }

    public void sortStudentsByCreationDate() {
        Comparator<Student> dateComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentCreationDate().compareTo(o2.getStudentCreationDate());
            }
        };
        studentsCollection.sort(dateComparator);
    }

    public void sortStudentsBySumDegree(){
        Comparator<Student> sumDegreeComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getDegreesSum(),o2.getDegreesSum());
            }
        };
        studentsCollection.sort(sumDegreeComparator);
    }

    // preparation for sortedStudentsByDegree(): getting all the subjects for particular student
    public ArrayList<StudentSubject> getSubjectsForStudent(Student student) {
        ArrayList<StudentSubject> subjectsForStudent = new ArrayList<>();
        for (int i = 0; i < student.getSubjectsSelection().size(); i++) {
            StudentSubject stsubj = new StudentSubject(student, student.getSubjectsSelection().get(i));
            subjectsForStudent.add(stsubj);
        }
        return subjectsForStudent;
    }

    // preparation for sortedStudentsByDegree()
    public ArrayList<StudentSubject> getAllStudentsWithSubjects() {
        ArrayList<StudentSubject> allStudentsWithSubjects = new ArrayList<>();
        for (Student student : studentsCollection) {
            ArrayList<StudentSubject> subjectsForEachStudent = getSubjectsForStudent(student);
            allStudentsWithSubjects.addAll(subjectsForEachStudent);
        }
        return allStudentsWithSubjects;
    }

    public ArrayList<StudentSubject> sortedStudentsByDegree() {
        Comparator<StudentSubject> degreeComparator = new Comparator<StudentSubject>() {
            @Override
            public int compare(StudentSubject o1, StudentSubject o2) {
                return Integer.compare(o2.getSubject().getSubjectDegree(), o1.getSubject().getSubjectDegree());
            }
        };
        ArrayList<StudentSubject> sortedStudentsByDegree = getAllStudentsWithSubjects();
        sortedStudentsByDegree.sort(degreeComparator);
        return sortedStudentsByDegree;
    }
}
