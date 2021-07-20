package com.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int hit;
	private String pw;

}
