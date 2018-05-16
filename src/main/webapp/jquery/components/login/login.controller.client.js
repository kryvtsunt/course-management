var userService = new UserServiceClient();
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
    userService.login(username, password).then(success);
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








