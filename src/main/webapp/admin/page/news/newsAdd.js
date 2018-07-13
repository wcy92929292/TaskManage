layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	 //日期范围
	  laydate.render({
	    elem: '#test6'
	    ,range: true
	  });
	//创建一个编辑器
 	var editIndex = layedit.build('news_content');
 	var addNewsArray = [],addNews;
 	form.on("submit(addNews)",function(data){
 		console.log(data);
 		$.ajax({
            type: 'POST',
            url: '../../../task/addTask.do',
            dataType: 'json',
            data: data.field,//往后台发送的是data.field，即一个{name：value}的数据结构
            async: true,
            success: function (result) {
                if (result.code == 0) {
                    layer.msg('保存成功', {icon: 1, time: 1000});
                    parent.location.reload();
                } else {
                    layer.msg('保存失败！' + result.msg, {icon: 2, time: 1000});
                }
            },
            error: function (result, type) {
                layer.msg('保存失败！', {icon: 2, time: 1000});
            }
        });
        return false;
 		//是否添加过信息
	 	if(window.sessionStorage.getItem("addNews")){
	 		addNewsArray = JSON.parse(window.sessionStorage.getItem("addNews"));
	 	}
	 	//显示、审核状态
 		var isShow = data.field.show=="on" ? "checked" : "",
 			newsStatus = data.field.shenhe=="on" ? "审核通过" : "待审核";

 		addNews = '{"newsName":"'+$(".newsName").val()+'",';  //文章名称
 		addNews += '"newsId":"'+new Date().getTime()+'",';	 //文章id
 		addNews += '"newsLook":"'+$(".newsLook option").eq($(".newsLook").val()).text()+'",'; //开放浏览
 		addNews += '"newsTime":"'+$(".newsTime").val()+'",'; //发布时间
 		addNews += '"newsAuthor":"'+$(".newsAuthor").val()+'",'; //文章作者
 		addNews += '"isShow":"'+ isShow +'",';  //是否展示
 		addNews += '"newsStatus":"'+ newsStatus +'"}'; //审核状态
 		addNewsArray.unshift(JSON.parse(addNews));
 		window.sessionStorage.setItem("addNews",JSON.stringify(addNewsArray));
 		//弹出loading
// 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
//        setTimeout(function(){
//            top.layer.close(index);
//			top.layer.msg("文章添加成功！");
// 			layer.closeAll("iframe");
//	 		//刷新父页面
//	 		parent.location.reload();
//        },2000);
 		return false;
 	})
 	
//$("#location").on("keyup",function(){
//	var myGeo = new BMap.Geocoder();
//	// 将地址解析结果显示在地图上,并调整地图视野
//	myGeo.getPoint($("#location").val(), function(point){
//		if (point) {
//			alert(point.lat+","+point.lng);
//		}else{
//			alert("您选择地址没有解析到结果!");
//		}
//	});
////	$("#lation").val(point.lat+","+point.lng);
//})
 	loadMapAutocomplete("location", "searchResultPanel");
 	
 	function G(id) {
        return document.getElementById(id);
    }
    function loadMapAutocomplete(suggestId, searchResultPanel) {
        var checkValue;
        Ac = new BMap.Autocomplete( //建立一个自动完成的对象
            {
                "input": suggestId,
            });
        Ac.addEventListener("onhighlight", function(e) { //鼠标放在下拉列表上的事件
            var str = "";
            var _value = e.fromitem.value;
            var value = "";
            if(e.fromitem.index > -1) {
                value = _value.province + _value.city + _value.district + _value.street + _value.business;
            }
            str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

            value = "";
            if(e.toitem.index > -1) {
                _value = e.toitem.value;
                value = _value.province + _value.city + _value.district + _value.street + _value.business;
            }
            str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
            G(searchResultPanel).innerHTML = str;
        });

        Ac.addEventListener("onconfirm", function(e) { //鼠标点击下拉列表后的事件
            var _value = e.item.value;
            checkValue = _value.province + _value.city + _value.district + _value.street + _value.business;
            G(searchResultPanel).innerHTML = "onconfirm<br />index = " + e.item.index + "<br />myValue = " + checkValue;
            var myGeo = new BMap.Geocoder();
        	// 将地址解析结果显示在地图上,并调整地图视野
        	myGeo.getPoint($("#location").val(), function(point){
        		if (point) {
        			$("input[name=lation]").val(point.lat+","+point.lng);
        		}else{
        			$("input[name=lation]").val("您选择地址没有解析到结果!");
        		}
        	});
        });
    }
})
