package test.java;

import static org.junit.Assert.*;

import org.junit.*;

import main.java.FileExtMan;
import main.java.LogAnalyser;

public class LogAnalTest {

	private LogAnalyser logAnal;
	private static final String validFName = "a.slr";
	private static final String invalidFName = "b.slrr";

	private FileExtManStub fileExtMan;

	@Before
	public void setUp() {
		fileExtMan = new FileExtManStub();
		logAnal = new LogAnalyser();
		logAnal.setFileExtMan(fileExtMan);
	}

	@After
	public void tearDown() {
		// nothing to do
	}

	@Test
	public void isValidLogFileName_ValidLogFileName_ReturnsTrue() {
		fileExtMan.setWillReturn(true);
		assertEquals(true, logAnal.isValidLogFileName(validFName));
	}

	@Test
	public void isValidLogFileName_InvalidLogFileName_ReturnsFalse() {
		fileExtMan.setWillReturn(false);
		assertEquals(false, logAnal.isValidLogFileName(invalidFName));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isValidLogFileName_Empty_ExceptionThrow() {
		logAnal.isValidLogFileName("");
	}

}