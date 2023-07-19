package com.plcoding.contactscomposemultiplatform.contact.data

import com.plcoding.contactscomposemultiplatform.contact.domain.Contact
import database.ContactEntity

fun ContactEntity.toContact(): Contact {

    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        photoBytes = null // TODO: Get the image
    )
}