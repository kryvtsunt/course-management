function User(username, password, email, firstName, lastName, role, phone, dateOfBirth) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.phone = phone;
    this.dateOfBirth = dateOfBirth;

    this.setUsername = setUsername;
    this.getUsername = getUsername;
    this.setPassword = setPassword;
    this.getPassword = getPassword;
    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;
    this.setLastName = setLastName;
    this.getLastName = getLastName;
    this.setRole = setRole;
    this.getRole = getRole;
    this.setPhone = setPhone;
    this.getPhone = getPhone;
    this.setEmail = setEmail;
    this.getEmail = getEmail;
    this.getDateOfBirth = getDateOfBirth;
    this.setDateOfBirth = setDateOfBirth;
    var self = this;

    function setUsername(username) {
        self.username = username;
    }
    function getUsername() {
        return self.username;
    }
    function setPassword(password) {
        self.password = password;
    }
    function getPassword() {
        return self.password;
    }
    function setFirstName(firstName) {
        self.firstName = firstName;
    }
    function getFirstName() {
        return self.firstName;
    }
    function setLastName(lastName) {
        self.lastName = lastName;
    }
    function getLastName() {
        return self.lastName;
    }
    function setPhone(phone) {
        self.phone = phone;
    }
    function getPhone() {
        return self.phone;
    }
    function setEmail(email) {
        self.email = email;
    }
    function getEmail() {
        return self.email;
    }
    function setRole(role) {
        self.role = role;
    }
    function getRole() {
        return self.role;
    }
    function setDateOfBirth(dateOfBirth) {
        self.dateOfBirth = dateOfBirth;
    }
    function getDateOfBirth() {
        return self.dateOfBirth;
    }



}
