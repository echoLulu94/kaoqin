<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="table-box">
    <div class="query-area">
        <form rel="form" id="queryForm" method="get">
            <div class="form-group clearfix">
                <span class="input-span">考勤类别：</span>
                <div class="col-sm-2">
                    <select class="form-control" id="attendanceCategories" name="attendanceCategories">
                        <option>课堂考勤</option>
                        <option>活动考勤</option>
                    </select>
                </div>
                <span class="input-span">统计周期：</span>
                <div class="col-sm-2">
                    <select class="form-control" id="statisticalCycle" name="statisticalCycle
">
                        <option>按天统计</option>
                        <option>按周统计</option>
                        <option>按月</option>
                    </select>
                </div>
                <div class="col-sm-2">
                    <input class="form-control" id="startTime" name="startTime">
                </div>
                <span class="input-span">-</span>
                <div class="col-sm-2">
                    <input class="form-control" id="endTime" name="endTime">
                </div>
            </div>
            <div class="form-group clearfix">
                <span class="input-span">学院：</span>
                <div class="col-sm-2">
                    <select class="form-control" name="college" id="college"></select>
                </div>
                <span class="input-span">专业：</span>
                <div class="col-sm-2">
                    <select class="form-control" name="professional" id="professional"></select>
                </div>
                <span class="input-span">班级：</span>
                <div class="col-sm-2">
                    <select class="form-control" name="className" id="className"></select>
                </div>
                <span class="input-span">姓名：</span>
                <div class="col-sm-2">
                    <input class="form-control" id="name" name="name">
                </div>
                <button class="btn btn-middle">搜索</button>
            </div>
        </form>
    </div>
    <div class="chart-bar" id="chartBar"></div>
    <div class="chart-line" id="chartLine"></div>
</div>
<script>
    $(function(){
        initBarChart();
        initLineChart();
    });
    function initBarChart() {
        var chart=echarts.init(document.getElementById("chartBar"));
        var option = {
            color: ['#3398DB'],
            backgroundColor:'#fff',
            tooltip : {
                trigger: 'axis',
                axisPointer : {
                    type : 'shadow'
                },
                formatter: '考勤详情<br />正常: {c0}'
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '5%',
                right: '5%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    name : '院系',
                    data : ['医学分院', '计算机系', '生物系', '经济贸易系', '汽车系', '建筑工程系'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    name : '到课率',
                    axisLabel: {
                        formatter: '{value} %'
                    }
                }
            ],
            series : [
                {
                    name:'正常',
                    type:'bar',
                    barWidth: '20%',
                    data:[95, 80, 90, 85, 95, 83]
                }
            ]
        };
        chart.setOption(option);
    }

    function initLineChart(){
        var chart=echarts.init(document.getElementById("chartLine"));
        var option = {
            backgroundColor:'#fff',
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['中药药理学','药用植物学','药物化学','生物工程','化工原理']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['11-01','11-06','11-11','11-16','11-21','11-26','11-30']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'中药药理学',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'药用植物学',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'药物化学',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'生物工程',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'化工原理',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        chart.setOption(option);
    }
</script>