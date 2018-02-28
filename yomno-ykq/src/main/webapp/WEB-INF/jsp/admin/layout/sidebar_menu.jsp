<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="menu-box">
	<ul>
		<li>
			<a href="kewaikaoqinxinxi.html"><img src="${admin}/images/menu_icon1.png">课外考勤信息<span>></span></a>
		</li>
		<li class="active">
			<a href="ketangkaoqinxinxi.html"><img src="${admin}/images/menu_icon2.png">课堂考勤信息<span>></span></a>
		</li>
		<li>
			<a href="jiaoshixinxi.html"><img src="${admin}/images/menu_icon3.png">教师信息<span>></span></a>
		</li>
		<li>
			<a href="#"><img src="${admin}/images/menu_icon4.png">学生信息<span>></span></a>
		</li>
		<li>
			<a href="#"><img src="${admin}/images/menu_icon5.png">课程信息<span>></span></a>
		</li>
	</ul>
</div>

<script type="text/javascript">
	$(function() {
		$('.second-menu li a:first').parent().addClass('active');
	    $('.second-menu li a:first').trigger('onclick');
	});
</script>
<!-- /.sidebar -->