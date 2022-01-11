package myapp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import myapp.imp.BeanFileLogger;
import myapp.imp.FileLogger;
import myapp.imp.SimpleCalculator;
import myapp.imp.StderrLogger;
import myapp.services.ICalculator;
import myapp.services.ILogger;

public class TestLoggerServices
{

	@Before
	public void setUp() throws Exception
	{
		System.err.println("===================");
	}

	@After
	public void tearDown() throws Exception
	{
	}

	public void use(ILogger logger)
	{
		logger.log("Voila le résultat = hello");
	}

	public void use(ICalculator calc)
	{
		calc.add(100, 200);
	}

	@Test
	public void testStderrLogger()
	{
		StderrLogger logger = new StderrLogger();
		logger.start();
		use(logger);
		logger.stop();
	}

	@Test
	public void testFileLogger()
	{
		FileLogger logger = new FileLogger("./tmp/myapp.log");
		logger.start();
		use(logger);
		logger.stop();
	}

	@Test
	public void testBeanFileLogger()
	{
		BeanFileLogger logger = new BeanFileLogger();
		logger.setFileName("./tmp/myapp.log");
		logger.start();
		use(logger);
		logger.stop();
	}

	@Test
	public void testBeanFileLoggerWithConstruct()
	{
		BeanFileLogger logger = new BeanFileLogger("./tmp/myapp.log");
		logger.start();
		use(logger);
		logger.stop();
	}

	@Test
	public void testCaluculatorAndStderrLogger()
	{
		StderrLogger logger = new StderrLogger();
		logger.start();
		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setLogger(logger);
		calculator.start();
		use(calculator);
		calculator.stop();
		logger.stop();
	}

	@Test
	public void testCaluculatorAndFileLogger()
	{
		FileLogger logger = new FileLogger("./tmp/myapp.log");
		logger.start();
		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setLogger(logger);
		calculator.start();
		use(calculator);
		calculator.stop();
		logger.stop();
	}
}
