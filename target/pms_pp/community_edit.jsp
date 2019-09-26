<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*
		 * 提交
		 */
		$("#submitbutton").click(function() {
			if(validateForm()){
				/*$("#submitForm").submit();*/
				$.ajax({
	                    data: {"communityId":${comm.communityId },"communityName": $("#commName").val(), "communityBuildingingnum": $("#commBuildingingnum").val(), "communityAddress": $("#commAddress").val(), "communityManager": $("#commManager").val(), "communityManagerLink":$("#commManagerLink").val(), "communityArea":$("#commArea").val(), "communityCreatetime": $("#commCreatetime").val()},
	                    type: "POST",
	                    url: "<%=basePath %>updatecomm.action",
	                    success: function (flag) {
	                    	window.parent.$.fancybox.close();  
	                    },
	                    error : function (flag) {
	                    	window.parent.$.fancybox.close();
	                    }
	            });
				
			}
		});
		
		/*
		 * 取消
		 */
		$("#cancelbutton").click(function() {
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		});
		
		var result = 'null';
		if(result =='success'){
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		}
	});

	
	/** 表单验证  **/
	function validateForm(){
		if($("#commName").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源小区', ok:true,});
			return false;
		}
		if($("#commBuildingingnum").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源栋号', ok:true,});
			return false;
		}
		if($("#commManager").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源层号', ok:true,});
			return false;
		}
		if($("#commAddress").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源房号', ok:true,});
			return false;
		}
		if($("#commManagerLink").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源面积', ok:true,});
			return false;
		}
		if($("#commArea").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写计租面积', ok:true,});
			return false;
		}
		if($("#commCreatetime").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源座落地址', ok:true,});
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form id="submitForm" name="submitForm" action="<%=basePath %>insertcomm.action" method="post">
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">编辑社区</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">社区名</td>
					<td class="ui_text_lt">
						<input type="text" id="commName" value="${comm.communityName }" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房屋数</td>
					<td class="ui_text_lt">
						<input type="text" id="commBuildingingnum" value="${comm.communityBuildingingnum }" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">地址</td>
					<td class="ui_text_lt">
						<input type="text" id="commAddress" value="${comm.communityAddress }" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">负责人</td>
					<td class="ui_text_lt">
						<input type="text" id="commManager" value="${comm.communityManager }"  class="ui_input_txt02" onkeyup="checkFyFh();"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">负责人联系方式</td>
					<td class="ui_text_lt">
						<input type="text" id="commManagerLink" value="${comm.communityManagerLink }" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">占地面积</td>
					<td class="ui_text_lt">
						<input type="text" id="commArea" value="${comm.communityArea }" class="ui_input_txt02"/>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">建成时间</td>
					<td class="ui_text_lt">
						<input type="text" id="commCreatetime" value="${comm.communityCreatetime }" class="ui_input_txt02"/>
					</td>
				</tr>


				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="button" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>

</body>
</html>