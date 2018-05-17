function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.updateUserSession = updateUserSession;
    this.login = login;
    this.logout = logout;
    this.profile = profile;
    this.register = register;
    this.reset = reset;
    this.forgotPassword = forgotPassword;
    this.loginUrl = 'http://localhost:8080/api/login';
    this.logoutUrl = 'http://localhost:8080/api/logout';
    this.registerUrl = 'http://localhost:8080/api/register';
    this.profileUrl = 'http://localhost:8080/api/profile';
    this.userUrl = 'http://localhost:8080/api/user';
    this.forgotUrl = 'http://localhost:8080/api/forgot'
    this.resetUrl = 'http://localhost:8080/api/reset'
    var self = this;

    function login(username, password) {
        return fetch(self.loginUrl, {
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
        return fetch(self.logoutUrl, {
            method: 'post',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function register(username, password) {
        return fetch(self.registerUrl, {
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
        return fetch(self.profileUrl)
            .then(function (response) {
                if (response.status == 10) {
                    return null;
                }
                else {
                    return response.json();
                }
            });
    }

    function forgotPassword(email) {
        return fetch(self.forgotUrl, {
            method: 'post',
            body: JSON.stringify({email: email}),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function findUserById(userId) {
        return fetch(self.userUrl + '/' + userId)
            .then(function (response) {
                return response.json();
            });
    }

    function createUser(user) {
        return fetch(self.userUrl, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function updateUserSession(user) {
        return fetch(self.userUrl + '/' + "session", {
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

    function updateUser(userId, user) {
        return fetch(self.userUrl + '/' + userId, {
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

    function reset() {
        return fetch(self.resetUrl + '/' + userId, {
            method: 'put',
            body: JSON.stringify({password: password}),
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
        return fetch(self.userUrl + '/' + userId, {
            method: 'delete'
        })
    }

    function findAllUsers() {
        return fetch(self.userUrl).then(function (response) {
            return response.json();
        });
    }
}