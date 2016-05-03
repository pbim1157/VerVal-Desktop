package test.java;

import org.junit.runner.RunWith;

import main.java.LogAnalyser;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LogAnalyserParamTest {
	private LogAnalyser logAnal;

	private FileExtManStub fileExtMan;

	@Parameterized.Parameter
	public String fName;

	@Parameterized.Parameter(value = 1)
	public boolean exp;

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "a.slr", true }, { "b.slrr", false } });
	}

	@Before
	public void setUp() {
		fileExtMan = new FileExtManStub();
		logAnal = new LogAnalyser();
		//logAnal.setFileExtMan(fileExtMan);
	}

	@Test
	public void test() {
		fileExtMan.setWillReturn(exp);
		Assert.assertEquals(exp, logAnal.isValidLogFileName(fName));
	}
}
