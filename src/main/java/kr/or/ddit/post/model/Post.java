package kr.or.ddit.post.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	private int postno;			// 게시글 번호
	private int boardno;		// 게시판 번호
	private String posttitle;	// 게시글 제목
	private String postcontent;	// 게시글 내용
	private String userid;		// 작성자
	private Date postwdate;		// 작성일시
	private int deleteyn;		// 삭제여부
	private int parentpostno;	// 부모게시글번호

	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getPostwdate() {
		return postwdate;
	}
	public String getPostwdateFmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(postwdate);
	}
	public void setPostwdate(Date postwdate) {
		this.postwdate = postwdate;
	}
	public int getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(int deleteyn) {
		this.deleteyn = deleteyn;
	}
	public int getParentpostno() {
		return parentpostno;
	}
	public void setParentpostno(int parentpostno) {
		this.parentpostno = parentpostno;
	}

}
