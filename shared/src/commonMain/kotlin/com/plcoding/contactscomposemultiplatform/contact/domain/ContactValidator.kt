package com.plcoding.contactscomposemultiplatform.contact.domain

object ContactValidator {

    fun validateContact(contact: Contact): ValidationResult {
        var result = ValidationResult()

        if (contact.firstName.isBlank()) {
            result = result.copy(firstNameError = "First name cannot be empty")
        }

        if (contact.lastName.isBlank()) {
            result = result.copy(lastNameError = "Last name cannot be empty")
        }

        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-zA-Z0-9_-]+")
        if (!emailRegex.matches(contact.email)) {
            result = result.copy(emailError = "Invalid email")
        }

        val phoneNumberRegex = Regex("[0-9]{10}")
        if (!phoneNumberRegex.matches(contact.phoneNumber)) {
            result = result.copy(phoneNumberError = "Invalid phone number")
        }

        return result
    }

    data class ValidationResult(
        val firstNameError: String? = null,
        val lastNameError: String? = null,
        val emailError: String? = null,
        val phoneNumberError: String? = null,
    )

}