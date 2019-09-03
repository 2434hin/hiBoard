package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {

	private IUserDao userDao;
	private SqlSession sqlSession;

	@Before
	public void setup() {
		userDao = new UserDao();
		sqlSession = MybatisUtil.getSession();
	}

	// 테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		sqlSession.close();
	}

	/**
	 *
	 * Method : getUserTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";

		/***When***/
		User userVo= userDao.getUser(sqlSession, userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
	}

}
