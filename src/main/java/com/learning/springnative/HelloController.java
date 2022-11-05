package com.learning.springnative;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/greeting")
public class HelloController {

  @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> greeting(@PathVariable String name) {

    GreetingResponse greetingResponse = new GreetingResponse("Hello from the server, " + name);
    EntityModel<GreetingResponse> entityModel =
        EntityModel.of(
            greetingResponse, linkTo(methodOn(HelloController.class).greeting(name)).withSelfRel());

    return ResponseEntity.ok(entityModel);
  }
}
