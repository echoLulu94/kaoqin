<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>南京航空航天大学考试报名管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="keywords" content="南京航空航天大学,考试报名管理系统" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta name="rendener" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${plugins}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${plugins}/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${plugins}/datatables/jquery.dataTables_themeroller.css">
<!-- DataTables Buttons -->
<link rel="stylesheet"
	href="${plugins}/datatables/extensions/Select/css/select.dataTables.css">
<link rel="stylesheet"
	href="${plugins}/datatables/extensions/Select/css/select.bootstrap.css">
 <link rel="stylesheet" href="${plugins}/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">
<!-- iCheck -->
<link rel="stylesheet" href="${plugins}/iCheck/all.css">
<link rel="stylesheet" href="${admin}/css/index.css">
<link rel="stylesheet" href="${admin}/css/media.css">

<script src="${plugins}/jQuery/jquery.1.9.1.min.js"></script>
<script src="${plugins}/bootstrap/js/bootstrap.min.js"></script>
<script src="${plugins}/jQuery-ui/jquery-ui.custom.min.js"></script>
<!--[if IE 9]>
    <script src="${plugins}/incompatible/html5shiv.js"></script>
    <script src="${plugins}/incompatible/respond.min.js"></script>
<![endif]-->
<!-- DataTables -->
<script src="${plugins}/datatables/jquery.dataTables.js"></script>
<script src="${plugins}/datatables/dataTables.bootstrap.min.js"></script>
<script src="${plugins}/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script src="${plugins}/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${plugins}/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="${plugins}/jquery-validation/localization/messages_zh.js"></script>
<script src="${plugins}/fastclick/fastclick.js"></script>
<script src="${plugins}/iCheck/icheck.min.js"></script>
<script src="${plugins}/moment/moment.js"></script>
<script src="${plugins}/moment/moment-with-locales.js"></script>
<script src="${admin}/js/moyanBase.js"></script>
<script src="${admin}/js/moyanSelect.js"></script>
<script src="${admin}/js/ajaxfileupload.js"></script>
<script src="${admin}/js/event.js"></script>
<script src="${admin}/js/main.js"></script>

<script> 
   (function() {
     if (! 
     /*@cc_on!@*/
     0) return;
     var e = "abbr, article, aside, audio, canvas, datalist, details, dialog, eventsource, figure, footer, header, hgroup, mark, menu, meter, nav, output, progress, section, time, video".split(', ');
     var i= e.length;
     while (i--){
         document.createElement(e[i])
     } 
})() 
</script>
</head>
<body>

     <%@ include file="header.jsp"%>
	 <div class="container">
		 <div class="main-content clearfix">
			 <%@ include file="sidebar_menu.jsp"%>
		 </div>
		 <div class="right-content">
			 <%@ include file="content.jsp"%>
		 </div>
	 </div>

<script type="text/javascript">
    var ctx = "${ctx}";
    var plugins = "${plugins}";
</script>
</body>
</html>
