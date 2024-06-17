package hibernate.hibernatetask.controller;

import java.util.ArrayList;
import java.util.List;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hiberbate.hibernatetask.entity.EmployeeNameDTO;
import hibernate.hibernatetask.service.Service;

public class Controller {
	
  private Service service = new Service();
	
  public String insertDepartment(String name ,String location) {
	  return service.insertDepartment(name, location);
  }
  
  public String insertEmployee(String firstName , String lastName , String email,double salary,Department department){
	  return service.insertEmployee(firstName, lastName, email, salary, department);
  }

public List<Employee> getAllEmployees() {
	return service.getAllEmployees();
	
}

public List<Employee> getEmployeeswithsalarygreaterthan() {
	return service.getEmployeeswithsalarygreaterthan();
}

public List<Employee> getEmployeeswithorder() {
	return service.getEmployeeswithorder();
}

public List<Department> getDepartmentsWithPagination(int pageNumber, int pageSize) {
	return service.getDepartmentsWithPagination(pageNumber, pageSize);
}

public List<Object[]> getEmployeecolumns2() {
	return service.getEmployeecolumns2();
}

public Long getEmployeeCount() {
	return service.getEmployeeCount();
}

public Double getEmployeeMaxSalary() {
	return service.getEmployeeMaxSalary();
}

public Double getEmployeeSumSalary() {
	return service.getEmployeeSumSalary();
}
public Double getEmployeeAvgSalary() {
	return service.getEmployeeAvgSalary();
}
public List<Department> getDepDistictCount() {
	return service.getDepDistictCount();
}
public List<Object[]> selectSpecificFilds() {
	return service.selectSpecificFilds();
}
public List<EmployeeNameDTO> getFirstAndLastNames() {
	return service.getFirstAndLastNames();
}
public List<Object[]> entityProjection() {
	return service.entityProjection();
}
public List<Object[]> countOfEmployees() {
	return service.countOfEmployees();
}
public List<Object[]> empNameWithDep() {
	return service.empNameWithDep();
}
public List<Employee> fetchAllEmployee() {
	return service.fetchAllEmployee();
}
public List<Department> fetchAllDepartment(){
	return service.fetchAllDepartment();
}
public List<Employee> getEmpWithDep() {
	return service.getEmpWithDep();
}
public List<Employee> joinEmpAndDep() {
	return service.joinEmpAndDep();
}
public List<Employee> getEmpToDepLoc() {
	return service.getEmpToDepLoc();
}
}
