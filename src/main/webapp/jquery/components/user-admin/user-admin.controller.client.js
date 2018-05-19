var userService = new UserServiceClient();

var tbody;
var template;

var username;
var email;
var firstName;
var lastName;
var password;
var role;
var form;

var $username;
var $email;
var $firstName;
var $lastName;
var $password;
var $role;
var $form;


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
    username = $username.val();
    password = $password.val();
    email = $email.val();
    firstName = $firstName.val();
    lastName = $lastName.val();
    role = $role.val();

    var user = new User(username, password, email, firstName, lastName, role, null, null);
    userService.createUser(user)
        .then(findAllUsers);
    refreshForm();
}

function updateUser(event) {
    var updateBtn = $(event.currentTarget);
    var userId = updateBtn
        .parent()
        .parent()
        .parent()
        .attr('id');
    username = $username.val();
    password = $password.val();
    email = $email.val();
    firstName = $firstName.val();
    lastName = $lastName.val();
    role = $role.val();

    var user = new User(username,password,email,firstName,lastName,role,null,null);
    userService.updateUser(userId,user)
        .then(findAllUsers);
    refreshForm();
}

function refreshForm() {
    $username.val(null);
    $password.val(null);
    $firstName.val(null);
    $lastName.val(null);
    $email.val(null);
    $role.val(null);
    $form.attr("id", "formAdmin");          /// maybe keep depending on implementation
    $('.tk-update-btn').addClass("tk-hidden");
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
    $('.tk-update-btn').removeClass("tk-hidden");
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







