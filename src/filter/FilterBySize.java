package filter;

import java.io.File;

public class FilterBySize extends Filter {
	int fromSize;
	int toSize;

	public FilterBySize(Filter next, int fromSize, int toSize) {
		super(next);
		if(fromSize > toSize){
			throw new IllegalArgumentException();
		}
		this.fromSize = fromSize;
		this.toSize = toSize;
	}

	@Override
	protected boolean doSearch(File file) {
		if (file.length() < fromSize || file.length() > toSize) {
			return false;
		}
		return true;
	}

}
