<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/material-blue/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery.validatebox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery.textbox.js"></script>
	
	
</head>

<body>
<script>
	
		//解决子框架嵌套的问题
		var path = window.location.pathname;
		path = path.substring(path.lastIndexOf("/")+1);
		if("index.jsp" == path){
			window.location.href="${pageContext.request.contextPath}/login.jsp";
		}
		

		function submitForm(){
			$('#adminLogin').submit();
		}
		function clearForm(){
			$('#adminLogin').form('clear');
		}
		function err(target, message){
			var t = $(target);
			if (t.hasClass('textbox-text')){
				t = t.parent();
			}
			var m = t.next('.error-message');
			if (!m.length){
				m = $('<div class="error-message"></div>').insertAfter(t);
			}
			m.html(message);
		}
		
	</script>
	

	<div style="background:url('images/logo.gif')0 0 no-repeat;height:100px;text-align:center;margin-top:30px;overflow:hidden;">
		<h2>天成物业管理系统</h2>
	</div>
	<div style="width:400px;margin:200px auto;">
		<h2>登录</h2>
		<p style="display:none;">When your mind's made up , there's no point trying to change it.</p>
		<div class="easyui-panel" title="管理员登录" style="width:100%;max-width:400px;padding:30px 60px;">
		
			<form id="adminLogin" method="post" action="${basePath}admin/queryAdmin.action">
				<div class="form-floating-label form-field" style="margin-bottom:20px">
					<input class="easyui-textbox" name="username" style="width:100%" data-options="label:'用户名:',labelPosition:'top'">
				</div>
				<div class="form-floating-label form-field" style="margin-bottom:20px">
					<input class="easyui-passwordbox" name="userpassword" style="width:100%" data-options="label:'密码:',labelPosition:'top'">
				</div>
			</form>
			
			<div style="text-align:center;padding:5px 0">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登录</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">重置</a>
			</div>
		</div>
	</div>
	
	
</body>
</html>