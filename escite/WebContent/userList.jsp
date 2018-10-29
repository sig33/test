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
	
	<title>UserList画面</title>
	
</head>

<body>

	<div id = "header">
		<div id = "pr">
		</div>
	</div>
	
	<div id = "main">
		<div id = "top">
			<p>UserList</p>
		</div>
		<div>
			<s:if test="userListList == null || userListList.size() == 0">
				<h3>ユーザー情報はありません。</h3>
			</s:if>
			
			<s:elseif test="userListList != null">
				<h3>ユーザー情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>ログインID</th>
						<th>パスワード</th>
						<th>名前</th>
						<th>作成日</th>
					</tr>
					
				<s:iterator value="userListList">
					<tr>
						<td><s:property value="loginId"/></td>
						<td><s:property value="loginPass"/></td>
						<td><s:property value="userName"/></td>
						<td><s:property value="insert_date"/></td>
					</tr>
				</s:iterator>
				</table>
				
				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
				
			</s:elseif>
			
		</div>
		
	</div>
	
	<div id = "footer">
		<div id = "pr">
		</div>
	</div>

</body>
</html>