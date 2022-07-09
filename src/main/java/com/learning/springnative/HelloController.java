package com.learning.springnative;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String hello() {
    return "Hello from the server";
  }
}
