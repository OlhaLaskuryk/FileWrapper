package wrapper;

import java.io.FileNotFoundException;

import org.junit.Test;

public class FileReadWrapperTest {
	@Test(expected = FileNotFoundException.class)
	public void fileReadWrapperFileNotFound() throws FileNotFoundException {
		new FileReadWrapper("test.in");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fileReadWrapperIllegalArgument() throws FileNotFoundException {
		new FileReadWrapper("bin");
	}
	
	@Test
	public void fileReadWrapper() throws FileNotFoundException {
		new FileReadWrapper("text.txt");
	}
	
	@Test
	public void iterator() throws FileNotFoundException {
		FileReadWrapper file = new FileReadWrapper("text.txt");
		for(String line : file){
			
		}
	}
}
