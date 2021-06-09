package io.practise.boot.service;

import io.practise.boot.model.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

  @GetMapping("/allTopics")
  public List<Topic> getTopics(){
    return Arrays.asList(
            new Topic(1, "A", "ABC", "123"),
            new Topic(2, "B", "ABC", "321"));
  }
}
