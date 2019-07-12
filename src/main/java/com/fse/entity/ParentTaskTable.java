package com.fse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ParentTaskTable")
@NamedQuery(name="ParentTaskTable.getAllTasks", query="from ParentTaskTable")
public class ParentTaskTable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int parentid;
	
	@Column(name="parenttask")
	String parenttask;
	
	@OneToMany(mappedBy="parentTaskTable", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<TaskTable> taskTableList;
	
	public ParentTaskTable() {
		
	}
	public void addTask(TaskTable taskTable) {
		taskTable.setParentTaskTable(this);
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getParenttask() {
		return parenttask;
	}

	public void setParenttask(String parenttask) {
		this.parenttask = parenttask;
	}

	public List<TaskTable> getTaskTableList() {
		return taskTableList;
	}

	public void setTaskTableList(List<TaskTable> taskTableList) {
		this.taskTableList = taskTableList;
	}
	
	
}
