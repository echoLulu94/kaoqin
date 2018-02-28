$(function(){
    $('#menu').on('click','.second-menu li',function(){
        $('.second-menu li').removeClass('active');
        $(this).addClass('active');
    });
    $('#menu').on('click','.glyphicon-chevron-up',function(){
        $(this).parent().next().slideUp("slow");
        $(this).attr('class','glyphicon glyphicon-chevron-down');
    });
    $('#menu').on('click','.glyphicon-chevron-down',function(){
        $(this).parent().next().slideDown("slow");
        $(this).attr('class','glyphicon glyphicon-chevron-up');
    });
   
    JudgeBroswer();
});

/**让网站兼容ie7*/
function JudgeBroswer() {
    var browser=navigator.appName;
    var b_version=navigator.appVersion;
    var version=b_version.split(";");
    var trim_Version=version[1].replace(/[ ]/g,"");
    if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE7.0")
    {
        $('.content').css({"padding-bottom":"0"});
        $('.header .search-group').css({'width':'auto','margin':'0 60px 0 60px'});
        $('.header .search-group .form-control').css({'width':'200px','padding':'0 12px','float':'left','margin-left':'-10px','line-height':'40px','height':'40px'});
        $('.header .input-group-addon').css({'width':'49px','padding':'8px 0 0 0','float':'left','height':'32px'});
        $('.header-ope>li').css({'width':'65px'});
        $('.right-content').css({'width':'1000px'});
        $('.col-sm-2').css({'width':'13%'});
        $('.query-area input').css({'height':'22px'});
        $('.query-area .btn-special').css({'margin-left':'30px'});
        $('.btn-special').css({'padding':'6px 10px'});
        $('.col-sm-4').css({'width':'28%'});
        $('.small').css({'width':'100px'});
        $('.medium').css({'width':'268px'});
        $('.col-sm-8').css({'width':'60%'});
        $('.login-box input').css({'width':'220px','height':'30px','float':'left'});
        $('.login-box .input-group-addon').css({'width':'25px','height':'30px','line-height':'30px','float':'left'});
        $('.login-box .btn-login').css({'border':'none'});
        $('.btn-special').css({'padding':'8px 10px 3px 10px'});
        $('.form-horizontal .control-label').css({'padding-top':'8px','text-align':'right'});
        $('input[name != "search"]').css({'height':'20px','margin-bottom':'15px'});
        $('.minimal').css({'margin-bottom':'0'});
        $('.modal-footer').css({'height':'35px'});
        $('.modal-footer .btn').css({'width':'15%'});
        $('.menu-box > .menu-identity').css({'height':'auto','padding':'14px 8px'});
    }
}