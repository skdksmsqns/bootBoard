package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.QnaDTO;
import com.board.service.BoardService;
import com.board.service.QnaService;

@Controller
@RequestMapping("/comment")
public class QnaController {

	@Autowired
	private QnaService service;

	// 댓글 리스트
	@RequestMapping("/list")
	@ResponseBody
	private List<QnaDTO> mCommentServiceList(Model model,int no) throws Exception {
		return service.commentListService(no);
	}

	// 댓글 작성
	@RequestMapping("/write")
	@ResponseBody
	private int mCommentServiceInsert(@RequestParam int no, @RequestParam String qnaContent,@RequestParam String qnaWriter) throws Exception {

		QnaDTO comment = new QnaDTO();
		comment.setNo(no);
		comment.setQnaContent(qnaContent);
		comment.setQnaWriter(qnaWriter);
		return service.commentInsertService(comment);

	}

	// 댓글 수정
	@RequestMapping("/update")
	@ResponseBody
	private int mCommentServiceUpdateProc(@RequestParam int qnaNo, @RequestParam String qnaContent) throws Exception{

		QnaDTO comment = new QnaDTO();
	        comment.setQnaNo(qnaNo);
	        comment.setQnaContent(qnaContent);
	        
	        return service.commentUpdateService(comment);
	}

	// 댓글 삭제
	@RequestMapping("/delete/{qnaNo}")
	@ResponseBody
	private int mCommentServiceDelete(@PathVariable int qnaNo) throws Exception {

		return service.commentDeleteService(qnaNo);
	}

}
