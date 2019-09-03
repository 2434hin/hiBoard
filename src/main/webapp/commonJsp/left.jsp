<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@page import="kr.or.ddit.board.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

	IBoardService boardService = new BoardService();

	List<Board> boardList = boardService.getBoardList();

	request.setAttribute("boardList", boardList);

%>

<ul class="nav nav-sidebar">
	<!-- 게시판 생성 -->
	<li class="active"><a href="<%=request.getContextPath() %>/boardNew"><span class="glyphicon glyphicon-music"></span> 게시판 생성 <span class="sr-only">(current)</span></a></li>

	<!-- 게시판으로 이동 -->
	<c:forEach items="${boardList}" var="board">
		<c:if test="${board.useyn == 0}">	<!-- 게시판 사용여부가 사용인 게시판만 표시 -->
			<li class="active"><a href="<%=request.getContextPath() %>/boardPost?boardno=${board.boardno}"><span class="glyphicon glyphicon-music"></span> ${board.boardname} <span class="sr-only">(current)</span></a></li>
		</c:if>
	</c:forEach>
</ul>

