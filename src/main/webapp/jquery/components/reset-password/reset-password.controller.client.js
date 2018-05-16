var userService = new UserServiceClient();
var username;
var password;


//IIFE = Immediately-invoked function expression
// Main function
(function () {

    $('#signUpBtn').click(login);
    $('#forgot').click(forgotPassword);
})()

function login() {
    username = $("#username").val();
    password = $("#inputPassword").val();
    userService.login(username, password).then(success);
}

function forgotPassword(){
    console.log("asdf");
    userService.forgotPassword().then(success2);
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

function success2(response) {
        console.log("Email was sent");
}








