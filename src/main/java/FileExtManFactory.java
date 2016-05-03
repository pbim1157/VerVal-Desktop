package main.java;

public class FileExtManFactory {
	private static FileExtManFactory fileExtFactory;
	private FileExtMan fileExtMan;

	private FileExtManFactory() {

	}

	public static FileExtManFactory getInstance() {
		if (fileExtFactory == null) {
			fileExtFactory = new FileExtManFactory();
		}
		return fileExtFactory;
	}

	public FileExtMan getFileExtMan() {
		if (fileExtMan != null) {
			return fileExtMan;
		} else {
			return new FakeFileExtMan();
		}
	}

	public void setFileExtMan(FileExtMan fileExtMan) {
		this.fileExtMan = fileExtMan;
	}
}
