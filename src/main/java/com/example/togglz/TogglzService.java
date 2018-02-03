package com.example.togglz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;

@RestController
public class TogglzService {
	
	@Autowired 
	private FeatureManager featureManager;
	
	@Autowired
	private Feature togglz;

	private static Logger LOG = LogManager.getLogger(TogglzService.class);
	
	@RequestMapping(value = "/togglz", method = RequestMethod.GET)
	public String togglz() {
		LOG.debug("Debug Log entry");
		LOG.warn("Warn log entry");
		LOG.error("Error log entry");
		if(featureManager.isActive(togglz)) {
			return "Togglz is active";
		}
		return "Togglz is not active";
	}
}
