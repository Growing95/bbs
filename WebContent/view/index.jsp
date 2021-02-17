<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send_go() {
	location.href="/0204_MVC_bbs/MyController?cmd=list&cPage=1";
} 
</script>
</head>
<body>
<button name="button" value="리스트보기" onclick="send_go()" style="width:400px; height: 400px;"></button>
</body>
</html>
