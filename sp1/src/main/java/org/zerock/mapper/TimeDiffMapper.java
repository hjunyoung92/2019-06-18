package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeDiffMapper {

	@Select("select datediff(now(), '2019-04-03')")
	public int calcGap();
	
	@Select("select datediff(now(), #{day})")

	public int calcGapDay(String day);
	
}
