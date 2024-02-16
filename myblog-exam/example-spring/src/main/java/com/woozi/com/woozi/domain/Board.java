package com.woozi.com.woozi.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

	private long boardSeq;
	private String title;
	private String content;
	private Date regDate;
	
}
