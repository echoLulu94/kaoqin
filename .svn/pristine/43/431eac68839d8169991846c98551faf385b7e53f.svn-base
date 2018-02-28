<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="table-box">
    <div class="chart-change">
        <div class="chart-caption">项目出席率</div>
        <div class="chart-type">考勤类别：
            <select class="form-control">
                <option>活动考勤</option>
                <option>课题考勤</option>
            </select>
            <a href="#">详情</a>
        </div>
    </div>
    <div class="chart-bg chart-main">
        <div class="chart-pie" id="chart"></div>
        <div class="chart-text">
            <ul class="chart-text-ul1">
                <li>累计组织项目次数：22</li>
                <li>累计项目参加率：82.8%</li>
            </ul>
            <ul class="chart-text-ul2">
                <li><img src="${admin}/images/colour1.jpg">准点率:60%</li>
                <li><img src="${admin}/images/colour2.jpg">迟到率:50%</li>
            </ul>
            <ul class="chart-text-ul2">
                <li><img src="${admin}/images/colour3.jpg">缺勤率:40%</li>
                <li><img src="${admin}/images/colour4.jpg">请假率:30%</li>
            </ul>
        </div>
    </div>
    <div class="detail-box">
        <div class="project-box">
            <div class="project-title">活动名称</div>
            <ul class="project-ul">
                <li class="active"><a href="#">第一届大学生生存现状讨论会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
                <li><a href="#">第一届dota竞技比赛举办会</a></li>
            </ul>
        </div>
        <div class="chart-bg chart-bg-detail">
            <div class="chart-pie" id="chart2"></div>
            <div class="chart-text">
                <ul class="chart-text-ul1">
                    <li>累计项目参加率：82.8%</li>
                </ul>
                <ul class="chart-text-ul2">
                    <li><img src="${admin}/images/colour1.jpg">准点率:60%</li>
                    <li><img src="${admin}/images/colour2.jpg">迟到率:50%</li>
                </ul>
                <ul class="chart-text-ul2">
                    <li><img src="${admin}/images/colour3.jpg">缺勤率:40%</li>
                    <li><img src="${admin}/images/colour4.jpg">请假率:30%</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script>
    $(function(){
        initChart('chart');
        initChart('chart2');
    });
    function getData(percent) {
        return [{
            value: percent,
            name: percent
        }, {
            value: 1 - percent,
            itemStyle: {
                normal: {
                    color: 'transparent'
                }
            }
        }];
    }
    function initChart(id){
        var chart=echarts.init(document.getElementById(id));
        var colors=['#9db9de','#a8add3','#9082bd','#c490c0'];
        var placeHolderStyle = {
            normal: {
                label: {
                    show: false
                },
                labelLine: {
                    show:false
                }
            }
        };
        var option = {
            color: colors,
            tooltip: {
                trigger: 'item',
                formatter: function(params, ticket, callback) {

                    return params.seriesName + ": " + params.name * 100 + "%";
                }
            },
            legend: {
                show:false
            },
            series: [{
                name: '准点率',
                type: 'pie',
                clockWise: true, //顺时加载
                hoverAnimation: false, //鼠标移入变大
                radius: [120, 140],
                itemStyle: placeHolderStyle,
                data: getData(0.6)
            }, {
                name: '迟到率',
                type: 'pie',
                clockWise: true, //顺时加载
                hoverAnimation: false, //鼠标移入变大
                radius: [95, 115],
                itemStyle: placeHolderStyle,
                data: getData(0.5)
            }, {
                name: '缺勤率',
                type: 'pie',
                clockWise: true, //顺时加载
                hoverAnimation: false, //鼠标移入变大
                radius: [70, 90],
                itemStyle: placeHolderStyle,
                data: getData(0.4)
            }, {
                name: '请假率',
                type: 'pie',
                clockWise: true, //顺时加载
                hoverAnimation: false, //鼠标移入变大
                radius: [45, 65],
                itemStyle: placeHolderStyle,
                data: getData(0.3)
            }]
        };
        chart.setOption(option);
    }
</script>