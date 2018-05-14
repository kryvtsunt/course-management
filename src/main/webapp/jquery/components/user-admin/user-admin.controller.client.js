var userService = new UserServiceClient();
var tbody;
var template;
var $usernameFld, $passwordFld;
var $removeBtn, $editBtn, $createBtn;
var $firstNameFld, $lastNameFld;
var $userRowTemplate, $tbody;


//IIFE = Immediately-invoked function expression
// Main function
(function () {
    tbody = $('tbody');
    template = $('.template');
    $('#createUser').click(createUser);
    findAllUsers();
})()

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
    userService.createUser(user)
        .then(findAllUsers);

}

function findAllUsers() {
    userService.findAllUsers().then(renderUsers);
}

function findUserById() {
    //TODO
}

function deleteUser(event) {
    var deleteBtn = $(event.currentTarget);
    var userId = deleteBtn
        .parent()
        .parent()
        .attr('id');

    userService
        .deleteUser(userId)
        .then(findAllUsers);
}

function selectUser() {
    //TODO
}

function updateUser(event) {
    //TODO
}

function renderUser(user) {
    //TODO
}

function renderUsers(users) {
    tbody.empty();
    for (var i = 0; i < users.length; i++) {
        var user = users[i];
        var clone = template.clone();
        clone.attr('id', user.id);
        clone.find('.delete').click(deleteUser);
        clone.find('.edit').click(editUser);
        clone.find('.username')
            .html(user.username)
        tbody.append(clone)
    }
}







