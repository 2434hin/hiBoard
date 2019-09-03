package kr.or.ddit.post.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostFile;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

@WebServlet("/fileDownload")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;

	//다운로드 버퍼 크기
	private static final int BUFFER_SIZE = 8192; // 8kb

	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}

	/**
	 *
	 * Method : doGet
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 파일 다운로드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int fileNo = Integer.parseInt(request.getParameter("fileNo"));	// 다운로드 할 파일 번호

		// 파일 번호에 맞는 파일 정보 조회
		PostFile file = postService.getPostFile(fileNo);

	    InputStream is = null;

	    try {
	      is = new FileInputStream(file.getRealfilename());
	      download(request, response, is);
	    } finally {
	      try {
	        is.close();
	      } catch (Exception ex) {
	      }
	    }

	}

	/**
	 *
	 * Method : download
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @param is
	 * Method 설명 : 파일 다운로드
	 */
	private void download(HttpServletRequest request, HttpServletResponse response, InputStream is) {

		 byte[] buffer = new byte[BUFFER_SIZE];

		 BufferedInputStream fin = null;
	     BufferedOutputStream outs = null;

 	     try {
	       fin = new BufferedInputStream(is);
	       outs = new BufferedOutputStream(response.getOutputStream());
	       int read = 0;

	       while ((read = fin.read(buffer)) != -1) {
	         outs.write(buffer, 0, read);
	       }
	     } catch (IOException ex) {

	     } finally {
	       try {
	         outs.close();
	       } catch (Exception ex1) {
	       }

	       try {
	         fin.close();
	       } catch (Exception ex2) {

	       }
	    }
	}

}
