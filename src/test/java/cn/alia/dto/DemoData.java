package cn.alia.dto;

import java.util.Date;

/**
 * 承装Excel表格数据的类
 * 注意点: Java类中的属性的顺序和Excel中的列头的顺序是相同的
 * @Author 夜泊 
 * @BLOG   https://hd1611756908.github.io/
 */
public class DemoData {
    
	private String name;
	private Date hireDate;
	private Double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "DemoData{" +
				"name='" + name + '\'' +
				", hireDate=" + hireDate +
				", salary=" + salary +
				'}';
	}
}