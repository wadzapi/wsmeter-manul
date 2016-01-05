package org.wadzapi.employeeService.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Сущность предметной области "работник"
 * Используется также для передачи веб-сервисом
 */
@XmlRootElement(name="employee")
public class Employee 
{
	/**
	 * Имя работника
	 */
	private String firstName;

	/**
	 * Фамилия работника
	 */
	private String lastName;

	/**
	 * Идентификатор работника
	 */
	private String employeeId;

	/**
	 * Email
	 */
	private String email;

	/**
	 * Дата наема
	 */
	private String dateOfJoining;

	/**
	 * Название департамента
	 */
	private String department;

	/**
	 * @return имя работника
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName имя работника
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return фамилия работника
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName фамилия работника
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return идентификатор работника
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId идентификатор работника
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return дата наема
	 */
	public String getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining дата наема
	 */
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return название департамента
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department название департамента
	 */
	public void setDepartment(String department) {
		this.department = department;
	}		
}
