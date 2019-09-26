<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
 	 <meta charset="UTF-8">
    <title>添加费项</title>
    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 
	
  </head>
  
  <body>
  
	<div class="easyui-navpanel" style="position:relative;padding:20px">
		<header>
			<div class="m-toolbar">
				<div class="m-title"></div>
				<div class="m-right">
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" outline="true" onclick="$('#ff').form('reset')" style="width:60px">Reset</a>
				</div>
			</div>
		</header>
		<form id="ff" method="post">
			<div style="margin-bottom:10px">
				<input class="easyui-textbox" name="costitemName" label="费项名称" prompt="" style="width:100%">
			</div>
			<div style="margin-bottom:10px">
				<input class="easyui-textbox" name="costitemUnit" label="费项单位:" prompt=""  style="width:100%">
			</div>
			<div style="margin-bottom:10px">
				<input class="easyui-numberbox" name="costitemPrice" label="费项价格:" prompt="" style="width:100%">
			</div>
		</form>
	</div>
	
  </body>
</html>