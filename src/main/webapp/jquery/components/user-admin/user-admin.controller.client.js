var tbody;
var template;
var users;
var userService = new UserServiceClient();

//IIFE = Immediately-invoked function expression
(function () {
    tbody = $('tbody');
    template = $('.template');
    $('#createUser').click(createUser);
    findAllUsers();
})()

function findAllUsers() {
    userService
        .findAllUsers()
        .then(renderUsers);
}

function renderUsers(users) {
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

function deleteUser(event) {
var deleteBtn = $(event.currentTarget);
var uderId = deleteBtn
    .parent()
    .parent()
    .attribute('id');
userService.deleteUser(userId);
}

function editUser(event) {

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
    userService.createUser(user)
        .then(findAllUsers);


}