function User(username, password, firstName, lastName, role, phone, email, dateOfBirth) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.phone = phone;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.resetToken = resetToken;

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
    this.getResetToken = getResetToken;
    this.setResetToken = setResetToken;


    function setUsername(username) {
        this.username = username;
    }
    function getUsername() {
        return this.username;
    }
    function setPassword(password) {
        this.password = password;
    }
    function getPassword() {
        return this.password;
    }
    function setFirstName(firstName) {
        this.firstName = firstName;
    }
    function getFirstName() {
        return this.firstName;
    }
    function setLastName(lastName) {
        this.lastName = lastName;
    }
    function getLastName() {
        return this.lastName;
    }
    function setPhone(phone) {
        this.phone = phone;
    }
    function getPhone() {
        return this.phone;
    }
    function setEmail(email) {
        this.email = email;
    }
    function getEmail() {
        return this.email;
    }
    function setRole(role) {
        this.role = role;
    }
    function getRole() {
        return this.role;
    }
    function setDateOfBirth(dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    function getDateOfBirth() {
        return this.dateOfBirth;
    }
    function setResetToken(resetToken) {
        this.resetToken = resetToken;
    }
    function getResetToken() {
        return this.resetToken;
    }



}
