package kr.or.ddit.board.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

public class BoardServiceTest {

	private IBoardService boardService;

	@Before
	public void setup() {
		boardService = new BoardService();
	}

	/**
	 *
	 * Method : getBoardListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 전체 목록 조회
	 */
	@Test
	public void getBoardListTest() {
		/***Given***/

		/***When***/
		List<Board> boardList = boardService.getBoardList();

		/***Then***/
		assertEquals(4, boardList.size());
	}

	/**
	 *
	 * Method : insertBoardTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 생성
	 */
	@Test
	public void insertBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardname("테스트 게시판");
		board.setUseyn(0);

		/***When***/
		int inserCnt = boardService.insertBoard(board);

		/***Then***/
		assertEquals(1, inserCnt);
	}

	/**
	 *
	 * Method : updateBoardTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 사용 수정
	 */
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setBoardno(7);
		board.setBoardname("혜인 전용 게시판");
		board.setUseyn(1);

		/***When***/
		int updateCnt = boardService.updateBoard(board);

		/***Then***/
		assertEquals(1, updateCnt);
	}

	/**
	 *
	 * Method : getBoardTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 번호에 맞는 게시판 조회
	 */
	@Test
	public void getBoardTest() {
		/***Given***/
		int boardNo = 1;

		/***When***/
		Board board = boardService.getBoard(boardNo);

		/***Then***/
		assertEquals("자유게시판", board.getBoardname());
	}
}
