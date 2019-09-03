package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/insertPost")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class InsertPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;

	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	/**
	 *
	 * Method : doPost
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 게시글 신규, 답글생성
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));	// 게시판 번호
		String postTitle = request.getParameter("postTitle");				// 게시글 제목
		String postContent = request.getParameter("postContent");			// 게시글 내용
		String parentpostno = request.getParameter("parentpostno");			// 부모게시글 번호

		// 로그인한 유저 정보 조회
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("S_USERVO");

		String userId = user.getUserId();	// 작성자

		Post post;
		int insertCnt = 0;
		if(parentpostno == null || parentpostno.equals("")) {

			// 세글 작성
			post = new Post(boardNo, postTitle, postContent, userId);
			insertCnt = postService.insertPost(post);

		} else {

			// 답글 작성
			int parentPostNo = Integer.parseInt(request.getParameter("parentpostno"));	// 부모게시글 번호
			int postGn = Integer.parseInt(request.getParameter("postGn"));				// 그룹 번호
			post = new Post(boardNo, postTitle, postContent, userId, postGn, parentPostNo);
			insertCnt = postService.insertPost(post);
		}

		// 글 작성 시 저장한 파일 insert
		String filename = "";
		String path = "";
		Collection<Part> file = request.getParts();
		for(Part p : file) {
			if("file".equals(p.getName())) {
				if(p.getSize() > 0) {
					filename = FileuploadUtil.getFilename(p.getHeader("Content-Disposition"));	// 사용자가 업로드한 파일명
					String realFilename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(p.getHeader("Content-Disposition"));
					path = FileuploadUtil.getPath() + realFilename + ext;

					p.write(path);

					// 파일 insert
					PostFile postFile = new PostFile(filename, path);
					postService.insertPostFile(postFile);
				}
			}
		}

		// 게시글 작성 성공 시
		if(insertCnt > 0) {
			int postNo = postService.getPostNo();	// 신규 게시글 번호 얻어오기

			// 게시글 생성 후 게시글 상세정보 jsp로 이동
			response.sendRedirect(request.getContextPath() + "/post?postNo=" + postNo);
		}
	}

}
