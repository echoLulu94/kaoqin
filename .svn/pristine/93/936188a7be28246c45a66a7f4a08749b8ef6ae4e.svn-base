var currTable;  // 当前表格
var dataTableIsInit = false;
var parentTableRecordId = 0;
var tableLanguage = {
        decimal:        "",
        emptyTable:     "没有任何数据",
        info:           "显示前 _START_ - _END_ 条，共  _TOTAL_ 条",
        infoEmpty:      "共  _TOTAL_ 条",
        infoFiltered:   "（从 _MAX_ 条中过滤）",
        infoPostFix:    "",
        thousands:      ",",
        lengthMenu:     "每页  _MENU_ 条",
        loadingRecords: "正在加载...",
        processing:     "正在处理...",
        search:         "查询:",
        zeroRecords:    "没有匹配到记录",
        paginate: {
            first:      "第一页",
            last:       "最后一页",
            next:       "下一页",
            previous:   "上一页"
        }
};
var baseContent_UEditor = '<script id="UEeditor_S" class="content" type="text/plain"></script>';

/**
 * 点击菜单显示功能
 * 
 * @param url
 */
function showFunction(url) {
    $.ajax({
        type: 'get',
        url: url,
        dataType: 'html',
        async: false,
        success: function(data) {
            redirectLogin(data);

            dataTableIsInit = false;
            parentTableRecordId = 0;

            $(".content-wrapper").html(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

/**
 * 初始化表格数据
 * 
 * @param table
 */
function initTable(table, pid) {
    var data;
    if (pid != null) {
        data = {pid : pid};
        parentTableRecordId = pid;
    }
    
    if (table.type == "ordinary") {
        initOrdinaryTable(table, data);
    } else if (table.type == "dataTable" || table.type == null) {
    	
        if (dataTableIsInit == false) {
            initDataTable(table, data);
            dataTableIsInit = true;
        } else {
            reloadDataTable(currTable, data);
        }
    }
}

function initTable1(obj) {
	obj.style.backgroundColor='#DCDCDC';			//选中变颜色
	$(obj).siblings().css("backgroundColor","#FFF");
}

function initOrdinaryTable(table, data) {
    $.ajax({
        type : 'get',
        url : table.ajax.url + '?t=' + new Date(),
        data : data,
        dataType : 'html',
        success : function(data) {
            
            //加载列表
            $(table.id).html(data);
            
            //含有子列表
            if (table.child != null) {
                var firstRowId = $(table.id + " input[name='rowId']")[0].value;

                initTable(table.child, firstRowId);
            }
            try {
                onInitTableSuccess(table);
            } catch(e) {}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function initDataTable(table, data) {
    var defaultOrder = [[ 1, 'asc' ]];
    if (table.order != null && table.order != '') {
        defaultOrder = table.order;
    }
    
    $.extend( $.fn.dataTable.defaults, {
        language: tableLanguage,
        dom: 'lfrtip',
        buttons: false,
        searching: true,
        processing: false,
        info: true,
        paging: true,
        lengthChange: false,
        autoWidth: false,
        ordering: true,
        order: defaultOrder,
//        select: true,
//        select: {
//            style:    'os',
//            selector: 'td:first-child'
//        },
//      "serverSide": true,
//        scrollX : false,
//        scrollY : "400px", // 设置垂直滚动条，TODO：放开后会变成两个table（表头和内容），会造成伸缩菜单时表头不一致
        scrollCollapse : false, // 是否合并滚动条空间
        deferRender : true // 延迟加载
    });
    
    currTable =  $(table.id).DataTable({
        ajax : {
            url : table.ajax.url + '?t=' + new Date(),
            data : data,
            type : table.ajax.type != null ?  table.ajax.type : "GET",
            dataType : table.ajax.dataType != null ?  table.ajax.dataType : "json",
            dataSrc : table.ajax.dataSrc
        },
        columns : table.columns,
        columnDefs : table.columnDefs,
        
        // 表格初始化完成后调用
        initComplete : function(settings, json) {
        	
        },
        drawCallback : function( settings ) {
              //alert( '表格重绘了' );
              // 全选和选择按钮初始化
        	  
              $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
                radioClass: 'iradio_minimal-blue'
              });
              
              $('#allCheckbox').on('ifChecked', function(event){ 
                  $('input[type="checkbox"]').iCheck('check');
                }).on('ifUnchecked', function(event){ 
               $('input[type="checkbox"]').iCheck('uncheck');
             });            
             
            // 单击一行时选择记录
           	$(".div_table tbody tr").bind("click",function(){
         		if($(this).find('input[type="checkbox"].minimal').is(':checked')){
         			$(this).iCheck('uncheck');
         		}else{
         			$(this).iCheck('check');
         		}
     		}); 
          }
    });
}

function reloadDataTable(table, data) {
    table.settings()[0].ajax.data = data;
    table.ajax.reload(null,false);
}


/**
 * 创建（新增）表单
 * 
 * @param modal
 */
function create(modal, beforeCreate, afterCreate){

    // 调用页面自定义方法
    try {
    	var validated =  beforeCreate(modal);
        if(validated == -1){
     	   return false;
        }
        
    } catch(e) {}

    if (modal.openType == "page") {
        $(".row").hide();
        $(modal.id).show();
        
    } else {
        // 初始化并显示modal
        $(modal.id).modal({
            keyboard: true,
            show: true,
            toggle:'modal',
            backdrop:'static'
        });
        
        // 设置标题
        $(modal.formId + " h4").text(modal.createTitle);
        
    }
    
    // 初始化表单
    initForm(modal.formId);
    
    // 调用页面自定义方法
    try {
        afterCreate(modal);
    } catch(e) {}
    
    $('.modal-content').draggable({
        handle: ".modal-header"   // 只能点击头部拖动
    });
    
}

//图片点击事件
function content_largeImg(a){
	var height = $(a).height();
	if(height == 200){
		$('#click_img').empty()
		$('#click_img').append("<img style='width:98%' src="+ $(a)[0].src +"></img>")
	}
}

function group_largeImg(a){
	var height = $(a).height();
	if(height == 200){
		$(a).parent().parent().siblings().hide()
		$(a).width("299%");
        $(a).height("auto");
	}else{
		$(a).parent().parent().siblings().show()
		 $(a).width("90%");
         $(a).height(200);
	}
}

function cancel(modal) {
    $(modal.id).hide();
    $(".row").show();
}

/**
 * 显示（修改）
 * 
 * @param modal
 * @param id
 */
function show(modal, id, beforeShow, afterShow) {
    try {
        var evt = window.event || arguments.callee.caller.arguments[0];
        evt.stopPropagation();
    } catch(e) {}
    
    //调用页面自定义方法
    try {
        beforeShow(modal);
    } catch(e) {}
    
    // 列表上方编辑
    if (id == null) {
        // 取得所有选中的checkbox
        var obj = $(modal.loadTable.id + " tbody :checkbox:checked");
        
        if (obj.length == 0) {
            alert('请选择要操作的数据!');
            return;
        }
        if (obj.length > 1) {
            alert('只能选择一条数据!');
            return;
        }
        id = $(obj[0]).val();
    }
    
    if (modal.openType == "page") {
        $(".row").hide();
        $(modal.id).show();
        
    } else {
        // 初始化并显示modal
        $(modal.id).modal({
            keyboard: true,
            show: true,
            toggle:'modal',
            backdrop:'static'
        });
        
        // 设置标题
        $(modal.id + " h4").text(modal.editTitle);
    }
    
    // 初始化表单
    initForm(modal.formId);
    //获取并显示表单内容
    $.ajax({
        type: 'get',
        url: modal.showURL + "/" + id + '?t=' + new Date(),
        dataType: 'json',
        async: false,
        success: function(data) {
            var obj = data.data.obj;      
            for (var o in obj) {
                var e = modal.formId + ' #' + o;
                if(e.indexOf('#user') != -1){
                	e= modal.formId + ' #' + 'username';//针对群主用户管理中的用户姓名
                }
                if ($(e).is("input")) {
                    if ($(e).prev().attr("type") == "file") {
                        $(e).val(obj[o]);                    
                       // $(e).closest("span").find("img").attr("src", ctx + "/sys/attachment/" + obj[o] );
                       // 以上为fileInput的用法，未完成
                        if (obj[o] != null) {
                            showFile(e, obj[o], obj[o+'Name']);
                        }
                    } else if ($(e).attr("type") == "radio") {
                        var e_name = modal.formId + " input[id='" + o + "']";
                       
                        $(e).each(function() {
                            if (typeof(obj[o]) != "object") {
                                if ($(this).attr("value") == obj[o]) {
                                    $(this).iCheck("check");
                                } else {
                                    $(this).iCheck("uncheck");
                                }
                            } else {
                                if (obj[o] != null && $(this).attr("value") == obj[o].id) {
                                    $(this).iCheck("check");
                                } else {
                                    $(this).iCheck("uncheck");
                                }
                            }
                        });
                    } else if ($(e).attr("type") == "checkbox") {
                        if (obj[o] != null) {
                            var strArr = new Array();
                            strArr = obj[o].split(",");
                            
                            $(e).each(function() {
                                for (i =0; i < obj[o].length ; i++ ) {
                                    if ($(this).attr("value") == strArr[i]) {
                                        $(this).iCheck("check");
                                        break;
                                    } else {
                                        $(this).iCheck("uncheck");
                                    }
                                }
                            });
                        }
                        
                    } else if ($(e).hasClass("date")) {
                        $(e).val(obj[o] != null ? moment(obj[o]).format('YYYY-MM-DD') : null);
                        
                    } else if ($(e).hasClass("summernoteHidden")) {
                        $(e).val(obj[o]);
                        $(e).parent().summernote("code", obj[o]);
                    } else {
                    	if(typeof(obj[o]) == 'object'&& e.indexOf('#username') != -1){//针对群主用户管理中的用户姓名
                    		$(e).attr('data-text',obj[o].username);
                    		obj[o]=obj[o].name;
                    	}
                    	$(e).val(obj[o]);  
                    }
                    
                } else if ($(e).is("select")) {
                	if (typeof(obj[o])!= 'object'){//数据形式为字段
                		selected = obj[o] != null ? obj[o] : null;
                        $(e).moyanSelect(selected);
                	}else{//数据形式为对象
                		selected = obj[o] != null ? obj[o].id : null;
                        $(e).moyanSelect(selected);
                	}
                    
                    
                } else if ($(e).is("textarea")) {
                    $(e).val(obj[o]);
                }
            }          
            
            /**考试资格确认页面*/
            if(data.data.jfxx != null){
            	var list=data.data.jfxx;           	
            	for (var o in list) {
                    var e = modal.formId + ' #' + o;
                    selected = list[o] != null ? list[o] : null;
                    $(e).val(list[o]);
            	}
            }
            
            if(data.data.jfxxid != null){
            	var e = modal.formId + ' #jfxxid';
            	var jfxxid=data.data.jfxxid;
            	selected = jfxxid != null ? jfxxid : null;
                $(e).val(selected);
            }
            /**考试资格确认页面*/
            
            //调用页面自定义方法
            try {
                afterShow(modal, obj);
            } catch(e) {}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            redirectLogin(XMLHttpRequest.responseText);
            //alert(errorThrown);
        }
    });
    
}


/**
 * 初始化表单校验器
 * 
 * @param formId
 */
function initValidator(formId) {
    // 注册jQuery即时校验
    $(formId).validate({
        onfocusout: function(element) {
            doValidate(element);
        },
        onkeyup: function(element) {
            doValidate(element);
        },
        onsubmit:function(element) {
            alert();
        },
        errorElement: "span",
        errorClass: "has-error",
        validClass: ""
    });
    
    // 清除校验内容
    $(formId).validate().resetForm();

    // 清除错误样式
    $(formId + " div").removeClass("has-error");
}

function doValidate(element) {
//  if (!$(element).hasClass('dtyundatepicker')) {
    if ($(element).valid()){
        $(element).parent().parent().removeClass('has-error');
        $(element).next().addClass('help-block');
    } else {
        $(element).parent().parent().addClass('has-error');
        $(element).next().addClass('help-block');
    }
//}
}

/**
 * 初始化表单
 * 
 * @param formId
 */
function initForm(formId) {
  // 初始化校验器
  initValidator(formId);
  //保存并发布可用
  $("#saverelease").attr('disabled',false);
  // 清除编辑的内容
  $(formId + " :input[type='text']").val("");
  $(formId + " :input[type='hidden']").val("");
  $(formId + " :input[type='password']").val("");
  $(formId + " :input[type='email']").val("");
  $(formId + " :input[type='number']").val("");
  
  //初始化视频
  var videoShowDiv=document.getElementById('videoShowDiv');
  if(videoShowDiv!=null&&videoShowDiv!=""){
	  videoShowDiv.innerHTML="<input type='file' data-type='image' class='form-control' id='videoShow' name='videoShow' placeholder='' data-min-file-count='1'>";	  
  }
  
  
  $(formId + " textarea").val("");
  
  if($(formId + " #id").length == 0) {
      $(formId).append('<input type="hidden" id="id" name="id">');
  }

  // 初始化下拉框控件
  $(formId + ' select').each(function() {
      $(this).moyanSelect();
  });
  
  // 初始化checkbox
  $(formId + ' input[type="checkbox"]').iCheck({
      checkboxClass: 'icheckbox_minimal-blue'
   }).iCheck("uncheck");
  
  // 初始化radiobox
  $(formId + ' input[type="radio"]').iCheck({
      radioClass: 'iradio_minimal-blue'
  }).iCheck("uncheck");
  
  //初始化radiobox(是否选中默认选中是)
  $(formId).find("input[name='isEnable']").eq(0).iCheck("check");
  //初始化是否重点(默认选中是)
  $(formId).find("input[name='isKeyRecommend']").eq(1).iCheck("check");
  //初始化是否置顶(默认选中否)
  $(formId).find("input[name='isTop']").eq(1).iCheck("check");
  // 初始化日期控件
  $(formId + ' .date').each(function() {
      $(this).datepicker({
          keyboardNavigation: false,
          forceParse: false,
          autoclose: true,
          toggleActive: false,
          todayHighlight: true, // 当前日期
          language: 'zh-CN',
          format: 'yyyy-mm-dd'
      });     
      /*$(this).parent().attr("style","position: relative; z-index: 9999;");*/
  });
  
  //初始化日期时间控件
  $(formId + ' .dateTime').each(function() {
	  $(this).datetimepicker({
		    format: 'YYYY-MM-DD HH:mm:ss',
		    showTodayButton: true,
		    useCurrent: true,
            locale: 'zh-CN',
            keepOpen: true
      });
  });
  //初始化小组成员
  $(formId).find('#table-member tbody #appendTr').empty();
  
  // 初始文件上传控件  
  $(formId + ' :file').each(function() {
      if ($(this).attr("data-type") != "imageCrop") {
          initFile($(this));
      }
  })
  
  // 初始化富文本控件
  $(formId + ' .summernote').each(function() {
      $(this).summernote({
          lang: 'zh-CN',
          height: '300',
          focus: true,
          maxHeight: null,
          minHeight: null
      });
      
      var id = $(this).attr("data-id");
      var name = $(this).attr("data-name");
      
      if($(formId + " #" + id).length == 0) {
          $(this).append('<input class="summernoteHidden" type="hidden" id="' + id + '" name="' + name + '">');
      }
      
      $(this).summernote("code", "");
  });
}


/**
 * 保存
 * 
 * @param modal
 */
function save(modal, beforeSave, afterSave){
    if ($(modal.formId).validate().form()) {
        $(modal.formId + ' .summernoteHidden').each(function() {
            $(this).val($(this).parent().summernote("code"));
        })
        
        try {
           var validated =  beforeSave(modal);
           if(validated == -1){
        	   return;
           }
        } catch (e) {
        }
        
        var data = $(modal.formId).serialize();
        doSave(modal, data, afterSave);
        
     }else{											//保存时判断是否有“必填”
    	 $(".has-error").each(function(){			//循环所有class=has-error
    		 if($(this).text() == "必填"){			
    			 $(this).parent().parent().addClass('has-error');
    		     $(this).next().addClass('help-block');
    		     $(this).addClass('help-block');
    		 }else{
    		    
    		 }
    	 })
     }
}

/**
 * 进行保存
 * 
 * @param modal
 * @param data
 */
function doSave(modal, data, afterSave) {
    $.ajax({
        type: 'post',
        url: modal.saveURL,
        data: data,
        dataType: 'json',
        traditional: true,
        success: function(result) {
//             btn.disabled = false;
            if (result.success) {
                if (modal.openType == "page") {
                    $(modal.id).hide();
                    $(".row").show();
                } else {
                    $(modal.id).modal('hide');
                }
                
                initTable(modal.loadTable, parentTableRecordId);
                
                try {
                    afterSave(modal);
                } catch(e) {}

            } else {
                alert(result.errorMsg);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            redirectLogin(XMLHttpRequest.responseText);
            //alert(errorThrown);
        }
    });
}

/**批量删除（删除选中的记录）*/
function delBat(modal, beforeDelete, afterDelete) {
    
    try {
        var evt = window.event || arguments.callee.caller.arguments[0];
        evt.stopPropagation();
    } catch(e) {}
    
    // 取得所有选中的checkbox
    var obj = $(modal.loadTable.id + " tbody :checkbox:checked");
    if (obj.length == 0) {
    
        alert('请选择要删除的数据!');
        return;
    }

    // 将记录ID保存到数值
    var ids = new Array();
    for (i = 0; i < obj.length; i++) {
        ids[i] = obj[i].value;
    }

    try {
        beforeDelete(modal);
    } catch(e) {}

    
    // 进行删除
    del(modal, ids, afterDelete);
}


/**
 * 删除（单个）
 * 
 * @param modal
 * @param ids
 */
function del(modal, ids, afterDelete) {
    try {
        var evt = window.event || arguments.callee.caller.arguments[0];
        evt.stopPropagation();
    } catch(e) {}
    

    if (confirm('确定要删除吗？')) {
        $.ajax({
            type: 'post',
            url: modal.deleteURL,
            data: {
                ids: ids
            },
            dataType: 'json',
            traditional: true,
            success: function(result) {
                if (result.success) {
                    initTable(modal.loadTable, parentTableRecordId);
                    
                    try {
                        afterDelete(modal);
                    } catch(e) {}

                } else {
                    if (result.errorMsg.indexOf("ConstraintViolationException") > 0) {
                        alert('您选择的记录已经被引用，不能被删除');
                    }
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                redirectLogin(XMLHttpRequest.responseText);
            }
        });
    }
}


/**批量操作（操作选中的记录）*/
function operateBat(modal, beforeOperate, afterOperate) {
    try {
        var evt = window.event || arguments.callee.caller.arguments[0];
        evt.stopPropagation();
    } catch(e) {}
    
    // 取得所有选中的checkbox
    var obj = $(modal.loadTable.id + " tbody :checkbox:checked");
    if (obj.length == 0) {
    	var msg = modal.msg == null ? '操作' : modal.msg;
    	
        alert('请选择要' + msg + '的数据!');
        return;
    }

    // 将记录ID保存到数值
    var ids = new Array();
    for (i = 0; i < obj.length; i++) {
        ids[i] = obj[i].value;
    }

    try {
        beforeOperate(modal);
    } catch(e) {}

    
    // 进行操作
    operate(modal, ids, afterOperate);
}


/**
 * 操作（单个）
 * 
 * @param modal
 * @param ids
 */
function operate(modal, ids, afterOperate) {
    try {
        var evt = window.event || arguments.callee.caller.arguments[0];
        evt.stopPropagation();
    } catch(e) {}
    
	var msg = modal.msg == null ? '操作' : modal.msg;
	
    if (confirm('确定要' + msg + '吗？')) {
        $.ajax({
            type: 'post',
            url: modal.operateURL,
            data: {
                ids: ids
            },
            dataType: 'json',
            traditional: true,
            success: function(result) {
                if (result.success) {
                    initTable(modal.loadTable, parentTableRecordId);
                    
                    try {
                        afterOperate(modal);
                    } catch(e) {}

                } else {
                    if (result.errorMsg.indexOf("ConstraintViolationException") > 0) {
                        alert('您选择的记录已经被引用，不能被' + msg);
                    }
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                redirectLogin(XMLHttpRequest.responseText);
            }
        });
    }
}


/**
 * 初始化文件上传控件
 * 
 * @param _this
 */
function initFile(_this){
	if (_this.siblings().length > 0) {
        _this.attr("id", _this.next().attr("id"));
        _this.attr("name", _this.next().attr("name"));
        _this.siblings().remove();
    }
	var value = _this.attr("value");
    var id = _this.attr("id");
    var name = _this.attr("name");
    var type = _this.attr("data-type");
    var title = _this.attr("title");
    _this.attr("id", "_" + id);
    _this.attr("name", "file");
    if (type == "image") {
       _this.attr("style", "display: none;");
       _this.before('<img class="form-control-img" id="file_' + id + '" alt="Desert1" title="">');
       _this.prev().click(function() {
           _this.click();
       });
    } else {
        _this.before('<a id="file_' + id + '" style="display: none;" class="">下载</a>');

    }
    if(id!="uploads1"){
    	_this.before('<a id="fileDel_' + id + '" style="display: none;" class="btn del-upload">删除</a>');    	
    }
    _this.after('<input type="hidden" id="' + id + 'Name" name="' + name + 'Name">');
    _this.after('<input type="hidden" id="' + id + '" name="' + name + '">');
    _this.attr("onChange", "uploadFile('" + id + "','" + name + "');");
    
    showFile("#" + id);
}

/**
 * 上传文件
 * 
 * @param id
 */

function uploadFile(id,fileId) {
    var type = $("#_" + id).attr("data-type");
    var fileId = $("#"+id).val();
    
    $.ajaxFileUpload({

        url : ctx + "/attachment/upload",
        secureuri : false,
        fileElementId : "_" + id,
        data : {fileId : fileId}, // 此处有bug，放开会造成第二次上传时，提交不了图片
        dataType : 'json',
        type : 'POST',
        success : function(data, status) {
          if (data.success == false) {
              if (data.errorCode == "01") {
                  alert("上传的文件不能为空！");
              } else if (data.errorCode == "02") {
                  alert("上传的文件太大了！");
              } else {
                  alert(data.errorMsg);
              }
              return;
          }  
            
          initFile($("#_" + id));
            
          var file = data.data.obj;
          $("#" + id).attr("value", file.id);
          $("#" + id + "Name").attr("value", file.name);
          
          showFile("#" + id, file.id, file.name,file.file,file.type);
          $("#" + id + "_" + id).css("word-wrap","break-word");
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("上传失败，请检查文件大小或类型");

            //redirectLogin(XMLHttpRequest.responseText);
        }
    });
}

/**
 * 显示文件
 * 
 * @param id 表单提交用的id（hidden）
 * @param fileId
 */
function showFile(id, fileId, fileName,fileUrl,type) {
    var hiddenId = $(id).attr("id");
    if (fileId != null && fileId != "") {
        if ($("#_" + hiddenId).attr("data-type") == "image") {
            $("#file_" + hiddenId).attr("src", ctx + "/attachment/" + fileId + "?isImage=true");
        } else {
            $("#file_" + hiddenId).removeAttr("style");
            $("#file_" + hiddenId).attr("href", ctx + "/attachment/" + fileId);
            $("#file_" + hiddenId).html(fileName);
        }
        
        $("#fileDel_" + hiddenId).removeAttr("style");
        $("#fileDel_" + hiddenId).attr("onclick", 'delFile(\'#_' + hiddenId + '\', ' + fileId + ');');
        
    } else {
        if ($("#_" + hiddenId).attr("data-type") == "image") { 
            $("#file_" + hiddenId).attr("src", ctx + "/static/admin/img/uploadImg.jpg?");
        } 
    } 
    var videoShowDiv=document.getElementById('videoShowDiv');
    if(fileUrl != null&& fileUrl != ""&&fileId!=null&&hiddenId=="videoShow"){
    	videoShowDiv.innerHTML="<video controls='controls' width='320' height='240' type="+type+"><source src="+ctx+fileUrl+" type="+type+"></source></video>" +
    			"<input type='hidden' id='videoShow' name='videoShow' value="+fileId+">";//+"<input type='file' data-type='image' class='form-control' id='videoShow' name='videoShow' placeholder='' data-min-file-count='1' style='display: none;'";
    	
    	//$("#videoShow").before("<a id='fileDel_'" + id + "'  class='btn del-upload'  onclick='delFile("+hiddenId+","+fileId+");'>删除</a>");
    }
}

function delFile(_this, fileId) {
    initFile($(_this));
}

/**设置树*/
function settingTree(url, whetherAddCheck) {
    var setting = {
        async: {
            enable: true,
            type: "get",
            //表示异步加载采用 post 方法请求
            url: url,
            autoParam: ["id", "type"] //传递节点的id 和 type值给后台(当异步加载数据时)
        },
        check: {
        	autoCheckTrigger: true,
        	chkboxType: {"Y":"","N":""},
        	enable: whetherAddCheck
        },
        callback: {
            onAsyncSuccess: zTreeOnAsyncSuccess,
            onClick: zTreeOnClick //单击节点事件
        }
    };

    return setting;
}

/**重新加载树*/
function reloadTree(id) {

    var tree = $(id);
    var treeUrl = tree.attr("data-url");

    if (treeUrl != null) {
        $.fn.zTree.destroy(id);
        $.fn.zTree.init(tree, settingTree(treeUrl));
    }
}


/**数异步加载成功*/
function zTreeOnAsyncSuccess(event, treeId, node, msg) {
    var treeObj = $.fn.zTree.getZTreeObj(treeId);
    var nodes = treeObj.getNodes();

    // 异步展开一级子节点
    if (nodes.length > 0) {
        treeObj.expandNode(nodes[0], true, false, false);
    }
}

/**点击树的节点*/
function zTreeOnClick(event, treeId, node) {
    if ($("#" + treeId + "_currNode").length > 0) {
        $("#" + treeId + "_currNode").val(node.id);
    } else {
        $("#" + treeId).before('<input type="hidden" id="' + treeId + '_currNode" name="id" value="' + node.id + '">');
    }
    
    initTable(currTable, node.id);
}

function initFileInput(fileObj) {
    
    
//    ff = fileObj.fileinput({
//        language: 'zh', //设置语言
//        showPreview : true, //是否显示预览
//        showCaption : false, //是否显示标题
//        showRemove  : false, //显示移除按钮
//        showUpload : true, //是否显示上传按钮
//        showCancel : false, //显示取消按钮（Ajax上传中）
//        dropZoneEnabled: false,//是否显示拖拽区域
//        browseClass : "btn btn-primary", //按钮样式             
//        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
//        uploadUrl: ctx + "/sys/attachment/upload", //上传的地址
//        uploadAsync : true, //是否异步上传
//        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
////        allowedPreviewTypes ：[] //预览的文件后缀
//        //minImageWidth: 50, //图片的最小宽度
//        //minImageHeight: 50,//图片的最小高度
//        //maxImageWidth: 1000,//图片的最大宽度
//        //maxImageHeight: 1000,//图片的最大高度
//        maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
//        //minFileCount: 0,
//        maxFileCount: 10, //表示允许同时上传的最大文件个数
//        enctype: 'multipart/form-data',
//        validateInitialCount: true,
//        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
//        initialPreview : ["<img src='" + ctx + "/sys/attachment/" + 0 + "' class='file-preview-image' alt='Desert' title='Desert'>"]
//    });
}

function redirectLogin(data) {
    if (data.indexOf("admin/login") > 0) {
        location.href = ctx + "/admin/login";
    }
}

$(function(){
	/*左侧菜单栏点击时改变字体颜色*/
	$('.treeview-menu li a').click(function(){
		$(this).parent().addClass('active');
		$(this).parent().siblings().removeClass('active');
		$(this).parent().parent().parent().siblings().children().children().removeClass('active');
	});
	$('.sidebar-menu>li:first .fa-angle-left').trigger("click");//自动触发左侧菜单的下拉功能
	
	    
});
