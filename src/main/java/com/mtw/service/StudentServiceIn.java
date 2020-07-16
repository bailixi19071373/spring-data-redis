package com.mtw.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.mtw.pojo.Student;

public interface StudentServiceIn {
		@CachePut(value = "student", key = "#result.id")
		Student addOne(Student stu);
		@CachePut(value = "student", key = "#result.id")
		Student modOne(Student stu);
		@Cacheable("student")
		Student queryOne(Integer id);
		@CacheEvict(value = "student")
		void deleteOne(Integer id);
}
