$("#submit").click(function(){
	//alert($("#bank").val()+"+++++++"+$("#number").val());
	$.ajax({
        type: 'POST',
        url: '../task/updateBank.do',
        data:{"bank":$("#bank").val(),"number":$("#number").val()},
        dataType: 'json',
        async: false,
        success: function (data) {
        	console.log(data);
        	if(data.code=="0"){
        		location.href = "bank.html";
        	}
        }
})
})