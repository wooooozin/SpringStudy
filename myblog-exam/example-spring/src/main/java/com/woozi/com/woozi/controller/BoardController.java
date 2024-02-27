package com.woozi.com.woozi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woozi.com.woozi.domain.Board;
import com.woozi.com.woozi.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping
	public List<Board> getList() {
		return boardService.findAll();
	}
	
	@GetMapping("/{boardSeq}")
	public Board get(@PathVariable Long boardSeq) {
		return boardService.getBoardDetail(boardSeq);
	}
	
	/**
	 * 게시물 저장
	 * @param board
	 */
	@PostMapping
	public void saveBoard(Board board) {
		boardService.saveBoard(board);
	}
	
	/**
	 * 게시물 삭제
	 * @param boardSeq
	 */
	@DeleteMapping
	public void deleteBoard(Long boardSeq) {
		boardService.deleteBoard(boardSeq);
	}
	
}
