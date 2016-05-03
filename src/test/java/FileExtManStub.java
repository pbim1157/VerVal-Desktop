package test.java;

import main.java.FileExtMan;

public class FileExtManStub implements FileExtMan {

	private boolean retVal;

	@Override
	public boolean isValid(String fName) {
		return retVal;
	}

	public void setWillReturn(boolean retVal) {
		this.retVal = retVal;
	}

}
