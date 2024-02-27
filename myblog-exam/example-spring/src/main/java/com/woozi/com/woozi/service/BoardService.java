
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

	private final BoardRepository boardRepository;
	
	/**
	 * 목록 리턴
	 * @return
	 */
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	/**
	 * 목록 상세보기
	 * @param boardSeq
	 * @return
	 */
	public Board getBoardDetail(Long boardSeq) {
		return boardRepository.getBoardDetail(boardSeq);
	}
	
	/**
	 * 게시물 저장
	 * @param board
	 */
	public void saveBoard(Board board) {
		boardRepository.saveBoard(board);
	}
	
	public void updateBoard(Board board) {
		boardRepository.updateBoard(board);
	}
	
	/**
	 * 게시물 삭제
	 * @param boardSeq
	 */
	public void deleteBoard(Long boardSeq) {
		boardRepository.deleteBoard(boardSeq);
	}
	
	
}
