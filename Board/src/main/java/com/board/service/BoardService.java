package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.webjjang.util.PageObject;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	// 검색 게시판 리스트
	public List<BoardDTO> list(PageObject pageObject) {
		pageObject.setTotalRow(mapper.getCount(pageObject));
		return mapper.list(pageObject);
	}

	// 검색 게시판 글보기
	public BoardDTO view(int no, int inc) {
		if (inc == 1) {
			mapper.increas(no);
		}
		return mapper.view(no);
	}

	// 글쓰기
	public int write(BoardDTO dto) {
		return mapper.write(dto);
	}

	// 글수정
	public int update(BoardDTO dto) throws Exception {
		return mapper.update(dto);
	}

	// 글삭제
	public int delete(int no, String pw) throws Exception {
		return mapper.delete(no, pw);
	}

}
