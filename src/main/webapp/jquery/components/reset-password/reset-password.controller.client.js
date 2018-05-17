var userService = new UserServiceClient();
var username;
var password;


//IIFE = Immediately-invoked function expression
// Main function
(function () {
    var pathname = window.location.pathname;
    var url      = window.location.href;
    console.log(pathname);
    $('#resetBtn').click(reset)
})()

function reset() {
    password = $("#passwordFld").val();
    verifyPassword = $("#verifyPassword").val();

    userService.reset(username, password).then(success);
}

function success(response) {
        console.log(response);
        window.location.href = "../login/login.template.client.html";
}








