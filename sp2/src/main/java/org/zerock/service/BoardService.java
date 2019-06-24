/**
 * 
 */
package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

/**
 * @author bitcamp13
 *
 */
public interface BoardService extends GenericService<BoardVO, Integer> {
	public List<BoardVO> listAll();

}
