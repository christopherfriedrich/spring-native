package com.learning.springnative;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.Duration;
import javax.servlet.http.HttpServletResponse;
import jpprof.CPUProfiler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

  @GetMapping(path = "/greeting/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> greeting(@PathVariable String name) {

    GreetingResponse greetingResponse = new GreetingResponse("Hello from the server, " + name);
    EntityModel<GreetingResponse> entityModel =
        EntityModel.of(
            greetingResponse, linkTo(methodOn(HelloController.class).greeting(name)).withSelfRel());

    return ResponseEntity.ok(entityModel);
  }

  @GetMapping(path = "/debug/pprof/profile")
  @ResponseBody
  public void profile(
      @RequestParam(required = false) String seconds, HttpServletResponse response) {
    try {
      Duration d = Duration.ofSeconds(Integer.parseInt(seconds));
      CPUProfiler.start(d, response.getOutputStream());
      response.flushBuffer();
    } catch (Exception e) {
      System.out.println("exception: " + e.getMessage());
    }
  }
}
