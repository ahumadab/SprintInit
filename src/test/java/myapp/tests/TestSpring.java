package myapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.services.ICalculator;
import myapp.services.ILogger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/config.xml")
public class TestSpring
{

	@Autowired
	@Qualifier("test")
	ILogger logger;

	@Autowired
	ICalculator calc;

	@Before
	public void setUp() throws Exception
	{
		System.err.println("===================");
	}

	public void use(ILogger logger)
	{
		logger.log("Voila le résultat");
	}

	public void use(ICalculator calc)
	{
		calc.add(100, 200);
	}

	@Test
	public void testStderrLogger()
	{
		System.err.println("+++ StderrLogger");

		use(logger);
	}

	@Test
	public void testCalculatorWithLogger()
	{
		System.err.println("+++ CalculatorWithLogger");
		use(calc);
	}
}
