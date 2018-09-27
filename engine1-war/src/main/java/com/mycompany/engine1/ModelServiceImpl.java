package com.mycompany.engine1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.app.common.exception.RepositoryDataAccessException;
import com.mycompany.app.common.model.ModelA;
import com.mycompany.app.common.model.ModelB;
import com.mycompany.app.common.repository.ModelARepository;
import com.mycompany.app.common.repository.ModelBRepository;
import com.mycompany.app.common.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	ModelARepository modelARepository;
	@Autowired
	ModelBRepository modelBRepository;
	
	public ModelServiceImpl(ModelARepository modelARepository, ModelBRepository modelBRepository) {
		this.modelARepository = modelARepository;
		this.modelBRepository = modelBRepository;
	}

	@Transactional
	public void save(ModelA a, ModelB b) throws RepositoryDataAccessException {
		modelARepository.save(a);
		modelBRepository.save(b);
	}

	public ModelA getModelA(String name) throws RepositoryDataAccessException {
		return modelARepository.get(name);
	}

	public ModelB getModelB(String name) throws RepositoryDataAccessException {
		return modelBRepository.get(name);
	}

}
