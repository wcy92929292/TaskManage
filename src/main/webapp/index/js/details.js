var sid = GetQueryString("sid");
$.ajax({
        type: 'POST',
        url: '../task/getTaskingDetail.do',
        dataType: 'json',
        data: {'sid':sid},//yi个id
        async: false,
        success: function (data) { 
        	console.log(data.result);
        	if(data.code=="0"){
        		$("#title").text(data.result.title);
        		$("#type").text(data.result.type);
        		$("#score").text(data.result.score);
        		$("#lockTime").text(tranPeriod(data.result.lockTime));
        		$("#address").text(data.result.location+"-"+data.result.address);
        		$("#remark").text(data.result.remark);
        		$("#status").text(tranStatus(data.result.status));
        		$("#startTime").text(getDateTimeStr(data.result.startTime));
        		$("#endTime").text(getDateTimeStr(data.result.endTime));
        		$("#cancel").attr("aid",data.result.aid);
        		if(data.result.status!=0){
        			$("#material").show();
        			$("#imgs").attr("src","../upload/read.do?name="+data.result.picture);
        		}else{
        			$("#stepNext").show();
        		}
        	}
        }
})
$(".liji").attr("href","apply1.html?aid="+GetQueryString("aid"));
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