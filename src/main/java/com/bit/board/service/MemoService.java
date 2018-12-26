package com.bit.board.service;

import com.bit.board.model.MemoDto;

public interface MemoService {
	int writeMemo(MemoDto memoDto);
	// ajax로 넘길거니까 List 말고 String으로 넘겨준다.
	String listMemo(int seq);
	int modifyMemo(MemoDto memoDto);
	int deleteMemo(int mseq);
}
