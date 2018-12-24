package com.bit.board.common.service;

import java.util.Map;

import com.bit.util.PagiNavigation;

public interface CommonService {
	PagiNavigation makePageNavigation(Map<String, String> param);
	//bcode, pg, key, word 
}
