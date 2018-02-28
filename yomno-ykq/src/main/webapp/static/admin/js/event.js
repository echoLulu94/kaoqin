//HashMap对象定义
var hashMap = {
Set : function(key,value){this[key] = value},
Get : function(key){return this[key]},
Contains : function(key){return this.Get(key) == null?false:true},
Remove : function(key){delete this[key]}
}



function Offset(e){
	var t = e.offsetTop;
	var l = e.offsetLeft;
	var w = e.offsetWidth;
	var h = e.offsetHeight - 2;
	while(e = e.offsetParent){
		t += e.offsetTop;
		l += e.offsetLeft;
	}
	return {
		top : t,
		left : l,
		width : w,
		height : h
	}
}

function itemShow(id) {
	document.getElementById(id+"s").className = "calendarEventHov";
	document.getElementById(id).style.display = "none";
	var lft = getLeft(document.getElementById(id+"s"));
	var top = getTop(document.getElementById(id+"s"));

	document.getElementById("eventContent").style.left = (lft+30)+"px";
	document.getElementById("eventContent").style.top = (top-10)+"px";
	document.getElementById("eventContent").innerHTML = document.getElementById(id).innerHTML;
	document.getElementById("eventContent").style.display="block";
}

function itemHide(id) {
	document.getElementById(id+"s").className = "calendarEvent";
	document.getElementById(id).style.display = "none";
	document.getElementById("eventContent").innerHTML = "";
	document.getElementById("eventContent").style.display="none";
}

function dateToString(date){
	return date.getFullYear()+this.digitFix(date.getMonth()+1,2)+this.digitFix(date.getDate(),2);
}

function digitFix(number,count){
	var _string = number+"";
	var _count = count-_string.length;
	for(var i = 0; i < _count; i++)
		_string = "0" + _string;
	return _string;
}
var monthArray = ["1/Jan","2/Feb","3/Mar","4/Apr","5/May","6/Jun","7/Jul","8/Agu","9/Sep","10/Oct","11/Nov","12/Dec"];

function JCalendar (year,month,date) {
	var _date = arguments.length == 0 ? new Date() : new Date(year,month-1,date);
	this.year = _date.getFullYear();
	this.month = _date.getMonth() + 1;
	this.fday = new Date(this.year,this.month-1,1).getDay();
	this.dayNum = new Date(this.year,this.month,0).getDate();

	JCalendar.cur_year = this.year;
	JCalendar.cur_month = this.month;
	JCalendar.cur_date = _date.getDate();

}
JCalendar.prototype.show = function(){
	var date = new Array(this.fday > 0 ? this.day : 0);
	var html_str = new Array();
	var date_index = 0;
	/*var weekDay = ["日","一","二","三","四","五","六"];*/
	var weekDay = ["SUN","MON","TUE","WED","THU","FRI","SAT"];

	for(var j = 1; j <= this.dayNum; j++){
		date.push(j);
	}
	html_str.push("<div class='calendarBox'><div style='padding-left:280px;float:left;'><div class='preMonth' onclick='JCalendar.update(-1);return false' title='Prev'><</div><div class='calendarTit' id='calendar_title'>" + monthArray[this.month-1] + " " + this.year + "</div><div class='nextMonth' onclick='JCalendar.update(1);return false' title='Next'>></div></div>");
	html_str.push("<table id='calendar' border='0' cellspacing='0' cellpadding='0' class='calendarTab'>");

	html_str.push("<tr>");
	for(var i = 0; i < 7; i++){
		if ( i == 0 || i == 6) {
			html_str.push("<th class='yellow'>" + weekDay[i] + "</th>");
		} else {
			html_str.push("<th class='normal'>" + weekDay[i] + "</th>");
		}
	}
	html_str.push("</tr>");

	for(var i = 0; i < 7; i++){
		html_str.push("<tr>");
		for(var j = 0; j < 7; j++){
			tmp = date[date_index++];
			tmp = tmp ? tmp : "";
			var tmpdate = new Date(JCalendar.cur_year,JCalendar.cur_month-1,tmp);
			if(hashMap.Contains(dateToString(tmpdate))){
				html_str.push("<td><span class='calendarEvent'>" + tmp);
				html_str.push("<div class='calendarShowBox'><div class='caTop'></div><div class='caCen'>"+hashMap.Get(dateToString(tmpdate))+"</div><div class='caBot'></div></div>");
				html_str.push("</span></td>");
			}else if(tmp == ""){
				html_str.push("<td></td>");
			}else{
				html_str.push("<td><div></div></td>");
			}
		}
		html_str.push("</tr>");
	}

	html_str.push("</table>");
	html_str.push("</div>");
	html_str.push("<div id='eventContent'>&nbsp;</div>");
	return html_str.join("");
}
JCalendar.update = function(_month){
	var date = new Date(JCalendar.cur_year,JCalendar.cur_month - 1 + _month,1);
	var fday = date.getDay();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var dayNum = new Date(JCalendar.cur_year,JCalendar.cur_month  + _month,0).getDate();
	var tds = document.getElementById("calendar").getElementsByTagName("td");
	for(var i = 7; i < tds.length; i++)
		tds[i].innerHTML = "";
	document.getElementById("calendar_title").innerHTML = monthArray[month-1] + " " + year;
	JCalendar.cur_year = year;
	JCalendar.cur_month = month;
	for(var j = 1; j <= dayNum; j++){
		var tmpdate = new Date(JCalendar.cur_year,JCalendar.cur_month-1,j);
		//if(j == JCalendar.cur_date)
		var tmpdate_str = dateToString(tmpdate);
		if(hashMap.Contains(tmpdate_str)) {
			tds[6 + fday + j].innerHTML = "<span id='"+tmpdate_str+"s' class='calendarEvent' onmouseover='itemShow("+tmpdate_str+")' onmouseout='itemHide("+tmpdate_str+")' >" + j + "<div id='"+tmpdate_str+"' class='calendarShowBox'>"+hashMap.Get(tmpdate_str)+"</div></span>";
			//tds[6 + fday + j].innerHTML += "<div class='calendarShowBox'><div>"+hashMap.Get(dateToString(tmpdate))+"</div></div>";
			//tds[6 + fday + j].innerHTML += "<div class='calendarShowBox'><div>"+hashMap.Get(dateToString(tmpdate))+"</div></div>";
			//tds[6 + fday + j].innerHTML += "</span>";
			//alert(tds[6 + fday + j].innerHTML);
		}else{
			//tds[6 + fday + j].innerHTML = "<div onclick='JCalendar.click(this)'>" + j + "</div>";
            if(JCalendar.cur_date == j){
                tds[6 + fday + j].innerHTML = "<div class='normal'><span class='today'>" + j + "</span></div>";
            }else{
                tds[6 + fday + j].innerHTML = "<div class='normal'>" + j + "</div>";
            }

		}
	}
	JCalendar.onupdate(year,month,JCalendar.cur_date);
}

JCalendar.onupdate = function(year,month,date){//日历更改时执行的函数，可以更改为自己需要函数,控件传递过来的参数为当前日期
	//alert(year + "年" + month + "月" + date + "日");
}

JCalendar.click = function(obj){
	var tmp = document.getElementById("c_today");
	tmp.parentNode.innerHTML = "<div onmouseover=\"this.style.backgroundColor='#CCC'\" onmouseout=\"this.style.backgroundColor=''\" onclick='JCalendar.click(this)'>" + tmp.innerHTML + "</div>";
	JCalendar.cur_date = parseInt(obj.innerHTML);
	obj.parentNode.innerHTML = "<span id='c_today' style='background-color:#036;color:#FFF;'>" + obj.innerHTML + "</span>";
	JCalendar.onclick(JCalendar.cur_year,JCalendar.cur_month,JCalendar.cur_date);

}

JCalendar.onclick = function(year,month,date){//点击日期时执行的函数，可以更改为自己需要函数,控件传递过来的参数为当前日期
	alert(year + "年" + month + "月" + date + "日");
}
