$.ajax({
        type: 'POST',
        url: '../task/getTodayTaskDetail.do',
        dataType: 'json',
        data: {'id':GetQueryString("id")},//yi个id
        async: false,
        success: function (data) { 
        	if(data.code=="0"){
        		$("#topTitle").text(data.result.title);
        		$("#title").text(data.result.title);
        		$("#distance").text(GetQueryString("distance")+"米");
        		$("#type").text(data.result.type);
        		$("#score").text(data.result.score);
        		$("#lockTime").text(tranPeriod(data.result.lockTime));
        		$("#address").text(data.result.location+"-"+data.result.address);
        		$("#remark").text(data.result.remark);
        	}
        }
})

$("#accept").click(function(){
	$.ajax({
        type: 'POST',
        url: '../task/acceptTask.do',
        dataType: 'json',
        data: {'id':GetQueryString("id"),'period':$("#lockTime").text()},//yi个id
        async: false,
        success: function (data) { 
        	if(data.code=="0"){
        		alert("接受成功，马上去完成吧！");
        		location.href="apply1.html?id="+data.result;
        	}
        }
})
})