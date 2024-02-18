
package com.woozi.com.woozi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woozi.com.woozi.domain.Board;
import com.woozi.com.woozi.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
/**
 * 게시판 Service
 * @author hyou
 */
@Service
@RequiredArgsConstructor
public class BoardService {

	private BoardRepository boardRepository;
	
	/**
	 * 목록 리
	 * @return
	 */
	List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	/**
	 * 목록 상세보기
	 * @param boardSeq
	 * @return
	 */
	Board getBoardDetail(Long boardSeq) {
		return boardRepository.getBoardDetail(boardSeq);
	}
	
	/**
	 * 게시물 저장
	 * @param board
	 */
	void saveBoard(Board board) {
		boardRepository.saveBoard(board);
	}
	
	/**
	 * 게시물 삭제
	 * @param boardSeq
	 */
	void deleteBoard(Long boardSeq) {
		boardRepository.deleteBoard(boardSeq);
	}
	
	
}
