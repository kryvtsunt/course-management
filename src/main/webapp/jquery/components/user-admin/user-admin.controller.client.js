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
    $username = $("#usernameFld");
    $password = $("#passwordFld");
    $email = $("#emailFld");
    $firstName = $("#firstNameFld");
    $lastName = $("#lastNameFld");
    $role = $("#roleFld");

    tbody = $('tbody');
    template = $('#templateUser');
    $('.tk-create-btn').click(createUser);
    $('.tk-update-btn').click(updateUser);
    $('.tk-refresh-btn').click(refreshForm);
    findAllUsers();
})();

function createUser() {
    var username = $('#usernameFld').val();
    var password = $('#passwordFld').val();
    var email = $('#emailFldfld').val();
    var firstName = $('#firstNameFld').val();
    var lastName = $('#lastNameFld').val();
    var role = $('#roleFld').val();

    var user = new User(username, password, firstName, lastName, role, null, email);
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

    var username = $('#usernameFld').val();
    var password = $('#passwordFld').val();
    var email = $('#emailFldfld').val();
    var firstName = $('#firstNameFld').val();
    var lastName = $('#lastNameFld').val();
    var role = $('#roleFld').val();
    var user = {
        username: username,
        password: password,
        firstName: firstName,
        lastName: lastName,
        role: role,
        email: email
    };
    userService.updateUser(userId,user)
        .then(findAllUsers);
    refreshForm();
}

function refreshForm() {
    $username.val(null);
    $password.val(null);
    $firstName.val(null);
    $lastName.val(null);
    $role.val(null);
    $email.val(null);
    //$form.attr("id", "formAdmin");          /// maybe keep depending on implementation
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
    $email.val(user.email);
    $firstName.val(user.firstName);
    $lastName.val(user.lastName);
    $role.val(user.role);
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
            .html(user.username);
        clone.find('.tk-password')
            .html(user.password);
        clone.find('.tk-email')
            .html(user.email);
        clone.find('.tk-first-name')
            .html(user.firstName);
        clone.find('.tk-last-name')
            .html(user.lastName);
        clone.find('.tk-role')
            .html(user.role);
        tbody.append(clone)
    }
}







