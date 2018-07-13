$.ajax({
    type: 'POST',
    url: '../task/getUserScore.do',
    dataType: 'json',
    async: false,
    success: function (data) {
    	console.log(data)
    	if(data.code=="0"){
    		$("#zhifubao").attr("src","../upload/read.do?name="+data.user.zhifubaoQrc);
    	}
    }
})
