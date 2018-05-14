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
    template = $('.templateAdmin');
    $('.createBtn').click(createUser);
    findAllUsers();
})()

function createUser() {
    var username = $('#usernameFld').val();
    var password = $('#passwordFld').val();
    var firstName = $('#firstNameFld').val();
    var lastName = $('#lastNameFld').val();
    var role = $('#roleFld').val();
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
        clone.find('.deleteBtn').click(deleteUser);
        clone.find('.updateBtn').click(updateUser);
        clone.find('.usernameDat')
            .html(user.username)
        clone.find('.passwordDat')
            .html(user.password)
        clone.find('.firstNameDat')
            .html(user.firstName)
        clone.find('.lastNameDat')
            .html(user.lastName)
        clone.find('.roleDat')
            .html(user.role)
        tbody.append(clone)
    }
}







