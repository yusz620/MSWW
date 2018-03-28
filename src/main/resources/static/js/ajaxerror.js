$.ajax({
		url: "/error/getAjaxerror",
		type: "POST",
		async: false,
		success: function(data){
			debugger;
				if(data.status==200 && data.msg=="success"){
					alert("success");
				}else{
					alert("发生异常"+data.msg);
				}
			},
		error: function(response,ajaxOption,throwError){
			alert("error");
		}	
	
	}
);