package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class ListCommand implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
	
	Paging paging = new Paging();
	//1.전체게시물의 수 구하기
	int count = DAO.getCount();
	paging.setTotalRecord(count);   
	//2.전체 게시물의 수를 활용해서 전체 페이지의 수를 구하자
	paging.setTotalPage(paging.getTotalRecord()/paging.getNumPerPage());
	if (paging.getTotalRecord()%paging.getNumPerPage() !=0) {
		paging.setTotalPage(paging.getTotalPage()+1);
	}
	//3. 현제 페이지를 구하기
	// list.jsp 부터 cPage라는 파라미터에 현재 페이지값이 들어있다.
	String cPage = request.getParameter("cPage");
	
	//맨처음 index를 통해서 들어오면 cPage라는 파라미터가 없다.
	if (cPage == null) {
		paging.setNowPage(1);
	}else {
		paging.setNowPage(Integer.parseInt(cPage));
	}
	
	// ** 4. 현제 페이지의 시작번호와 끝번호를 구해서 DB에서 가져오자
	paging.setBegin((paging.getNowPage()-1)*paging.getNumPerPage()+1);
	paging.setEnd((paging.getBegin()-1)+paging.getNumPerPage());
	List<BVO> list= DAO.getList(paging.getBegin(),paging.getEnd());
	
	// ** 5. 시작블록과 끝블록을 구하자
	paging.setBeginBlock((int)((paging.getNowPage()-1)/paging.getPagePerBlock())*paging.getPagePerBlock()+1);
	paging.setEndBlock(paging.getBeginBlock()+paging.getPagePerBlock()-1);
	// ** 주의사항 : endBlock이 totalPage보다 클 수 있다.
	// 				 이때는 쓸데없는 블록번호가 생성된다.
	//				 해결 방법은 endBlock을 totalPage로 변경하면된다.
	if (paging.getEndBlock() > paging.getTotalPage()) {
		paging.setEndBlock(paging.getTotalPage());
	}
	request.setAttribute("list", list);
	request.setAttribute("paging", paging);
	
	return "view/list.jsp";
}
}
