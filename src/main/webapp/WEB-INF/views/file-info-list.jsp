<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>사진</th>
	</tr>
	<tbody id="tBody">
	</tbody>
</table>
<script>
window.onload = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/file-infos');
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var res = JSON.parse(xhr.responseText);
			var html = '';
			for(var fi of res){
				html += '<tr>';
				html += '<td>' + fi.fiiNum + '</td>';
				html += '<td>' + fi.fiiTitle + '</td>';
				html += '<td><img src="/resources/' + fi.fiiFilePath + '" width="400"></td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();	
}
</script>
</body>
</html>