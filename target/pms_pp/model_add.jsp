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


	
</script>
</head>
<body>
<form id="submitForm" name="submitForm" action="<%=basePath %>addModel.action" method="post">
	<div id="container">
		<div id="nav_links">
			当前位置：新增小区&nbsp;>&nbsp;<span style="color: #1A5CC6;"></span>
			<div id="page_close">
				
			</div>
		</div>
		<div class="ui_content">

			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">社区名</td>
					<td class="ui_text_lt">
						<input type="text" name="communityName" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房屋数</td>
					<td class="ui_text_lt">
						<input type="text" name="communityBuildingingnum" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">地址</td>
					<td class="ui_text_lt">
						<input type="text" name="communityAddress" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">负责人</td>
					<td class="ui_text_lt">
						<input type="text" name="communityManager" class="ui_input_txt02" onkeyup="checkFyFh();"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">负责人联系方式</td>
					<td class="ui_text_lt">
						<input type="text" name="communityManagerLink" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">占地面积</td>
					<td class="ui_text_lt">
						<input type="text" name="communityArea" class="ui_input_txt02"/>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">建成时间</td>
					<td class="ui_text_lt">
						<input type="text" name="communityCreatetime" class="ui_input_txt02"/>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">--------------------</td>
					<td class="ui_text_lt">--------------------</td>
				</tr>


				<tr>
					<td class="ui_text_rt">楼栋单元数</td>
					<td class="ui_text_lt">
						<input type="text" name="buildingUnitnum" class="ui_input_txt02"/>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">楼栋层数</td>
					<td class="ui_text_lt">
						<input type="text" name="buildingFloornum" class="ui_input_txt02"/>
					</td>
				</tr>
				
				<tr>
					<td class="ui_text_rt">--------------------</td>
					<td class="ui_text_lt">--------------------</td>
				</tr>

				<tr>
					<td class="ui_text_rt">单元内每层户数</td>
					<td class="ui_text_lt">
						<input type="text" name="unitFloorNum" class="ui_input_txt02"/>
					</td>
				</tr>


				
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input type="submit" value="提交" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>

</body>
</html>