function validateBookForm() {
    let title = document.bookForm.title.value.trim();
    let isbn = document.bookForm.isbn.value.trim();
    let year = document.bookForm.year.value.trim();
    let currentYear = new Date().getFullYear();

    if (title === "") {
        alert("Title is required.");
        return false;
    }

    if (!/^[A-Za-z\s]+$/.test(title)) {
        alert("Title must contain only letters and spaces.");
        return false;
    }

    if (!/^\d{13}$/.test(isbn)) {
        alert("ISBN must be exactly 13 digits.");
        return false;
    }

    if (!/^\d{4}$/.test(year) || parseInt(year) > currentYear) {
        alert("Enter a valid 4-digit year not greater than the current year.");
        return false;
    }

    return true;
}
