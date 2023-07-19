package com.plcoding.contactscomposemultiplatform.di

import android.content.Context
import com.plcoding.contactscomposemultiplatform.contact.data.SQLDelightContactDataSource
import com.plcoding.contactscomposemultiplatform.contact.domain.ContactDataSource
import com.plcoding.contactscomposemultiplatform.core.data.DatabaseDriverFactory
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase

actual class AppModule(
    private val context: Context
) {
    actual val contactDataSource: ContactDataSource by lazy {
        SQLDelightContactDataSource(
            db = ContactsDatabase(
                driver = DatabaseDriverFactory(context).create()
            )
        )
    }
}