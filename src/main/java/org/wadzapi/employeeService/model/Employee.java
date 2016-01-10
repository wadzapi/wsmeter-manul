package org.wadzapi.employeeService.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Сущность предметной области "работник"
 * Используется также для передачи веб-сервисом
 */
@XmlRootElement(name="employee")
public class Employee {
	/**
	 * Идентификатор работника
	 */
	private String employeeId;
	/**
	 * Имя работника
	 */
	private String firstName;
	/**
	 * Фамилия работника
	 */
	private String lastName;
	/**
	 * Дата рождения
	 */
	private String birthDate;
	/**
	 * Дата наема
	 */
	private String hireDate;
	/**
	 * Дата увольнения
	 */
	private String leaveDate;
	/**
	 * Название департамента
	 */
	private List<String> departments;

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
	 * @return дата рождения
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate дата рождения
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return дата наема
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate дата наема
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return дата увольнения
	 */
	public String getLeaveDate() {
		return leaveDate;
	}

	/**
	 * @param leaveDate дата увольнения
	 */
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	/**
	 * @return название департамента
	 */
	public List<String> getDepartments() {
		return departments;
	}

	/**
	 * @param departments название департамента
	 */
	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}		
}
