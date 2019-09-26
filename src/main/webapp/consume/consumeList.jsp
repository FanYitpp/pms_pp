<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户费用明细</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 

</head>
<body>
	<div style="border:0px solid #000;width:100%;padding:10px;">
		
		起始日期：<input id="conStartDate" type="text" class="easyui-datebox " editable="false" >&nbsp;&nbsp;
		结束日期：<input id="conEndDate" type="text"  class="easyui-datebox" editable="false" >&nbsp;&nbsp;
		
		<input id="house_number" class="easyui-textbox" data-options="
					label: '房间编号:',
					labelPosition: 'left',
					buttonText: 'Search',
					onClickButton:function(){
						var house_number = $('#house_number').textbox('getValue');
						if(house_number.trim() == ''){
							alert('请输入房间编号！！！');
						}else{
							getDateGridList(house_number);
						}
					}" style="width:260px"/> &nbsp;&nbsp;
		
	</div>
	
	<table id="consumeInfo" ></table>
	
    <script type="text/javascript">
    
    /* $('#dg').datagrid('reload',url); */
    
    	function getDateGridList(house_number){
    	
    		var beginTime = $('#conStartDate').datebox('getValue');
    		var endTime = $('#conEndDate').datebox('getValue');
    		
    		/* $.fn.datebox.defaults.formatter = function(date){
				var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				return y+"-"+m+"-"+d;
			} */
    	
    		$("#consumeInfo").datagrid({
    			broder:20,
	    		toolbar: '#tb',
	    		striped: true,
	    		fit: false,
	    		border:false,
	    		queryParams: {
		        	houseNumber:house_number,
		        	beginTime:beginTime,
		        	endTime:endTime
		        },
	    		url : '${pageContext.request.contextPath}/consume/queryConsumeInfoByHouseNumber.action?time='+new Date().getTime(),
	    		columns : [[
	    				{field:'house_number',title:'房间编号：',width:'14%',halign:'center',align:'center',rowspan:2,
	    					/* ,styler: function(value,row,index){
									return 'background-color:#ffee00;color:red;';
							} */
	    				},
	    				{field:'costitem_name',title:'费项名称：',width:'14%',halign:'center',align:'center',rowspan:2},
	    				{field:'costitem_unit',title:'费项单位',width:'14%',halign:'center',align:'center',rowspan:2},
	    				{field:'consume_count',title:'费项数量',width:'14%',halign:'center',align:'center',rowspan:2},
	    				{field:'allPrice',title:'费项总价',width:'14%',halign:'center',align:'center',rowspan:2},
	    				{field:'consume_time',title:'费项时间',width:'14%',halign:'center',align:'center',rowspan:2},
	    				{field:'consume_status',title:'收费状态',width:'14%',halign:'center',align:'center',rowspan:2},				
	    		],[]],
	    		fitColums : true,
	    		singleSelect : true,
	    		pagination : true,
	    		pageNumber   : 1,
	    		pageSize : 15,
	    		pageList : [10,15,20]
	    	});
    	} 
    	
    </script>
</body>
</html>