<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
	text-align: center;
	padding: 4px 10px;
	background-color: #F6F6F6;
}

th {
	text-align: center;
	padding: 4px 10px;
	background-color: #B2CCFF;
}

h2 {
	text-align: center;
}

table {
	width: 800px;
	margin: 0px auto;
}
</style>
<script type="text/javascript">
	function delete_ok(f) {
		if ("${bvo.pwd}" == f.pwd.value) {
			var chk = confirm("진짜 삭제하나요?");
			if (chk) {
				f.action = "/0204_MVC_bbs/MyController?cmd=delete_ok";
				f.submit();

			} else {
				history.go(-1);
			}

		} else {
			alert("비밀번호틀림\n다시입력하세요");
			f.pwd.value = "";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
	<h2>BBS 글삭제</h2>
	<form method="post">
		<table>
			<tbody>
				<tr>
					<th>비밀번호 확인</th>
					<td align="left"><input type="password" name="pwd"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="button" value="삭제"
						onclick="delete_ok(this.form)"> 
						<input type="hidden" value="${bvo.b_idx}" name="b_idx"> 
						<input type="hidden" value="${cPage }" name="cPage">
					
						</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>