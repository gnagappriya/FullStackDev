package com.fse.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TaskTable")
public class TaskTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int taskid;
	
	
	
	@Column(name="task")
	String task;
	
	
	@Column(name="startdate")
	String startdate;
	
	@Column(name="enddate")
	String enddate;
	
	
	@Column(name="priority")
	String priority;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="parentid")
	ParentTaskTable parentTaskTable;
	
	public TaskTable() {
		
	}
	

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public ParentTaskTable getParentTaskTable() {
		return parentTaskTable;
	}

	public void setParentTaskTable(ParentTaskTable parentTaskTable) {
		this.parentTaskTable = parentTaskTable;
	}
	
	
	
}
