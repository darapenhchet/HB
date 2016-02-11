$(function(){
	
	var _ctx = ($("meta[name='ctx']").attr("content")===undefined) ? "" : $("meta[name='ctx']").attr("content");
	
	// Prepend context path to all jQuery AJAX requests
	$.ajaxPrefilter(function( options, originalOptions, jqXHR ) {
	    if (!options.crossDomain) {
	        options.url = _ctx + options.url;
	    }
	});
	
	var bills = {};
	
	bills.findAll = function(){
		$.ajax({
			url: "/users/bills",
			type: "GET",
			data: {
				page: 0,
				limit: 30,
				name: $("#txtSearch").val()
			},
			success: function(data){
				console.log(data);
				$("tbody#BILLS").html('');
				$("#BILLS_TEMPLATE").tmpl(data.content).appendTo("tbody#BILLS");
				$("#TOTAL_BILLS").html(data.totalElements);
			},
			error: function(data){
				
			}
		});
	};
	
	
	//bills.findAll();
	
});