package filter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class FilterByExtensionTest {
	File file = new File("C:/Users");
	FilterByExtension filter;
	
	@Test
	public void filterByExtensionConstructor()  {

		new FilterByExtension(null, "");
	}
	
	@Test
	public void filterByExtensionFilter()  {

		filter = new FilterByExtension(null, "gg");
		assertEquals(false,filter.doFilter(file));
	}
	
	@Test
	public void filterByExtensionFilter2() {
		filter = new FilterByExtension(null, "ini");
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(true,filter.doFilter(file));
		}
	}
	
}
