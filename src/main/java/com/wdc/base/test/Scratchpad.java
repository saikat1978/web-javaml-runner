package com.wdc.base.test;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.wdc.base.repository.RunConfigurationRepository;
import com.wdc.base.repository.entity.RunConfiguration;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class Scratchpad {
	

	
	@Autowired
	private RunConfigurationRepository configurationRepository;

	@Test
	public void addRecord() {
		RunConfiguration configuration = new RunConfiguration();
		configuration.setCommand("abc");
		configuration.setConfigName("abc");
		configuration.setDirPath("abc");
		configuration.setPort("1234");
		
		configurationRepository.save(configuration);
		Logger.getAnonymousLogger().info("########## The config id is " + configuration.getId());
		assertTrue(configuration.getId() != null);
		
		configurationRepository.findById(configuration.getId());
		assertTrue("abc".equalsIgnoreCase(configuration.getCommand()));
		
	}

}
