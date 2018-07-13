$("#submitQrc").click(function(){
	var formData = new FormData(); 
	formData.append('file', $('#file')[0].files[0]);  //添加图片信息的参数
	formData.append('flag', '2');  //添加图片信息的参数
	$.ajax({
	    url: '../upload/uploadQrc.do',
	    type: 'POST',
	    cache: false, //上传文件不需要缓存
	    data: formData,
	    processData: false, // 告诉jQuery不要去处理发送的数据
	    contentType: false, // 告诉jQuery不要去设置Content-Type请求头
	    success: function (data) {
//	        var rs = eval("("+data+")");
	        if(data.code=="0"){
	            alert('上传成功！');
	            location.href='withdrawals.html';
	        }else{
	        	alert('上传失败 重新进入上传！');
	        	location.href='zhifubao.html'
	        }
	    },
	    error: function (data) {
	        tipTopShow("上传失败");
	    }
	})  
})


document.getElementById('file').onchange = function() {
    var imgFile = this.files[0];
    var fr = new FileReader();
    fr.onload = function() {
        document.getElementById('image').getElementsByTagName('img')[0].src = fr.result;
    };
    fr.readAsDataURL(imgFile);
};
