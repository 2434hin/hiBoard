package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

@WebServlet("/boardPost")
public class BoardPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;
	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
		boardService = new BoardService();
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
	 * Method 설명 : 게시판 번호에 맞는 게시글 리스트 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageStr = request.getParameter("page");			// 페이지 번호
        String pagesizeStr = request.getParameter("pagesize");	// 페이지 사이즈

        int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
        int pagesize = pagesizeStr == null ? 10 : Integer.parseInt(pagesizeStr);

        request.setAttribute("page", page);
        request.setAttribute("pagesize", pagesize);

        int boardNo = Integer.parseInt(request.getParameter("boardno"));

        Map<String, Object> paramter = new HashMap<String, Object>();
        paramter.put("page", page);
        paramter.put("pagesize", pagesize);
        paramter.put("boardNo", boardNo);

        // 게시판 번호에 맞는 페이지와 페이지 사이즈를 가지고 게시글 조회
        List<Post> postList = postService.getPostList(paramter);
        // 게시판 번호를 가지고 게시글의 총 개수 조회
        int totalCnt = postService.getPostTotalCnt(boardNo);

        int paginationSize = (int)Math.ceil((double)totalCnt / pagesize);

		request.setAttribute("postList", postList);
		request.setAttribute("paginationSize", paginationSize);

		// 게시글 리스트 조회 시 게시판의 정보 출력을 위한 게시판 정보 조회
		Board board = boardService.getBoard(boardNo);
		request.setAttribute("board", board);

		// 게시글 리스트 조회 jsp로 이동
		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);


	}

}
