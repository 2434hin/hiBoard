package kr.or.ddit.reply.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.reply.model.Reply;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.util.MybatisUtil;

public class ReplyServiceTest {

	private IReplyService replyService;

	@Before
	public void setup() {
		replyService = new ReplyService();
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
		int insertCnt = replyService.insertReply(reply);

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
		List<Reply> replyList = replyService.getReplyList(postNo);

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
		int deleteCnt = replyService.deleteReply(replyNo);

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
