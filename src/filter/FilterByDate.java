package filter;

import java.io.File;
import java.util.Date;

public class FilterByDate extends Filter {

	Date from;
	Date to;

	public FilterByDate(Filter next, Date fromDate, Date toDate) {
		super(next);
		if (fromDate.getTime() > toDate.getTime()) {
			throw new IllegalArgumentException();
		}
		this.from = fromDate;
		this.to = toDate;
	}

	@Override
	protected boolean doSearch(File file) {
		if (file.lastModified() < from.getTime() || file.lastModified() > to.getTime()) {
			return false;
		}
		return true;
	}

}
