package com.wdc.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdc.base.repository.RunConfigurationRepository;
import com.wdc.base.repository.entity.RunConfiguration;

@Service
public class RunConfigurationService {

	@Autowired
	private RunConfigurationRepository cfgRepo;
	
	public void add(RunConfiguration cfg) {
		cfgRepo.save(cfg);
	}
	
}
