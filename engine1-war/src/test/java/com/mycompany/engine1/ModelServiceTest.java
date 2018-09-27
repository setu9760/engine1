package com.mycompany.engine1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mycompany.app.common.model.ModelA;
import com.mycompany.app.common.model.ModelB;
import com.mycompany.app.common.repository.ModelARepositoryImpl;
import com.mycompany.app.common.repository.ModelBRepositoryImpl;
import com.mycompany.app.common.service.ModelService;

@RunWith(MockitoJUnitRunner.class)
public class ModelServiceTest {

	@Mock ModelARepositoryImpl modelARepository;
	@Mock ModelBRepositoryImpl modelBRepository;
	
	ModelService service;
	
	@Before
	public void setUp() throws Exception {
		service = new ModelServiceImpl(modelARepository, modelBRepository);
	}

	@Test
	public void testSave() throws Exception {
		ModelA a = new ModelA("a", 1);
		ModelB b = new ModelB("b", 1);
		service.save(a, b);
		verify(modelARepository).save(a);
		verify(modelBRepository).save(b);
	}
	
	@Test
	public void testGetModelA() throws Exception {
		ModelA mock = new ModelA("a", 1);
		when(modelARepository.get("a")).thenReturn(mock);
		ModelA a = service.getModelA("a");
		assertNotNull(a);
		assertEquals(mock, a);
	}
	
	@Test
	public void testGetModelB() throws Exception {
		ModelB mock = new ModelB("b", 1);
		when(modelBRepository.get("b")).thenReturn(mock);
		ModelB b = service.getModelB("b");
		assertNotNull(b);
		assertEquals(mock, b);
	}
}
