package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostDao {

	/**
	 *
	 * Method : getPostList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	List<Post> getPostList(SqlSession sqlSession, Map<String, Object> paramter);

	/**
	 *
	 * Method : getPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	Post getPost(SqlSession sqlSession, int postNo);

}
