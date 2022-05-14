package com.example.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
public class ProjectApplicaitonTest3 {

    @Test
    void testProperties(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求，当前访问singers
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/music");
        ResultActions perform = mvc.perform(builder);
        //设置预期值与真实值进行比较，成功测试通过，失败测试失败
        //定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //预计本次调用成功的：状态200
        ResultMatcher ok = status.isOk();
        //添加预期值到本次调用过程中进行匹配
        perform.andExpect(ok);
    }
}