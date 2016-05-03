
package main.java;

public class LogAnalyser {
	public boolean isValidLogFileName(String fName) {
		if (fName == null) {
			throw new IllegalArgumentException("The filename variable is empty");
		}
		return fName.endsWith(".slr");
	}
}
