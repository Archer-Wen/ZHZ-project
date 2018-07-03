$(document).ready(function(){
	$(function(){
		var url = window.location.search;
		if(url.indexOf('login=true') != -1){
			$("#show-modal").click();
		}
		initTable();
		getJson();
	});
	
	function initTable(){
		$('#table').bootstrapTable({
			url: '',
			method:  'get',						//服务器数据的请求方式 'get' 或 'post'。
			striped: true,
			//classes:  'table-no-bordered',	//删除表格的边框样式。
			sortName: 'id',						//定义排序列，通过url方式获取数据填写字段名，否则填写下标。
			sortOrder: 'asc',					//定义排序方式，'asc' 或者 'desc'。
			cache: true,						//设置为 false 禁用 AJAX 数据缓存。
			pagination: true,					//设置为 true 会在表格底部显示分页条。
			paginationLoop: false,				//设置为 true 启用分页条无限循环的功能。
			onlyInfoPagination: false,			//设置为 true 只显示总数据数，而不显示分页按钮。需要设置 pagination='true'。
			sidePagination: 'client',			//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置服务器数据地址（url）或者重写ajax方法。
			pageNumber: 1,						//如果设置了分页，首页页码。
			pageSize: 5,						//如果设置了分页，页面数据条数。
			pageList: [5],						//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
			search: true,						//是否启用搜索框。
			searchOnEnterKey: true,				//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法。
			strictSearch: false,				//设置为 true启用全匹配搜索，否则为模糊搜索。
			showHeader: true,					//是否显示列头。
			
		    columns: [{
		    	field: 'img',
	    		title: 'logo',
	    		width: '15%',
	    		align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
	    		valign: 'middle',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    	halign: 'left',					//指示如何对齐表格标题。'left'、'right'、'center'可以使用。
		    	searchable: false,				//指示列是否可以被搜索  
		    }, {
		    	searchable: true,				//指示列是否可以被搜索
		        field: 'goods_describe',
		        width: '50%',
		        title: '商品主题',
		        cellStyle:{  
        			css:{"font-size":"1rem;"}
   				 }
		    }, {
		    	searchable: false,
		        field: 'goods_hour',
		        title: '价格',
		        align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
	    		valign: 'middle',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
	    		cellStyle:{  
        			css:{"font-size":"1rem;"}
   				}
		    }, {
		    	searchable: false,
	    		align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
		    	halign: 'left',					//指示如何对齐表格标题。'left'、'right'、'center'可以使用。
		    	valign: 'top',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    	width: '15%',					//列的宽度。如果没有定义，宽度将自动扩展以适应其内容。可用'10%'或者10,后者直接取10px。
		        field: 'goods_no',
		        title: '操作',
		        //searchable: false				//指示列是否可以被搜索
			    formatter: function(value, row, index) {
		  			var s;
		  			if(row.goods_no != null) {
		  				var url = row.id;
		  				s = '<button class="btn btn-success">立即租号</button>';
		  			}
		  			return s;
		  		},
	   		}]
		});
	};//creat-table end
	
	$("#login-btn").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(username == ""){
			$("#alert-danger").html("用户名不能为空");
			$("#alert-danger").addClass("alert alert-danger");
			return;
		}
		if(password == ""){
			$("#alert-danger").html("密码不能为空");
			$("#alert-danger").addClass("alert alert-danger");
			return;
		}
		Login(username,password);
	});
	
	$("#show-modal").click(function(){
		var session_id = localStorage.getItem("session");
		var user_name = localStorage.getItem("username");
		if(session_id!=null && user_name!=null){
			$("#my-modal-alert").toggle();
			$("#modal_message").html('确定注销'+user_name+'吗？');
		}else{
			$("#username").val(user_name);
			$("#myModal").modal('show');
			return;
		}
	});
	
});

function getJson(temp){
	if(temp == null){
		temp = 'ALL';
	}
	var pushdata = {'gameName':temp};
		$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/show_rent",
		async:true,
		cache:true,
		dateType:"json",
		data: pushdata,
		success: function (result) {
			var row = [];
			var level;
			var recomm;
			$.each(result, function(i,item) {
				level = creat_level(item.goods_credit_level);
				recomm = creat_recomm(item.goods_recomm);
				console.log(level);
				var imgUrl = 'img/LOL.jpg';
				if(temp=='英雄联盟'){
					imgUrl = 'img/LOL.jpg';
				}
				if(temp == '绝地求生'){
					imgUrl = 'img/PUBG-icon.png';
				}
				if(temp == '王者荣耀'){
					imgUrl = 'img/WZRY.jpg';
				}
				row.push({
					img: '<a class = "view"  href="javascript:void(0)"><img style="width:100px;height:70px;" src="'+imgUrl+'" /></a>',
					goods_describe: '<p>[可租] '+item.goods_theme+'</p><p>租用时间：'+item.goods_short_time+'小时起租</p><p>信用等级：'+level+'</p><p>认证：'+recomm+'</p>',
					goods_hour: '<p>租金：'+item.goods_hour+'元/小时</p><p>保证金：'+item.goods_compensate+'元</p>',
					goods_no: item.goods_no
				})
			});
			$('#table').bootstrapTable('load',row);
		},error: function(XMLHttpRequest) {
			var json = JSON.parse(XMLHttpRequest.responseText);
			if(json.message == '请登陆后操作'){
				$("#login-modal").click();
			}
		}
		
	});
};

function togetJson(gameName){
	getJson(gameName);
}

function creat_level(temp){
	if(temp == 0){
		return '青铜用户';
	}else if(temp == 1){
		return '白银用户';
	}else if(temp == 2){
		return '黄金用户';
	}else if(temp == 3){
		return '钻石用户';
	}else if(temp == 4){
		return '大师用户';
	}else if(temp == 5){
		return '王者用户'
	}else{
		return temp;
	}
};

function creat_recomm(temp){
	if(temp == 0){
		return '个人认证';
	}else if(temp == 1){
		return '商家认证';
	}else if(temp == 2){
		return '个人商家认证';
	}else if(temp == 3){
		return '特价商品';
	}else if(temp == 4){
		return '测试认证';
	}else{
		return temp;
	}
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
				$("#alert-danger").html(result);
				$("#alert-danger").addClass("alert alert-danger");
				return;
			}
			var time = new Date().getTime()+(1000*60*30);//半小时过期
			localStorage.setItem("endtime",time);
			localStorage.setItem("username", username);
			localStorage.setItem("session", result);
			$("#myModal").modal('hide');
		}
	});
	
};

