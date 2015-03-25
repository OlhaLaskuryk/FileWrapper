package filter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class FilterBySizeTest {
	File file = new File("C:/Users");
	FilterBySize filter;

	@Test
	public void filterByDateConstructor() throws ParseException {
		new FilterBySize(null, 0, 0);
	}

	@Test
	public void filterByDateFilter() throws ParseException {
		filter = new FilterBySize(null, 0, 0);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(false, filter.doFilter(file));
		}
	}

	@Test
	public void filterByDateFilter2() throws ParseException {
		filter = new FilterBySize(null, 2000, 2000);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(false, filter.doFilter(file));
		}
	}

	@Test
	public void filterByDateFilter3() throws ParseException {
		filter = new FilterBySize(null, 0, 2000);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(true, filter.doFilter(file));
		}
	}
}
