package com.bit.board.dao;

import java.util.List;
import java.util.Map;

import com.bit.board.model.AlbumDto;


public interface AlbumDao {
	int writeArticle(AlbumDto albumDto);
	//실패 0 성공 1 -> 글 번호
	List<AlbumDao> listArticle(Map<String, String> param);
	AlbumDao viewArticle(int seq);
	
	void modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
}
