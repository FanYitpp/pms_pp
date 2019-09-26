<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="<%=basePath %>style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>style/authority/common_style.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>style/authority/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" media="screen"></link>
<script type="text/javascript" src="<%=basePath %>scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/artDialog/artDialog.js?skin=default"></script>

<title>信息管理系统</title>
<script type="text/javascript">
	$(document).ready(function(){
		/** 新增   **/
	    $("#addBtn").fancybox({
	    	'href'  : 'style_add.jsp',
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href = '<%=basePath %>initstyle.action';
	        }
	    });
		
		
	    /**编辑   **/
	    $("a.edit").fancybox({
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href ='<%=basePath %>initstyle.action';
	        }
	    });

	    $("#backBtn").click(function() {
	    	history.go(-1);
		});
	    
	});
	/** 用户角色   **/
	var userRole = '';


	/** 新增   **/
	function add(){
		$("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();	
	}
	


	/** 普通跳转 **/
	function jumpNormalPage(page){
		$("#submitForm").attr("action", "house_list.html?page=" + page).submit();
	}
	
	/** 输入页跳转 **/
	function jumpInputPage(totalPage){
		// 如果“跳转页数”不为空
		if($("#jumpNumTxt").val() != ''){
			var pageNum = parseInt($("#jumpNumTxt").val());
			// 如果跳转页数在不合理范围内，则置为1
			if(pageNum<1 | pageNum>totalPage){
				art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
				pageNum = 1;
			}
			$("#submitForm").attr("action", "house_list.html?page=" + pageNum).submit();
		}else{
			// “跳转页数”为空
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
			$("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
		}
	}
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_bottom">
							<input type="button" value="新增" class="ui_input_btn01" id="addBtn" /> 
							<input type="button" value="返回" class="ui_input_btn01" id="backBtn" /> 
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>类型名</th>
							<th>面积</th>
							<th>操作</th>
						</tr>
						
						<c:forEach items="${ALstyle }" var="style">
							<tr>
								<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
								<td>${style.styleName }</td>
								<td>${style.styleArea }</td>
								<td>
									<a href="<%=basePath %>initeditstyle.action?styleid=${style.styleId }" class="edit">编辑</a> 
									<a href="<%=basePath %>delectstyle.action?styleid=${style.styleId }">删除</a>
								</td>
							</tr>
						</c:forEach>
						
					</table>
				</div>
				<div class="ui_tb_h30">
				</div>
			</div>
		</div>
	</form>

</body>
</html>
