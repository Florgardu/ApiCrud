package com.example.courseapi.topic;

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

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	//GET a todos los topics
	@RequestMapping ("/topics")
	public List<Topic> getAllTopic () {
		return topicService.getAllTopics() ;
	}

	//GET un solo topic 
	
	@RequestMapping ("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);	
	}
	
	//POST create un nuevo topic 
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);

	}
	
	//PUT UPDATE un topic 
		@PutMapping("/topics/{id}")
		public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
			topicService.updateTopic(id, topic);
		}
		
	
	//DELETE borrar un topic 
		
		@DeleteMapping("/topics/{id}")
		public void deleteTopic(@PathVariable String id) {
			topicService.deleteTopic(id);
		}
		
		

	
//	@PostMapping("/topics")
//	public @ResponseBody ResponseEntity<String> post() {
//	    return new ResponseEntity<String>("POST Response", HttpStatus.OK);
//	}
	
	
}
