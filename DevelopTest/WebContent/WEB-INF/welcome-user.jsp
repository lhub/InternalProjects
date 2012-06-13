<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome User</title>
</head>
<body>
<h1>${message}</h1>
<b>Title : </b><s:property value="title"/>
		<br>
		<s:push value = "artist">
			<b>Artist Bio :</b> <s:property value="bio" /> <br>
		</s:push>
</body>
</html>