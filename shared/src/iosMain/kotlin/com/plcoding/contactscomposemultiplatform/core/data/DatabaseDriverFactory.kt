package com.plcoding.contactscomposemultiplatform.core.data

import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            ContactsDatabase.Schema,
            "contacts.db"
        )
    }
}