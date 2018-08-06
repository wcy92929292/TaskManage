$.ajax({
    type: 'POST',
    url: '../task/getUserScore.do',
    dataType: 'json',
    async: false,
    success: function (data) {
    	console.log(data)
    	if(data.code=="0"){
    		if(data.user.zhifubaoQrc==null || data.user.zhifubaoQrc==""){
    			$("#zhifubao").hide();
    			$("#tu").html('<p style="text-align:center;color:#c5c5c5">没有支付宝二维码</p>');
    		}
    		$("#zhifubao").attr("src","../upload/read.do?name="+data.user.zhifubaoQrc);
    	}
    }
})
