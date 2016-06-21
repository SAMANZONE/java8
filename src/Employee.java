/**
 * Copyright (c) 2005-2011, ShipXpress Inc. (http://shipxpress.com) All Rights Reserved.
 *
 * @author :  saman
 * @Date :  6/17/16
 * @Time :  10:32 AM
 */
public class Employee {

	private int empId;
	private String empName;
	private int age;
	private int salary;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee) o;

		if (empId != employee.empId) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return empId;
	}

	public Employee() {
	}

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public Employee(int empId, String empName, int age, int salary) {
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee doPopulate(Employee e, int add) {

		e.setSalary(e.getSalary()+add);
		return e;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"empId=" + empId +
				", empName='" + empName + '\'' +
				", age=" + age +
				", salary=" + salary +
				'}';
	}
}
