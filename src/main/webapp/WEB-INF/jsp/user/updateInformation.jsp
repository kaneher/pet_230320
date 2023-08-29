<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<table class="table table-border">
		<tbody>
			<tr>
				<th>비밀번호 변경</th>
				<td><input type="password" id="password" name="password" class="form-control" placeholder="변경할 비밀번호를 입력해 주세요"></td>
			</tr>
			<tr>
				<th>이메일 변경</th>
				<td><input type="text" id="email" name="email" class="form-control" placeholder="변경할 이메일을 입력해 주세요"></td>
			</tr>
			<tr>
				<th>주소 변경</th>
				<td><input type="text" id="address" name="address" class="form-control" placeholder="변경할 주소를 입력해 주세요"></td>
			</tr>
			<tr>
				<th>전화번호 변경</th>
				<td><input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="변경할 전화번호를 입력해 주세요"></td>
			</tr>
			<tr>
				<th>프로필 사진 변경</th>
				<td><input type="file" id="file" accept=".jpg, .jpeg, .png, .gif"></td>
			</tr>
		</tbody>
	</table>
	<div class="d-flex justify-content-center">
		<button type="button" id="saveBtn" class="btn btn-info">정보 수정 완료</button>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('#saveBtn').on('click', function() {
			
			// 값 가져오기
			let password = $('#password').val().trim();
			let email = $('#email').val().trim();
			let address = $('#address').val().trim();
			let phoneNumber = $('#phoneNumber').val().trim();
			let file = $('#file').val().trim();
			
			// validation check
			if (file != "") {
				let ext = file.split(".").pop().toLowerCase();
				//alert(ext);
				
				if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) {
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$('#file').val(''); // 파일을 비운다.
					return;
				}
			}
			
			// AJAX
			let formData = new FormData();
			formData.append("password", password); // key는 form태그의 name 속성과 같고 RequestParam명이 된다.
			formData.append("email", email);
			formData.append("address", address);
			formData.append("phoneNumber", phoneNumber);
			formData.append("file", $('#file')[0].files[0]);
			
			$.ajax({
				// request
				type:"post"
				, url:"/user/update_user_information"
				, data:formData
				, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
				, processData:false  // 파일 업로드를 위한 필수 설정
				, contentType:false  // 파일 업로드를 위한 필수 설정
				
				// response
				, success:function(data) {
					if (data.code == 1) {
						// 성공
						alert("회원정보가 수정되었습니다.");
						location.href = "/user/information_view";
					} else {
						// 로직상 실패
						alert(data.errorMessage);
					}
				}
				, error:function(request, status, error) {
					alert("회원정보를 수정하는데 실패했습니다.");
				}
			});
			
		});
	});
</script>