<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="table-box">
	<table class="table" id="myTable">
		<thead>
		<tr>
			<th>项目名称</th>
			<th>考勤员</th>
			<th>是否通知</th>
			<th>状态</th>
			<th>考勤时间</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>

<script>
var table = {
		id : "#myTable",
		ajax : {
			url : "${ctx}/",
			dataSrc : "data.list"
		},
		columns : [ {
			data : ""
		}, {
			data : ""
		}, {
			data : ""
		}, {
			data : ""
		}, {
			data : ""
		}, {
			data : ""
		} ],
		columnDefs : [
				{
					targets : 0,
					orderable : false,
					render : function(data, type, full) {
						return "<input type='checkbox' class='minimal' value='" + data  + "'>";
					}
				}],
		order : [ [ 1, 'desc' ] ]
	};
	
$(function(){
	//initTable(table);
});	

</script>



