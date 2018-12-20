package com.bit.board.admin.service;

import java.util.List;

import com.bit.board.admin.model.BoardListDto;
import com.bit.board.admin.model.BoardTypeDto;
import com.bit.board.admin.model.CategoryDto;

public interface BoardAdminService {
	
	List<BoardListDto> getBoardMenu();//모든 값을 가져오라는 거 인자값 필요x
	
	List<CategoryDto> getCategory();
	void makeCategory(CategoryDto categoryDto);
	List<BoardTypeDto> getBoardType();
	void makeBoard(BoardListDto boardListDto);
	
}
