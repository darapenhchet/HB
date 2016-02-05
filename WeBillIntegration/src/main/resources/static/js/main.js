$(function() {
	var customer = {};
	customer.donates = function(){
		var input = {
			"expiry_date" : "20160229",
	    	"remark" : "HRD DONATION",
/*	    	"customer_code" : $("#txtCustomerCode").val(),
	    	"customer_name" : $("#txtCustomerName").val(),
	    	"customer_email" : $("#txtCustomerEmail").val(),
	    	"customer_phone" : $("#txtCustomerPhone").val(),*/
	    	"currency" : "USD",
	    	"amount" : $("#txtAmount").val()
		};
		$.ajax({ 
		    url: "/donates", 
		    type: 'POST', 
		    dataType: 'JSON', 
		    data: JSON.stringify(input),  
		    beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader("X-CSRF-TOKEN", $("input[name='_csrf']").val());
            },
		    success: function(data) { 
		    	console.log(data);
		    	if(data.RESP_DATA.response_code=="200"){
		    		$("#alertSuccess").show();
		    		$("#alertSuccess").delay(5000).fadeOut(400);
		    	}else{
		    		$("#errorMessage").html(data.RESP_DATA.response_msg);
		    		$("#alertDanger").show();
		    		$("#alertDanger").delay(5000).fadeOut(400);
		    	}
		    },
		    error:function(data,status,er) { 
		        console.log("error: "+data+" status: "+status+" er:"+er);
		    }
		});				
	};
	
	customer.signup = function(){
		var input = {
		    	"customer_code" : $("#txtCustomerCode").val(),
		    	"customer_name" : $("#txtCustomerName").val(),
		    	"customer_email" : $("#txtCustomerEmail").val(),
		    	"customer_phone" : $("#txtCustomerPhone").val()
			};
			$.ajax({ 
			    url: "/signup", 
			    type: 'POST', 
			    dataType: 'JSON', 
			    data: JSON.stringify(input),  
			    beforeSend: function(xhr) {
	                xhr.setRequestHeader("Accept", "application/json");
	                xhr.setRequestHeader("Content-Type", "application/json");
	                xhr.setRequestHeader("X-CSRF-TOKEN", $("input[name='_csrf']").val());
	            },
			    success: function(data) { 
			    	console.log(data);
			    	/*if(data.RESP_DATA.response_code=="200"){
			    		$("#alertSuccess").show();
			    		$("#alertSuccess").delay(5000).fadeOut(400);
			    	}else{
			    		$("#errorMessage").html(data.RESP_DATA.response_msg);
			    		$("#alertDanger").show();
			    		$("#alertDanger").delay(5000).fadeOut(400);
			    	}*/
			    },
			    error:function(data,status,er) { 
			        console.log("error: "+data+" status: "+status+" er:"+er);
			    }
			});	
	};
	
	$("#btnSubmit").click(function(){
		customer.donates();
	});
	
});