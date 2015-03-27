package wrapper;

import java.io.FileNotFoundException;

import org.junit.Test;

public class FileReadWrapperTest {
	@Test(expected = FileNotFoundException.class)
	public void fileReadWrapperFileNotFound() throws FileNotFoundException {
		new FileReadWrapperIterator("test.in");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fileReadWrapperIllegalArgument() throws FileNotFoundException {
		new FileReadWrapperIterator("bin");
	}
	
	@Test
	public void fileReadWrapper() throws FileNotFoundException {
		new FileReadWrapperIterator("text.txt");
	}
	
	@Test
	public void iterator() throws FileNotFoundException {
		FileReadWrapperIterable file = new FileReadWrapperIterable("text.txt");
		for(String line : file){
			
		}
	}
}
