package com.plcoding.contactscomposemultiplatform.di

import com.plcoding.contactscomposemultiplatform.contact.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}