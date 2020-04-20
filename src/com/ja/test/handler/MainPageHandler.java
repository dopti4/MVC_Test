package com.ja.test.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.test.dao.BoardDao;
import com.ja.test.vo.BoardVO;

public class MainPageHandler {
	
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardVO> list = dao.getBoardList();
		
		request.setAttribute("BoardList", list);	//값 담고 포워딩
		
		
		//return "redirect:/read_page.do";	//리다이렉트
		
		return "/WEB-INF/main_page.jsp";	//포워딩
		
	}
}

