package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class UserServiceTest {

	private IUserService userService;

	@Before
	public void setup() {
		userService = new UserService();
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
		User userVo= userService.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
	}

}
