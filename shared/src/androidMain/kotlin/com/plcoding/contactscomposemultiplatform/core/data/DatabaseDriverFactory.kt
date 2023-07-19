package com.plcoding.contactscomposemultiplatform.core.data

import android.content.Context
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            ContactsDatabase.Schema,
            context,
            "contacts.db"
        )
    }
}