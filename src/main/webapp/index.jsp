<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.member.model.MemberDto"%>
<%

MemberDto memberDto = new MemberDto();
memberDto.setId("jieun");
memberDto.setName("김지은");
memberDto.setEmail("wldmsl0828@naver.com");

session.setAttribute("userInfo", memberDto);

response.sendRedirect(request.getContextPath()+"/badmin/boardmenu.bit");
%>