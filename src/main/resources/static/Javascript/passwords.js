
    function validatePasswords() {
    const password = document.getElementById("password").value;
    const repeatPassword = document.getElementById("repeat-password").value;
    const errorMessage = document.getElementById("error-message");

    if (password !== repeatPassword) {
    errorMessage.style.display = "block";
    return false;
} else {
    errorMessage.style.display = "none";
    return true;
}
}
