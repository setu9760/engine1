package com.mycompany.engine1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.app.common.model.ModelA;
import com.mycompany.app.common.model.ModelB;
import com.mycompany.app.common.service.ModelService;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class Engine1Controller {

	@Autowired
	ModelService modelService;
	
	@GetMapping("/modela/{name}")
	public ResponseEntity<ModelA> getModelA(@PathVariable String name) throws Exception {
		return new ResponseEntity<>(modelService.getModelA(name), HttpStatus.OK);
	}

	@GetMapping("/modelb/{name}")
	public ResponseEntity<ModelB> getModelB(@PathVariable String name) throws Exception {
		return new ResponseEntity<>(modelService.getModelB(name), HttpStatus.OK);
	}
	
	@GetMapping("/hello/{name}")
	public ResponseEntity<String> hello(@PathVariable String name) {
		return new ResponseEntity<>(String.format("{\"msg\" : \"hello %s\"}", name), HttpStatus.OK) ;
	}
}
