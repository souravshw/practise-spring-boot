package io.practise.boot.service;

import io.practise.boot.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class TopicService {

  private List<Topic> allTopics = new ArrayList<>(Arrays.asList(
          new Topic(1, "A", "ABC", "123"),
          new Topic(2, "B", "ABC", "321"),
          new Topic(3, "C", "ABC", "321"),
          new Topic(4, "D", "ABC", "321")));


  public List<Topic> getAllTopics() {
    return allTopics;
  }

  public Optional<Topic> getTopicById(String id) {

    try {
      Integer checkId = Integer.parseInt(id);
    } catch (NumberFormatException cause) {
      System.out.println("TopicService.getTopicById " + cause.toString());
      return Optional.empty();
    }

    return allTopics.stream()
            .filter(eachTopic -> eachTopic.getId()
                    .equals(Integer.parseInt(id)))
            .findFirst();
  }

  public void createTopic(Topic topic) throws DataFormatException {
    if(topic != null) {
      allTopics.add(topic);
    }else{
      throw new DataFormatException("Improper format for topic object !");
    }
  }


  public boolean updateTopic(Topic updatedTopic) {
    Optional<Topic> matchingTopic = allTopics.stream()
            .filter(eachTopic ->
                    eachTopic.getId().equals(updatedTopic.getId()))
            .findFirst();

    if(matchingTopic.isPresent()){
      allTopics.remove(matchingTopic);
      allTopics.add(updatedTopic);
      return true;
    }else{
      return false;
    }
  }
}
