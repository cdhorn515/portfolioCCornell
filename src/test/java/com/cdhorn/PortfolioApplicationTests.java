package com.cdhorn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PortfolioApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void sanityTest() throws Exception {
		assertEquals(3, 3);
	}


}
