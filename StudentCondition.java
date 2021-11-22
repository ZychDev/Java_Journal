
public enum StudentCondition { 
  Present { 
	public String toString() { 
      		return "Present"; 
		} 
	},
	
  Absent { 
	public String toString() { 
      return "Absent"; 
    } 
  },
  Sick { 
	public String toString() { 
      return "Sick"; 
    } 
  }
 
}
