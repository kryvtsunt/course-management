var username;
var password;
var firstName;
var lastName;
var email;
var phone;
var date;
var role;
var user;

var userService = new UserServiceClient();

//IIFE = Immediately-invoked function expression
(function () {

    getUser();

    $("#updateBtn").click(updateUser);
    $("#LogOut").click(logout);




})()
function updateUser(){
    username = $("#usernameFld").val();
    password = $("#passwordFld").val();
    firstName = $("#firstNameFld").val();
    lastName = $("#lastNameFld").val();
    email = $('#emailFld').val();
    phone = $('#phoneFld').val();
    date = $('#dateFld').val();
    role = $("#roleFld").val();

    var user = new User(username, password, email, firstName, lastName, role, phone, date);
    userService
        .updateUserSession(user)
        .then(success)
}

function success(response){
    if (response === null){
        alert("User was not updated");
    }
    else {
        alert("User was updated");
    }
}

function getUser(){
    userService.profile().then(renderUser);
}

function renderUser(user) {
    $("#usernameFld").val(user.username);
    $("#passwordFld").val(user.password);
    $('#emailFld').val(user.email);
    $('#firstNameFld').val(user.firstName);
    $("#lastNameFld").val(user.lastName);
    $("#roleFld").val(user.role);
    var date = getFormattedDate(new Date(user.dateOfBirth));
    $('#dateFld').val(date);
    $('#phoneFld').val(user.phone);
}

function getFormattedDate(date) {
    var year = date.getFullYear();

    var month = (1 + date.getMonth()).toString();
    month = month.length > 1 ? month : '0' + month;

    var day = date.getDate().toString();
    day = day.length > 1 ? day : '0' + day;

    return year + '-' + month + '-' + day;
}

function logout(){
    userService.logout();
    window.location.href = "../login/login.template.client.html";
}


