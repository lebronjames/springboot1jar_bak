package com.zhuowang.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhuowang.entity.Student;
import com.zhuowang.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public List<Student> getList(){
		logger.info("从数据库读取student列表");
		return studentService.getList();
	}
}
