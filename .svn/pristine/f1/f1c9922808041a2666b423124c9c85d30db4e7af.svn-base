<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="chart-box">
	<div class="chart" id="chart"></div>
	<div class="legend clearfix">
		<ul class="legend-ul1">
			<li><img src="${admin}/images/legend1.png">组织项目次数</li>
			<li><img src="${admin}/images/legend2.png">参加项目人数</li>
		</ul>
		<ul class="legend-ul2">
			<li><img src="${admin}/images/legend3.png">平均准点率：89%</li>
			<li><img src="${admin}/images/legend4.png">平均迟到率：8%</li>
			<li><img src="${admin}/images/legend5.png">平均缺勤率：2%</li>
		</ul>
		<ul class="legend-ul3">
			<li>累计组织项目次数：35</li>
			<li>累计参加项目人数：535</li>
		</ul>
	</div>
</div>
<div class="calendar-div">
	<div class="calendar-main">
		<div class="calendar_contain" id="calendar_contain"></div>
	</div>
</div>

<script>
    $(function(){
        initChart('chart');

        document.getElementById("calendar_contain").innerHTML = new JCalendar().show();
        JCalendar.update(0);
    });
    function initChart(id){
        var chart=echarts.init(document.getElementById(id));

        var category = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sept','Nov','Oct','Dec'];

        var option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                show:false,
                data:['组织项目次数','参加项目人数','平均准点率','平均迟到率','平均缺勤率']
            },
            grid: [
                {
                    left: 90,
                    right: 90
                }
            ],
            xAxis: {
                boundaryGap:false,
                data: category,
                splitLine: {show: false},
                axisTick:{show:false},
                axisLine:{show:false},
                splitArea:{show:false},
                axisLabel:{color:'#fff'}
            },
            yAxis: [{
                type: 'value',
                name: '次数',
                nameTextStyle:{
                    color:'#fff'
                },
                offset: 50,
                splitLine: {show: false},
                axisTick:{show:false},
                axisLine:{show:false},
                splitArea:{show:false},
                axisLabel:{color:'#fff'}
            },{
                type: 'value',
                name: '概率',
                nameTextStyle:{
                    color:'#fff'
                },
                offset: 50,
                splitLine: {show: false},
                axisTick:{show:false},
                axisLine:{show:false},
                splitArea:{show:false},
                axisLabel:{color:'#fff'}
            }],
            series: [{
                name: '参加项目人数',
                type: 'line',
                smooth: true,
                lineStyle:{
                    color: '#fff',
                    width: 4
                },
                symbolSize:0,
                data: [0,43,32,45,55,66,83,35,66,88,55,0]
            },{
                name: '组织项目次数',
                type: 'line',
                smooth: true,
                showAllSymbol:true,
                symbol: 'circle',
                symbolSize: 15,
                lineStyle:{
                    color: '#fff',
                    width: 2
                },
                itemStyle:{
                    color: '#fff'
                },
                data: [0,33,42,55,45,66,73,45,76,58,75,0]
            }, {
                name: '平均准点率',
                type: 'bar',
                barWidth: 14,
                yAxisIndex: 1,
                itemStyle: {
                    color:'#416298'
                },
                data: [60,70,65,76,80,62,69,79,53,89,60,80]
            }, {
                name: '平均迟到率',
                type: 'bar',
                barWidth: 14,
                yAxisIndex: 1,
                itemStyle: {
                    color:'#476891'
                },
                data: [20,30,15,36,20,12,19,29,13,39,20,22]
            }, {
                name: '平均缺勤率',
                type: 'bar',
                barWidth: 14,
                yAxisIndex: 1,
                itemStyle: {
                    color:'#4c6fa8'
                },
                data: [10,14,25,16,20,22,29,19,13,19,20,14]
            }]
        };
        chart.setOption(option);
    }
</script>



