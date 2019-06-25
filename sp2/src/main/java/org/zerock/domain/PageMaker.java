package org.zerock.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageMaker {
	private Criteria cri;
	private boolean priv, next;
	private int totalCount;
	private int current,start,end;
	
	public PageMaker(Criteria cri, int totalCount) {
		
		this.totalCount = totalCount;
		this.current = cri.getPage();
		this.cri=cri;
		
		int tempEnd  = ((int)Math.ceil(current/10.0))*10;
		
		start = tempEnd - 9 ;
		priv = start != 1;
		
		int tempTotal = tempEnd * cri.getAmount();
		if (tempTotal > totalCount) {
			end = (int) Math.ceil(totalCount/(double)(cri.getAmount()));
		}else {
			end = tempEnd;
		}
		
		next= tempTotal <totalCount;
	}
	
	
}
