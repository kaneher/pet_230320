<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<div class="mb-3">
		<h1>${dogKindEntity.dogKind}</h1>
	</div>
	<div class="mb-3">
		<img src="${dogKindEntity.dogKindImagePath}" alt="견종사진" width="500">
	</div>
	<div>
		${dogKindEntity.features}
	</div>
</div>