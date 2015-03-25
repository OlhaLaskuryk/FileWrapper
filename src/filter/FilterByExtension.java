package filter;

import java.io.File;

public class FilterByExtension extends Filter {
	String extension;

	public FilterByExtension(Filter next, String extension) {
		super(next);
		this.extension = extension;
	}

	@Override
	protected boolean doSearch(File file) {
		int i = file.getName().lastIndexOf('.');
		String extensionFile = file.getName().substring(i + 1).toLowerCase();
		if (extensionFile.equals(extension)) {
			return true;
		}
		return false;
	}

}
