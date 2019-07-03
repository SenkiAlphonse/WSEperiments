package com.alphonse.wsexperiments.controllerTest;

import com.alphonse.wsexperiments.RESTcontroller.HelloRESTController;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloRESTController.class)
public class HelloRESTControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void returnDefaultHello() throws Exception {
        mockMvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(not(0))))
                .andExpect(jsonPath("$.greeting", is("Hello, World!")));
    }

    @Test
    public void returnCustomHello() throws Exception {
        mockMvc.perform(get("/hello?name=Alfonz")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(not(0))))
                .andExpect(jsonPath("$.greeting", is("Hello, Alfonz!")));
    }

}
