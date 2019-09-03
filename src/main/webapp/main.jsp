<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/commonJsp/basicLib.jsp" %>

<body>

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp" %>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="blog-header">
					<h1 class="blog-title">hiBoard</h1>
					<p class="lead blog-description"><span class="glyphicon glyphicon-heart-empty"></span>혜인 게시판<span class="glyphicon glyphicon-heart-empty"></span></p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<hr>
							<h2 class="blog-post-title">게시판 만들기</h2>
							<p class="blog-post-meta">2019.08.28 ~ 2019.09.02 / room 202</p>

							<p>jsp를 통한 웹 프로그래밍 학습</p>
							<hr>

							<h3>상세내역</h3>
							<p>게시판 만글기 요구사항</p>
							<ul>
								<li>게시판 => 신규 추가, 비황성화</li>
								<li>게시글 리스트 화면 => 계층 형, 페이징 기능(페이징 사이즈 : 10)</li>
								<li>게시글 작성 => 첨부파일은 5개 한정</li>
								<li>게시글 상세화면</li>
								<li>게시글 수정</li>
								<li>게시글 삭제 => 삭제 시 DB 내역은 남기기</li>
								<li>댓글 생성 => 500자 까지만 입력 가능</li>
								<li>댓글 삭제 => 삭제 시 DB 내역은 남기기</li>
							</ul>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>