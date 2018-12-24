package com.bit.board.common.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.board.common.dao.CommonDao;
import com.bit.util.BoardConstance;
import com.bit.util.PagiNavigation;
@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public PagiNavigation makePageNavigation(Map<String, String> param) {
		int pg = Integer.parseInt(param.get("pg"));
		int pageSize = BoardConstance.PAGE_COUNT;
		int listSize = BoardConstance.LIST_COUNT;
		
		PagiNavigation navigation = new PagiNavigation();                                                              
		int newArticleCount = sqlSession.getMapper(CommonDao.class).getNewArticleCount(Integer.parseInt(param.get("bcode")));
		int totalArticleCount = sqlSession.getMapper(CommonDao.class).getTotalArticleCount(param);// 여기서 부르고 mapper 파일로 가서 쿼리 생성
		navigation.setNewArticleCount(newArticleCount); //db
		navigation.setTotalArticleCount((totalArticleCount-1)/listSize +1); //db
		
		int totalPageCount = totalArticleCount/listSize;
		navigation.setTotalPageCount(totalPageCount);
		
		navigation.setPageNo(pg);
		
		navigation.setNowFirst(pg <= pageSize);
		navigation.setNowEnd((totalPageCount -1)/pageSize*pageSize < pg);
		
		return navigation;
	}

}
