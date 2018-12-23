<%@page pageEncoding="utf-8" %>
<html>
	<head></head>
	<body>
		<form action="login.do" method="post" >
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login2.do" method="post" >
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login3.do" method="post" >
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login4.do" method="post" >
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login5.do" method="post" >
		测试session传值<br/>
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login6.do" method="post" >
		测试ModelMap传值<br/>
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login7.do" method="post" >
		ModelAndView对象,将处理结果添加到ModelAndView对象里<br/>
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login8.do" method="post" >
		测试重定向的第一种方式<br/>
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
		
		<form action="login9.do" method="post" >
		测试重定向的第二种方式<br/>
			账号:<input type="text" name="adminCode"/><br/>
			密码:<input type="password" name="pwd"/><br/>
			<input type="submit" value="登录"/><br/><br/>
		</form>
	</body>
</html>