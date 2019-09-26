<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
 	 <meta charset="UTF-8">
    <title>费项列表</title>
    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 
	
  </head>
  
  <body>
  
  	<a id="addCostitem"  class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加费项</a>
  	
    <table id="costitemdg" ></table>
    
    <div id="dd"></div>
    
    <script type="text/javascript">
  		$(function(){
    		getDateGrid();
    	});
    	
    	function getDateGrid(){
    		$("#costitemdg").datagrid({
    			broder:20,
	    		striped: true,
	    		fit: false,
	    		border:false,
	    		url : '${pageContext.request.contextPath}/costitem/selectCostitemList.action?time='+new Date().getTime(),
	    		columns : [[
	    				{field:'costitemId',title:'费项编号',width:'25%',halign:'center',align:'center',rowspan:2
	    				/* 	,styler: function(value,row,index){
									return 'background-color:#87cefa;color:red;';
							} */
	    				},
	    				{field:'costitemName',title:'费项名称',width:'25%',halign:'center',align:'center',rowspan:2},
	    				{field:'costitemUnit',title:'费项单位',width:'25%',halign:'center',align:'center',rowspan:2},
	    				{field:'costitemPrice',title:'费项价格',width:'25%',halign:'center',align:'center',rowspan:2},		
	    		],[]],
	    		fitColums : true,
	    		singleSelect : true,
	    		pagination : true,
	    		pageNumber   : 1,
	    		pageSize : 15,
	    		pageList : [10,15,20]
	    	});
    	} 
    	
    	$("#addCostitem").click(function(){
	    	$('#dd').dialog({    
				    title: '添加费项',    
				    width: 400,    
				    height: 400,    
				    closed: false,    	
				    cache: false,       
				    modal: true,
				    href: 'costitem/addcostitem.jsp',
				    buttons:[{
						text:'保存',
						handler:function(){
							$.messager.alert("提示信息","添加成功!","info");
							var costitem = $("#ff").serialize();
							$.ajax({  
					             type: "POST",  
					             url: "${pageContext.request.contextPath}/costitem/addCostitem.action",  
					             data: costitem,
					             success: function(data){  
					                     alert(data);  
					                    }, 
					             error:function(e){  
					                     alert(e);
					             		}  
					         });  
							$('#dd').dialog("close",true);
						}
					},{
						text:'关闭',
						handler:function(){
							$('#dd').dialog("close");
						}
					}]
			});   
		});
  
  </script>
    
  </body>
  
</html>