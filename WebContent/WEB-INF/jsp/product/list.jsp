<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	table { 
		border : 1px solid;    
		margin-left: 56px;
	    margin-top: 10px;
	    margin-bottom: 50px;
	    text-align: center;
	}
	table tr { border : 1px solid;}
	table td{ border : 1px solid; width:100px;}

</style>
<% 
	String path = request.getContextPath();
	
%>
<script type="text/javascript" src="<%=path %>/static/jquery-3.3.1.js"></script>
</head>
<body>

	<input name="name"><button id="btn-search">搜索</button>
	
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

	
	<script type="text/javascript">
	
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
			$("#table tbody").html("");	
			$.ajax({
				url:"<%=path %>/product/query3",
				data:{
					name:$("[name='name']").val()
				},
				success:function(data){
					debugger;
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
						html+= "<td><button class='btn-del' value='"+ this.id +"'>删除</button></td>"
						html+= "</tr>";
						$("#table tbody").append(html);	
					})
				}
				
			})
		})
	
		
	
	
	</script>
</body>
</html>