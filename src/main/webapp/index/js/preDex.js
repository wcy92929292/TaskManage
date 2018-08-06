var focusList = null;
function taskList(address,flag){
	$.ajax({
        type: 'POST',
        url: '../task/getPreTaskList.do',
        dataType: 'json',
        data: {'myAddress':address,'flag':flag},//yi个id
        async: false,
        success: function (data) { 
//        	var datas =  JSON.stringify(deleteEmptyProperty(data));
//        	$.cookie('data'+flag, datas);
//        	document.cookie = 'name'+flag+'='+encodeURI(data);
//        	console.log(data);
        	$(".product").html("");
        	if(data.code == "2"){
    			$(".product").html('<p style="text-align:center;color:#c5c5c5">没有可接任务</p>');
    			return false;
    		}
        	if (data.code == "0") {
//        		alert(data.result);
        		if(data.result.length==0){
        			$(".product").html('<p style="text-align:center;color:#c5c5c5">没有可接任务</p>');
        			return false;
        		}
        		for (var int = 0; int < data.result.length; int++) {
        			var star ="";
        			focusList = data.focus;
        			if (data.focus==undefined || !IsInArray(data.focus, data.result[int].id)) {
        				star = "star1";
					} else {
						star = "star2";
					}
					$(".product").append(
					'<a diasbled href="business2.html?id='+data.result[int].id+'&distance='+data.result[int].distance+'&state=0">'+
//					'<a class="noStart">'+
					'<div class="sp_pr" >'+
		                    '<div class="text_p" diasbled >'+
		                        '<p>'+data.result[int].title+'</p>'+
//		                        '<span class="yue">'+data.result[int].type+'</span>'+
		                        '<span class="yue"><b name="focus" tid="'+data.result[int].id+'">关注<img src="./images/'+star+'.png" style="width:1.5em;height:1.5em;margin-right: 0;" />'+data.result[int].focusNum+'</b><em class="em_s"><b name="truePeriod">'+'('+data.result[int].truePeriod+')'+'</b></em></span>'+
//		                        '<span class="yue">'+data.result[int].location+'</span>'+
//		                        '<span class="yue" style="width:5em;" name="focus" tid="'+data.result[int].id+'" ><img src="./images/'+star+'.png" style="width:1.5em;height:1.5em;margin-right: 0;" />'+data.result[int].focusNum+'</span>'+
		                        '</div>'+
		                    '<div class="jul">'+data.result[int].distance+'米</div>'+
			            '</div>	'	+
			        '</a>'
					)
				}
        	}
        }
})
$("b[name='focus']").click(function(event){
		event.stopPropagation();
		if(focusList==undefined){
			alert("检测到您尚未登录，请登录后继续！");
			self.location='./login.html?next=preIndex'; 
//			location.href("./login.html");
			return false;
		}
		if($(this).find("img").eq(0).attr("src").indexOf("star1")!=-1){
			var n = $(this).text();
			n = n.substring(2,n.length);
			$.ajax({
		        type: 'POST',
		        url: '../task/focusPlus.do',
		        dataType: 'json',
		        data: {'tid':$(this).attr("tid"),'flag':0},//yi个id
		        async: false,
		        success: function (data) { 
		        	if(data.code == "0"){
		    			
		        	}
		        }
			})
			$(this).html('关注<img src="./images/star2.png" style="width:1.5em;height:1.5em;margin-right: 0;" />'+(Number(n)+1));
			var note = $(this).next().children().eq(0).text();
			alert("感谢关注该任务，此任务于"+note+"期间可用，先到先得，请届时尽早领取任务，拍摄照片");
		}else if($(this).find("img").eq(0).attr("src").indexOf("star2")!=-1){
			var n = $(this).text();
			n = n.substring(2,n.length);
			$.ajax({
		        type: 'POST',
		        url: '../task/focusPlus.do',
		        dataType: 'json',
		        data: {'tid':$(this).attr("tid"),'flag':1},//yi个id
		        async: false,
		        success: function (data) { 
		        	if(data.code == "0"){
		        	}
		        }
			})
    		$(this).html('关注<img src="./images/star1.png" style="width:1.5em;height:1.5em;margin-right: 0;" />'+(Number(n)-1));
			alert("您已取消关注该任务");
		}
		return false;
	})
}

$("#filter a").click(function(){
	if($(this).text()=="全部任务"){
		taskList($("#nowPoint").val(),1)
	}else if($(this).text()=="离我最近"){
		taskList($("#nowPoint").val(),2)
	}else if($(this).text()=="酬金最高"){
		taskList($("#nowPoint").val(),3)
	}else if($(this).text()=="即将开始"){
		taskList($("#nowPoint").val(),4)
	}else if($(this).text()=="关注最多"){
		taskList($("#nowPoint").val(),5)
	}
})
//$("#nowAddress").focus(function(){
//	setTimeout(loadMapAutocomplete("nowAddress", "searchResultPanel"), 2000);
	
//})


$("#nowAddress").on("blur",function(){
//	alert($("#filter a[class=currer]").index());
	taskList($("#nowPoint").val(),$("#filter a[class=currer]").index()+1);
})

$("#nowAddress").on("keyup",function(){
	$("#nowAddress1").val($("#nowAddress").val());
})
	loadMapAutocomplete("nowAddress1", "searchResultPanel");
//})
 	function G(id) {
        return document.getElementById(id);
    }
 	var c=0;
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
            $("#nowAddress").val($("#nowAddress1").val());
            var myGeo = new BMap.Geocoder();
        	// 将地址解析结果显示在地图上,并调整地图视野
        	myGeo.getPoint($("#nowAddress").val(), function(point){
        		if (point) {
        			$("#nowPoint").val(point.lat+","+point.lng);
        		}else{
        			$("#nowPoint").val("您选择地址没有解析到结果!");
        		}
        	});
        });
    }
    function IsInArray(arr,val){
    	var testStr=','+arr.join(",")+",";
    	return testStr.indexOf(","+val+",")!=-1;
    	}