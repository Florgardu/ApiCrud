package com.example.courseapi.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseapi.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	//GET a todos los courses de un topic especifico 
	@RequestMapping ("/topics/{id}/courses")
	public List<Course> getAllCourses (@PathVariable String id) {
		return courseService.getAllCourses(id) ;
	}

	//GET un solo course 
	
	@RequestMapping ("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);	
	}
	
	//POST create un nuevo course 
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "",""));
		courseService.addCourse(course);

	}
	
	//PUT UPDATE un course 
		@PutMapping("/topics/{topicId}/courses/{id}")
		public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
			course.setTopic(new Topic(topicId, "",""));
			courseService.updateCourse (course);
		}
		
	
	//DELETE borrar un course 
		
		@DeleteMapping("/topics/{topicId}/courses/{id}")
		public void deleteCourse(@PathVariable String id) {
			courseService.deleteCourse(id);
		}
		
		

	
//	@PostMapping("/topics")
//	public @ResponseBody ResponseEntity<String> post() {
//	    return new ResponseEntity<String>("POST Response", HttpStatus.OK);
//	}
	
	
}
