package com.bit.board.dao;

import java.util.List;
import java.util.Map;

import com.bit.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);
	//실패 0 성공 1 -> 글 번호
	List<ReboardDto> listArticle(Map<String, String> param);
	ReboardDto viewArticle(int seq);
	int replyArticle(ReboardDto reboardDto);
	
	void modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
}
