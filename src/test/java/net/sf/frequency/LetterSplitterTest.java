package net.sf.frequency;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class LetterSplitterTest {

	@Test
	public void testSplit() {
		LetterSplitter splitter = new LetterSplitter();
		List<String> result1 = splitter.split("eve");
		List<String> expected1 = new ArrayList<String>();
		expected1.add("e");
		expected1.add("v");
		expected1.add("e");
		Assert.assertEquals(expected1, result1);

		List<String> result2 = splitter.split("a,bc^ D");
		List<String> expected2 = new ArrayList<String>();
		expected2.add("a");
		expected2.add("b");
		expected2.add("c");
		expected2.add("d");
		Assert.assertEquals(expected2, result2);

	}

}
