package hiberbate.hibernatetask.entity;

import javax.persistence.Entity;

@Entity
public class EmployeeNameDTO 
{
	private String firstName;
    private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "EmployeeNameDTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

    
}
