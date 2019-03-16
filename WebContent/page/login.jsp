<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String basePath = request.getScheme()+"://"+
   			request.getServerName()+":"+
			request.getServerPort()+
   			request.getContextPath()+"/"; 
%>

<html>
<head>
<base href="<%=basePath %>">
<title>Home</title>
<!-- Custom Theme files -->
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
<body>
<script src="common/js/jquery-3.1.1.min.js"></script>
<script src="js/cookie.js"></script>

<div class="login">
	<h2>Acced Form</h2>
	<div class="login-top">
		<h1>LOGIN FORM</h1>
		<form>
			<input type="text" id="username" value="User Id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入账号';}">
			<input type="password" id="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入密码';}">
			<p id="result">您还未登录</p>
	    </form>
	    <div class="forgot">
	    	<!--<a href="#">forgot Password</a>-->  <!-- loging()点击事件处理函数 -->
	    	<input type="submit" value="Login" id="login" onclick="loging()">
	    </div>
	</div>
	<div class="login-bottom">
		<h3><div class="checkbox control-wrapper">
			<label>
				<input type="checkbox" id="check" style="font-size: large" >是否以管理员身份登陆
			</label>
		</div></h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy; 2017.Hr-Zhou HR All rights reserved. - More Templates <a  target="_blank" title="">HrGraTest</a></p>
</div>

<!-- 先读取页面，在执行jquery，是为了让Message.hide();生效-->
<script type="text/javascript">
	//先隐藏你还没登录
	var Message=$("#result");
	Message.hide();
	
	var flag;
	function loging() {
		if($("#check").is(":checked")){
			flag=1;
		}else{
			flag=0;
		}
		var username=$("#username").val();
		var password=$("#password").val();
		
		$.ajax({
			type:"POST",
			/* async. 默认是true，即为异步方式，$.Ajax执行后，
            会继续执行ajax后面的脚本，直到服务器端返回数据后，
            触发$.Ajax里的success方法，这时候执行的是两个线程。
            若要将其设置为false，则所有的请求均为同步请求，在没有返回值之前，
            同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行 */
			async:false,
			url:"Admin/login",
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
		    dataType: "text",
		    data:{
		    	adminName:username,
		    	adminPassword:password,
		    	flag:flag
		    },
			//数据发送成功，服务器会返回响应信息data,浏览器接收并处理
			success:function(data){
				  window.location.href=data;
			},
			error:function(data){
				if(flag==1){
	                Message.html("登陆失败：用户名、密码错误或权限不足");
				}else{
					Message.html("登陆失败：用户名或者密码错误");
				}
				//显示隐藏标签
                Message.show();
            }
		});
		
		$('#username,#password').bind('keyup', function(e) {
	        if (e.keyCode == "13") {
	            $("#login").click();
	        }
	    });
		
	}
</script>

</body>
</html>