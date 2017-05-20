package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleMongoServiceApplicationTests {

	// I decided not to write any test cases because I didn't write any code worth testing.
	// Spring tests their own code so I don't need to test basic CRUD / REST operations.
	@Test
	public void contextLoads() {}

}
