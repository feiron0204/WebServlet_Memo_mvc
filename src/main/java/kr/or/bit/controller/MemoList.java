package kr.or.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;

/**
 * Servlet implementation class MemoList
 */
@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemoList() {
        super();
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("목록보기 구현");
		memodao m=new memodao();
		
		try {
			System.out.println(m.getMemoList());
			request.setAttribute("memoList", m.getMemoList());
			request.getRequestDispatcher("memolist.jsp").forward(request, response);
			System.out.println("전송!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * //요청판단? 할필요없음 요청1당 서블릿1개니까
		 * //서비스(업무)
		 * memodao dao = new memodao();
		 * try{
		 * 		//데이터
		 * 		List<memo> memolist=dao.getMemoList();
		 * 
		 * 		//저장(session? request?)
		 * 		request.setAttribute("memolist",memolist);
		 * 
		 * 		//view 페이지
		 * 		RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
		 * 
		 * 		//view forward(데이터전달)
		 * 		dis.forward(request,response);
		 * 
		 * }catch(SQLException e){
		 * 		e.printStackTrace();
		 * }
		 */
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
