
package main.java;

public class LogAnalyser {

	// private FileExtMan fileExtMan;

	private WebService webServ;

	public boolean isValidLogFileName(String fName) {
		/*
		 * if (fName == null) { throw new IllegalArgumentException(
		 * "The filename variable is empty"); } // return
		 * fName.endsWith(".slr"); return fileExtMan != null &&
		 * fileExtMan.isValid(fName);
		 */
		// return getFileExtMan().isValid(fName);
		if ((webServ != null) && (fName.length() < 3)) {
			webServ.logError(fName + " file name is too short.");
		}

		return getFileExtMan().isValid(fName);
	}

	public void setWebServ(WebService webServ) {
		this.webServ = webServ;
	}

	/*
	 * public void setFileExtMan(final FileExtMan fileExtMan) { this.fileExtMan
	 * = fileExtMan; }
	 */

	public FileExtMan getFileExtMan() {
		return FileExtManFactory.getInstance().getFileExtMan();
	}

}
