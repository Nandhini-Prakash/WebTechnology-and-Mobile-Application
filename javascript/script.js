function validateForm() {
    // Get form elements
    const firstName = document.getElementById("firstName");
    const lastName = document.getElementById("lastName");
    const password = document.getElementById("password");
    const email = document.getElementById("email");
    const mobile = document.getElementById("mobile");
    const address = document.getElementById("address");
    
    // Get error message elements
    const firstNameError = document.getElementById("firstNameError");
    const lastNameError = document.getElementById("lastNameError");
    const passwordError = document.getElementById("passwordError");
    const emailError = document.getElementById("emailError");
    const mobileError = document.getElementById("mobileError");
    const addressError = document.getElementById("addressError");
    
    // Reset error states
    resetErrors([firstName, lastName, password, email, mobile, address]);
    hideErrorMessages([firstNameError, lastNameError, passwordError, emailError, mobileError, addressError]);
    
    // Validation patterns
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const mobilePattern = /^[0-9]{10}$/;
    const namePattern = /^[a-zA-Z]+$/;
    
    let isValid = true;
    
    // First Name Validation
    if (firstName.value.length < 6 || !namePattern.test(firstName.value)) {
        showError(firstName, firstNameError, "First name must be at least 6 characters long and contain only alphabets.");
        isValid = false;
    }
    
    // Last Name Validation
    if (lastName.value.trim() === "") {
        showError(lastName, lastNameError, "Last name should not be empty.");
        isValid = false;
    }
    
    // Password Validation
    if (password.value.length < 6) {
        showError(password, passwordError, "Password must be at least 6 characters long.");
        isValid = false;
    }
    
    // Email Validation
    if (!emailPattern.test(email.value)) {
        showError(email, emailError, "Invalid email format. It should be in the format name@domain.com");
        isValid = false;
    }
    
    // Mobile Validation
    if (!mobilePattern.test(mobile.value)) {
        showError(mobile, mobileError, "Mobile number must be exactly 10 digits.");
        isValid = false;
    }
    
    // Address Validation
    if (address.value.trim() === "") {
        showError(address, addressError, "Address should not be empty.");
        isValid = false;
    }
    
    return isValid;
}

// Helper functions
function showError(inputElement, errorElement, message) {
    inputElement.classList.add("error");
    errorElement.textContent = message;
    errorElement.style.display = "block";
}

function hideErrorMessages(errorElements) {
    errorElements.forEach(element => {
        element.style.display = "none";
    });
}

function resetErrors(inputElements) {
    inputElements.forEach(element => {
        element.classList.remove("error");
        element.classList.remove("success");
    });
}