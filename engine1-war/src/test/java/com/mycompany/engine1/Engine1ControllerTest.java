package com.mycompany.engine1;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mycompany.app.common.model.ModelA;
import com.mycompany.app.common.model.ModelB;
import com.mycompany.app.common.service.ModelService;

@RunWith(SpringRunner.class)
@WebMvcTest(Engine1Controller.class)
public class Engine1ControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    ModelService modelService;
    
    @Test
    public void testHello() throws Exception {
    	mvc.perform(get("/engine1/api/hello/abcd"))
    		.andExpect(status().isOk())
    		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    		.andExpect(jsonPath("$.msg", is("hello abcd")))
    		.andDo(print());
    }
    
    @Test
    public void testGetModelA() throws Exception {
    	when(modelService.getModelA("abcd")).thenReturn(new ModelA("abcd", 1));
    	mvc.perform(get("/engine1/api/modela/abcd"))
	    	.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name", is("abcd")))
			.andExpect(jsonPath("$.number", is(1)))
    		.andDo(print());
    }
    
    @Test
    public void testGetModelB() throws Exception {
    	when(modelService.getModelB("abcd")).thenReturn(new ModelB("abcd", 1));
    	mvc.perform(get("/engine1/api/modelb/abcd"))
	    	.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name", is("abcd")))
			.andExpect(jsonPath("$.number", is(1)))
    		.andDo(print());
    }
}
