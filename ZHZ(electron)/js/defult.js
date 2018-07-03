$(document).ready(function(){
	$("#verticalnavbar a").click(function(){
		$("#verticalnavbar li").removeClass("active");
		$(this).parent().addClass("active");
	});

	$("#example-navbar-collapse #mainbar").click(function(){
		$("#example-navbar-collapse #mainbar").children().css({"color":"#777777"});
		$(this).children().css({"color":"#ffffff"});
	});
	
	$(function(){
		
	});
	
	
});
//自定义关闭，最小化
function closebt(e){
	const {ipcRenderer} = require('electron');
	ipcRenderer.send('close-main-window');
}
function minbt(e){
	const {ipcRenderer} = require('electron');
	ipcRenderer.send('min-main-window');
}
//注销
function zuxiao(){
	var message = $("#modal_message").html();
	if(message.indexOf('注销') != -1){
		localStorage.removeItem("username");
		localStorage.removeItem("session");
		$("#my-modal-alert").toggle();
	}else{
		$("#my-modal-alert").toggle();
	}
}
//时间失效注销
function rootzuxiao(){
	localStorage.removeItem("username");
	localStorage.removeItem("session");
	localStorage.removeItem("endtime");
}