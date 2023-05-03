package Model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "user_data")
public class User
{
@Column(name = "name")
  private String name;
@Column(name = "position")
  private String position;
@Column(name = "office")
  private String office;
@Column(name = "age")
  private int age;
@Column(name = "startdate")
  private Date startDate;
@Column(name = "salary")
  private double salary;


	
  
  
public String getName()
{
	return name;
}
public void setName(String name) 
{
	this.name = name;
}
public String getPosition() 
{
	return position;
}
public void setPosition(String position) 
{
	this.position = position;
}
public String getOffice()
{
	return office;
}
public void setOffice(String office)
{
	this.office = office;
}
public int getAge()
{
	return age;
}
public void setAge(int age)
{
	this.age = age;
}
public Date getStartDate()
{
	return startDate;
}
public void setStartDate(Date startDate) 
{
	this.startDate = startDate;
}
public double getSalary()
{
	return salary;
}
public void setSalary(double salary)
{
	this.salary = salary;
}

}
