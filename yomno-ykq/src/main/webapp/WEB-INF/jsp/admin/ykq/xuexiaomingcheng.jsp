<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="table-box">
    <div class="chart-change">
        <div class="chart-caption">学校名称与LOGO设置</div>
    </div>
    <div class="form-content">
        <form id="myForm">
            <div class="form-group clearfix">
                <div class="col-sm-2 t-a-r">学校名称：</div>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="schoolName" id="schoolName">
                </div>
            </div>
            <div class="form-group clearfix">
                <div class="col-sm-2 t-a-r">企业logo长传：</div>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="logo" id="logo">
                </div>
            </div>
            <div class="form-group clearfix">
                <div class="col-sm-offset-2 col-sm-2">
                    <button class="btn btn-save">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>