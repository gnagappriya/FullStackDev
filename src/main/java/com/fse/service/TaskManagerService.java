package com.fse.service;

import java.util.List;

import com.fse.entity.ParentTaskTable;
import com.fse.model.ParentTask;

public interface TaskManagerService {
	public String addTask(ParentTaskTable ptt);
	
	public List<ParentTask> getAllTasks();
}
