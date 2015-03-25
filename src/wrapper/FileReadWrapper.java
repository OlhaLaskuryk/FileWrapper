package wrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Wrapper for file: iterator read in line.
 * 
 * @author Olha_Laskuryk
 */
public class FileReadWrapper implements Iterable<String> {
	private File file;
	private Scanner sc;

	/**
	 * Constructor get filename.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public FileReadWrapper(String filename) throws FileNotFoundException {
		super();
		this.file = new File(filename);
		if(!file.exists()){
			throw new FileNotFoundException();
		}
		if(!file.isFile()){
			throw new IllegalArgumentException();
		}
		if(!file.canRead()){
			throw new UnsupportedOperationException();
		}
		this.sc = new Scanner(file);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>(){

			@Override
			public boolean hasNext() {
				return sc.hasNextLine();
			}

			@Override
			public String next() {
				if (hasNext()) {
					return sc.nextLine();
				}
				sc.close();
				throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
}
