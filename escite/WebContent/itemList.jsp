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
	
	<title>ItemList画面</title>
	
</head>

<body>

	<div id = "header">
		<div id = "pr">
		</div>
	</div>
	
	<div id = "main">
		<div id = "top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test="itemListList == null || itemListList.size() == 0">
				<h3>商品情報はありません。</h3>
			</s:if>
			
			<s:elseif test="itemListList != null">
				<h3>商品情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
						<th>作成日</th>
					</tr>
					
				<s:iterator value="itemListList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/><span>円</span></td>
						<td><s:property value="itemStock"/><span>個</span></td>
						<td><s:property value="insert_date"/></td>
					</tr>
				</s:iterator>
				</table>
				
				<s:form action="ItemListDeleteConfirmAction">
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