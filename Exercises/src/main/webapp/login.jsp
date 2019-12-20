<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html> 
	<head>
		<title>JSP for LoginForm form</title>
	</head>
	<body>
		<form action="customer/login" method="post">
			请您输入账号 : <input type="text" name="account"><br>
			请您输入密码 : <input type="password" name="password"><br>
			<input type="submit" value="登录">
		</form>
		<HR>
		${msg}
	</body>
</html>
