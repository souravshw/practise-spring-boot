package io.practise.boot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController {


  @GetMapping("/hello")
  public String getHello(){
    return "Hello";
  }
}
