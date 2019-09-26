<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'expense-house.jsp' starting page</title>

	<link href="<%=basePath %>style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>style/authority/common_style.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>style/authority/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" media="screen"></link>
	<script type="text/javascript" src="<%=basePath %>scripts/authority/commonAll.js"></script>
	<script type="text/javascript" src="<%=basePath %>scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="<%=basePath %>scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<script type="text/javascript" src="<%=basePath %>scripts/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="<%=basePath %>scripts/artDialog/artDialog.js?skin=default"></script>
	
	<% List<Map<String,Object>> students = new ArrayList<Map<String,Object>>();
        Map<String,Object> s1 = new HashMap<String,Object>();
        s1.put("name","jim");
        s1.put("age","15");
        students.add(s1);
           Map<String,Object> s2 = new HashMap<String,Object>();
        s2.put("name","lucy");
        s2.put("age","12");
        students.add(s2);
       
       request.setAttribute("students",students); 
 %>
	<script type="text/javascript">
		var consumeid=new Array();
		function batchDel(){
			$("[name = IDCheck] : checked").each(function(i){
				$.ajax({
					type:"POST",
					url: "<%=basePath %>deleteByConsumeId.action",  
           	  		data: {consumeId:$(this).val()}, 
           	  		success:function(data){
           	  		$(this).parent.parent.remove();
             		}   
         		});
			})
		}
	function del(){
	$.ajax({
			type:"POST",
			url: "<%=basePath %>deleteByConsumeId.action",  
             data: {consumeId:$(this).val()}, 
             success:function(data){
             $(this).parent.parent.remove();
             }   
         });
	}
	</script>
  </head>
  
  <body>
  <h3>${requestScope.add}</h3>
  	<div id="box_bottom">
  		<input type="button" value="新增" class="ui_input_btn01" id="addBtn" /> 
		<input type="button" value="删除" class="ui_input_btn01" onclick="batchDel();" /> 
		<input type="button" value="导入" class="ui_input_btn01" id="importBtn" />
		<input type="button" value="导出" class="ui_input_btn01" onclick="exportExcel();" />
	</div>
   <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
   	<tr>
		<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" /></th>
		<th>房屋地址</th>
		<th>房屋名</th>
		<th>户主名</th>
		<th>费项</th>
		<th>总费用</th>
		<th>缴费时间</th>
		<th>操作</th>
	</tr>
	<%-- <c:forEach items="${requestScope.list}" var="link">
	<tr>
		<td><input type="checkbox" name="IDCheck" value="${link.consume_id}" class="acb" /></td>
		<td>${link.unit_name}</td>
		<td>${link.house_name}</td>
		<td>${link.host_name}</td>
		<td>${link.costitem_name}</td>
		<td>${link.consume_count}</td>
		<td>${link.consume_time}</td>
		<td><input type="button" value="修改" name="change" onclick="changeConsume()"><input type="button" value="删除" name="del" onclick="del()"></td>
	</tr>
	</c:forEach> --%>
	<c:forEach items="${students}" var="list">
	<tr>
	<td>${list.name }</td>
	<td>${list.age}</td>
	</tr>
	</c:forEach>
	</table>
	
	<div id="box_bottom">
		<input type="button" value="首页"  onclick="" /> 
		<input type="button" value="上一页"  id="importBtn" />
		<select name="pagenum">
		<option value="1" selected="selected">1</option>
		</select>
		<input type="button" value="下一页"  onclick="exportExcel();" />
		<input type="button" value="尾页"  onclick="" /> 
	</div>
  </body>
</html>
