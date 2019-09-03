package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {

	private IPostDao postDao;
	private SqlSession sqlSession;

	@Before
	public void setup() {
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSession();
	}

	@After
	public void tearDown() {
		sqlSession.close();
	}

	/**
	 *
	 * Method : getPostListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	@Test
	public void getPostListTest() {
		/***Given***/
		Map<String, Object> paramter = new HashMap<String, Object>();
        paramter.put("page", 1);
        paramter.put("pagesize", 10);
        paramter.put("boardNo", 7);

		/***When***/
        List<Post> postList = postDao.getPostList(sqlSession, paramter);

		/***Then***/
        assertEquals(2, postList.size());
	}

	/**
	 *
	 * Method : getPostTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	@Test
	public void getPostTest() {
		/***Given***/
		int postNo = 35;

		/***When***/
		Post post = postDao.getPost(sqlSession, postNo);

		/***Then***/
		assertEquals("brown", post.getUserid());
	}

	/**
	 *
	 * Method : insertPostTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 새글작성
	 */
	@Test
	public void insertPostTest() {
//		/***Given***/
//		Post post = new Post();
//		post.setBoardno(1);
//		post.setPosttitle("테스트 게시글");
//		post.setPostcontent("테스트 게시글");
//		post.setUserid("brown");
//
//		/***When***/
//		int insertCnt = postDao.insertPost(sqlSession, post);
//		sqlSession.commit();
//
//		/***Then***/
//		assertEquals(1, insertCnt);
	}

	/**
	 *
	 * Method : getPostNoTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 신규 게시글의 게시글 번호 조회
	 */
	@Test
	public void getPostNoTest() {
		/***Given***/

		/***When***/
		int postNO = postDao.getPostNo(sqlSession);

		/***Then***/
		assertEquals(53, postNO);
	}

	/**
	 *
	 * Method : deletePostTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시글 삭제
	 */
	@Test
	public void deletePostTest() {
		/***Given***/
		int postNo = 35;

		/***When***/
		int deletePost = postDao.deletePost(sqlSession, postNo);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deletePost);
	}

	/**
	 *
	 * Method : insertPostFileTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시글 작성 시 파일 저장
	 */
	@Test
	public void insertPostFileTest() {
		/***Given***/
		PostFile postFile = new PostFile();
		postFile.setFilename("공유1.png");
		postFile.setRealfilename("e:\\board\\2019\\09\\6b9f5aa4-ddf1-4dc1-86bb-436b1fca165a.png");
		postFile.setPostno(46);

		/***When***/
		int insertCnt = postDao.insertPostFile(sqlSession, postFile);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}

	/**
	 *
	 * Method : getPostFileListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시글 번호에 맞는 파일 조회
	 */
	@Test
	public void getPostFileListTest() {
		/***Given***/
		int postNo = 35;

		/***When***/
		List<PostFile> postFile = postDao.getPostFileList(sqlSession, postNo);

		/***Then***/
		assertEquals(1, postFile.size());
	}

	/**
	 *
	 * Method : updatePostTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시글 수정
	 */
	@Test
	public void updatePostTest() {
		/***Given***/
		Post post = new Post();
		post.setPostno(49);
		post.setPosttitle("222");
		post.setPostcontent("22");

		/***When***/
		int updateCnt = postDao.updatePost(sqlSession, post);

		/***Then***/
		assertEquals(1, updateCnt);
	}

	/**
	 *
	 * Method : deleteFileTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 파일 삭제
	 */
	@Test
	public void deleteFileTest() {
//		/***Given***/
//		int fileNo = 8;
//
//		/***When***/
//		int deleteCnt = postDao.deleteFile(sqlSession, fileNo);
//
//		/***Then***/
//		assertEquals(1, deleteCnt);
	}

	/**
	 *
	 * Method : getPostTotalCntTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 전체 게시글 건수 조회
	 */
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		int boardNo = 7;

		/***When***/
		int postCnt = postDao.getPostTotalCnt(sqlSession, boardNo);

		/***Then***/
		assertEquals(2, postCnt);
	}

	/**
	 *
	 * Method : getPostFileTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 선택한 파일 정보 조회
	 */
	@Test
	public void getPostFileTest() {
		/***Given***/
		int fileNo = 25;

		/***When***/
		PostFile postFile = postDao.getPostFile(sqlSession, fileNo);

		/***Then***/
		assertEquals("공유1.png", postFile.getFilename());
	}


}
