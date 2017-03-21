package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathEndpointController.class)
public class MathEndpointControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testCalculateEndpointAddition() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testCalculateEndpointSubtraction() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testCalculateEndpointNoOperator() throws Exception {
        this.mvc.perform(get("/math/calculate?x=30&y=5").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("30 + 5 = 35"));
    }

    @Test
    public void testSumEndpoint() throws Exception {
        this.mvc.perform(get("/math/sum?n=4&n=5&n=6").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolumeEndpoint() throws Exception {
        this.mvc.perform(patch("/math/volume/6/7/8").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }
}