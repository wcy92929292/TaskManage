var status = GetQueryString("status");
if(status=="0"){
	$("#tab div").eq(1).css("color","#246fc0");
}else if(status=="1"){
	$("#tab div").eq(2).css("color","#246fc0");
}else if(status=="2"){
	$("#tab div").eq(3).css("color","#246fc0");
}else if(status=="3"){
	$("#tab div").eq(4).css("color","#246fc0");
}else{
	$("#tab div").eq(0).css("color","#246fc0");
}
$.ajax({
    type: 'POST',
    url: '../task/getMyAcceptTaskList.do',
    dataType: 'json',
    data: {'status':status},//yi个id
    async: false,
    success: function (data) {
    	console.log(data.result);
    	for (var i = 0; i < data.result.length; i++) {
    		var time1 = getDateTimeStr(data.result[i].startTime);
    		var time2 = getDateTimeStr(data.result[i].endTime);
    		var str ="";
    		if(data.result[i].status=="0"){
    			str ='<div class="button">'+
			        	'<a href="apply1.html?aid='+data.result[i].aid+'" class="liji">去完成</a>'+
			            '<a href="#" id="cancel" aid="'+data.result[i].aid+'" class="qu">取消</a>'+
			        '</div>';
    		}
    		$("#ding_d").append(
        			'<div class="on_d">'+
        			'<a href="details.html?aid='+data.result[i].aid+'&sid='+data.result[i].sid+'">'+
    	    	        '<div class="sp_pr">'+
    	    	                '<div class="text_p">'+
    	    	                    '<p>'+data.result[i].title+'</p>'+
    	    	                    '<span class="yue" style="margin-top:1.286em;">领取时间：'+time1+'</span>'+
    	    	                    '<span class="yue" style="margin-top:1.286em;">过期时间：'+time2+'</span>'+
    	    	                '</div>'+
    	    	            '<span class="spanStatus">'+tranStatus(data.result[i].status)+'</span>'+
    	    	        '</div>'+
        	        '</a>'+ str+
        	    '</div>'		
        	)
		}
    }
})


$("#cancel").click(function(){
	var aid = $(this).attr("aid");
	$.ajax({
	    type: 'POST',
	    url: '../task/cancelMyAcceptTask.do',
	    dataType: 'json',
	    data: {'aid':aid},//yi个id
	    async: false,
	    success: function (data) {
	    	console.log(data);
	    	if(data.code=="0"){
	    		alert("取消成功！");
	    		location.href = "personal.html"
	    	}
	    }
	})
	
})