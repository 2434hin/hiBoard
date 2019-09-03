package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/replyPost")
public class ReplyPostController extends HttpServlet {
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
	 * Method 설명 : 답글 작성 화면 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String postNo = request.getParameter("postNo");		// 게시글 번호
		String boardNo = request.getParameter("boardNo");	// 게시판 번호
		String postGn = request.getParameter("postGn");		// 게시글 그룹번호

		request.setAttribute("postNo", postNo);
		request.setAttribute("boardno", boardNo);
		request.setAttribute("postGn", postGn);

		// 답글 작성 jsp로 이동
		request.getRequestDispatcher("/post/postForm.jsp").forward(request, response);
	}

}
