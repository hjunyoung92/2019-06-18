package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageMaker {
	private Criteria cri;
	private boolean prev, next;
	private int current,start,end;
	private int totalCount;
	
	public PageMaker(Criteria cri, int totalCount) {
		
		this.totalCount = totalCount;
		this.current = cri.getPage();
		this.cri=cri;
		
		int tempEnd  = ((int)Math.ceil(current/10.0))*10;
		
		start = tempEnd - 9 ;
		prev = start != 1;
		
		int tempTotal = tempEnd * cri.getAmount();
		if (tempTotal > totalCount) {
			end = (int) Math.ceil(totalCount/(double)(cri.getAmount()));
		}else {
			end = tempEnd;
		}
		
		next= tempTotal <totalCount;
	}
	
	public String getLink(String path, int pageNum) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path)
				.queryParam("page", pageNum)
				.queryParam("amount", cri.getAmount());
		return builder.toUriString();
		
	}
	
}
