<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	
	<title>ItemListDeleteConfirm画面</title>
	
	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action',url);
			$('form').submit();
		}
	</script>
</head>

<body>

	<div id = "header">
		<div id = "pr">
		</div>
	</div>
	
	<div id = "main">
		<div id = "top">
			<p>ItemListDeleteConfirm</p>
		</div>
		<div>
			<p>すべての商品を削除します。よろしいですか？</p>
			
			<s:form>
				<tr>
					<td><input type="button" value="ＯＫ" onclick="submitAction('ItemListDeleteCompleteAction')"/></td>
					<td><input type="button" value="キャンセル" onclick="submitAction('ItemListAction')"/></td>
				</tr>
			</s:form>
		</div>
	</div>
	
	<div id = "footer">
		<div id = "pr">
		</div>
	</div>

</body>
</html>