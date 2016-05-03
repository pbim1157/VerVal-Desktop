package test.java;

import main.java.FileExtMan;
import main.java.LogAnalyser;

public class TestLogAnal extends LogAnalyser {
	private FileExtMan fileExtMan;

	public TestLogAnal(FileExtMan fileExtMan) {
		this.fileExtMan = fileExtMan;
	}

	@Override
	public FileExtMan getFileExtMan() {
		return fileExtMan;
	}
}
