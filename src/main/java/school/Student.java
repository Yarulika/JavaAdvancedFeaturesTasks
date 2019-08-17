package school;

import java.util.*;

public class Student {
    private String name;
    private int age;
    private String address;
    private ArrayList<Subject> subjectsSelection;
    private Date studentCreationDate;

    public Student(String name, int age, String address) {
        this(name, age, address, new Date());
    }

    public Student(String name, int age, String address, Date creationDate) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.subjectsSelection = new ArrayList<>();
        this.studentCreationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address) &&
                Objects.equals(subjectsSelection, student.subjectsSelection) &&
                Objects.equals(studentCreationDate, student.studentCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address, subjectsSelection, studentCreationDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName != null && !"".equals(newName)) {
            this.name = newName;
        } else {
            System.out.println("Fill in the student name");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge > 5) {
            this.age = newAge;
        } else {
            System.out.println("Too young for school");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        if (newAddress != null & !"".equals(newAddress)) {
            address = newAddress;
        } else {
            System.out.println("Fill in student's address");
        }
    }

    public Date getStudentCreationDate() {
        return studentCreationDate;
    }

    public ArrayList<Subject> getSubjectsSelection() {
        return subjectsSelection;
    }

    public int getDegreesSum(){
        int degreesSum = 0;
        if (subjectsSelection.size() > 0){
            for (int i = 0; i < subjectsSelection.size(); i++) {
                degreesSum += subjectsSelection.get(i).getSubjectDegree();
            }
        }
        return degreesSum;
    }

    public void registerSubject(Subject newSubject) {
        if (subjectsSelection.size() == 5) {
            System.out.println("Subject cannot be added: max number of subjects = 5");
            return;
        }
        for (Subject s : subjectsSelection) {
            if (s.getSubjectTitle() == newSubject.getSubjectTitle()) {
                System.out.println("This subject (" + newSubject.getSubjectTitle() + ") was already selected for student");
                return;
            }
        }
        subjectsSelection.add(newSubject);
    }

    public void registerDegree(SubjectTitle subjectTitle, int subjectDegree) {
        for (Subject sub : subjectsSelection) {
            if (sub.getSubjectTitle() == subjectTitle) {
                sub.setSubjectDegree(subjectDegree);
                return;
            }
        }
        System.out.println("Subject title not found");
    }

    public void registerRundomSubjectsWithDegree() {
        for (int i = 0; i < 5; i++) {
            int randomID = new Random().nextInt(SubjectTitle.values().length);
            SubjectTitle randomTitle = SubjectTitle.values()[randomID];
            Subject subj = new Subject(randomTitle);
            subjectsSelection.add(subj);
            int randomDegree = new Random().nextInt(100);
            subj.setSubjectDegree(randomDegree);
        }
    }
}
