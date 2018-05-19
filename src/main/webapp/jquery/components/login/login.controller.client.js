var username;
var password;

var userService = new UserServiceClient();
//IIFE = Immediately-invoked function expression
// Main function
(function () {
    $('#signUpBtn').click(login);
})()

function login() {
    $('#error1').hide();
    $('#error2').hide();
    $('#error3').hide();
    username = $("#usernameFld").val();
    password = $("#passwordFld").val();
    if (username == "") {
        $('#error1').show();
    }
    else if (password == "") {
        $('#error2').show();
    } else {
        userService.login(username, password).then(success);
    }
}

function success(response) {
    if (response === null) {
        $('#error3').show();
    }
    else {
        window.location.href = "../profile/profile.template.client.html";
    }
}








