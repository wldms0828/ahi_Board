package com.bit.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.board.model.MemoDto;
import com.bit.board.service.MemoService;
import com.bit.member.model.MemberDto;
//@RestController(@Controller+@ResponseBody)
@Controller
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="memo", method=RequestMethod.POST, headers= {"Content-type=application/json;charset=UTF-8"})
	public @ResponseBody String write(@RequestBody MemoDto memoDto, HttpSession session) {
		//@ResponseBody로 넘긴건 JSON으로 보내겠다는 뜻이므로 List말고 String으로 받는다.
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
			int cnt = memoService.writeMemo(memoDto);
		}
		String memolist=memoService.listMemo(memoDto.getSeq());
		System.out.println(memolist);
		return memolist;
	}
	
	@RequestMapping(value="memo/{seq}", method=RequestMethod.GET)
	public @ResponseBody String list(@PathVariable(value="seq") int seq) {
		//@PathVariable(value="seq") 파라미터 값이 아니고 경로값을 받는 것이기 때문에 PathVariable
		String memolist=memoService.listMemo(seq);
		return memolist;
	}
	
	@RequestMapping(value="memo", method=RequestMethod.PUT, headers= {"Content-type=application/json;charset=UTF-8"})
	public @ResponseBody String modify(@RequestBody MemoDto memoDto, HttpSession session) {
		//@ResponseBody로 넘긴건 JSON으로 보내겠다는 뜻이므로 List말고 String으로 받는다.
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int cnt = memoService.modifyMemo(memoDto);
		}
		String memolist=memoService.listMemo(memoDto.getSeq());
		System.out.println(memolist);
		return memolist;
	}
	
	@RequestMapping(value="memo/{seq}/{mseq}", method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable(value="seq") int seq, @PathVariable(value="mseq") int mseq) {
		// 답글 삭제 이기 때문에 mseq를 받는것 글 삭제면 mseq를 받지 않아도 된다.
		memoService.deleteMemo(mseq);
		String memolist=memoService.listMemo(seq);
		return memolist;
	}

}
