<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="h-100 d-flex align-items-center justify-content-between">
	<%-- logo --%>
	<div>
	<%-- 로그인 안 된 상태에서는 홈 버튼 누르면 로그인 화면으로 --%>
		<c:choose>
			<c:when test="${not empty userName}">
				<h1 class="font-weight-bold">
					<a href="/dog/user_dog_view" class="subject">MyPet</a>
				</h1>
			</c:when>
			<c:otherwise>
				<h1 class="font-weight-bold">
					<a href="/user/sign_in_view" class="subject">MyPet</a>
				</h1>
			</c:otherwise>
		</c:choose>
	</div>

	<%-- 로그인 정보 --%>
	<div>
		<%-- 로그인이 된 경우에만 로그인 정보와 로그아웃 노출 --%>
		<c:if test="${not empty userName}">
			<img src="${profileImagePath}" width="70" class="mr-3">
			<span class="mr-3">${userName} 님 환영합니다!</span>
			<a href="/user/sign_out">로그아웃</a>
		</c:if>
	</div>
</div>