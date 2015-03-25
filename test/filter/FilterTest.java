package filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FilterTest {
	File file = new File("C:/Users");
	Filter filter;

	@Test
	public void filterByDateConstructor() {
		filter = new FilterByName(null, "des");
		filter = new FilterBySize(filter, 10, 3100);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(true, filter.doFilter(file));
		}
	}
}
