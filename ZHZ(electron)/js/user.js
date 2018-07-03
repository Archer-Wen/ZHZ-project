$(document).ready(function(){
	$(function(){
		initTable();
		//getJson();
		panduan();
	});
	
	
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
			pageSize: 10,						//如果设置了分页，页面数据条数。
			pageList: [10],					//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
			search: true,						//是否启用搜索框。
			searchOnEnterKey: true,				//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法。
			strictSearch: false,				//设置为 true启用全匹配搜索，否则为模糊搜索。
			showHeader: true,					//是否显示列头。
			
		    columns: [{
		    	field: 'no',
	    		title: '订单编号',
	    		width: '25%',
	    		align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
	    		valign: 'middle',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    	halign: 'center',					//指示如何对齐表格标题。'left'、'right'、'center'可以使用。
		    	searchable: false,				//指示列是否可以被搜索 
		    	
		    }, {
		        field: 'game',
		    	searchable: true,				//指示列是否可以被搜索
		        width: '10%',
		        title: '游戏',
		        align: 'center',
		    	valign: 'middle',
		    	halign: 'center',
		    }, {
		    	field: 'username',
		    	searchable: true,
		        title: '账号',
		        align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
		        width: '20%',
	    		valign: 'middle',				//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    },{
		    	field: 'order_amount',
		    	searchable: false,
		    	title: '租金',
		    	align: 'center',
		    	valign: 'middle',
		    	halign: 'center',
		    	width: '15%',
		    },{
		        field: 'endtime',
		        title: '到期时间',
		    	searchable: false,
		    	width: '30%',
	    		align: 'center',				//指示如何排列列数据。'left'、'right'、'center'可以使用。
		    	halign: 'center',					//指示如何对齐表格标题。'left'、'right'、'center'可以使用。
		    	valign: 'top',					//指示如何排列单元格数据。'top', 'middle', 'bottom' 可以使用。
		    	width: '15%',					//列的宽度。如果没有定义，宽度将自动扩展以适应其内容。可用'10%'或者10,后者直接取10px。
	   		}],
		});
	};//creat-table end
	
	$("#my-modal-alert button").click(function(){
		$("#my-modal-alert").toggle();
	});
});

function getJson(state){
	var endtime = localStorage.getItem("endtime");
	if(new Date().getTime() - endtime > 0){
		rootzuxiao();
	}
	var session_id = localStorage.getItem("session");
	var user_name = localStorage.getItem("username");
	if(session_id == null || user_name == null) {
		window.location.href = "Login.html";
	}
	var push_data = {'sessionId':session_id,'user_name':user_name,'state':state};
		$.ajax({
		type:"get",
		url:"http://localhost:8080/wlh/showBuyerOrder",
		async:true,
		cache:false,
		dateType:"json",
		data: push_data,
		success: function (result) {
			if(result == '无效用户信息'){
				$("#my-modal-alert").toggle();
				$("#modal_message").html(result);
			}
			var row = [];
			$.each(result, function(i,item) {
				var strs = item.order_end_time.split("T");
				row.push({
					no: item.order_no,
					game: item.goods_game,
					username: item.goods_access,
					order_amount: item.order_amount,
					endtime: strs[0]+" "+strs[1],
				})
			});
			$('#table').bootstrapTable('load',row);
		},error: function(XMLHttpRequest) {
			var json = JSON.parse(XMLHttpRequest.responseText);
			$("#my-modal-alert").toggle();
			$("#modal_message").html(json.message);
			
		}
		
	});
};

function panduan(tem) {
	if(tem != null) {
		tem.parent().siblings().removeClass('active');
		tem.parent().addClass('active');
		var flag = judgestate(tem.html());
		getJson(flag);
	}else{
		getJson(4);
	}
}

function judgestate(flag){
	if(flag=='进行中'){
		return 4;
	}else if(flag=='待付款'){
		return 0;
	}else if(flag=='已完成'){
		return 2;
	}else if(flag=='已失败'){
		return 1;
	}else if(flag=='已失效'){
		return 3;
	}else{
		return 4;
	}
}
