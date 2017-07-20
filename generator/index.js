/**
 * 
 */

$(function() {
	initConfig();// 加载配置
});

function initTables(){
	var url=basePath +'/generatorTables.do?' + Math.random();
	var connection = $("#connection").val();//数据库连接
	var port = $("#port").val();//端口号
	var dataBase = $("#dataBase").val();//数据库
	var userId = $("#userId").val();//用户名
	var userPass = $("#userPass").val();//密码
	var isHump = $("#isHump").val();//模型是否驼峰命名
	var param={'connection':connection,'port':port,'dataBase':dataBase,'userId':userId,'userPass':userPass};
	
	getTables2(url,param,isHump);
}
function filterTables(){
	var isHump = $("#isHump").val();//模型是否驼峰命名
	var tables=getCookie("tables")==""?"no data":getCookie("tables");
	var tableVal=(unescape(tables)).split(",");
	var filtered=tableVal.filter(isContain);
	redItem($(".del"));
	initOrder(filtered,isHump);
}
function isContain(element,index,array){
	var filter=$("#filter").val();
	return element.indexOf(filter)!=-1;
}

function initConfig(){
	$("#form").validate();
	setDefaultValues();//加载cookie值
}


// 增加一列表名
function addItem(){
	var item = "";
	item += "<div class='form-group'>"
 		+"<label class='col-lg-2 control-label'>表名</label>"
 		+"<div class='col-xs-3'><input type='text' name='tableNames' class='form-control' /></div>"
 		+"<label class='col-lg-2 control-label'>模型名</label>"
 		+"<div class='col-xs-3'><input type='text' name='modelNames' class='form-control' /></div>"
 		+"<a class='btn btn-success btn-xs' onclick='addItem()' title='增加'><span class='fui-check'>&nbsp;增加</span></a>&nbsp;"
 		+"<a class='btn btn-danger btn-xs del' onclick='redItem(this)' title='删除'><span class='fui-cross'>&nbsp;删除</span></a>"
 		+"</div>";
	$("#form").append(item);
}
function addItems(tableName,tableNameAlias){
	var item = "";
	item += "<div class='form-group'>"
 		+"<label class='col-lg-2 control-label'>表名</label>"
 		+"<div class='col-xs-3'><input type='text' name='tableNames' class='form-control' value="+tableName+" /></div>"
 		+"<label class='col-lg-2 control-label'>模型名</label>"
 		+"<div class='col-xs-3'><input type='text' name='modelNames' class='form-control' value="+filter(tableName,tableNameAlias)+" /></div>"
 		+"<a class='btn btn-success btn-xs' onclick='addItem()' title='增加'><span class='fui-check'>&nbsp;增加</span></a>&nbsp;"
 		+"<a class='btn btn-danger btn-xs del' onclick='redItem(this)' title='删除'><span class='fui-cross'>&nbsp;删除</span></a>"
 		+"</div>";
	$("#form").append(item);
}
//删除一列表名
function redItem(para){
	$(para).parent().remove();
}

//生成并下载
function doSubmit(){
	if($("#form").valid(this,'填写信息不完整。') == false){
		return;
	}
	if (typeof($("#submitBtn")) != "undefined") { 
		$("#submitBtn").attr("disabled", "disabled");
	}
	var url =  basePath +'/generatorServlet.do?' + Math.random();
	$.ajax({
		type : 'post',
		url : url,
		dataType : 'text',
		data : $("#form").serialize(),
		success : function (data, textStatus) {
			$("#submitBtn").removeAttr("disabled");
			data = JSON.parse(data);
			if(data.rspCode == "000001"){
				alert("数据库连接失败，请检查您的数据库地址和数据库名");
			}else if(data.rspCode == "000002"){
				alert("数据库连接错误");
			}else if(data.rspCode == "000003"){
				alert("数据库连接错误");
			}else if(data.rspCode == "000004"){
				alert("发生错误，请检查您的用户名或密码");
			}else if(data.rspCode == "000005"){
				alert("操作失败");
			}else{
				//alert("操作成功");
				doStorageCookies();//存储到cookie
				window.open(basePath + "/tmp" +data.zipName);
			}
	    },
		error: function(data, textStatus){
			alert('操作失败');
			$("#submitBtn").removeAttr("disabled");
		}
	});
}

//加载上一次存储的cookie值
function setDefaultValues(){
	$("#connection").val(getCookie("connection"));
	$("#port").val(getCookie("port") != "" ? getCookie("port") : "3306");
	$("#dataBase").val(getCookie("dataBase"));
	$("#userId").val(getCookie("userId") != "" ? getCookie("userId") : "root");
	$("#userPass").val(getCookie("userPass"));
	$("#modelPath").val(getCookie("modelPath"));
	$("#daoPath").val(getCookie("daoPath"));
	$("#mappingPath").val(getCookie("mappingPath"));
}

//将值存储到cookie，下次加载时调取
function doStorageCookies(){
	var connection = $("#connection").val();//数据库连接
	var port = $("#port").val();//端口号
	var dataBase = $("#dataBase").val();//数据库
	var userId = $("#userId").val();//用户名
	var userPass = $("#userPass").val();//密码
	var modelPath = $("#modelPath").val();//模型的包名路径
	var daoPath = $("#daoPath").val();//DAO的包名路径
	var mappingPath = $("#mappingPath").val();//映射文件的路径
	addCookie("connection",connection,180);
	addCookie("port",port,180);
	addCookie("dataBase",dataBase,180);
	addCookie("userId",userId,180);
	addCookie("userPass",userPass,180);
	addCookie("modelPath",modelPath,180);
	addCookie("daoPath",daoPath,180);
	addCookie("mappingPath",mappingPath,180);
}

//存储cookie值
//name:cookie键
//value:cookie值
//expiresDays:过期时间（单位：天）
function addCookie(name, value, expiresDays) {
	var cookieString = name + "=" + escape(value);
	// 判断是否设置过期时间
	if (expiresDays > 0) {
		var date = new Date();
		date.setTime(date.getTime + expiresDays * 24 * 3600 * 1000);
		cookieString = cookieString + "; expires=" + date.toGMTString();
	}
	document.cookie = cookieString;
} 

//获取cookie值
function getCookie(name){ 
	var strCookie=document.cookie; 
	var arrCookie=strCookie.split("; "); 
	for(var i=0;i<arrCookie.length;i++){ 
		var arr=arrCookie[i].split("="); 
		if(arr[0]==name)return unescape(arr[1]); 
	} 
	return "";
}

function getTables(url,param){
	$.ajax({ 
		  type:'get', 
		  url:url, 
		  async:false,
		  data:param,
		  dataType:'text',
		  beforeSend:function(XMLHttpRequest){
			  //在发送请求之前调用，并且传入一个 XMLHttpRequest 作为参数。
		  },
		  success:function(data,textStatus){ 
		  }, 
		  complete:function(XMLHttpRequest,textStatus){ 
		    //当请求完成之后调用这个函数,无论成功或失败。传入 XMLHttpRequest 对象，以及一个包含成功或错误代码的字符串
		  }, 
		  error:function(){ 
			  //在请求出错时调用。传入 XMLHttpRequest 对象，描述错误类型的字符串以及一个异常对象（如果有的话）
		    console.log("bad request");
		  } 
		}); 
}

function getTables2(url,param,alias){
	$.ajax({ 
		  type:'get', 
		  url:url, 
		  async:false,
		  data:param,
		  dataType:'text',
		  success:function(data){
			  var tables=eval(data);
			  addCookie("tables",tables,180);
			  initData(tables);
			  initOrder(tables,alias);
		  }
	});
	
}
function filter(str,alias){
	if(alias=="0"){
		var splits=str.split("_");
		var tableNames=splits[0];
		for(var i=1;i<splits.length;i++)
			tableNames+=splits[i].charAt(0).toUpperCase()+splits[i].substring(1,splits[i].length);
		return tableNames;
		}
	return str;
}

function initData(tables){
	for(var i=0;i<tables.length;i++)
	$("#tableList").append('<option value='+tables[i]+'>')
}
function initOrder(tables,alias){
	 var t=$("input[name=tableNames]").length;
	  if(tables)
		  for(var i=0;i<tables.length;i++){
			  if(t>i){
				  $("input[name=tableNames]").eq(i).val(tables[i]);
				  if(tables[i].indexOf("_")){
					  var res=filter(tables[i],alias);
					  $("input[name=modelNames]").eq(i).val(res);
				  }
			  }
			  else{
				  addItems(tables[i],alias);
			  }
		  }
}
//删除cookie值
function deleteCookie(name){ 
	var date=new Date(); 
	date.setTime(date.getTime()-99999999*24*3600*1000); 
	document.cookie=name+"=; expires="+date.toGMTString(); 
}
