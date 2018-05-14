var userService = new UserServiceClient();
var $username;
var $firstName;
var $lastName;
var $updateBtn;

//IIFE = Immediately-invoked function expression
(function () {
    $username = $("#username");
    $firstName = $("#firstName")
    $lastName = $("#lastName");
    $updateBtn = $("#updateBtn").click(updateUser);
    findUserById(122);
})()

function updateUser(){
    var user = {
        firstName: $firstName.val(),
        lastName: $lastName.val()
    };
    userService
        .updateUser(122, user)
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
        .findUserById(userId)
        .then(renderUser);
}

function renderUser(user) {
    $username.val(user.username);
    $firstName.val(user.firstName);
    $lastName.val(user.lastName);
}
