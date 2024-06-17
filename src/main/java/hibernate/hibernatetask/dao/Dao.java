package hibernate.hibernatetask.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.sql.JoinType;

import hiberbate.hibernatetask.entity.Department;
import hiberbate.hibernatetask.entity.Employee;
import hiberbate.hibernatetask.entity.EmployeeNameDTO;
import hibernate.hibernatetask.configuration.HibernateConfig;

public class Dao {

	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public boolean insertDepartment(String name ,String location) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
        
		Department department = new Department();
		department.setName(name);
		department.setLocation(location);
		session.save(department);
		transaction.commit();

		session.close();
		return true;
	}
	
	public boolean insertEmployee(String firstName , String lastName , String email,double salary,Department department) {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
        
		Employee employee = new Employee();
		
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setSalary(salary);
		employee.setDepartment(department);
		session.save(employee);
		transaction.commit();

		session.close();
		return true;
		
		
	}

	public List<Employee> getAllEmployees() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);

		List<Employee> list = criteria.list();


		transaction.commit();
		session.close();
		return list;
	}
	
	public List<Employee> getEmployeeswithsalarygreaterthan() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 50000.0));
		List<Employee> list = criteria.list();


		transaction.commit();
		session.close();
		return list;
	}
	
	public List<Employee> getEmployeeswithorder() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("lastName"));
		List<Employee> list = criteria.list();


		transaction.commit();
		session.close();
		return list;
	}
	
	public List<Department> getDepartmentsWithPagination(int pageNumber, int pageSize) {
        Session session = factory.openSession();
        try {
            // Create Criteria Query
            Query<Department> query = session.createQuery("FROM Department", Department.class);

            // Calculate starting index for pagination
            int firstResult = (pageNumber - 1) * pageSize;

            // Apply pagination
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);

            // Execute query and return results
            return query.getResultList();
        } finally {
            session.close();
        }
    }
	
	public List<Department> getEmployeeColumns(int pageNumber, int pageSize) {
        Session session = factory.openSession();
        try {
            // Create Criteria Query
            Query<Department> query = session.createQuery("FROM Department", Department.class);

            // Calculate starting index for pagination
            int firstResult = (pageNumber - 1) * pageSize;

            // Apply pagination
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);

            // Execute query and return results
            return query.getResultList();
        } finally {
            session.close();
        }
    }
	
	public List<Object[]> getEmployeecolumns2() {
        Session session = factory.openSession();
 
        Query<Object[]> criteriaQuery =session.createQuery("select firstName,lastName from Employee",Object[].class);
        return criteriaQuery.list();
    }
	
	public Long getEmployeeCount() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.count("id"));
		List<Long> countlist = criteria.list();

		session.close();

		for (Long count : countlist) {

			return count;
		}

		return (long) 0;

	}
	
	
	public Double getEmployeeMaxSalary() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("salary"));
		List<Double> maxlist = criteria.list();

		session.close();

		for (Double max : maxlist) {
			 return max;
		}
	

		return null;
	}
	
	public Double getEmployeeSumSalary()
	{
		Session session=factory.openSession();
		Transaction transcation=session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.setProjection(Projections.sum("salary"));
		List<Double> salarySum=criteria.list();
		transcation.commit();
		session.close();
		
		for(Double salary:salarySum)
		{
			return salary;
		}
		return null;
	}
	public Double getEmployeeAvgSalary()
	{
		Session session=factory.openSession();
		Transaction transcation=session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		List<Double> salarySum=criteria.list();
		transcation.commit();
		session.close();
		
		for(Double salary:salarySum)
		{
			return salary;
		}
		return null;
	}
	public List<Department> getDepDistictCount()
	{
		Session session=factory.openSession();
		Transaction transcation=session.beginTransaction();
		Criteria criteria=session.createCriteria(Department.class);
		criteria.setProjection(Projections.countDistinct("name"));
		return criteria.list();
		
	}
	public List<Object[]> selectSpecificFilds()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.projectionList().add(Projections.property("firstName")).add(Projections.property("lastName")));
	    List<Object[]> list=criteria.list();
	    transaction.commit();
	    return list;
	}
	
	public List<EmployeeNameDTO> getFirstAndLastNames()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<EmployeeNameDTO> results = null;
        String hql = "select new EmployeeNameDTO(e.firstName, e.lastName) from Employee e";
        Query<EmployeeNameDTO> query = session.createQuery(hql, EmployeeNameDTO.class);
        results = query.getResultList();
        transaction.commit();
        return results;
	}
	public List<Object[]> entityProjection()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.projectionList().add(Projections.property("id")).add(Projections.property("firstName")));
	    List<Object[]> list=criteria.list();
	    transaction.commit();
	    return list;
	}
	
	public List<Object[]> countOfEmployees()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("department")).add(Projections.rowCount(),"employeeCount"));
        List<Object[]> list=criteria.list();
        transaction.commit();
        session.close();
        return list;
	}
	
	public List<Object[]> empNameWithDep()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("Department", "dept");
        criteria.setProjection(Projections.projectionList().add(Projections.property("firstName"),"firstName").add(Projections.property("lastName"),"lastName")
        		.add(Projections.property("dept.name"),"departmentName"));
        List<Object[]> results=criteria.list();
        transaction.commit();
        return results;
	}
	
	public List<Employee> fetchAllEmployee()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setFetchMode("Department", FetchMode.JOIN);
        List<Employee> employees=criteria.list();
        transaction.commit();
        session.close();
        return employees;
	}
	public List<Department> fetchAllDepartment()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Department.class);
        criteria.createAlias("Employee", "employee",JoinType.LEFT_OUTER_JOIN);
        List<Department> department=criteria.list();
        transaction.commit();
        session.close();
        return department;
	}
	public List<Employee> getEmpWithDep()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setFetchMode("Department", FetchMode.JOIN);
        List<Employee> employees=criteria.list();
        transaction.commit();
        session.close();
        return employees;
	}
	public List<Employee> joinEmpAndDep()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("Department","dept");
        criteria.createAlias("dept.project","proj");
        List<Employee>employee=criteria.list();
        transaction.commit();
        session.close();
        return employee;
	}
	public List<Employee> getEmpToDepLoc()
	{
		Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("Depatment", "dept");
        criteria.add(Restrictions.eq("dept.location", "New York"));
        List<Employee>employee=criteria.list();
        transaction.commit();
        session.close();
        return employee;
	}
}
