package filter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class FilterByDateTest {
	public static final String FORMAT_DATE = "MM/dd/yy HH:mm";
	public static final DateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
	File file = new File("C:/Users");
	FilterByDate filter;
	
	@Test
	public void filterByDateConstructor() throws ParseException {
		Date from = formatter.parse("01/01/90 00:00");
		Date to = formatter.parse("02/01/90 00:00");
		new FilterByDate(null, from, to);
	}
	
	@Test
	public void filterByDateFilter() throws ParseException  {
		Date from = formatter.parse("01/01/90 00:00");
		Date to = formatter.parse("01/01/90 00:00");
		filter = new FilterByDate(null, from, to);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(false,filter.doFilter(file));
		}
	}
	
	@Test
	public void filterByDateFilter2() throws ParseException  {
		Date from = formatter.parse("01/01/25 00:00");
		Date to = formatter.parse("01/01/25 00:00");
		filter = new FilterByDate(null, from, to);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(false,filter.doFilter(file));
		}
	}
	
	@Test
	public void filterByDateFilter3() throws ParseException  {
		Date from = formatter.parse("01/01/10 00:00");
		Date to = formatter.parse("01/01/16 00:00");
		filter = new FilterByDate(null, from, to);
		File[] listOfFiles = file.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				continue;
			}
			assertEquals(true,filter.doFilter(file));
		}
	}

}
