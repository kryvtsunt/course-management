var userService = new UserServiceClient();
var username;
var password;


//IIFE = Immediately-invoked function expression
// Main function
(function () {
    $('#resetBtn').click(reset)
})()

function reset() {
    var url = window.location.href;
    var token = url.split('=')[1];
    var password = $('#inputPassword').val();
    console.log(password);
    userService.reset(token, password).then(success);
}

function success(response) {
    if (response === null) {
        alert("User not found");
    }
    else {
        alert("Success");
        window.location.href = "../login/login.template.client.html";
    }
}





