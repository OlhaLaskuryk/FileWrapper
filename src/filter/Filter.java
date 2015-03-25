package filter;

import java.io.File;

public abstract class Filter {
	Filter next;
	
	public Filter(Filter next){
		this.next = next;
	}
	
	public boolean doFilter(File file){
		boolean res = this.doSearch(file);
		if (!res) {
			return false;
		}
		if (next != null) {
			return next.doFilter(file);
		}
		return res;
	}
	
	protected abstract boolean doSearch(File file);
}
