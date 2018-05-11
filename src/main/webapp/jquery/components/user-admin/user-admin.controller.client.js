
//IIFE
(function(){
	var h1 = $('h1');
	h1.css('color','red');
	
	var tr = $('.template');
	var tr1 = tr.clone();
	var tbody = $('tbody');
	
	var users = [{username: 'bob'}, {username: 'charlie'}]
	
	for (var i=0; i<users.length; i++){
		var user = users[i];
		var clone = tr.clone();
		clone.find('.username')
				.html(user.username);
		tbody.append(clone)
	}
})()