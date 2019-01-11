package com.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "value=test", classes = {CommunityApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommunityApplicationTests {

    @Value("${value}")
    private String value;

    @Test
    public void contextLoads() {
        assertThat(value, is("test"));
    }

}

