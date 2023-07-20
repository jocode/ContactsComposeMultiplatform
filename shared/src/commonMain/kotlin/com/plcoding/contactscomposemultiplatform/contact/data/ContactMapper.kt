package com.plcoding.contactscomposemultiplatform.contact.data

import com.plcoding.contactscomposemultiplatform.contact.domain.Contact
import com.plcoding.contactscomposemultiplatform.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage): Contact {

    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        photoBytes = imagePath?.let { imageStorage.getImage(it) },
    )
}