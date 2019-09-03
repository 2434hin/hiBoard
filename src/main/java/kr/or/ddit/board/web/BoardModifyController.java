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

@WebServlet("/boardModify")
public class BoardModifyController extends HttpServlet {
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

		// 게시판 생성
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
	 * Method 설명 : 게시판 수정
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시판 수정 버튼 클릭 시
		request.setCharacterEncoding("UTF-8");

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));	// 게시판 번호
		String boardName = request.getParameter("boardNm");					// 게시판 이름
		int useYN = Integer.parseInt(request.getParameter("useYN"));		// 게시팡 사용여부

		Board board = new Board();
		board.setBoardno(boardNo);
		board.setBoardname(boardName);
		board.setUseyn(useYN);

		// 게시판 수정
		boardService.updateBoard(board);

		// 게시판 생성 메뉴로 이동
		doGet(request, response);
	}

}
