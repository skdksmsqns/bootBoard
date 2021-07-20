package com.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class QnaDTO {
	private int qnaNo;
	private int no;
	private String qnaContent;
	private String qnaWriter;
	private Date qnaDatDATE;

}
