package none.course.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import none.course.model.Topic;

@RestController
public class TopicController {

	// Map<Integer, Topic> TopicData = new HashMap<Integer, Topic>();

	@Autowired
	private TopicService topicService;

//GET with ID
	@RequestMapping(value = CourseURLConstants.GET_TOPIC, method = RequestMethod.GET)
	public @ResponseBody Topic getAllById(@PathVariable("id") int tId) {
		Topic t = new Topic();
		try {

			t = topicService.getTopics().get(tId - 1);
		} catch (Exception e) {

			t = new Topic();
		}

		return t;

	}

//GET
	@RequestMapping(value = CourseURLConstants.GET_ALL_TOPICS, method = RequestMethod.GET)
	public @ResponseBody List<Topic> getAllTopics() {

		return topicService.getTopics();
		/*
		 * List<Topic> Topics = new ArrayList<Topic>(); Set<Integer> TopicIdKeys =
		 * TopicData.keySet(); for (Integer i : TopicIdKeys) {
		 * Topics.add(TopicData.get(i)); } return Topics;
		 */

	}

//POST
	@RequestMapping(value = CourseURLConstants.CREATE_TOPIC, method = RequestMethod.POST)
	public @ResponseBody void AddTopic(@RequestBody Topic newT) {
		topicService.addTopic(newT);
	}
//PUT
	@RequestMapping(value = CourseURLConstants.UPDATE_TOPIC, method = RequestMethod.PUT)
	public @ResponseBody void UpdateTopic(@RequestBody Topic newT, @PathVariable("id") int tId) {
		topicService.Update(tId, newT);
	}
//DELETE
	@RequestMapping(value = CourseURLConstants.DELETE_TOPIC, method = RequestMethod.DELETE)
	public @ResponseBody void DeleteTopic(@PathVariable("id") int tId) {
		topicService.Delete(tId);
	}
}
