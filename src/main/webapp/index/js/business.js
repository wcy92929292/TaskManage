$.ajax({
        type: 'POST',
        url: '../task/getTodayTaskDetail.do',
        dataType: 'json',
        data: {'id':GetQueryString("id")},//yi个id
        async: false,
        success: function (data) { 
        	if(data.cun >0){
        		alert("检测到您已经领取了任务，即将为您跳转到个人中心！");
        		location.href="personal.html";
        	}
        	if(data.code=="0"){
//        		$("#topTitle").text(data.result.title);
        		$("#title").text(data.result.title);
        		$("#distance").text(GetQueryString("distance")+"米");
        		$("#type").text(data.result.type);
        		$("#score").text(data.result.score);
        		$("#lockTime").text(tranPeriod(data.result.lockTime));
        		$("#address").text(data.result.location+"-"+data.result.address);
        		$("#remark").text(data.result.remark);
        		if(GetQueryString("state")=="0"){
        			$("#guize").hide();
        			$("#accept").hide();
        			$("#tishi").show();
        			$("#period").parent().show();
        			$("#period").text(data.result.truePeriod);
        		}else{
        			$("#guize").show();
        			$("#accept").show();
        			$("#tishi").hide();
        			$("#period").parent().hide();
        		}
        	}
        }
})

$("#accept").click(function(){
	if($('#yes').is(':checked')){
		$.ajax({
	        type: 'POST',
	        url: '../task/acceptTask.do',
	        dataType: 'json',
	        data: {'id':GetQueryString("id"),'period':$("#lockTime").text()},//yi个id
	        async: false,
	        success: function (data) { 
	        	if(data.code=="0"){
	        		alert("接受成功，马上去完成吧！");
	        		location.href="applyTask.html?aid="+data.result;
	        	}
	        }
		})
	}else{
		alert("请阅读完，勾选同意并继续！");
		return false;
	}
	
})
