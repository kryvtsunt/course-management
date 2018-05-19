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
    $('#error1').hide();
    $('#error2').hide();
    $('#error3').hide();
    $('#error4').hide();
    $('#error5').hide();
    username = $("#usernameFld").val();
    password = $("#inputPasswordFld").val();
    verify = $("#verifyPasswordFld").val();
    if (username == "") {
        $('#error1').show();
    }
    else if (password == "") {
        $('#error2').show();
    }
    else if (verify == "") {
        $('#error3').show();
    }
    else if (password !== verify) {
        $('#error4').show();
    }
    else {
        userService.register(username, password).then(success);
    }
}

function success(response) {
    if (response === null) {
        $('#error5').show();
    }
    else {
        window.location.href = "../profile/profile.template.client.html";
    }
}


