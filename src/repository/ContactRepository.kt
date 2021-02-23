package repository

import entity.ContactEntity

class ContactRepository {

    //companion object allow me to access in all my packages
    companion object {

        private val contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: ContactEntity) {

        }
    }


}