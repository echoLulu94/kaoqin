(function($){
    jQuery.fn.moyanSelect = function(selected) {

        var id = $(this).attr("id");
        var name = $(this).attr("name");
        var type = $(this).attr("data-type");
        var clazz = $(this).attr("class");
        var url = $(this).attr("data-url");
        var optionValue = $(this).attr("data-option-value");
        var optionName = $(this).attr("data-option-name");
        var optionPara = $(this).attr("data-option-para");
        var disabled = $(this).attr("disabled");
        var isPicture = $(this).attr("data-isPicture");
        var content = $(this).attr("data-content");
        var optionCode = $(this).attr("data-code");

        $(this).empty();
                
        loadOptions(this, url, selected);

        function loadOptions(_this, url, selected){
            $.ajax({
                type: 'get',
                url: url,
                dataType: 'json',
                traditional: true,
                async: false,
                success: function(result) {
                    var list = result.data.list;

                    if (result.success) {
                        if(type == "radio") {
                            var el_parent = $(_this).parent();
                            $(el_parent).empty();
                            var style='';
                            if(list.length == 2){
                            	style='float:left;width:40%;margin-left:10%'
                            }else{
                            	style='float:left;width:33%;margin-left:12%'
                            }
                            for (var i = 0; i < list.length; i++) {
                                var option = list[i];
                                
                                if(isPicture == "true" && content == "content"){
                                	var el_option = "<div style="+style+"><input type='radio' class='" + clazz + "' " +
                                    "id='" + id + "' name='" + name + "' " +
                                    "value='" + eval("option." + optionValue) + "'/>" + eval("option." + optionName)+
                                    "<div data-toggle='modal' data-target='#myImg' class='m-t-10'>" +
                                    "<img onclick='content_largeImg(this)'  style='width:95%;height:200px;cursor:pointer' src='"+ctx + "/attachment/"+ eval("option." + optionPara) + "?isImage=true'>" +
                                    "</div></div>" +
                                    "<div class='modal fade' id='myImg' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>" +
                                    "<div class='modal-dialog'><div class='modal-content'><div class='modal-header'>" +
                                    "<button type='button' class='close' data-dismiss='modal'><span aria-hidden='true'>×</span></button>" +
                                    "<h4 class='modal-title' id='myModalLabel'>模版</h4></div>" +
                                    "<div class='modal-body' id='click_img'></div><div class='modal-footer'></div></div></div></div>";
                                
                                }else if(isPicture == "true" && content == "group"){
                                	var el_option = "<div style='float:left;width:33%'><input type='radio' class='" + clazz + "' " +
                                    "id='" + id + "' name='" + name + "' " +
                                    "value='" + eval("option." + optionValue) + "'/>" + eval("option." + optionName)+
                                    "<div><img onclick='group_largeImg(this)' style='width:95%;height:200px;cursor:pointer' src='"+ctx + "/attachment/" + eval("option." + optionPara) + "?isImage=true'></div></div>";
                                
                                }else{
                                	var el_option = "<input type='radio' class='" + clazz + "' " +
                                    "id='" + id + "' name='" + name + "' " +
                                    "value='" + eval("option." + optionValue) + "'/>" + eval("option." + optionName);
                                }
                                
                                
                                $(el_parent).append(el_option);
                        
//                                if (selected == option.id ) {
//                                    $(el_parent).iCheck({
//                                        radioClass: 'iradio_minimal-blue'
//                                    }).iCheck("check");
//                                } else {
                                    $(el_parent).iCheck({
                                        radioClass: 'iradio_minimal-blue'
                                    }).iCheck("uncheck");
//                                }
                            }
                        } else if (type == "checkbox") {
                            var el_parent = $(_this).parent();
                            $(el_parent).empty();
                          
                            	 for (var i = 0; i < list.length; i++) {
                                     var option = list[i];
                                     
                                     if(disabled=="disabled"){
                                         var el_option = "<input type='checkbox' class='" + clazz + "' " +
                                         "id='" + id + "' name='" + name + "' " +
                                         "value='" + eval("option." + optionValue) +  "'disabled='disabled' checked='checked'/>" + eval("option." + optionName);
                                     }else{
                                    	 var el_option = "<input type='checkbox' class='" + clazz + "' " +
                                         "id='" + id + "' name='" + name + "' " +
                                         "value='" + eval("option." + optionValue) + "'/>" + eval("option." + optionName);
                                      }
                                     
                                     $(el_parent).append(el_option);
                             
//                                     if (selected == option.id ) {
//                                         $(el_parent).iCheck({
//                                             checkboxClass: 'icheckbox_minimal-blue'
//                                         }).iCheck("check");
//                                     } else {
                                         $(el_parent).iCheck({
                                             checkboxClass: 'icheckbox_minimal-blue'
                                         }).iCheck("uncheck");
//                                     }
                                 }
                           
                        } else {
                            $(_this).append("<option value=''>---请选择---</option>");
                            for (var i = 0; i < list.length; i++) {
                                var option = list[i];
                                //alert(JSON.stringify(option))
                                if(type == "dataCode"){
                                	if (selected == option.code ) {
                                        var el_option = "<option selected='selected' value='";
                                    } else {
                                        var el_option = "<option value='";
                                    }
                                	
                                }else{//取数据库中的id
                                	 if (selected == option.id ) {//取数据库中的code
                                         var el_option = "<option selected='selected' value='";
                                     } else {
                                         var el_option = "<option value='"; 
                                     }
                                }
                                
                                el_option = el_option + eval("option." + optionValue) + "' data-para=" + eval("option." + optionPara) + " >" + eval("option." + optionName) + "</option>";
                               
                                $(_this).append(el_option);
                            }
                        }

                    } else {
                        alert(result.errorMsg);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("请求异常");
                }
            });
        }
    }
})(jQuery);