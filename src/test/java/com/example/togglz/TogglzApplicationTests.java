package com.example.togglz;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TogglzApplicationTests {

	@Autowired
	TogglzService togglzPresenter;
	@Test
	public void contextLoads() {
		assertEquals("Togglz is active", togglzPresenter.togglz());
	}

}
