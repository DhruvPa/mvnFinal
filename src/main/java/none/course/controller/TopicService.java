package none.course.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import none.course.model.Topic;

@Service
public class TopicService {
	List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic(1, "java", "Java Java"), new Topic(2, "C", "C C"),
			new Topic(3, "C++", "CPP CPP"), new Topic(4, "Spring", "Java Spring Boot")));

	public List<Topic> getTopics()
	{
		return topics;
	}

	public void addTopic(Topic newT) {
		// TODO Auto-generated method stub
		topics.add(newT);
	}

	public void Update(int tId, Topic newT) {
		// TODO Auto-generated method stub
		for(int i=0; i<topics.size();i++) {
			if(topics.get(i).getId()==tId)
			{
				topics.set(i, newT);
			}
		}
		
	}

	public void Delete(int tId) {
		// TODO Auto-generated method stub
		for(int i=0; i<topics.size();i++) {
			if(topics.get(i).getId()==tId)
			{
				topics.remove(i);
			}
	}
	}


}
