package filter;

import java.io.File;

public class FilterByName extends Filter {
	String name;
	
	public FilterByName(Filter next, String name) {
		super(next);
		this.name = name;
	}

	@Override
	protected boolean doSearch(File file) {
		int index = file.getName().toLowerCase().indexOf(name);
		if (index == -1) {
			return false;
		}
		return true;
	}
}
