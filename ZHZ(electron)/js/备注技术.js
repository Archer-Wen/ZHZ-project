{
	field: 'companyImage',
	title: '公司logo',
	formatter: function(value, row, index) {
		var s;
		if(row.companyImage != null) {
			var url = row.companyImage;
			//var i = row.companyImage.indexOf("webapps");
			//var url = row.companyImage.substring(i+7,row.companyImage.length);
			//var url = 'F:\idnex.jpg';
			s = '<a class = "view"  href="javascript:void(0)"><img style="width:300;height:40px;"  src="' + url + '" /></a>';
		}
		return s;
	},

	//定义点击之后放大图片的事件

	events: 'operateEvents'
},



//点击之后放到图片

window.operateEvents = {

	    'click .view': function (e, value, row, index) {
	    	console.log(row);
	    /* 	var i = row.companyImage.indexOf("webapps");
			var url = row.companyImage.substring(i+7,row.companyImage.length); */
			var url = row.companyImage;
			layer.open({
	          type: 1,
	          title: false,
	          closeBtn: 0,
	          area: ['700px', '300px'],
	          skin: 'layui-layer-nobg', //没有背景色
	          shadeClose: true,
	          content: '<img  src="'+url+'"/>'
	        });
	    },
};

方法:
load	data	加载数据到表格中，旧数据会被替换。

