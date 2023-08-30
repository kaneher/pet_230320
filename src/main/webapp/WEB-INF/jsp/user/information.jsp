<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container d-flex justify-content-center">
	<table class="table table-border">
		<tbody>
			<tr>
				<th>이름</th>
				<td>${userEntity.name}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${userEntity.email}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${userEntity.address}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${userEntity.phoneNumber}</td>
			</tr>
			<c:if test="${not empty userEntity.profileImagePath}">
				<tr>
					<th>프로필 이미지</th>
					<td><img src="${userEntity.profileImagePath}" alt="내 프로필 사진" width="300"></td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>
<div class="container d-flex justify-content-center">
	<a href="/user/update_user_information_view" class="btn btn-info">내 정보 수정</a>
</div>