<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script >


</script>
<body>
	<br>
	<form  method="post" id="addUserForm">
		<input type="hidden" value="${user.id}" name="id"></br>
		<div class="">
			<center>
			账号:<input type="text" value="${user.userName}" name="userName"></br>
			密码:<input type="text" value="${user.password}" name="password"></br>
			手机号:<input type="text"  value="${user.phone}" name="phone" ></br>
			</center>
		</div>
	</form>
</body>
</html>