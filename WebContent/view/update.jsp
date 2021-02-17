<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:1000px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>
<script type="text/javascript">
function update_data(f) {
	if ("${bvo.pwd}"==f.pwd.value) {
		f.action="/0204_MVC_bbs/MyController?cmd=update_ok&cPage=${cPage}";
		f.submit();
		}else{
			alert("비밀번호가 틀렸습니다.");	
			f.pwd.value="";
			f.pwd.focus();
			return;
		}

}
function list_go(f) {
	f.action = "/0204_MVC_bbs/MyController?cmd=list";
	f.submit();
}
</script>
</head>
<body>
<div>
<div id="bbs">
	<form method="post" encType="multipart/form-data">
		<table summary="게시판 수정하기">
			<caption>게시판 수정</caption>
			<tbody>
				<tr>
					<th style="display: none;" colspan="2">번호:</th>
					<td><input type="hidden" name="b_idx" value="${bvo.b_idx}" size="45"/></td>
				</tr>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" size="45"/></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" size="12"/></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
					<textarea name="content" cols="50" 
							rows="8"></textarea>
					 <script>
                        CKEDITOR.replace( 'content' );
                </script>		
					</td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<td>
					<input type="file" name="file_name">${bvo.file_name}
					<input type="radio" name="f_name" value="">파일없음
					<input type="radio" name="f_name" value="${bvo.file_name}" checked>이전파일
					</td>
				</tr>
				<tr>
					<th>비밀번호:</th>
					<td><input type="password" name="pwd" size="12"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정하기" onclick="update_data(this.form)"/>
						<input type="reset" value="다시">
						<input type="button" value="목록" onclick="list_go(this.form)"/>
						<input type="hidden" name="cPage" value="${cPage}">
						<input type="hidden" name="b_idx" value="${bvo.b_idx}">
					</td>
				</tr>
				
			</tbody>
		</table>
	</form>
	</div>
</div>
</body>
</html>