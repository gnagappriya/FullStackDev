package com.fse.dao;

import java.util.List;

import com.fse.entity.ParentTaskTable;
import com.fse.model.ParentTask;

public interface TaskManagerDao {
	public String addTask(ParentTaskTable ptt);
	public List<ParentTask> getAllTasks();
}
