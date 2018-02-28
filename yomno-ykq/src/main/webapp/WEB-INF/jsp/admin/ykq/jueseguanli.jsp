<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="table-box">
    <div class="chart-change">
        <div class="chart-caption">角色管理</div>
    </div>
    <div class="form-content">
        <table class="table table-bordered role-table" id="myTable">
            <thead>
            <tr>
                <th></th>
                <th>角色名称</th>
                <th>角色说明</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
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
