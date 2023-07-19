package com.plcoding.contactscomposemultiplatform.contact.data

import com.plcoding.contactscomposemultiplatform.contact.domain.Contact
import com.plcoding.contactscomposemultiplatform.contact.domain.ContactDataSource
import com.plcoding.contactscomposemultiplatform.database.ContactsDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SQLDelightContactDataSource(
    db: ContactsDatabase
): ContactDataSource {

    private val queries = db.contactQueries

    override fun getContacts(): Flow<List<Contact>> {
        return queries
            .getContacts()
            .asFlow()
            .mapToList()
            .map {
                it.map { contactEntity ->
                    contactEntity.toContact()
                }
            }
    }

    override fun getRecentContacts(amount: Int): Flow<List<Contact>> {
        return queries
            .getRecentContacts(amount.toLong())
            .asFlow()
            .mapToList()
            .map {
                it.map { contactEntity ->
                    contactEntity.toContact()
                }
            }
    }

    override fun getContactById(id: Long): Flow<Contact?> {
        return queries
            .getContactById(id)
            .asFlow()
            .mapToOneOrNull()
            .map { contactEntity ->
                contactEntity?.toContact()
            }
    }

    override suspend fun insertContact(contact: Contact) {
        queries.insertContact(
            id = contact.id,
            firstName = contact.firstName,
            lastName = contact.lastName,
            phoneNumber = contact.phoneNumber,
            email = contact.email,
            createdAt = Clock.System.now().epochSeconds,
            imagePath = null
        )
    }

    override suspend fun deleteContact(id: Long) {
        queries.deleteContact(id)
    }
}