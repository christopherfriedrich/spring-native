package com.learning.springnative;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/greeting")
public class HelloController {

  @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> greeting(@PathVariable String name) {

    GreetingResponse greetingResponse = new GreetingResponse("Hello from the server, " + name);
    EntityModel<GreetingResponse> entityModel = EntityModel.of(greetingResponse, linkTo(methodOn(HelloController.class).greeting(name)).withSelfRel());

    return ResponseEntity.ok(entityModel);

  }
}
