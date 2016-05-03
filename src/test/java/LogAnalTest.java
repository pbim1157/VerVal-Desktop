package test.java;

import static org.junit.Assert.*;

import org.junit.*;
import org.mockito.Mockito;

import main.java.FileExtMan;
import main.java.FileExtManFactory;
import main.java.LogAnalyser;
import main.java.WebService;

public class LogAnalTest {

	private LogAnalyser logAnal;
	private static final String validFName = "a.slr";
	private static final String invalidFName = "b.slrr";

	private FileExtManStub fileExtMan;

	private WebService webServ;

	@Before
	public void setUp() {
		fileExtMan = new FileExtManStub();
		// logAnal = new LogAnalyser();
		// logAnal.setFileExtMan(fileExtMan);
		logAnal = new TestLogAnal(fileExtMan);
		FileExtManFactory.getInstance().setFileExtMan(fileExtMan);
		webServ = new ManualWebService();
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

	/*
	 * @Test(expected = IllegalArgumentException.class) public void
	 * isValidLogFileName_Empty_ExceptionThrow() {
	 * logAnal.isValidLogFileName(""); }
	 */

	@Test
	public void IsValidLogFileNameTestable_NotValid_ReturnFalse() {
		fileExtMan.setWillReturn(false);
		assertEquals(false, logAnal.isValidLogFileName(""));
	}

	@Test
	public void IsValidLogFileNameTestable_Valid_ReturnTrue() {
		fileExtMan.setWillReturn(true);
		assertEquals(true, logAnal.isValidLogFileName(""));
	}

	@Test
	public void isValiedLogFileName_FileNameTooShort_CallsWebService() {
		logAnal.isValidLogFileName("12");
		assertEquals(true, webServ.getLastError());
	}

	@Test
	public void isValiedLogFileNameMock_FileNameTooShort_CallsWebService() {
		WebService mockedWebService = Mockito.mock(WebService.class);
		logAnal.setWebServ(mockedWebService);
		logAnal.isValidLogFileName("12");
		Mockito.verify(mockedWebService, Mockito.times(2)).logError("12 file name is too short.");

	}

}