package com.bit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.board.common.dao.CommonDao;
import com.bit.board.dao.ReboardDao;
import com.bit.board.model.ReboardDto;

@Service
public class ReboardServiceImpl implements ReboardService {
	@Autowired
	private SqlSession sqlsession; 
	
	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int seq = sqlsession.getMapper(CommonDao.class).getNextSeq(); //글 번호
		reboardDto.setSeq(seq);
		reboardDto.setRef(seq);
		int cnt = sqlsession.getMapper(ReboardDao.class).writeArticle(reboardDto);//insert
		return cnt !=0 ? seq : 0;
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> param) {

		return null;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		return sqlsession.getMapper(ReboardDao.class).viewArticle(seq);
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyArticle(ReboardDto reboardDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int seq) {
		// TODO Auto-generated method stub
		
	}

}
