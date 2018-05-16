var userService = new UserServiceClient();
var username;
var password;


//IIFE = Immediately-invoked function expression
// Main function
(function () {
    $('#sendBtn').click(forgotPassword);
})()

function forgotPassword(){
    var email = $('#email').val();
    userService.forgotPassword(email).then(success);
}

function success(response) {
        alert("Email was sent");
}








