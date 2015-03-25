package filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FilterByNameTest {
	File file = new File("C:/Users");
	FilterByName filter;
	
	@Test
	public void filterByNameConstructor()  {
		new FilterByName(null, "");
	}
	
	@Test
	public void filterByNameFilter()  {

		filter = new FilterByName(null, "gg");
		assertEquals(false,filter.doFilter(file));
	}
	
	@Test
	public void filterByNameFilter2() {
		filter = new FilterByName(null, "des");
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(true, filter.doFilter(file));
		}
	}
}
