function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.updateUser2 = updateUser2;
    this.login = login;
    this.logout = logout;
    this.profile = profile;
    this.register = register;
    this.loginU = 'http://localhost:8080/api/login';
    this.logoutU = 'http://localhost:8080/api/logout';
    this.registerU = 'http://localhost:8080/api/register';
    this.profileU = 'http://localhost:8080/api/profile';
    this.url = 'http://localhost:8080/api/user';
    var self = this;

    function login(username, password) {
        return fetch(self.loginU, {
            method: 'post',
            body: JSON.stringify({username: username, password: password}),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function (response) {
                if (response.status == 10) {
                    return null;
                }
                else {
                    return response.json();
                }
            });
    }

    function logout() {
        return fetch(self.logoutU, {
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function register(username, password) {
        return fetch(self.registerU, {
            method: 'post',
            body: JSON.stringify({username: username, password: password}),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function (response) {
                if (response.status == 10) {
                    return null;
                }
                else {
                    return response.json();
                }
            });
    }

    function profile() {
        return fetch(self.profileU)
            .then(function (response) {
                if (response.status == 10) {
                    return null;
                }
                else {
                    return response.json();
                }
            });
    }

    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function (response) {
                return response.json();
            });
    }

    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function updateUser(userId, user) {
        // return fetch(self.url + '/' + "session", {
        //     method: 'put',
        //     body: JSON.stringify(user),
        //     headers: {
        //         'content-type': 'application/json'
        //     }
        // })
        //     .then(function (response) {
        //         if (response.status == 10) {
        //             return null;
        //         }
        //         else {
        //             return response.json();
        //         }
        //     });
    }

    function updateUser2(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function (response) {
                if (response.status == 10) {
                    return null;
                }
                else {
                    return response.json();
                }
            });
    }



    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        })
    }

    function findAllUsers() {
        return fetch(self.url).then(function (response) {
            return response.json();
        });
    }
}