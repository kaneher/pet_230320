<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${dogEntityList}" var="dogEntity">
<div class="user-dog-box d-flex justify-content-center">
	<div class="bg-info w-50">
		<img src="${dogEntity.dogProfileImagePath}" alt="반려견 사진" width="951" height="500">
	</div>
	<div class="bg-secondary w-50">
		<table>
			<thead>
				<tr>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<br>
</c:forEach>
<div class="d-flex justify-content-center">
	<a href="/dog/add_dog_view"><button type="button" id="toAddDogBtn" class="btn btn-info">반려견 추가</button></a>
</div>