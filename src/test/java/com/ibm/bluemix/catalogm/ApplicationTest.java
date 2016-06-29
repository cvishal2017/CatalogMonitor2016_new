package com.ibm.bluemix.catalogm;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ApplicationTest {
	
	@Mock
	private Scheduler scheduler;
	
	@Before
	public void setup() {
		System.out.println("Doing Setup...");
	}
	
	@Test
	public void invokeScheduler() {
		
		System.out.println("Junit : Invoke Scheduler...");
		scheduler = Mockito.mock(Scheduler.class);
		scheduler.catalogCheck();
		verify(scheduler, atLeast(1)).catalogCheck();
		System.out.println("Junit : Invokation verified...");
	}
	
	
}
