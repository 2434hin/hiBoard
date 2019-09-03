package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postForm")
public class NewPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * Method : doGet
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 새글 작성 화면 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardno = Integer.parseInt(request.getParameter("boardno"));	// 게시판 번호

		request.setAttribute("boardno", boardno);

		// 게시글 생성을 하기 위해 게시글 생성 form jsp로 이동
		request.getRequestDispatcher("/post/postForm.jsp").forward(request, response);
	}

}
