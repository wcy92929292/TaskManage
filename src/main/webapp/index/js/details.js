var sid = GetQueryString("aid");
$.ajax({
        type: 'POST',
        url: '../task/getTaskingDetail.do',
        dataType: 'json',
        data: {'aid':sid},//yi个id
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
        		$("#status").text(tranStatus(data.result.status)+transReason(data.result.reason));
        		$("#startTime").text(getDateTimeStr(data.result.startTime));
        		$("#endTime").text(getDateTimeStr(data.result.endTime));
        		$("#cancel").attr("aid",data.result.aid);
        		if(data.result.status==1 || data.result.status==2 ||data.result.status==3){
        			$("#material").show();
        			$("#stepNext").hide();
        			var parr = data.result.picture.split(",");
        			for (var i = 0; i < parr.length; i++) {
        				$("#image").append('<img class="lit" id="imgs" src="../upload/read.do?name='+parr[i]+'">');
					}
        			$("#addr").text(data.result.photoAddr);
//        			.attr("src","../upload/read.do?name="+data.result.picture);
        		}else if(data.result.status==0){
        			$("#stepNext").show();
        			$("#material").hide();
        		}else if(data.result.status==4){
        			$("#stepNext").hide();
        			$("#material").hide();
        		}
        	}
        }
})
$(".liji").attr("href","applyTask.html?aid="+GetQueryString("aid"));
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