package com.mtw;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtw.config.SpringConfig;
import com.mtw.pojo.Student;
import com.mtw.service.StudentServiceIn;

public class Test {
		public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//		RedisService rs = context.getBean("redisService",RedisService.class);
//		rs.addString("key-1", "aaa");
		StudentServiceIn ss = context.getBean(StudentServiceIn.class);
		Student stu = new Student(1, "aaa", 1, new Date(), new String[] {"music","sport"});
//		ss.addOne(stu);
//		Student s = ss.queryOne(1);
//		System.out.println(s);
		ss.deleteOne(1);
		}
}
