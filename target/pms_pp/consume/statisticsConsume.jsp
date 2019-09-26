<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>常规费用统计</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 

</head>
<body>
	<div style="border:0px solid #000;width:100%;padding:10px;">
		小区：<input id="commConsume" class="easyui-combobox" data-options="    
			        valueField: 'communityId',    
			        textField: 'communityName',
			        limitToList: true, 
			        panelHeight: 130,   
			        url: '${pageContext.request.contextPath}/community/selectCommList.action',    
			        onSelect: function(rec){    
			            var url = '${pageContext.request.contextPath}/building/selectBuildByComm.action?commId='+rec.communityId;      
			            $('#buildConsume').combobox('clear',true);
			            $('#unitConsume').combobox('clear',true);
			            $('#buildConsume').combobox('reload', url);
			            $('#unitConsume').combobox('disable',true);
			        }" /> &nbsp;&nbsp;  
		楼宇：<input id="buildConsume" class="easyui-combobox" data-options="    
			        valueField: 'buildingId',
			        textField: 'buildingName',
			        limitToList: true,
			        panelHeight: 130,
			        onSelect: function(rec){    
			            var url = '${pageContext.request.contextPath}/unit/selectUnitByBuild.action?buildId='+rec.buildingId;    
			           	$('#unitConsume').combobox('clear',true);
			           	$('#unitConsume').combobox('enable',true);
			            $('#unitConsume').combobox('reload', url);    
			        }" />  &nbsp;&nbsp;  
		单元：<input id="unitConsume" class="easyui-combobox" data-options="valueField:'unitId',limitToList: true,textField:'unitName',panelHeight: 130" /> &nbsp;&nbsp;
		起始日期：<input id="conStartDate" type="text" class="easyui-datebox " editable="false" >&nbsp;&nbsp;
		结束日期：<input id="conEndDate" type="text"  class="easyui-datebox" editable="false" >&nbsp;&nbsp;
		
		<a id="queryConsume" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> &nbsp;&nbsp;
		<a id="clearInfoConsume"  class="easyui-linkbutton" data-options="iconCls:'icon-clear'">清空数据</a> &nbsp;&nbsp;
		<a id="printConsumeInfo"  class="easyui-linkbutton" data-options="iconCls:'icon-print'">导出数据</a> &nbsp;&nbsp;
		
		<script type="text/javascript">
			$(function(){   
			 
			    $('#queryConsume').bind('click', function(){  
			    	getDateGridSta();
			    });
			    
			    $("#printConsumeInfo").click(function(){
				    var commId = $("#commConsume").val();
		    		var buildId = $("#buildConsume").val();
		    		var unitId = $("#unitConsume").val();
		    		var beginTime = $('#conStartDate').datebox('getValue');
    				var endTime = $('#conEndDate').datebox('getValue');
		    		window.open("${pageContext.request.contextPath}/consume/exportExcelConsumeInfo.action?commId="+commId+"&buildId="+buildId+"&unitId="+unitId+"&beginTime="+beginTime+"&endTime="+endTime);

			    }); 
			    
			    $("#clearInfoConsume").click(function(){
			    	$('#commConsume').combobox('clear',true);
			    	$('#buildConsume').combobox('clear',true);
			    	$('#unitConsume').combobox('clear',true);
			    	$('#conStartDate').datebox('clear',true);
			    	$('#conEndDate').datebox('clear',true);
			    });
			});  
		</script>
	</div>
	
	<table id="statistics" ></table>
	
    <script type="text/javascript">
    
    	function getDateGridSta(){
    		
    		var commId = $("#commConsume").val();
    		
    		var buildId = $("#buildConsume").val();
    		
    		var unitId = $("#unitConsume").val();
    		
    		var beginTime = $('#conStartDate').datebox('getValue');
    		var endTime = $('#conEndDate').datebox('getValue');
    	
    		$("#statistics").datagrid({
    			broder:20,
	    		toolbar: '#tb',
	    		striped: true,
	    		fit: false,
	    		border:false,
	    		queryParams: {
		        	commId: commId,
		        	buildId: buildId,
		        	unitId: unitId,
		        	beginTime:beginTime,
		        	endTime:endTime
		        },
	    		url : '${pageContext.request.contextPath}/consume/queryStatisticsConsume.action?time='+new Date().getTime(),
	    		columns : [[
	    					{field:'hnum',title:'房间编号',width:140,halign:'center',align:'center',rowspan:2,width:'10%',
		    					styler: function(value,row,index){
										return 'background-color:#469cee;color:#ffffff;';
								}
		    				},
		    				{field:'host_name',title:'户主',halign:'center',align:'center',rowspan:2,width:'9%'},
		    				{field:'host_link',title:'联系方式',halign:'center',align:'center',rowspan:2,width:'9%'},
	    					{title:'物业费',halign:'center',align:'center',colspan:3},
	    					{title:'卫生费',halign:'center',align:'center',colspan:3},
	    					{title:'取暖费',halign:'center',align:'center',colspan:3},
	    					{title:'水费',halign:'center',align:'center',colspan:3},
	    					{title:'电费',halign:'center',align:'center',colspan:3},
	    					{title:'污水处理费',halign:'center',align:'center',colspan:3}
	    				],[
	    				
	    				{field:'peopertyYes',title:'已缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'peopertyNo',title:'未缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'peopertyAll',title:'总',halign:'center',align:'center',width:'4%'},
	    				
	    				{field:'sanitationYes',title:'已缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'sanitationNo',title:'未缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'sanitationAll',title:'总',halign:'center',align:'center',width:'4%'},
	    				
	    				{field:'heatingYes',title:'已缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'heatingNo',title:'未缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'heatingAll',title:'总',halign:'center',align:'center',width:'4%'},
	    				
	    				{field:'waterYes',title:'已缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'waterNo',title:'未缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'waterAll',title:'总',halign:'center',align:'center',width:'4%'},
	    				
	    				{field:'electricYes',title:'已缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'electricNo',title:'未缴',halign:'center',align:'center',width:'4%'},
	    				{field:'electricAll',title:'总',halign:'center',align:'center',width:'4%'},
	    				
	    				{field:'sewageYes',title:'已缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'sewageNo',title:'未缴费',halign:'center',align:'center',width:'4%'},
	    				{field:'sewageAll',title:'总',halign:'center',align:'center',width:'4%'}
	    								
	    		]],
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