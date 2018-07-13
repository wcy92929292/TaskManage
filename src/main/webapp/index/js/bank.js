$.ajax({
    type: 'POST',
    url: '../task/getMyBank.do',
    dataType: 'json',
    async: false,
    success: function (data) {
    	console.log(data);
    	if(data.code=="0"){
    		$("#bank").html(data.result.collectBank);
    		$("#number").html(data.result.collectAccount);
    	}
    }
})
