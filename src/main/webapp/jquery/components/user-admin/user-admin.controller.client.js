var tbody;
var template;
var users;
var userService = new UserServiceClient();

//IIFE = Immediately-invoked function expression
(function () {
    tbody = $('tbody');
    template = $('.template');
    $('#createUser').click(createUser);

    var promise = fetch('http://localhost:8080/api/user');
    promise.then(function (response) {
        return response.json();
    }).then(renderUsers)
})()

function renderUsers(users) {
    for (var i = 0; i < users.length; i++) {
        var user = users[i];
        var clone = template.clone();
        clone.find('.username')
            .html(user.username);
        tbody.append(clone)
    }
}

function createUser() {
    var username = $('#usernameFld').val();
    var password = $('#passwordFld').val();
    var firstName = $('#firstNameFld').val();
    var lastName = $('#lastNameFld').val();
    var user = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName
    };
    userService.createUser(user);
}