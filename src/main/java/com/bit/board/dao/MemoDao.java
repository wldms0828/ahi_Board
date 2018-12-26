package com.bit.board.dao;

import java.util.List;

import com.bit.board.model.MemoDto;

public interface MemoDao {
	int writeMemo(MemoDto memoDto);
	//db에서는 JSON으로 가져오는거 아니기 때문에 List로 받아야 한다.
	List<MemoDto> listMemo(int seq);
	int modifyMemo(MemoDto memoDto);
	int deleteMemo(int mseq);
}
