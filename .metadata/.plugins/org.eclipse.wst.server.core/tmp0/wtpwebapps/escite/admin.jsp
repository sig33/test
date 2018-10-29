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
	
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	
	<title>Admin画面</title>
	
	<style type="text/css">
		#item{
			float:left;
			border:1px solid black;
			margin:20px;
			padding:20px;
		}
		
		#user{
			float:left;
			border:1px solid black;
			margin:20px;
			padding:20px;
		}
		
		#text-center > p{
			clear:both;
		}
	</style>
	
</head>

<body>

	<div id = "header">
		<div id = "pr">
		</div>
	</div>
	
	<div id = "main">
		<div id = "top">
			<p>Admin</p>
		</div>
		
		<div id = "text-center">
			<div id = "item">
				<p>商品</p>
				<s:form action="ItemCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				
				<s:form action="ItemListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
			
			<div id = "user">
				<p>ユーザー</p>
				<s:form action="UserCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				
				<s:form action="UserListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
			
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>
	</div>
	
	<div id = "footer">
		<div id = "pr">
		</div>
	</div>

</body>
</html>