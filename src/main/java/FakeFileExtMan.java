package main.java;

public class FakeFileExtMan implements FileExtMan {
	public boolean isValid(String fileName) {
		return false;
	}
}
