package com.woozi.com.woozi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woozi.com.woozi.domain.Board;



@Repository
public interface BoardRepository {

	List<Board> findAll();
	
	Board getBoardDetail(Long boardSeq);
	
	void saveBoard(Board board);
	
	void deleteBoard(Long boardSeq);
	
	
}
