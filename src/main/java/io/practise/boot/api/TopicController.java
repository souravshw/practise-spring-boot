package io.practise.boot.api;

import io.practise.boot.common.ApplicationResponse;
import io.practise.boot.model.Topic;
import io.practise.boot.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
public final class TopicController {

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
      throw new ResponseStatusException(BAD_REQUEST, "Resource " + id + " not found");
    }
  }

  @PostMapping("/allTopics")
  public ApplicationResponse createTopic(Topic topic) {
    try {
      topicService.createTopic(topic);
    } catch (DataFormatException cause) {
      throw new ResponseStatusException(BAD_REQUEST, cause.getMessage());
    }
    return new ApplicationResponse("Data saved successfully !");
  }

  @PutMapping("/allTopics")
  public ApplicationResponse updateTopic(Topic topic) {
    boolean result = topicService.updateTopic(topic);

    if (result) {
      return new ApplicationResponse("Data saved successfully !");
    } else {
      throw new ResponseStatusException(BAD_REQUEST);
    }

  }
}
