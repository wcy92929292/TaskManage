$.ajax({
        type: 'POST',
        url: '../task/getUserScore.do',
        dataType: 'json',
        async: false,
        success: function (data) {
        	console.log(data)
        	if(data.code=="0"){
        		$("#score1").text(data.result);
        		$("#score2").text("￥"+data.result);
        		$("#yh").attr("name",data.user.collectBank);
        		$("#zfb").attr("name",data.user.zhifubaoQrc);
        		$("#wx").attr("name",data.user.weixinQrc);
        		
        		$("#zfb a").attr("href","zhifubao.html?name="+data.user.zhifubaoQrc);
        		$("#wx a").attr("name","weixin.html?name="+data.user.weixinQrc);
        	}
        }
})
$("#submit").click(function(){
	if($("#collectScore").val()=="请输入您的提现金额"||$("#collectScore").val()==0){
		alert("提现不能为空！");
		return false;
	}else if($("#collectScore").val()>($("#score1").text())){
		alert("余额不足！");
		return false;
	}
	$.ajax({
        type: 'POST',
        url: '../task/collectScore.do',
        data:{"type":$('input:radio:checked').val(),"money":$("#collectScore").val()},
        dataType: 'json',
        async: false,
        success: function (data) {
        	console.log(data)
        	if(data.code=="0"){
        		alert("提交成功，等待审核！");
        		location.href="withdrawals.html"
        	}
        }
	})
})