
var tbody;
var template;
var users;

//IIFE = Immediately-invoked function expression
(function(){
	template = $('.template');
	tbody = $('tbody');
	var promise = fetch('http://localhost:8080/api/user');
	promise.then(function(response){
		return response.json();
		}).then(renderUsers)
})()

function renderUsers(users) {
	for (var i=0; i<users.length; i++){
		var user = users[i];
		var clone = template.clone();
		clone.find('.username')
				.html(user.username);
		tbody.append(clone)
	}
}