package com.fse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.TaskManagerDao;
import com.fse.entity.ParentTaskTable;
import com.fse.model.ParentTask;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{

	@Autowired
	TaskManagerDao taskManagerDao;
	@Override
	public String addTask(ParentTaskTable ptt) {
		
		return taskManagerDao.addTask(ptt);
	}
	@Override
	public List<ParentTask> getAllTasks() {
		return taskManagerDao.getAllTasks();
		
	}

	
}
