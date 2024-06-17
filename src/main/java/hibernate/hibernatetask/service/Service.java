package hibernate.hibernatetask.service;

import java.util.ArrayList;
import java.util.List;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hiberbate.hibernatetask.entity.EmployeeNameDTO;
import hibernate.hibernatetask.dao.Dao;

public class Service {

	private Dao dao = new Dao();
	
	public String insertDepartment(String name ,String location) {
		if(dao.insertDepartment(name, location)==true) {
			return "Department inserted successfully";
		}
		else {
			return "department not inserted....";
		}
	}
	
	public String insertEmployee(String firstName , String lastName , String email,double salary,Department department){
		if(dao.insertEmployee(firstName, lastName, email, salary, department)  ==true) {
			return "Employee inserted successfully";
		}
		else {
			return "Employee not inserted....";
		}
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}
	
	public List<Employee> getEmployeeswithsalarygreaterthan() {
		return dao.getEmployeeswithsalarygreaterthan();
	}
	
	public List<Employee> getEmployeeswithorder() {
		return dao.getEmployeeswithorder();
	}
	
	public List<Department> getDepartmentsWithPagination(int pageNumber, int pageSize) {
		return dao.getDepartmentsWithPagination(pageNumber, pageSize);
	}
	
	public List<Object[]> getEmployeecolumns2() {
		return dao.getEmployeecolumns2();
	}
	
	public Long getEmployeeCount() {
		return dao.getEmployeeCount();
	}
	
	public Double getEmployeeMaxSalary() {
		return dao.getEmployeeMaxSalary();
	}
	public Double getEmployeeSumSalary() {
		return dao.getEmployeeSumSalary();
	}
	public Double getEmployeeAvgSalary() {
		return dao.getEmployeeAvgSalary();
	}
	public List<Department> getDepDistictCount() {
		return dao.getDepDistictCount();
	}
	public List<Object[]> selectSpecificFilds() {
		return dao.selectSpecificFilds();
	}
	public List<EmployeeNameDTO> getFirstAndLastNames(){
		return dao.getFirstAndLastNames();
	}
	public List<Object[]> entityProjection() {
		return dao.entityProjection();
	}
	public List<Object[]>countOfEmployees() {
		return dao.countOfEmployees();
	}
	public List<Object[]>empNameWithDep() {
		return dao.empNameWithDep();
	}
	public List<Employee> fetchAllEmployee() {
		return dao.fetchAllEmployee();
	}
	public List<Department> fetchAllDepartment(){
		return dao.fetchAllDepartment();
	}
	public List<Employee> getEmpWithDep() {
		return dao.getEmpWithDep();
	}
	public List<Employee> joinEmpAndDep() {
		return dao.joinEmpAndDep();
	}
	public List<Employee> getEmpToDepLoc() {
		return dao.getEmpToDepLoc();
	}
	

}
