package io.practise.boot.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController {


  @GetMapping("/hello")
  public String getHello(){
    return "Hello";
  }
}
