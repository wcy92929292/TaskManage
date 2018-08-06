$.ajax({
    type: 'POST',
    url: '../task/getMyBank.do',
    dataType: 'json',
    async: false,
    success: function (data) {
    	console.log(data);
    	if(data.code=="0"){
    		if(data.result.collectBank==null ||data.result.collectAccount==null){
    			$("#blueBank").hide();
    			$("#tu").html('<p style="text-align:center;color:#c5c5c5">没有设置银行</p>');
    		}
    		$("#bank").html(data.result.collectBank);
    		$("#number").html(data.result.collectAccount);
    	}
    }
})
