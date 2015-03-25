package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import filter.FilterByDateTest;
import filter.FilterByExtensionTest;
import filter.FilterByNameTest;
import filter.FilterBySizeTest;
import filter.FilterTest;
import wrapper.FileReadWrapperTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ FileReadWrapperTest.class, FilterTest.class,
	FilterByDateTest.class, FilterByExtensionTest.class, FilterByNameTest.class,
	FilterBySizeTest.class} )
public final class AllTests {
}
