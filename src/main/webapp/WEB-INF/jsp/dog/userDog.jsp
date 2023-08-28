<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${dogEntityList}" var="dogEntity">
<div class="container user-dog-box d-flex justify-content-center">
	<div class="bg-info w-50">
		<img src="${dogEntity.dogProfileImagePath}" alt="반려견 사진" width="555" height="500">
	</div>
	<div class="bg-secondary w-50">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>반려견 이름</th>
					<td>${dogEntity.dogName}</td>
				</tr>
				<tr>
					<th>반려견 나이</th>
					<td>${dogEntity.dogAge}</td>
				</tr>
				<tr>
					<th>반려견 견종</th>
					<td><a href="/dogKind/detail_view?dogKindId=${dogEntity.dogKindId}">${dogKindEntity.dogKind}</a> - 버튼을 누르시면 견종 정보를 볼 수 있습니다.</td>
				</tr>
				<tr>
					<th>반려견 체중</th>
					<td>${dogEntity.dogWeight}</td>
				</tr>
			</tbody>
		</table>
		<div class="d-flex justify-content-center">
			<a href="/dog/update_dog_view?dogId=${dogEntity.id}" class="btn btn-success mr-5">반려견 정보 수정</a>
			<button type="button" class="deleteBtn btn btn-danger ml-5" data-dog-id="${dogEntity.id}">반려견 정보 삭제</button>
		</div>
	</div>
</div>
<br>
</c:forEach>
<div class="d-flex justify-content-center">
	<a href="/dog/add_dog_view"><button type="button" id="toAddDogBtn" class="btn btn-info">반려견 추가</button></a>
</div>

<script>
	$(document).ready(function() {
		$(".deleteBtn").on('click', function() {
			
			let dogId = $(this).data('dog-id');
			
			$.ajax({
				type:"delete"
				, url:"/dog/delete_dog"
				, data:{"dogId":dogId}
				, success:function(data) {
					if (data.code == 1) {
						alert("반려견 정보가 삭제되었습니다.");
						location.href="/dog/user_dog_view";
					} else {
						alert(data.errorMessage);
					}
				}
				
				, error:function(request, status, error) {
					alert("반려견 정보를 삭제하는 데 실패하였습니다.");
				}
			});
		});
	});
</script>