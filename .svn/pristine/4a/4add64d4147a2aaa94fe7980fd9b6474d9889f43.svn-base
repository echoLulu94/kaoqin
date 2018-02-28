<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="table-box">
	<div class="query-area">
		<form rel="form" id="queryForm" method="get">
			<div class="form-group clearfix">
				<span class="input-span">学院：</span>
				<div class="col-sm-2">
					<select class="form-control" id="campus" name="campus"></select>
				</div>
				<span class="input-span">专业：</span>
				<div class="col-sm-2">
					<select class="form-control" id="professional" name="professional
"></select>
				</div>
				<span class="input-span">班级：</span>
				<div class="col-sm-2">
					<input class="form-control" id="className" name="className">
				</div>
				<span class="input-span">姓名：</span>
				<div class="col-sm-2">
					<input class="form-control" id="name" name="name">
				</div>
			</div>
			<div class="form-group clearfix">
				<span class="input-span">课程：</span>
				<div class="col-sm-2">
					<input class="form-control" id="course" name="course">
				</div>
				<span class="input-span">日期：</span>
				<div class="col-sm-2">
					<input class="form-control" id="startTime" name="startTime">
				</div>
				<span class="input-span to">-</span>
				<div class="col-sm-2">
					<input class="form-control" id="endTime" name="endTime">
				</div>
				<button class="btn btn-middle">搜索</button>
			</div>
		</form>
	</div>
	<table class="table" id="myTable">
		<thead>
		<tr>
			<th>学院</th>
			<th>专业</th>
			<th>班级</th>
			<th>姓名</th>
			<th>账号</th>
			<th>考勤</th>
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
