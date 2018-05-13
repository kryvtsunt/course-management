function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/user';
    var self = this;

    function createUser(user){
        fetch('http://localhost:8080/api/user', {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type' : 'application/json'
            }
        });
    }
}