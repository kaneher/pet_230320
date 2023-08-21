<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		</tbody>
	</table>
</div>
<div class="container d-flex justify-content-center">
	<a href="/user/update_user_information_view">반려견 정보 수정</a>
</div>