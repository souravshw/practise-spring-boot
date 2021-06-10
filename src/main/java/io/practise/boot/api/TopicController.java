package io.practise.boot.api;

import io.practise.boot.model.Topic;
import io.practise.boot.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @GetMapping("/allTopics")
  public List<Topic> getTopics() {
    return topicService.getAllTopics();
  }


  @GetMapping("/allTopics/{id}")
  public Topic getTopicById(@PathVariable String id) {

    Optional<Topic> topic = topicService.getTopicById(id);

    if (topic.isPresent()) {
      return topic.get();
    } else {
      throw new ResponseStatusException(EXPECTATION_FAILED, "Resource " + id + " not found");
    }
  }
}
