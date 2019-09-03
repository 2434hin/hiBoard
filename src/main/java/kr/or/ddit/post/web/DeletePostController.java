package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

@WebServlet("/deletePost")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
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
	 * Method 설명 : 게시글 삭제
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postNo = Integer.parseInt(request.getParameter("deletePostNo"));	// 삭제 할 게시글 번호
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));		// 게시판 번호

		// 게시글 삭제
		postService.deletePost(postNo);

		// 게시글 삭제 후 게시판 번호에 맞는 게시글 리스트 jsp로 이동
		response.sendRedirect(request.getContextPath() + "/boardPost?boardno=" + boardNo);

	}

	/**
	 *
	 * Method : doPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 게시글 수정 창에서 파일 삭제
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int fileNo = Integer.parseInt(request.getParameter("fileNo"));	// 삭제 할 파일 번호
		int postNo  = Integer.parseInt(request.getParameter("postNo"));	// 게시글 번호

		// 파일 번호에 맞는 파일 삭제
		postService.deleteFile(fileNo);

		// 게시글 가져오기
		Post post = postService.getPost(postNo);

		// 게시글 파일 가져오기
		List<PostFile> fileList = postService.getPostFileList(postNo);

		request.setAttribute("post", post);
		request.setAttribute("fileList", fileList);

		// 파일 삭제 후 다시 게시글 수정 jsp로 이동
		request.getRequestDispatcher("/post/updatePost.jsp").forward(request, response);
	}

}
