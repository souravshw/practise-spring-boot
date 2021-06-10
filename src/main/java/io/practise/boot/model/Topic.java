package io.practise.boot.model;

import java.util.Objects;

/**
 * @author Sourav
 */
public class Topic {
  private Integer id;
  private String topicName;
  private String description;
  private String credits;

  public Topic() {
    super();
  }

  public Topic(int id, String topicName, String description, String credits) {
    this.id = id;
    this.topicName = topicName;
    this.description = description;
    this.credits = credits;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCredits() { return credits; }

  public void setCredits(String credits) {
    this.credits = credits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Topic topic = (Topic) o;
    return id == topic.id && Objects.equals(topicName, topic.topicName) && Objects.equals(description, topic.description) && Objects.equals(credits, topic.credits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, topicName, description, credits);
  }
}
