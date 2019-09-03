package kr.or.ddit.reply.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

@WebServlet("/deleteReply")
public class DeleteReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IReplyService replyService;

	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	/**
	 *
	 * Method : doGet
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 댓글 삭제
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int replyNo = Integer.parseInt(request.getParameter("replyNo"));	// 댓글 번호
		int postNo = Integer.parseInt(request.getParameter("postNo"));		// 게시글 번호

		// 댓글 삭제
		replyService.deleteReply(replyNo);

		// 댓글 삭제한 게시글 상세 정보 jsp로 이동
		response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
	}

}
