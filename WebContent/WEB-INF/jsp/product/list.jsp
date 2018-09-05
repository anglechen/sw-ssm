<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid;
	margin-left: 56px;
	margin-top: 10px;
	text-align: center;
}

table tr {
	border: 1px solid;
}

table td {
	border: 1px solid;
	width: 100px;
}

.search,form,.M-box {
	margin-left: 56px;
}
</style>
<% 
	String path = request.getContextPath();
	
%>
<script type="text/javascript" src="<%=path %>/static/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=path %>/static/jquery.pagination.js"></script>
</head>
<body>
	<div>
		
	<form action="/sw-ssm/product/add">
		<input name="id" type="hidden"/>
		<div>资产名称：<input name="name"></div>
		<div>资产类型：<input name="type"></div>
		<div>出厂日期：<input  id="produceDate" name="produceDate"></div>
		<div>资产状态：<input name="status"></div>
		<div>资产价格：<input name="prices"></div>
		<div><button type="submit" >表单新增提交</button>
			<button type="button" id= "save">ajax新增提交</button>
		<button type="button" id= "update">ajax修改提交</button></div>
	</form>
	
	</div>
	<div class="search">
		<input name="search-name">
		<button id="btn-search">搜索</button>
	</div>
	
	
	
	<table id="table">
		<thead>
			<tr>
				<td></td>
				<td>id</td>
				<td>资产名称</td>
				<td>类型</td>
				<td>日期</td>
				<td>状态</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody></tbody>
		
	</table>
	<div class="search">
		<button class="page">上一页</button>
		<span id="page"></span>
		<button class="page">下一页</button>
		<span id="rowcount"></span>
	</div>
	
	<div class="M-box"></div>
	
	<div>
		<form action=""></form>
	</div>
	
	<script type="text/javascript">
		/* 当前页 */	
		var currenPage = 1;
		
		/* 分页的条数 */
		var rowCount = 5;
		
		/* 总记录条数 */
		var allCount = 0;
		$("#rowcount").html("每页显示" + rowCount +"条")
		
		function dateFormat(date){
			var d = new Date(date);
			var y = d.getFullYear();
			var M = d.getMonth()+1;
			var day = d.getDate()+1;
			var h = d.getHours();
			var mm = d.getMinutes();
			var s = d.getSeconds();
			return y+"-" + M + "-" + day + " " + h + ":" + mm + ":" + s;
		}
	
	
		$("#btn-search").on("click",function(){
			/* 获取当前总的记录条数 */
			$.ajax({
				url:"<%=path %>/product/query4",
				async:false,/* 把异步请求改成同步 */
				data:{
					name:$("[name='name']").val()
				},
				success:function(data){
					allCount = data.result;
				}
			})
			
			/* 获取当前符合条件的记录 */
			$.ajax({
				url:"<%=path %>/product/query3",
				data:{
					name:$("[name='search-name']").val()
				},
				success:function(data){
					debugger;
					
					handelTable(data);
					
				}
				
			})
		})
		
		/* 动态绑定删除事件 */
		$("#table").on("click",".btn-del",function(){
			var that = $(this).parents("tr");
			$.ajax({
				url:"<%=path %>/product/delete",
				data:{
					id:$(this).val()
				},
				success:function(data){
					alert("删除成功！");
					that.remove();
					
				},
				error:function(a,b,c){
					debugger;
				}
			})
		})
		/* 动态绑定修改事件 */
		$("#table").on("click",".btn-update",function(){
			$.ajax({
				url:"<%=path %>/product/query3",
				data:{
					id:$(this).val()
				},
				success:function(data){
					debugger;
					if(data.length > 0){
						$("input[name='id']").val(data[0].id);
						$("input[name='name']").val(data[0].name);
						$("input[name='type']").val(data[0].type);
						$("input[name='produceDate']").val(dateFormat(data[0].produceDate));
						$("input[name='status']").val(data[0].status);
						$("input[name='prices']").val(data[0].prices);
					}
					
				}
			})
			
		})
		
		/* 分页处理信息 */
		$(".page").on("click",function(){
			$.ajax({
				url:"<%=path %>/product/query3",
				data:{
					name:$("[name='name']").val(),
					startPage:(currenPage - 1) * rowCount,
					rowCount:rowCount
				},
				success:function(data){
					handelTable(data);
				}
			})
		})
		
		
		/* 用来处理页面数据的显示 */
		function handelTable(data){
				$("#table tbody").html("");	
				$(data).each(function(){
					html="<tr>";
					html+= "<td> <input type = 'checkbox' value ='"+ this.id +"' /></td>";
					html+= "<td>"+ this.id +"</td>";
					html+= "<td>"+ this.name +"</td>"
					html+= "<td>"+ this.type +"</td>"
					html+= "<td style='width:200px;'>"+ dateFormat(this.produceDate) +"</td>"
					html+= "<td>"+ this.status +"</td>"
					html+= "<td>"+ this.prices +"</td>"
					/* <button value='1' /> */
					html+= "<td><button class='btn-del' value='"+ this.id +"'>删除</button>"
					html+= "<button class='btn-update' value='"+ this.id +"' >修改</button></td>"
					html+= "</tr>";
					$("#table tbody").append(html);	
				})	
				/* 处理分页信息 */
				var dataLength = allCount;
				var pageLength = parseInt(dataLength/rowCount);
				if(dataLength%rowCount > 0){
					pageLength += 1;
				}
				$("#page").html("");
				for(var i = 1 ; i<=pageLength;i++ ){
					var html = "<button>" + i +"</button>"
					$("#page").append(html);
				}
				
				/* 直接用插件的处理分页 */
				$('.M-box').pagination({
				    pageCount:pageLength,
				    jump:true,
				    coping:true,
				    homePage:'首页',
				    endPage:'末页',
				    prevContent:'上页',
				    nextContent:'下页',
				    callback:function(index){
				    	
				    	$.ajax({
							url:"<%=path %>/product/query3",
							data:{
								name:$("[name='name']").val(),
								startPage:(index - 1) * rowCount,
								rowCount:rowCount
							},
							success:function(data){
								handelTable(data);
							}
						})
				    }
				});
		}
		
		$("#productDate").on("click",function(){
			WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});
		});
		
		
		/* 修改事件 */
		$("#update").on("click",function(){
			$.ajax({
				url:"/sw-ssm/product/update",
				data:{
					id:$("input[name='id']").val(),
					name:$("input[name='name']").val(),
					type:$("input[name='type']").val(),
					productDate:$("input[name='produceDate']").val(),
					status:$("input[name='status']").val(),
					prices:$("input[name='prices']").val()
				},
				success:function(data){
					alert("修改成功！");
				}
			})
		})
		
		/* 新增事件 */
		$("#save").on("click",function(){
			$.ajax({
				url:"/sw-ssm/product/add",
				data:{
					name:$("input[name='name']").val(),
					type:$("input[name='type']").val(),
					productDate:$("input[name='produceDate']").val(),
					status:$("input[name='status']").val(),
					prices:$("input[name='prices']").val()
				},
				success:function(data){
					alert("保存成功！");
				}
			})
		})
	
	</script>
</body>
</html>