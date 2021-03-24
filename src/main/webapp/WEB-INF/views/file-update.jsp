<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/file-info-update">
	<input type="text" name="fiiTitle"><br>
	<textarea name="fiiContent"></textarea><br>
	<input type="file" name="fiiFile"><br>
	<button>수정</button>
</form>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/file-info?fiiNum=' + ${param.fiiNum});
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var objs = document.querySelectorAll('input[type="text"], textarea');
			for(key in res){
				for(obj of objs){
					if(obj.name == key){
						obj.value = res[key];
					}
				}
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>