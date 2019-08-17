package school;

public class MainSchool {

    public static void main(String args[]){
        School sdaSchool = new School("SDA");
        System.out.println("==========================================================");
        System.out.println("School: " + sdaSchool.getName());
        System.out.println("==========================================================");
        Student studentOne = new Student("Bikram", 19,"Espoo, Katu 4" );
        Student studentTwo = new Student("Muhammed",18,"Helsinki, Katu 1");
        Student studentThree = new Student("Max",17,"Vantaa, Katu 22");
        Student studentFour = new Student("Alex", 18,"Katu 54");
        sdaSchool.addStudent(studentOne);
        sdaSchool.addStudent(studentTwo);
        sdaSchool.addStudent(studentThree);
        sdaSchool.addStudent(studentFour);

        for (Student stu: sdaSchool.getStudentsCollection()){
            System.out.println("Name: " + stu.getName() + "; Age: " + stu.getAge() );
        }

        studentOne.registerSubject(new Subject(SubjectTitle.ALGEBRA));
        studentOne.registerSubject(new Subject(SubjectTitle.DESIGN));
        studentOne.registerSubject(new Subject(SubjectTitle.BIOLOGY));
        studentOne.registerSubject(new Subject(SubjectTitle.GEOMETRY));
        studentOne.registerSubject(new Subject(SubjectTitle.IT));
        studentOne.registerDegree(SubjectTitle.ALGEBRA, 50);
        studentOne.registerDegree(SubjectTitle.DESIGN,30);
        studentOne.registerDegree(SubjectTitle.BIOLOGY,70);
        studentOne.registerDegree(SubjectTitle.GEOMETRY,90);
        studentOne.registerDegree(SubjectTitle.IT,100);
        System.out.println("==========================================================");
        System.out.println("Subjects and degrees for student: "+ studentOne.getName());
        for (Subject subj: studentOne.getSubjectsSelection()) {
            System.out.println(subj.getSubjectTitle() + ": " + + subj.getSubjectDegree());
        }
        System.out.println("SUM= " + studentOne.getDegreesSum());

        studentTwo.registerSubject(new Subject(SubjectTitle.IT));
        studentTwo.registerSubject(new Subject(SubjectTitle.ECONOMICS));
        studentTwo.registerSubject(new Subject(SubjectTitle.PHYSICS));
        studentTwo.registerSubject(new Subject(SubjectTitle.SPORT));
        studentTwo.registerSubject(new Subject(SubjectTitle.CHEMISTRY));
        studentTwo.registerDegree(SubjectTitle.IT, 60);
        studentTwo.registerDegree(SubjectTitle.ECONOMICS, 10);
        studentTwo.registerDegree(SubjectTitle.PHYSICS, 90);
        studentTwo.registerDegree(SubjectTitle.SPORT, 20);
        studentTwo.registerDegree(SubjectTitle.CHEMISTRY, 80);
        System.out.println("==========================================================");
        System.out.println("Subjects and degrees for student: "+ studentTwo.getName());
        for (Subject subj: studentTwo.getSubjectsSelection()) {
            System.out.println(subj.getSubjectTitle() + ": " + + subj.getSubjectDegree());
        }
        System.out.println("SUM= " + studentTwo.getDegreesSum());
        System.out.println("==========================================================");
        System.out.println("Sorted by SUM degree: ");
        sdaSchool.sortStudentsBySumDegree();
        for (Student stu: sdaSchool.getStudentsCollection()){
            System.out.println(stu.getName() + " " + stu.getDegreesSum());
        }
        System.out.println("==========================================================");
        System.out.println("Sorted collection by degree: ");
        for (StudentSubject stusubj2: sdaSchool.sortedStudentsByDegree()){
            System.out.println(stusubj2.getStudent().getName() + " " + stusubj2.getSubject().getSubjectTitle() + " " + stusubj2.getSubject().getSubjectDegree());
        }
    }
}
