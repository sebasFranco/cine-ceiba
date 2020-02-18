package com.ceiba.adn.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.application.caseuse.LookForChairs;
import com.ceiba.adn.domain.model.Chair;

@RestController
@RequestMapping("/chairs")
public class ChairController {

	private LookForChairs lookForChairsService;

	public ChairController(LookForChairs lookForChairsService) {
		this.lookForChairsService = lookForChairsService;
	}

	@GetMapping()
	public List<Chair> getAllS() {
		return lookForChairsService.getAll();
	}

}
