package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.Student;
//@Component
public class StudentDaoImpl implements StudentDao {
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
//@Autowired
	private JdbcTemplate template;

	public int insert(Student student) {
		  String query="insert into student (id,name,city) values(?,?,?)";
			int r=this.template.update(query,student.getId(),student.getName(),student.getCity());
			return r;
	}
	
	public int update(Student student) {
		String query="update  student set name=?, city=? where id=?";
		int r=this.template.update(query,student.getCity(),student.getName(),student.getId());
		return r;
	}
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int r=this.template.update(query,studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		String query="select * from student where id=?";
		RowMapper rowMapper=new RowMapperImpl();
		Student r=this.template.queryForObject(query,rowMapper, studentId);
		return r;
	}

	public List<Student> getAllStudent() {
		String query="select * from student";
		 List<Student> students=this.template.query(query, new RowMapperImpl());
		return students;
	}
	

}
