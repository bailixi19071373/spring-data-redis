package com.mtw.service;

import org.springframework.stereotype.Service;

import com.mtw.pojo.Student;
@Service
public class StudentService implements StudentServiceIn{

	@Override
	public Student addOne(Student stu) {
		// TODO Auto-generated method stub
		System.out.println("新增一个学生");
		return stu;
	}

	@Override
	public Student modOne(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student queryOne(Integer id) {
		// TODO Auto-generated method stub
		return new Student(1, "WWW", 1, null, null);
	}

	@Override
	public void deleteOne(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
