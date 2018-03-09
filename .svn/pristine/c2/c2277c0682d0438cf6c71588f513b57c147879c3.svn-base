<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="table-box">
	<div class="function_module">
		<div class="module">
			<div class="subordinate-module">主导航栏
			</div>
			<div id="div-left">
				<ul id="dtTree" class="ztree" data-url=""></ul>
			</div>
		</div>
		<div class="table-responsive div_table">
			<table class="table" id="myTable">
				<thead>
				<tr>
					<th>课程</th>
					<th>教师</th>
					<th>日期</th>
					<th>节次</th>
					<th>地点</th>
				</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
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
        }],
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
