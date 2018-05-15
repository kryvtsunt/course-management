var userService = new UserServiceClient();
var tbody;
var template;
var username;
var password;


//IIFE = Immediately-invoked function expression
// Main function
(function () {

    $('#signUpBtn').click(login);
})()

function login() {
    username = $("#username").val();
    password = $("#inputPassword").val();
    console.log(username + " " + password);
    userService.login(username, password)
}










