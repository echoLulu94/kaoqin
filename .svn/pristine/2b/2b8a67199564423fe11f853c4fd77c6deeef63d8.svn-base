<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="table-box">
    <div class="chart-change">
        <div class="chart-caption">修改密码</div>
    </div>
    <div class="form-content">
        <form id="myForm">
            <div class="form-group clearfix">
                <div class="col-sm-2 t-a-r">原始密码：</div>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="password" id="password">
                </div>
            </div>
            <div class="form-group clearfix">
                <div class="col-sm-2 t-a-r">新密码：</div>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="newPassword" id="newPassword">
                </div>
            </div>
            <div class="form-group clearfix">
                <div class="col-sm-2 t-a-r">确认密码密码：</div>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="rePassword" id="rePassword">
                </div>
            </div>
            <div class="form-group clearfix">
                <div class="col-sm-offset-2 col-sm-2">
                    <button class="btn btn-save" onclick="updatePassword()">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function updatePassword(){
        if($("#password").val()=="" || $("#newPassword").val()=="" || $("#rePassword").val()==""){
            alert("请将表格填写完整！")
        }else {
            $.ajax({
                async : false,
                cache : false,
                type : 'POST',
                url : '${ctx}/admin/sysmanage/user/updatePassword',
                data:{
                    "password":$("#password").val(),
                    "newPassword":$("#newPassword").val(),
                    "rePassword":$("#rePassword").val(),
                },//参数
                error : function() {// 请求失败处理函数
                    $('#passwordModal').modal('hide')
                    $("#password").val("");
                    $("#newPassword").val("");
                    $("#rePassword").val("");
                },
                success : function(json){
                    if(json.success == true){
                        alert("密码修改成功！");
                        $('#passwordModal').modal('hide')
                        $("#password").val("");
                        $("#newPassword").val("");
                        $("#rePassword").val("");
                    }else{
                        alert(json.errorMsg)
                    }
                }
            });
        }
    }
</script>