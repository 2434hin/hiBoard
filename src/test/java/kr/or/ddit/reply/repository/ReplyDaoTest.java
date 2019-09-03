package kr.or.ddit.reply.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.reply.model.Reply;
import kr.or.ddit.util.MybatisUtil;

public class ReplyDaoTest {

	private IReplyDao replyDao;
	private SqlSession sqlSession;

	@Before
	public void setup() {
		replyDao = new ReplyDao();
		sqlSession = MybatisUtil.getSession();
	}

	@After
	public void tearDown() {
		sqlSession.close();
	}

	/**
	 *
	 * Method : insertReplyTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 댓글 등록
	 */
	@Test
	public void insertReplyTest() {
		/***Given***/
		Reply reply = new Reply();
		reply.setPostno(48);
		reply.setReplycontent("테스트 댓글");
		reply.setUserid("brown");

		/***When***/
		int insertCnt = replyDao.insertReply(sqlSession, reply);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);

	}

	/**
	 *
	 * Method : getReplyListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시글 번호에 맞는 댓글 조회
	 */
	@Test
	public void getReplyListTest() {
		/***Given***/
		int postNo = 49;

		/***When***/
		List<Reply> replyList = replyDao.getReplyList(sqlSession, postNo);

		/***Then***/
		assertEquals(1, replyList.size());
	}

	/**
	 *
	 * Method : deleteReplyTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 댓글 삭제
	 */
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int replyNo = 7;

		/***When***/
		int deleteCnt = replyDao.deleteReply(sqlSession, replyNo);

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
