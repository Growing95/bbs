package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.CommDeleteCommand;
import com.ict.model.CommWriteCommand;
import com.ict.model.Command;
import com.ict.model.DeleteCommand;
import com.ict.model.DeleteOkCommand;
import com.ict.model.ListCommand;
import com.ict.model.OneListCommand;
import com.ict.model.UpdateCommand;
import com.ict.model.UpdateOkCommand;
import com.ict.model.WriteCommand;
import com.ict.model.WriteOkCommand;


@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cmd= request.getParameter("cmd");
		Command cm= null;
		switch (cmd) {
		case "list":cm= new ListCommand(); break;
		case "write":cm= new WriteCommand(); break;
		case "write_ok":cm= new WriteOkCommand(); break;
		case "update":cm= new UpdateCommand(); break;
		case "delete":cm= new DeleteCommand(); break;
		case "delete_ok":cm= new DeleteOkCommand(); break;
		case "update_ok":cm= new UpdateOkCommand(); break;
		case "onelist":cm= new OneListCommand(); break;
		case "comm_write":cm= new CommWriteCommand(); break;
		case "comm_delete":cm= new CommDeleteCommand(); break;
  
		}
		String path= cm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
