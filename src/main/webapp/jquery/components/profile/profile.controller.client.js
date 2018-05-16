var userService = new UserServiceClient();
var $username;
var $password;
var $firstName;
var $lastName;
var $updateBtn;
var $role;
var user;

//IIFE = Immediately-invoked function expression
(function () {
    $username = $("#usernameFld");
    $password = $("#passwordFld");
    $firstName = $("#firstNameFld")
    $lastName = $("#lastNameFld");
    $role = $("#roleFld");
    $("#updateBtn").click(updateUser);
    $("#LogOut").click(logout);
    getUser();
})()

function getUser(){
    userService.profile().then(renderUser);
}

function logout(){
    userService.logout();
    window.location.href = "../login/login.template.client.html";
}

function updateUser(){
    var user = new User($username.val(), $password.val(), $firstName.val(),$lastName.val(), $role.val());
    userService
        .updateUserSession(user)
        .then(success);
}

function success(response){
    if (response === null){
        alert("Nothing to update");
    }
    else {
        alert("User was updated");
    }
}


function findUserById(userId) {
    userService
        .findUserById(userId).then(renderUser);
}

function renderUser(user) {
    $username.val(user.username);
    $password.val(user.password);
    $firstName.val(user.firstName);
    $lastName.val(user.lastName);
    $role.val(user.role);
}
