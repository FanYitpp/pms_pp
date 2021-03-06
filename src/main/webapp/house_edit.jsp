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
	                    data: {"houseId":${house.houseId },
		                    "houseName": $("#houseName").val(), 
		                    "houseNumber": sessionStorage.getItem('commid')+"0"+sessionStorage.getItem('builid')+"0"+sessionStorage.getItem('unitid')+"0"+$("#houseName").val(), 
		                    "houseStyleId": $("#houseStyleId").val(), 
		                    "houseType": $("#houseType").val(), 
		                    "houseCreatetime": $("#houseCreatetime").val()
		                    },
	                    type: "POST",
	                    url: "<%=basePath %>updatehouse.action",
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
		if($("#houseName").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源小区', ok:true,});
			return false;
		}
		if($("#houseStyleId").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源小区', ok:true,});
			return false;
		}
		if($("#houseType").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源小区', ok:true,});
			return false;
		}
		if($("#houseCreatetime").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源栋号', ok:true,});
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form id="submitForm" name="submitForm" method="post">
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">编辑房间</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">房间号</td>
					<td class="ui_text_lt">
						<input type="text" id="houseName" value="${house.houseName }" class="ui_input_txt02"/>
					</td>
				</tr>
				
				
				<tr>
					<td class="ui_text_rt">户型</td>
					<td class="ui_text_lt">
						<select id="houseStyleId">
						  <c:forEach items="${ALstyle }" var="style">
					  		<option value="${style.styleId }" <c:if test='${house.houseStyleId==style.styleId }'>selected</c:if>>
					  		${style.styleName }-${style.styleArea }㎡</option>
						  </c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">使用类型</td>
					<td class="ui_text_lt">
						<select id="houseType">
						 	<option value="1" <c:if test='${house.houseType==1 }'>selected</c:if>>民用</option>
						 	<option value="2" <c:if test='${house.houseType==2 }'>selected</c:if>>商用</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">入住时间</td>
					<td class="ui_text_lt">
						<input type="text" id="houseCreatetime" value="${house.houseCreatetime }" class="ui_input_txt02"/>
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