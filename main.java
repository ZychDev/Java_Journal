

// Glowna funkcja programu

// Student : print() - wypisuje info o studencie  , CompareTo(Student OtherStudent) - porownoje do innego studenta 
// StudentCondition: typ wyliczeniowy 
// Comparable : porownanie 2 studentow

public class main{

	public static void main(String[] args) {
        
        // dodawanie studentow 
        Student student1 = new Student("Szymon", "Zych", StudentCondition.Absent, 2000, 10.0); 			
        Student student2 = new Student("Jan", "Zych", StudentCondition.Absent, 1999, 5.0);
		Student student3 = new Student("Matuesz", "Matczak", StudentCondition.Absent, 1998, 2.0);
		Student student4 = new Student("Szymon", "Entyk", StudentCondition.Present, 1997, 15.0);
		Student student5 = new Student("Jan", "Rapowanie", StudentCondition.Present, 2001, 5.0);
		Student student6 = new Student("Mateusz", "Ksyrejowicz", StudentCondition.Present, 1999, 13.0);
        //student1.print();


        // stworzenie klasy uczniow 
        Class ClassA = new Class("Class A", 15);
        ClassA.addStudent(student1);
        ClassA.addStudent(student2);
        //ClassA.summary();

        Class ClassB = new Class("Class B", 10);
        ClassB.addStudent(student3);
        ClassB.addStudent(student4);
        ClassB.addStudent(student5);
        ClassB.addStudent(student6);
    
        Class ClassC = new Class("Class C", 10);

        //ClassB.summary();


        // tworzenie miejsca na klasy 
        ClassContainer Group = new ClassContainer();
		Group.addClass(ClassA.group, ClassA);
        Group.addClass(ClassB.group, ClassB);
        Group.addClass(ClassC.group, ClassC);

        //Group.summary();


        // Swing start 
		SwingWindow test = new SwingWindow(Group);

    }

}