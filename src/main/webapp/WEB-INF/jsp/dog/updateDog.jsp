<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="update-dog-box">
		<h1 class="mb-4">반려견 정보 수정</h1>
			<table class="update-dog-table table table-bordered">
				<tr>
					<th>반려견 나이</th>
					<td><input type="text" id="dogAge" name="dogAge" class="form-control col-9" placeholder="반려견 나이를 입력하세요."></td>
				</tr>
				<tr>
					<th>반려견 체중</th>
					<td><input type="text" id="dogWeight" name="dogWeight" class="form-control col-9" placeholder="반려견 체중을 입력하세요."></td>
				</tr>
				<tr>
					<th>반려견 사진</th>
					<td><input type="file" id="file" accept=".jpg, .jpeg, .png, .gif"></td>
				</tr>
			</table>
			
			<button type="button" id="updateDogBtn" class="btn btn-primary float-right">반려견 정보 수정</button>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('#updateDogBtn').on('click', function() {
			
			// validation
			let dogAge = $("#dogAge").val().trim();
			let dogWeight = $('#dogWeight').val().trim();
			let file = $('#file').val().trim();
			
			if (!dogAge) {
				alert("반려견 나이를 입력하세요");
				return false;
			}
			if (!dogWeight) {
				alert("반려견 체중을 입력하세요");
				return false;
			}
			if (file != "") {
				alert(file);
				// C:\fakepath\MI 파이썬기본 방특 10.pdf
				// 확장자만 뽑은 후 소문자로 변경한다.
				let ext = file.split(".").pop().toLowerCase();
				// alert(ext);
				
				if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) {
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$('#file').val(''); // 파일을 비운다.
					return;
				}
			}
			
			// AJAX 통신
			// 이미지를 업로드 할 때는 반드시 form 태그가 있어야 한다.
			let formData = new FormData();
			formData.append("dogAge", dogAge);
			formData.append("dogWeight", dogWeight);
			formData.append("file", $('#file')[0].files[0]);
			
			$.ajax({
				// request
				type:"post"
				, url:"/dog/update_dog"
				, data:formData
				, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
				, processData:false  // 파일 업로드를 위한 필수 설정
				, contentType:false  // 파일 업로드를 위한 필수 설정
				
				// response
				, success:function(data) {
					if (data.code == 1) {
						// 성공
						alert("반려견 정보가 수정되었습니다.");
						location.href = "/dog/user_dog_view";
					} else {
						// 로직상 실패
						alert(data.errorMessage);
					}
				}
				, error:function(request, status, error) {
					alert("반려견 정보를 수정하는데 실패했습니다.");
				}
			});
			
		});
	});
</script>