var userService = new UserServiceClient();
var username;



//IIFE = Immediately-invoked function expression
// Main function
(function () {
    $('#resetBtn').click(reset)
})()

function reset() {
    $('#error1').hide();
    $('#error2').hide();
    $('#error3').hide();
    var password = $("#inputPasswordFld").val();
    var verify = $("#verifyPasswordFld").val();
    if (password == "") {
        $('#error1').show();
    }
    else if (verify == "") {
        $('#error2').show();
    }
    else if (password !== verify) {
        $('#error3').show();
    }
    else {
        var url = window.location.href;
        var token = url.split('=')[1];
        userService.resetPassword(token, password).then(success);
    }
}

function success(response) {
    if (response === null) {
        alert("User not found");
    }
    else {
        alert("Email was sent ");
        window.location.href = "../login/login.template.client.html";
    }
}





