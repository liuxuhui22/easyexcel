package cn.alia.dto;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * 创建User类,用于构建向Excel表格中写数据的类型;
 * @ExcelProperty:这个注解是EasyExcel提供,用于生成Excel表格头
 * @Author 夜泊 
 * @BLOG   https://hd1611756908.github.io/
 */
public class User {
	@ExcelProperty("用户编号")
	private Integer userId;
	@ExcelProperty("姓名")
	private String userName;
	@ExcelProperty("性别")
	private String gender;
	@ExcelProperty("工资")
	private Double salary;
	@ExcelProperty("入职时间")
	private Date hireDate;


	public User() {}

	public User(Integer userId, String userName, String gender, Double salary, Date hireDate) {
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", gender='" + gender + '\'' +
				", salary=" + salary +
				", hireDate=" + hireDate +
				'}';
	}




}