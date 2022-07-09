package com.learning.springnative;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloControllerTest {

    @Test
    void hello() throws Exception {
        HelloController helloController = new HelloController();

        String testee = helloController.hello();

        assertThat(testee).isEqualTo( "Hello from the server");
    }

}
