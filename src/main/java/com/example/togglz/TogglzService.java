package com.example.togglz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Feature logConfig;
	
	private static Logger LOG = LoggerFactory.getLogger(TogglzService.class);
	
	@RequestMapping(value = "/togglz", method = RequestMethod.GET)
	public String togglz() {
		if(featureManager.isActive(logConfig)) {
			return executeLogConfigFeature();
		}
		return "Log Config is not active";
	}

	private String executeLogConfigFeature() {
		LOG.info("Info log entry");
		LOG.debug("Debug log entry");
		LOG.warn("Warn log entry");
		LOG.error("Error log entry");
		return "Log Config Active";
	}
}
