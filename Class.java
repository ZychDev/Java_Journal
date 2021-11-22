import java.util.*;

public class Class {

    String group;
    List<Student> students = new ArrayList<>();
    int size;

    Class(String group, int size) {
        this.group = group;
        this.size = size;
    }
    Class()
    {
        this.group = group;
        this.size = size;
    }

    void addStudent(Student newStudent) {
        for (Student student : students) {
            if (student.Name.equals(newStudent.Name))
                System.err.println("Student with that Name exists :(");
        }

        if (students.size() >= size) System.out.println("Student list full");
        else students.add(newStudent);
    }

    void addPoints(Student student, double points) {
        student.PointsNumber += points;
    }

    Student getStudent(Student student) {
        for (Student s : students) 
        {
            if (s.PointsNumber <= 0) {
            	s = null;
            }
            else{
            	students.remove(1);
            }
        }
        return null;
    }

    Class DeleteStudent(String name, String surname, Class obiekt)
    {
        int counter = 0;
        for (Student s : obiekt.students) 
        {
            System.out.println(counter);

            System.out.println("IMIE: "+ s.Name + "DO USUNIECIA: "+ name);
            System.out.println("IMIE: " + s.Surname + "DO USUNIECIA: "+ surname);

            boolean areEqual = s.Name.equals(name);

            if (areEqual) 
            {
                System.out.println("Usuwam");
                System.out.println(s.Name);
                System.out.println(s.Surname);
                System.out.println("MOJA LICZBA");
                System.out.println(counter);

                obiekt.students.remove(counter);
                break;

            }
            counter++;
            
            
        }

        System.out.println("CZY ZOSTAL USUNIETY?");
        for (Student s : obiekt.students) 
        {
            System.out.println(s);

            
        }

        return obiekt;
    }

    Class getKlasa()
    {
        return new Class();
    }




    void changeCondition(Student student, StudentCondition condition) {
        student.StudentStatus = condition;
    }

    void removePoints(Student student, double points) {
        student.PointsNumber -= points;
        if (student.PointsNumber < 0) student.PointsNumber = 0;
    }

    public int compare(String s1, String s2) {
        return s1.equals(s2) ? 1 : 0;
    }

    Student search(String Surname) {
        Student result = null;
        for (Student student : students) {
            if (this.compare(Surname, student.Surname) == 1) result = student;
        }
        return result;
    }

    List<Student> searchPartial(String part) {
    
        ArrayList matchingStudents = new ArrayList<>();
        
        for (Student student : students) {
            if (student.Surname.contains(part)) matchingStudents.add(student);
        }
        return matchingStudents;
    }

    int countByCondition(StudentCondition condition) {
        int count = 0;
        for (Student student : students) {
            if (student.StudentStatus == condition) count++;
        }
        return count;
    }

    void summary() {

        System.out.println(this.group);
        for (Student student : students) {
            System.out.println(String.format("%s %s %s %d %.2f", student.Name,
                    student.Surname, student.StudentStatus, student.BirthYear, student.PointsNumber));
        }
        System.out.println("\n");

    }

    List<Student> sortByName() {
        List<Student> list = students;
        Collections.sort(list, Comparator.comparing((Student student) -> student.Name));
        return list;
    }

    static class pointsComparator implements Comparator<Student>
    {
        public int compare(Student s1, Student s2)
        {
            if(s1.PointsNumber-s2.PointsNumber > 0) return -1;
            else if(s1.PointsNumber == 0) return 0;
            else return 1;
        }
    }

    List<Student> sortByPoints() {
        List<Student> list = students;
        Collections.sort(list, new pointsComparator());
        return list;
    }

    Student max(){
        Student student = Collections.max(students, Comparator.comparingDouble(s -> s.PointsNumber));
        return student;
    }

    int getStudentCount(){
        return students.size();
    }

    String getGroupName(){
        return this.group;
    }

    String[][] GUI_Output() 
    {
        String[][] array_name = new String[this.getStudentCount()][3];
        int counter = 0;
        for (Student student : students) 
        {
            array_name[counter][0] = student.Name;
            array_name[counter][1] = student.Surname;
            array_name[counter][2] = student.getStatus();

            counter++;
        }

        for (int i = 0; i < array_name.length; i++) 
        {
            for (int j=0; j<array_name[i].length; j++)
            {
                System.out.println(array_name[i][j]);

            }
        }

        return array_name;

    }



}
