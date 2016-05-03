
package main.java;

public class LogAnalyser {

	private FileExtMan fileExtMan;

	public boolean isValidLogFileName(String fName) {
		if (fName == null) {
			throw new IllegalArgumentException("The filename variable is empty");
		}
		// return fName.endsWith(".slr");
		return fileExtMan != null && fileExtMan.isValid(fName);
	}

	public void setFileExtMan(final FileExtMan fileExtMan) {
		this.fileExtMan = fileExtMan;
	}

}
