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


</script >
<body>
	<br>
	<form  method="post" id="updateUserFrom">
		<input type="hidden" value="${id}"  name="id"></br>
		<input type="hidden"  name="loginTime"></br>
		<div class="">
			<center>
			账号:<input type="text"  name="userName"></br>
			密码:<input type="text" name="password"></br>
			手机号:<input type="text"   name="phone" ></br>
			</center>
		</div>
	</form>
</body>

<script >
	$(function () {
		toGoUser();
    });

    function toGoUser(){
        var id=$("[name=id]").val()
        $.ajax({
            url:"http://localhost:8090/user",
            type:"post",
            dataType:"json",
			data:{
                id:id,
		},
            async:false,
            success:function(result){
                $("[name=userName]").val(result.data.userName)
                $("[name=password]").val(result.data.password)
                $("[name=phone]").val(result.data.phone)
                $("[name=loginTime]").val(result.data.loginTime)
            },
            error:function(){
                alert("遇到未知错误！");
            }
        })
	}

</script>

</html>