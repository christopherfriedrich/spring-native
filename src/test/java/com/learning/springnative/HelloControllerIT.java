package com.learning.springnative;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerIT {
  @Autowired private MockMvc mockMvc;

  @Test
  void whenHittingHelloEndpointThenGreetingIsReturned() throws Exception {

    String testee = "John";

    mockMvc
        .perform(get("/greeting/" + testee).accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(
            jsonPath("$.greeting").value(String.format("Hello from the server, %s", testee)));
  }
}
