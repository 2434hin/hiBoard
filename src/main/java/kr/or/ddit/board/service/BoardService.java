package kr.or.ddit.board.service;

import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;

public class BoardService implements IBoardService {

	private IBoardDao boardDao;

	public BoardService() {
		boardDao = new BoardDao();
	}
}
