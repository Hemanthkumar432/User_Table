package com.user.table.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

}