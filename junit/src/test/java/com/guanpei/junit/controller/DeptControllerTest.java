package com.guanpei.junit.controller;

import com.guanpei.junit.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
public class DeptControllerTest extends BaseTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Transactional  ///测试回滚
    public void add() throws Exception {
        String body = "{\"dname\": \"创业部\"}";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/dept/add").content(body).contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void get() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/dept/get/{id}",2)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.dname").value("人事部"));
    }

    @Test
    public void get1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/dept/get").param("id","3")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

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