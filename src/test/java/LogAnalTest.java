package test.java;

import static org.junit.Assert.*;

import org.junit.*;

import main.java.LogAnalyser;

public class LogAnalTest {

	private LogAnalyser logAnal;
	private static final String validFName = "a.slr";
	private static final String invalidFName = "b.slrr";

	@Before
	public void setUp() {
		logAnal = new LogAnalyser();
	}

	@After
	public void tearDown() {
		// nothing to do
	}

	@Test
	public void isValidLogFileName_ValidLogFileName_ReturnsTrue() {
		assertEquals(true, logAnal.isValidLogFileName(validFName));
	}

	
	@Test
	public void isValidLogFileName_InvalidLogFileName_ReturnsFalse() {
		assertEquals(false, logAnal.isValidLogFileName(invalidFName));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void isValidLogFileName_Empty_ExceptionThrow() {
		logAnal.isValidLogFileName("");
	}

}