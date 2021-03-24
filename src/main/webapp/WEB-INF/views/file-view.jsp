<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>VIEW</h2>
<table border="1">
	<tbody id="tBody">
	</tbody>
</table>
<script>
window.onload = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/file-info?fiiNum=' + ${param.fiiNum});
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			var html = '';
			for(key in res){
				html += '<tr>';
				html += '<th>' + key + '</th>';
				html += '<td>' + res[key] + '</td>';
				html += '</tr>';
			}
			html += '<tr><td colspan="2" align="center">';
			html += '<button onclick="location.href=\'/views/file-update?fiiNum=' + ${param.fiiNum} + '\'">수정</button>';
			html += '  <button onclick="goDelete()">삭제</button>';
			html += '</tr></td>';
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}
function goDelete(){
	var param = {
			fiiNum : ${param.fiiNum}
	}
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/file-info-delete');
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			if(res.result == 1){
				alert(res.msg);
				location.href = '/views/file-view?fiiNum' + ${fiiNum};
			}
		}
	}
	xhr.setRequestHeader('content-type', 'application/json;charset="UTF-8"');
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>