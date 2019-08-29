package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDao;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {

	private IPostDao postDao;

	public PostService() {
		postDao = new PostDao();
	}

	/**
	 *
	 * Method : getPostList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	@Override
	public List<Post> getPostList(Map<String, Object> paramter) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> postList = postDao.getPostList(sqlSession, paramter);
		sqlSession.close();

		return postList;
	}

	/**
	 *
	 * Method : getPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	@Override
	public Post getPost(int postNo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Post post = postDao.getPost(sqlSession, postNo);
		sqlSession.close();

		return post;
	}

}
