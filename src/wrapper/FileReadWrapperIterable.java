package wrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Wrapper for file: iterator read in line. Implements Iterable<T>.
 * 
 * @author Olha_Laskuryk
 */
public class FileReadWrapperIterable implements Iterable<String>{
	private File file;
	
	/**
	 * Constructor get filename.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public FileReadWrapperIterable(String filename) throws FileNotFoundException {
		super();
		this.file = new File(filename);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		if (!file.isFile()) {
			throw new IllegalArgumentException();
		}
		if (!file.canRead()) {
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public Iterator<String> iterator() {
		return new IteratorFileRead<String>();
	}
	
	private class IteratorFileRead<T> implements Iterator<String>{
		public IteratorFileRead() {
			try {
				scI = new Scanner(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		Scanner scI;
		@Override
		public boolean hasNext() {
			return scI.hasNextLine();
		}

		@Override
		public String next() {
			if (hasNext()) {
				return scI.nextLine();
			}
			scI.close();
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
}
