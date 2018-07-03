$(document).ready(function(){
	$(function(){
		initTable();
		getJson();
	});
	
	$("#show-writeBBS").click(function(){
		$("#writeBBS").modal('show');
		$("#bbsTitle").val(null);
		$(".note-editor .note-editing-area .note-editable").html(null);
		$('#summernote').summernote({ 
        height: 200, 
        tabsize: 2, 
        lang: 'zh-CN' 
    	});
	});
	
	$("#BBS-btn").click(function(){
		writeBBS();
	});
	
	$("#show-modal").click(function() {
		var session_id = localStorage.getItem("session");
		var user_name = localStorage.getItem("username");
		if(session_id != null && user_name != null) {
			$("#my-modal-alert").toggle();
			$("#modal_message").html('确定注销' + user_name + '吗？');
		} else {
			$("#username").val(user_name);
			$("#myModal").modal('show');
			return;
		}
	});
	
	$("#login-btn").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(username == ""){
			$("#login-alert-danger").html("用户名不能为空");
			$("#login-alert-danger").addClass("alert alert-danger");
			return;
		}
		if(password == ""){
			$("#login-alert-danger").html("密码不能为空");
			$("#login-alert-danger").addClass("alert alert-danger");
			return;
		}
		Login(username,password);
	});
	
	/**
	 * 动态表格
	 */
	function initTable(){
		$('#table').bootstrapTable({
			//url: 'json/user.json',
			method:  'get',						//服务器数据的请求方式 'get' 或 'post'。
			striped: true,
			//classes:  'table-no-bordered',	//删除表格的边框样式。
			sortName: 'endtime',				//定义排序列，通过url方式获取数据填写字段名，否则填写下标。
			sortOrder: 'asc',					//定义排序方式，'asc' 或者 'desc'。
			cache: true,						//设置为 false 禁用 AJAX 数据缓存。
			pagination: true,					//设置为 true 会在表格底部显示分页条。
			paginationLoop: false,				//设置为 true 启用分页条无限循环的功能。
			onlyInfoPagination: false,			//设置为 true 只显示总数据数，而不显示分页按钮。需要设置 pagination='true'。
			sidePagination: 'client',			//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置服务器数据地址（url）或者重写ajax方法。
			pageNumber: 1,						//如果设置了分页，首页页码。
			pageSize: 8,						//如果设置了分页，页面数据条数。
			pageList: [8],					//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
			search: true,						//是否启用搜索框。
			searchOnEnterKey: true,				//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法。
			strictSearch: false,				//设置为 true启用全匹配搜索，否则为模糊搜索。
			showHeader: false,					//是否显示列头。
			
		    columns: [{
		    	field: 'no',
	    		title: '订单编号',
	    		//width: '25%',
	    		//align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
	    		//valign: 'middle',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    	//halign: 'center',					//指示如何对齐表格标题。'left'、'right'、'center'可以使用。
		    	searchable: true,				//指示列是否可以被搜索
		    }],
		});
	};//creat-table end
	
	
	/*
	 * 堆叠样式JS
	 */
	var cards = $(".card-drop"),
		toggler = cards.find(".toggle"),
		links = cards.find("ul>li>a"),
		li = links.parent('li'),
		count = links.length,
		width = 100;

		//set z-Index of drop Items
		li.each(function(i){
			$(this).css("z-index" , count - i); //invert the index values
		});

		//set top margins & widths of li elements
		function setClosed(){
			li.each(function(index){
				 $(this).css("top" , index * 4)
				 		.css("width" , (width - index * .5) + "%" )
				 		.css("margin-left" , (index * .25) + "%" )
			});
			li.addClass('closed');
			toggler.removeClass("active");
		}
		setClosed();

	/* -------------------------------------------------------- */ 
	/*	Toggler Click handler
	/* -------------------------------------------------------- */ 
	toggler.on("mousedown" , function(){
		var $this = $(this); //cache $(this)
		//if the menu is active:
		if($this.is(".active")){
			setClosed();
		}else{
			//if the menu is un-active:
			$this.addClass("active");
			li.removeClass('closed');
			//set top margins
			li.each(function(index){
				 $(this).css("top" , 60 * (index + 1))
				 		.css("width" , "100%")
				 		.css("margin-left" , "0px");
			});
		}
	});

	/* -------------------------------------------------------- */ 
	/*	Links Click handler
	/* -------------------------------------------------------- */ 
	links.on("click" , function(e){
		var $this = $(this),
			label = $this.data("label");
			icon = $this.children("i").attr("class");
			
			li.removeClass('active');
		if($this.parent("li").is("active")){
			$this.parent('li').removeClass("active");
		}else{
			$this.parent("li").addClass("active");
		}
		toggler.children("span").text(label);
		toggler.children("i").removeClass().addClass(icon);
		setClosed();
		e.preventDefault;
	});
	
});/*Jquery end*/

function getJson(temp){
	if(temp==null){
		temp = 1;
	}
	var pushdata = {'board_id':temp}
	$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/showBBS",
		async:true,
		cache:false,
		dateType:"json",
		data: pushdata,
		success: function (result) {
			if(result=='板块错误' || result=='无更多内容'){
				$("#my-modal-alert").toggle();
				$("#modal_message").html(result);
			}
			var row = [];
			$.each(result, function(i,item) {
				var strs = item.createtime.split("T");
				row.push({
					no: '<div id="question-content"><p id="bbs-id">'+item.bbs_id+'</p><p><a onclick="javascript :saveBBSId($(this).parent())">'+item.bbs_title+'</a></p>'+
		    	'<a href="#" onclick="deleteBBS();" class="pull-right text-color-999">删除</a>'+
		    	'<p class="pull-left">'+
		    	'<span class="text-color-999">'+item.account+' 发起了问题 • '+item.board_name+' •&nbsp;'+strs[0]+" "+strs[1]+' </span></p></div>'
				});
			});
			$('#table').bootstrapTable('load',row);
		},error: function(XMLHttpRequest) {
			var tem = JSON.parse(XMLHttpRequest.responseText);
			$("#my-modal-alert").toggle();
			$("#modal_message").html(tem.message);
		}
	});
};

function togetJson(gameName){
	var flag = 1;
	if(gameName == '绝地求生'){
		flag = 2;
	}
	if(gameName == '王者荣耀'){
		flag = 3
	}
	getJson(flag);
}

function deleteBBS(){
	var user = localStorage.getItem("username");
	var session = localStorage.getItem("session");
	var endtime = localStorage.getItem("endtime");
	if(new Date().getTime() - endtime > 0){
		rootzuxiao();
		$("#my-modal-alert").toggle();
		$("#modal_message").html("用户信息已经失效，请重新登陆");
		return;
	}
	var bbs_id = $("#bbs-id").html();
	var pushdata = {'userName':user,'session':session,'bbsId':bbs_id};
	$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/deleteBBS",
		async:true,
		cache:false,
		dateType:"json",
		data: pushdata,
		success: function (result) {
			if(result == '删除成功！'){
				$("#writeBBS").modal('hide');
				//getJson();
			}else{
				$("#writeBBS").modal('hide');
				$("#my-modal-alert").toggle();
				$("#modal_message").html(result);
			}
		},error: function(XMLHttpRequest) {
			$("#writeBBS").modal('hide');
			var tem = JSON.parse(XMLHttpRequest.responseText);
			$("#my-modal-alert").toggle();
			$("#modal_message").html(tem.message);
		}
	});
}

function writeBBS(){
	var user = localStorage.getItem("username");
	var session = localStorage.getItem("session");
	var endtime = localStorage.getItem("endtime");
	if(new Date().getTime() - endtime > 0){
		rootzuxiao();
		$("#alert-danger").addClass("alert alert-danger");
		$("#alert-danger").html("用户信息已经失效，请重新登陆");
		return;
	}
	if(user==null || session==null){
		$("#alert-danger").html('登陆后操作！');
		$("#alert-danger").addClass("alert alert-danger");
		return;
	}
	var title = $("#bbsTitle").val();
	var Content = $(".note-editable").html();
	var board = $(".card-drop .toggle .label-active").html();
	var pushdata = {'userName':user,'session':session,'title':title,'count':Content,'board':board};
	$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/writeBBS",
		async:true,
		cache:false,
		dateType:"json",
		data: pushdata,
		success: function (result) {
			if(result == '添加成功'){
				$("#writeBBS").modal('hide');
				getJson();
			}else{
				$("#alert-danger").html(result);
				$("#alert-danger").addClass("alert alert-danger");
				return;
			}
		},error: function(XMLHttpRequest) {
			var tem = JSON.parse(XMLHttpRequest.responseText);
			$("#alert-danger").html(tem.message);
			$("#alert-danger").addClass("alert alert-danger");
			return;
		}
	});
};

function Login(username,password){
	var postdate = {'UserName':username,'PassWord':password};
	$.ajax({
		type:"post",
		url:"http://localhost:8080/wlh/Login",
		async:true,
		cache:false,
		dateType:"json",
		data: postdate,
		success: function (result) {
			if(result == '用户名和密码不能为空' || result == '找不到用户或密码错误'){
				$("#login-alert-danger").html(result);
				$("#login-alert-danger").addClass("alert alert-danger");
				return;
			}
				//localStorage.setItem("a","b");
			var time = new Date().getTime()+(1000*60*30);
			localStorage.setItem("endtime",time);
			localStorage.setItem("username", username);
			localStorage.setItem("session", result);

			$("#myModal").modal('hide');
		}
	});
	
};

function saveBBSId(temp){
	var session_id = localStorage.getItem("session");
	var user_name = localStorage.getItem("username");
	var endtime = localStorage.getItem("endtime");
	if(new Date().getTime() - endtime > 0){
		rootzuxiao();
		$("#my-modal-alert").toggle();
		$("#modal_message").html("用户信息已经失效，请重新登陆");
		return;
	}
	if(session_id==null || user_name==null){
		$("#my-modal-alert").toggle();
		$("#modal_message").html("登陆后操作！");
		return;
	}
	temp = temp.prev().html()
	localStorage.setItem("bbsId", temp);
	window.location.href="reply.html";
}
