package com.example.courseapi.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository <Course , String > {
	
	public List<Course> findByName(String name);  // no hace falta implentarlo lo hace solo, FindByProperty

	
	public List<Course> findByTopicId(String topicId);
		
	

}
