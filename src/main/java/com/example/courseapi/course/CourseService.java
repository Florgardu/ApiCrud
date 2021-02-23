package com.example.courseapi.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	

	@Autowired
	private CourseRepository courseRepository;

	
	
	public List<Course> getAllCourses (String topicId){
	List<Course> allCourses= new ArrayList<>();
	courseRepository.findByTopicId(topicId)
	.forEach(allCourses::add);
	return allCourses;
	}
	
	
	public Course getCourse(String id) {
		Optional<Course> obj = courseRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}


	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateCourse(Course course) {
		courseRepository.save(course);
	}


	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	
	// otra forma de hacerlo con landa 
	
	// topics.removeIf(t -> t.getId().equals(id));
	
	
	
	
}
