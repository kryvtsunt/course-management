var userService = new UserServiceClient();
var tbody;
var template;
var $usernameFld, $passwordFld;
var $removeBtn, $editBtn, $createBtn;
var $firstNameFld, $lastNameFld;
var $userRowTemplate, $tbody;

var $username;
var $firstName;
var $lastName;
var password;
var $form;
var headClone;


//IIFE = Immediately-invoked function expression
// Main function
(function () {
    $form = $("#formAdmin");
    $username = $("#tk-username-fld");
    $password = $("#tk-password-fld");
    $firstName = $("#tk-first-name-fld")
    $lastName = $("#tk-last-name-fld");

    //headClone =$('thead').clone();
    tbody = $('tbody');
    template = $('#tk-template-user');
    $('.tk-create-btn').click(createUser);
    $('.tk-update-btn').click(updateUser);
    $('.tk-refresh-btn').click(refreshForm);
    findAllUsers();
})()

function createUser() {
    var username = $('#tk-username-fld').val();
    var password = $('#tk-password-fld').val();
    var firstName = $('#tk-first-name-fld').val();
    var lastName = $('#tk-last-name-fld').val();
    var role = $('#tk-role-fld').val();

    var user = new User(username, password, firstName, lastName, role);
    refreshForm();
    userService.createUser(user)
        .then(findAllUsers);
}

function updateUser(event) {
    var updateBtn = $(event.currentTarget);
    var userId = updateBtn
        .parent()
        .parent()
        .parent()
        .attr('id');

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
    userService.updateUser2(userId,user)
        .then(findAllUsers);
    refreshForm();
}

function refreshForm() {
    $username.val(null);
    $password.val(null);
    $firstName.val(null);
    $lastName.val(null);
    //$form.attr("id", "formAdmin");

     // $('.tk-create-btn').click(createUser);
     // $('.tk-update-btn').click(updateUser);
     // $('.tk-refresh-btn').click(refreshForm);
}
function findAllUsers() {
    userService.findAllUsers().then(renderUsers);
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


function editUser(event) {
    var editBtn = $(event.currentTarget);
    var userId = editBtn
        .parent()
        .parent()
        .parent()
        .attr('id');
    userService
        .findUserById(userId)
        .then(renderUser);
}


function renderUser(user) {
    $form.attr("id", user.id);
    $username.val(user.username);
    $password.val(user.password);
    $firstName.val(user.firstName);
    $lastName.val(user.lastName);
}


function renderUsers(users) {
    tbody.empty();
    for (var i = 0; i < users.length; i++) {
        var user = users[i];
        var clone = template.clone();
        clone.attr('id', user.id);
        clone.find('.tk-delete-btn').click(deleteUser);
        clone.find('.tk-edit-btn').click(editUser);
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







