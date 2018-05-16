var userService = new UserServiceClient();
var username;
var password;
var verify;


//IIFE = Immediately-invoked function expression
// Main function
(function () {

    $('#signUpBtn').click(register);
})()

function register() {
    username = $("#username").val();
    password = $("#inputPassword").val();
    verify = $("#verifyPassword").val();
    userService.register(username, password).then(success);
}

function success(response) {
    if (response === null) {
        alert("Not a valid user");
    }
    else {
        console.log(response);
        window.location.href = "../profile/profile.template.client.html";
    }
}


