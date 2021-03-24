<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="fiiTitle" placeholder="제목"><button onclick="search()">검색</button><br>
<input type="text" id="fiiContent" placeholder="내용"><button onclick="search()">검색</button><br>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>사진</th>
	</tr>
	<tbody id="tBody">
	</tbody>
</table>
<script>
function search() {
	var xhr = new XMLHttpRequest();
	var param = '?';
	var title = document.querySelector('#fiiTitle');
	var content = document.querySelector('#fiiContent');
	if(title.value.trim()){
		param += 'fiiTitle=' + title.value.trim();
	}
	if(content.value.trim()){
		param += 'fiiContent=' + content.value.trim();
	}
		
	xhr.open('GET', '/file-infos' + param);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var res = JSON.parse(xhr.responseText);
			var html = '';
			for(var fi of res){
				html += '<tr onclick="location.href=\'/views/file-view?fiiNum=' + fi.fiiNum + '\'" style="cursor:pointer">';
				html += '<td>' + fi.fiiNum + '</td>';
				html += '<td>' + fi.fiiTitle + '</td>';
				html += '<td>' + fi.fiiContent + '</td>';
				html += '<td><img src="/resources/' + fi.fiiFilePath + '" width="400"></td>';
				html += '</tr>';
			}
			html += '<tr><td colspan="4" align="right"><button onclick="location.href=\'/views/file-upload\'">등록</button></td></tr>'
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();	
}
window.onload = search;
</script>
</body>
</html>