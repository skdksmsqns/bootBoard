package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.QnaDTO;
import com.board.mapper.QnaMapper;

@Service
public class QnaService {

	@Autowired
	private QnaMapper mapper;

	// 댓글 목록
	public List<QnaDTO> commentListService(int no) throws Exception {
		return mapper.commentList(no);
	}

	// 댓글 작성
	public int commentInsertService(QnaDTO comment) throws Exception {

		return mapper.commentInsert(comment);
	}

	// 댓글 수정
	public int commentUpdateService(QnaDTO comment) throws Exception {

		return mapper.commentUpdate(comment);
	}

	// 댓글 삭제
	public int commentDeleteService(int qnaNo) throws Exception {

		return mapper.commentDelete(qnaNo);
	}

}
