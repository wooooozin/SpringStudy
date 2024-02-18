
package com.woozi.com.woozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woozi.com.woozi.domain.Board;

@Service
public interface BoardService {

	List<Board> findAll();
	
	Board getBoardDetail(Long boardSeq);
	
	void saveBoard(Board board);
	
	void deleteBoard(Long boardSeq);
	
	
}
