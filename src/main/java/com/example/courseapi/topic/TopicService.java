package com.example.courseapi.topic;

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
public class TopicService {
	

	@Autowired
	private TopicRepository topicRepository;

	
	
	public List<Topic> getAllTopics (){
	List<Topic> allTopics= new ArrayList<>();
	topicRepository.findAll()
	.forEach(allTopics::add);
	return allTopics;
	}
	
	
	public Topic getTopic(String id) {
		Optional<Topic> obj = topicRepository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}


	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}


	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}


	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
	// otra forma de hacerlo con landa 
	
	// topics.removeIf(t -> t.getId().equals(id));
	
	
	
	
}
