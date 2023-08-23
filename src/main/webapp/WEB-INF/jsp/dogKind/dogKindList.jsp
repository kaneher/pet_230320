<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>견종 사진</th>
				<th>견종 이름</th>
			</tr>
		</thead>
		<c:forEach items="${dogKindEntityList}" var="dogKindEntity" varstatus="status">
		<tbody>
			<tr>
				<td>${status.count}</td>
				<td>${dogKindEntity.dogKindImagePath}</td>
				<td>${dogKindEntity.dogKind}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>