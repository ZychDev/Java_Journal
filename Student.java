
public class Student implements Comparable{

	String Name, Surname;
	StudentCondition StudentStatus;
	Integer BirthYear;
	double PointsNumber;
	
	Student(String Name, String Surname, StudentCondition StudentStatus, Integer BirthYear, double  Points){
	
	this.Name = Name;
	this.Surname = Surname;
	this.StudentStatus = StudentStatus;
	this.BirthYear = BirthYear;
	this.PointsNumber = Points;
	
	}
	
	public void print(){
        System.out.println("\nStudent Info:");
        System.out.println(Name + " " + Surname);
        System.out.println("Year of birth: " + BirthYear);
        System.out.println("Lesson status: " + StudentStatus + ", Points: " + PointsNumber);
        System.out.println("\n");
        
    }

	String getStatus()
	{
		String tmp = "";
		if(this.StudentStatus == StudentCondition.Present)
		{
			tmp = "Present";
			return tmp;
		}
		else if(this.StudentStatus == StudentCondition.Absent)
		{
			tmp = "Absent";
			return tmp;
		}
		else
		{
			tmp = "Sick";
			return tmp;
		}
		
	}

	
    

    public int CompareTo(Student OtherStudent) {
        return Surname.equals(OtherStudent.Surname) ? 1 : 0;
    }

}
