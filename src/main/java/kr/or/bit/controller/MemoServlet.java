package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

/**
 * Servlet implementation class MemoServlet
 */
@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public MemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("데이터 삽입하기 구현");
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		  
		  
		memodao m =new memodao();
		memo temp = new memo(request.getParameter("id"),request.getParameter("email"),request.getParameter("memo"));
		System.out.println(temp);
		m.insertMemo(temp);
		out.print("<script>");
     	out.print("location.href='MemoList';");  
     	out.print("</script>");
     	
     	/*강사님 해답
     	 * request.setCharacterEncoding("UTF-8");//필터
     	 * String id = request.getParameter("id");
     	 * String email = request.getParameter("email");
     	 * String content = request.getParameter("memo");
     	 * 
     	 * //insert 대해서는 view 페이지가 없어요
     	 * //목록 이동
     	 * //글쓰기 가던가
     	 * //javascript 처리(이동)
     	 * response.setContentType("text/html;charset=UTF-8");
     	 * PrintWriter out = response.getWriter();
     	 * 
     	 * try{
     	 * memodao dao = new memodao();
     	 * int row = dao.insertMemo(new memo(id,email,content));
     	 * 
     	 * if(row >0){
     	 * 		out.print("<script>");
     	 * 		out.print("alert('등록성공');");
     	 * 		out.print("location.href='MemoList'");
     	 * 		out.print("</script>");
     	 * }
     	 * } catch(Exception e){
     	 * 		out.print("<script>");
     	 * 		out.print("alert('등록실패');");
     	 * 		out.print("location.href='Memo.html'");
     	 * 		out.print("</script>");
     	 * 
     	 * }finally{
     	 * 
     	 * }
     	 * 
     	 */
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
