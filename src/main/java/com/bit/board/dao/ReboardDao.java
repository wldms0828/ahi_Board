package com.bit.board.dao;

import java.util.List;
import java.util.Map;

import com.bit.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);
	//실패 0 성공 1 -> 글 번호
	List<ReboardDto> listArticle(Map<String, String> param);
	ReboardDto viewArticle(int seq);
	// 아래 세가지가 다 일어나야 답글기능이 다 가능하다.
	int replyArticle(ReboardDto reboardDto);
	void updateStep(ReboardDto reboardDto);
	void updateReply(int pseq);
	
	void modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
}
