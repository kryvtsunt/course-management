var userService = new UserServiceClient();
var username;
var password;


//IIFE = Immediately-invoked function expression
// Main function
(function () {
    $('#sendBtn').click(forgotPassword);
})()

function forgotPassword() {
    $('#error1').hide();
    $('#error2').hide();
    email = $("#emailFld").val();
    if (email == "") {
        $('#error1').show();
    } else {
        var email = $('#emailFld').val();
        userService.forgotPassword(email).then(success);
    }

    function success(response) {
        if (response === null) {
            $('#error2').show();
        }
        else {
            alert("Email was sent");
        }
    }
}









