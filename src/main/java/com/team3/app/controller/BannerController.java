package com.team3.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.Banner;
import com.team3.app.repository.BannerRepository;

@RestController
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	BannerRepository repository;
	
	@RequestMapping(value = "/all")
	public List<Banner> viewAll() {
		return repository.findAll();
	}
	
}
