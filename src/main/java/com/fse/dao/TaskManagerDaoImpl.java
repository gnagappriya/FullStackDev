package com.fse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.entity.ParentTaskTable;
import com.fse.entity.TaskTable;
import com.fse.model.ChildTask;
import com.fse.model.ParentTask;

@Repository
@Transactional
public class TaskManagerDaoImpl implements TaskManagerDao{

	 @Autowired
	 private SessionFactory sessionFactory;
	@Override
	public String addTask(ParentTaskTable ptt) {
		sessionFactory.getCurrentSession().saveOrUpdate(ptt);
		return ptt.getParenttask();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ParentTask> getAllTasks() {
		
		List<ParentTaskTable> pt =sessionFactory.getCurrentSession().createNamedQuery("ParentTaskTable.getAllTasks", ParentTaskTable.class).list();
		List<ParentTask> ptask = new ArrayList<>();
		for(ParentTaskTable ptt : pt) {
			ParentTask parentTask = new ParentTask();
			parentTask.setParentTask(ptt.getParenttask());
			ChildTask childTask = new ChildTask();
			for(TaskTable tt: ptt.getTaskTableList()) {
				childTask.setTask(tt.getTask());
				childTask.setPriority(tt.getPriority());
				childTask.setStartdate(tt.getStartdate());
				childTask.setEnddate(tt.getEnddate());
				parentTask.setChildTask(childTask);
				ptask.add(parentTask);
			}
				
		}
		return (List<ParentTask>) ptask;
		
	}

	
}
