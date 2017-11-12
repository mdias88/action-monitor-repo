
$(document).ready(function(){
	
	var stompClient = null;
	
	function webSocketConnect() {
	    var socket = new SockJS('/action-monitor/websocket');
	    stompClient = Stomp.over(socket);
	    stompClient.debug = null;
	    stompClient.connect({}, function (frame) {
	    	var text = $('textarea').val('Websocket connection establised!!!\n');
	        stompClient.subscribe('/broadcast/console', function (newMessage) {	   
	        		        	
	        	if(newMessage.body != 'NO_RESULTS'){
	        		console.log('Message recieved from server ' + newMessage.body);
	        		var textareaContent = $('textarea').val();
	        		if(textareaContent.indexOf(newMessage.body) == -1){
		        		var text = textareaContent + '\n' + newMessage.body;
		        		$('textarea').val(text);
	        		}
	        	}
	        	//UPDATE CONSOLE
	        	setTimeout(function(){
	        		stompClient.send("/app/message/console", {}, '');
	        	},5000);
	        });	  
	        
	    });
	}

	webSocketConnect();
	
	$('[type="radio"]').on('change', function(){
		var value = $(this).attr('value');		
		$('.actionContainer').addClass('visible-none');
		$('#' + value + 'Container').removeClass('visible-none');
	});
		
	$('[type="Button"]').on("click", function(e){
		e.preventDefault();
		var action = $(this).attr('value');	
		if(action != undefined){		
			$.ajax({
		           type: "POST",
		           url: action,
		           data: $("form").serialize(),
		           async:true,
		           success: function(data)
		           {
		               if(data != 'OK'){
		            	   console.error(data); 
		               }
		           },
		           error: function(data)
		           {
		               console.error(data.responseText); 
		               var text = $('textarea').val() + '\nERROR:' + data.responseText;
		        	   $('textarea').val(text);
		           }
		         });
		}
	});	
	
	//UPDATE CONSOLE
	setTimeout(function(){
		stompClient.send("/app/message/console", {}, '');
	},2000);
	
	
});


//# sourceMappingURL=actionMonitor.js