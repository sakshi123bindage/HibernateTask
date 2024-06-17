package hiberbate.hibernatetask;

import java.util.ArrayList;
import java.util.List;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hiberbate.hibernatetask.entity.EmployeeNameDTO;
import hibernate.hibernatetask.controller.Controller;

/**
 * Hello world!
 *
 */

public class App 
{
	
	
    public static void main( String[] args )
    {
    	// Department department = new Department();
    	// department.setId(3);
//         
        Controller controller = new Controller();
       // controller.insertDepartment("support", "kataraj");
       // controller.insertEmployee("Vighnesh", "Upadhe", "Vighnesh@gmail.com", 25000.0, department);
    	
//    	Controller controller = new Controller();
//    	List<Employee> list =controller.getEmployeeswithorder();
//    	System.out.println(list);
    	
    	
//        // Fetch departments with pagination
//        int pageNumber = 1; // Example: page 1
//        int pageSize = 4; // Example: 10 departments per page
//        List<Department> departments = controller.getDepartmentsWithPagination(pageNumber, pageSize);
//
//        // Print the paginated list of departments
//        System.out.println("Departments (Page " + pageNumber + ", Page Size " + pageSize + "):");
//        for (Department department : departments) {
//            System.out.println(department.getName());
//        }
    	
    	
    	
//    	List<Object[]> list =controller.getEmployeecolumns2();
//    	for (Object[] row : list) {
//            String firstName = (String) row[0];
//            String lastName = (String) row[1];
//            System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
//        }/
    	
    	
//    	long results =controller.getEmployeeCount();
//    	
//    	System.out.println(results);
    	
//    	Controller controller = new Controller();
//    	Double results = controller.getEmployeeMaxSalary();
//    	System.out.println(results);
        
//        Double result=controller.getEmployeeSumSalary();
//        System.out.println(result);

//       Double result=controller.getEmployeeAvgSalary();
//        System.out.println(result);
        
//        List<Department>result=controller.getDepDistictCount();
//       System.out.println(result);
        
/*        List<Object[]> list =controller.selectSpecificFilds();
    	for (Object[] row : list) {
           String firstName = (String) row[0];
           String lastName = (String) row[1];
           System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
        }
        List<EmployeeNameDTO> list =controller.getFirstAndLastNames();
    	System.out.println(list);
        
        List<Object[]> list =controller.entityProjection();
    	for (Object[] row : list) {
    	    long id=(long)row[0];
           String firstName = (String) row[1];
           System.out.println("Id:"+id+ "First Name: " + firstName);
        }*/
        
        List<Object[]> list =controller.countOfEmployees();
    	for (Object[] row : list) {
           System.out.println(row);
        }
    }
}
