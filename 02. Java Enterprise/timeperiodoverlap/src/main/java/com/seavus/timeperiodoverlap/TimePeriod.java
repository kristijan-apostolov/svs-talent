package com.seavus.timeperiodoverlap;

import java.util.Date;

public class TimePeriod {

	private Date startDate;
	private Date endDate;

	public TimePeriod(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public boolean overlapsWith(TimePeriod timePeriod) {
		return (startDate.before(timePeriod.endDate) && endDate
				.after(timePeriod.startDate));
	}
}
