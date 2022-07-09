package com.learning.springnative;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
class HelloControllerTest {

    @Test
    void hello() throws Exception {
        HelloController helloController = new HelloController();

        String testee = helloController.hello();

        assertThat(testee).isEqualTo("Hello from the server");
    }

}
