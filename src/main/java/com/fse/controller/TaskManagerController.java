package com.fse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fse.entity.ParentTaskTable;
import com.fse.entity.TaskTable;
import com.fse.model.ParentTask;
import com.fse.model.TaskManager;
import com.fse.service.TaskManagerService;



@RestController
@RequestMapping("taskManager")
@CrossOrigin(origins="*", allowedHeaders="*")
public class TaskManagerController {
	@Autowired
	TaskManagerService taskManagerService;
	
	
	@PostMapping("addTask")
	public ResponseEntity<TaskManager> addTask(@RequestBody TaskManager taskManager, UriComponentsBuilder builder) {
		
		ParentTaskTable ptt = new ParentTaskTable();
		TaskTable tt = new TaskTable();
		tt.setTask(taskManager.getTask());
		tt.setStartdate(taskManager.getStartdate());
		tt.setEnddate(taskManager.getEnddate());
		tt.setPriority(taskManager.getPriority());
		ptt.setTaskTableList(Arrays.asList(tt));
		
		ptt.addTask(tt);
		ptt.setParenttask(taskManager.getParenttask());
		String response = taskManagerService.addTask(ptt);
		//if(taskManager.getParenttask().equals(response)) {
		return new ResponseEntity<TaskManager>(taskManager, HttpStatus.CREATED);
		//}
		//return new ResponseEntity<TaskManager>(taskManager, HttpStatus.EXPECTATION_FAILED);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("getAllTasks")
	public List<ParentTask> getAllTasks(){
		List<ParentTask> allTasks = taskManagerService.getAllTasks();
		return (List<ParentTask>) new ResponseEntity<List<ParentTask>>(allTasks,HttpStatus.CREATED);
	}
}
