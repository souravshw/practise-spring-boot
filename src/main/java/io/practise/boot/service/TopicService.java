package io.practise.boot.service;

import io.practise.boot.model.Topic;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

  private List<Topic> allTopics = Arrays.asList(
          new Topic(1, "A", "ABC", "123"),
          new Topic(2, "B", "ABC", "321"),
          new Topic(3, "C", "ABC", "321"),
          new Topic(4, "D", "ABC", "321"));


  public List<Topic> getAllTopics() {
    return allTopics;
  }

  public Optional<Topic> getTopicById(String Id) {

    try {
      Integer checkId = Integer.parseInt(Id);
    } catch (NumberFormatException cause) {
      System.out.println("TopicService.getTopicById " + cause.toString());
      return Optional.empty();
    }

    return allTopics.stream()
            .filter(eachTopic -> eachTopic.getId()
                    .equals(Integer.parseInt(Id)))
            .findFirst();
  }
}
