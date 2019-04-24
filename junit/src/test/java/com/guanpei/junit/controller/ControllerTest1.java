package com.guanpei.junit.controller;

import com.guanpei.junit.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.WebApplicationContext;

//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用

public class ControllerTest1 extends BaseTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @Transactional
    public void get() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/dept/list")
        )
                ///期望返回状态为200
                .andExpect(MockMvcResultMatchers.status().isOk())
                ///期望返回头数据为{"Content-Type":"application/json;charset=UTF-8"}
                .andExpect(MockMvcResultMatchers.header().string("Content-Type","application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("6"));
    }
}
