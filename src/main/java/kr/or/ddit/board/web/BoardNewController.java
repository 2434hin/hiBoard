package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.UserService;

// 게시판 생성
@WebServlet("/boardNew")
public class BoardNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
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
	 * Method 설명 : 게시판 생성 화면 요청 처리
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 전체 게시판 목록 조회
		List<Board> boardList = boardService.getBoardList();

		request.setAttribute("boardList", boardList);

		request.getRequestDispatcher("/board/boardNew.jsp").forward(request, response);
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
	 * Method 설명 : 게시판 생성
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 게시판 생성 버튼 클릭 시
		request.setCharacterEncoding("UTF-8");

		String boardName = request.getParameter("newBoardName");		// 새로운 게시판 이름
		int useYN = Integer.parseInt(request.getParameter("newUseYN"));	// 새로운 게시판 사용여부

		Board board = new Board(boardName, useYN);

		int insertCnt = boardService.insertBoard(board);	// 게시판 insert

		if(insertCnt > 0) {
			// 게시판 생성 성공 시
			// 게시판 생성 후 게시판 생성 화면으로 이동
			doGet(request, response);
		}else {
			doGet(request, response);
		}
	}

}
