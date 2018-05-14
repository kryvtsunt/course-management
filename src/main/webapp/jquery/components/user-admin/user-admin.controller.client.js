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
    template = $('#tk-template-user');
    $('.tk-create-btn').click(createUser);
    findAllUsers();
})()

function createUser() {
    var username = $('#tk-username-fld').val();
    var password = $('#tk-password-fld').val();
    var firstName = $('#tk-first-name-fld').val();
    var lastName = $('#tk-last-name-fld').val();
    var role = $('#tk-role-fld').val();
    var user = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        role: role
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
    var updateBtn = $(event.currentTarget);
    var userId = updateBtn
        .parent()
        .parent()
        .parent()
        .attr('id');

    userService
        .updateUser(userId)
        .then(findAllUsers);
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
        clone.find('.tk-delete-btn').click(deleteUser);
        clone.find('.tk-edit-btn').click(updateUser);
        clone.find('.tk-username')
            .html(user.username)
        clone.find('.tk-password')
            .html(user.password)
        clone.find('.tk-first-name')
            .html(user.firstName)
        clone.find('.tk-last-name')
            .html(user.lastName)
        clone.find('.tk-role')
            .html(user.role)
        tbody.append(clone)
    }
}







