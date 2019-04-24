package com.guanpei.junit.controller;

import com.guanpei.junit.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
public class ControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void list() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/dept/list")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Content-Type","application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("6"));
    }

}
