package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import wrapper.FileReadWrapperIterable;
import filter.Filter;
import filter.FilterByDate;
import filter.FilterByExtension;
import filter.FilterByName;
import filter.FilterBySize;

public class Main {
	public static final String FORMAT_DATE = "MM/dd/yy HH:mm";
	public static final DateFormat formatter = new SimpleDateFormat(FORMAT_DATE);

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Введите путь к директории");
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		File superFile = new File(path);
		if (!superFile.isDirectory()) {
			sc.close();
			throw new IllegalArgumentException();
		}
		try {
			Filter filter = null;
			System.out.println("искать по имени файла ? (0\\1) ");
			if (Integer.parseInt(sc.nextLine()) == 1) {
				System.out.println("Введите имя");
				String name = sc.nextLine();
				name = name.toLowerCase();
				filter = new FilterByName(filter, name);
			}
			System.out.println("искать по расширению ? (0\\1) ");
			if (Integer.parseInt(sc.nextLine()) == 1) {
				System.out.println("Введите расширение");
				String extension = sc.nextLine();
				extension = extension.toLowerCase();
				filter = new FilterByExtension(filter, extension);
			}
			System.out.println("искать по размеру ? (0\\1) ");
			if (Integer.parseInt(sc.nextLine()) == 1) {
				System.out.println("Введите нижнюю границу в байтах");
				int fromSize = sc.nextInt();
				System.out.println("Введите верхнюю границу в байтах");
				int toSize = sc.nextInt();
				filter = new FilterBySize(filter, fromSize, toSize);
			}
			System.out.println("искать по дате ? (0\\1) ");
			if (Integer.parseInt(sc.nextLine()) == 1) {
				String date;
				System.out
						.println("Введите нижнюю границу диапазона в формате "
								+ FORMAT_DATE);
				date = sc.nextLine();
				Date fromDate = formatter.parse(date);
				System.out
						.println("Введите верхнюю границу диапазона в формате "
								+ FORMAT_DATE);
				date = sc.nextLine();
				Date toDate = formatter.parse(date);
				filter = new FilterByDate(filter, fromDate, toDate);
			}

			System.out.println("Поиск начат");
			doFilter(superFile, filter);
			System.out.println("Поиск закончен");
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		
		FileReadWrapperIterable frwI = new FileReadWrapperIterable("text.txt");
		int i = 0;
		for(String s: frwI) {
			//let's assume that your file has more than 2 lines
			if(i == 2) {
				for(String ss: frwI) {
					System.out.println("Inner sout: " + ss);
				}
			}
			System.out.println(s);
			i++;
		}

	}

	/**
	 * 
	 * 
	 * @param superFile
	 *            when search files.
	 * @param filter
	 *            filter search.
	 */
	public static void doFilter(File superFile, Filter filter) {
		File[] listOfFiles = superFile.listFiles();
		if(listOfFiles == null){
			return;
		}
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
					doFilter(file, filter);
				continue;
			}
			if (filter.doFilter(file)) {
				System.out.println(file.getAbsolutePath() + " = "
						+ file.lastModified());
			}
		}
	}
}
