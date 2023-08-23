<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>견종 사진</th>
				<th>견종 이름</th>
			</tr>
		</thead>
		<c:forEach items="${dogKindEntityList}" var="dogKindEntity" varStatus="status">
			<tbody>
				<tr>
					<td>${status.count}</td>
					<td><img src="${dogKindEntity.dogKindImagePath}" alt="견종 사진" width="200"></td>
					<td><a href="/dogKind/detail_view?dogKindId=${dogKindEntity.id}">${dogKindEntity.dogKind}</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>