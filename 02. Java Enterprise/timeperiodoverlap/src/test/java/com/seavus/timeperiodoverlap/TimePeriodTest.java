package com.seavus.timeperiodoverlap;

import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimePeriodTest {

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	private TimePeriod timePeriodB;

	@Before
	public void setUp() throws Exception {
		timePeriodB = new TimePeriod(formatter.parse("15/02/1991"),
				formatter.parse("15/02/2015"));
	}

	@Test
	public void testWhenAbeforeB() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/1981"),
				formatter.parse("15/02/1986"));
		Assert.assertFalse(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testWhenAintersectStartB() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/1981"),
				formatter.parse("15/02/1996"));
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testWhenAequalsB() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/1991"),
				formatter.parse("15/02/2015"));
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testWhenAintersectEndB() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/1995"),
				formatter.parse("15/02/2017"));
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testWhenAafterB() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/2017"),
				formatter.parse("15/02/2019"));
		Assert.assertFalse(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testWhenAinB() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/1996"),
				formatter.parse("15/02/1999"));
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}

	@Test
	public void testWhenBinA() throws Exception {
		TimePeriod timePeriodA = new TimePeriod(formatter.parse("15/02/1986"),
				formatter.parse("15/02/2019"));
		Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
	}
}
