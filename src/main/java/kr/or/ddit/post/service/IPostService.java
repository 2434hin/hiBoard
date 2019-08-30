package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;

public interface IPostService {

	/**
	 *
	 * Method : getPostList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param paramter
	 * @return
	 * Method 설명 : 게시판 번호에 맞는 게시글 출력
	 */
	List<Post> getPostList(Map<String, Object> paramter);

	/**
	 *
	 * Method : getPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 상세 정보 조회
	 */
	Post getPost(int postNo);

	/**
	 *
	 * Method : insertPostNew
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param post
	 * @return
	 * Method 설명 : 새글작성
	 */
	int insertPostNew(Post post);

	/**
	 *
	 * Method : getPostNo
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 신규 게시글의 게시글 번호 조회
	 */
	int getPostNo();

	/**
	 *
	 * Method : deletePost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 삭제
	 */
	int deletePost(int postNo);

	/**
	 *
	 * Method : insertPostFile
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postFile
	 * @return
	 * Method 설명 : 게시글 작성 시 파일 저장
	 */
	int insertPostFile(PostFile postFile);

	/**
	 *
	 * Method : getPostFileList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param postNo
	 * @return
	 * Method 설명 : 게시글 번호에 맞는 파일 조회
	 */
	List<PostFile> getPostFileList(int postNo);

	/**
	 *
	 * Method : insertPostReply
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param post
	 * @return
	 * Method 설명 : 답글 작성
	 */
	int insertPostReply(Post post);

}
