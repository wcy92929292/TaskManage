$.ajax({
    type: 'POST',
    url: '../task/getUserScore.do',
    dataType: 'json',
    async: false,
    success: function (data) {
    	console.log(data)
    	if(data.code=="0"){
    		if(data.user.weixinQrc==null || data.user.weixinQrc==""){
    			$("#weixin").hide();
    			$("#tu").html('<p style="text-align:center;color:#c5c5c5">没有微信二维码</p>');
    		}
    		$("#weixin").attr("src","../upload/read.do?name="+data.user.weixinQrc);
    	}
    }
})
