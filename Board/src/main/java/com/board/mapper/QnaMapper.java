package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.board.domain.QnaDTO;

@Mapper
@Repository("com.board.mapper.QnaMapper")
public interface QnaMapper {

	// 댓글 목록
	public List<QnaDTO> commentList(int no) throws Exception;

	// 댓글 작성
	public int commentInsert(QnaDTO comment) throws Exception;

	// 댓글 수정
	public int commentUpdate(QnaDTO comment) throws Exception;

	// 댓글 삭제
	public int commentDelete(int qnaNo) throws Exception;

}
