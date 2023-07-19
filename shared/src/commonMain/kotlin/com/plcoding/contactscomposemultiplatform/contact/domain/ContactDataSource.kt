package com.plcoding.contactscomposemultiplatform.contact.domain

import kotlinx.coroutines.flow.Flow

interface ContactDataSource {
    fun getContacts(): Flow<List<Contact>>
    fun getRecentContacts(amount: Int): Flow<List<Contact>>
    fun getContactById(id: Long): Flow<Contact?>
    suspend fun insertContact(contact: Contact)
    suspend fun deleteContact(id: Long)
}