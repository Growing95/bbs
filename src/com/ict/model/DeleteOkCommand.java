package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;

public class DeleteOkCommand implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	String b_idx=request.getParameter("b_idx");
	String cPage=request.getParameter("cPage");
	// 댓글이 없으면 삭제 가능, 댓글이 있으면 오류발생 
	/*
	 * try { int result=DAO.getDelete(b_idx); System.out.println(b_idx);
	 * 
	 * } catch (Exception e) { return "view/error.jsp"; }
	 */
	
	try {
		int result=DAO.getDeleteAll(b_idx);
	} catch (Exception e) {
		return "view/error.jsp";
	}
	return "MyController?cmd=list&cPage="+cPage;
}
}
